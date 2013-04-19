package ad.server.module.handler;

import java.util.Collection;

import rnd.bean.ApplicationBean;
import rnd.bean.ApplicationDynaBean;
import rnd.mywt.client.rpc.ApplicationRequest;
import rnd.mywt.client.rpc.ApplicationResponse;
import rnd.mywt.client.rpc.util.ARUtils;
import rnd.mywt.server.application.AbstractModuleHandler;
import rnd.mywt.server.application.ApplicationHandler;
import rnd.mywt.server.application.ApplicationHandlerPool;
import rnd.mywt.server.application.DefaultModuleHandler;
import rnd.mywt.server.application.ModuleHandler;
import rnd.mywt.server.util.AppBeanUtils;
import ad.server.Application;
import ad.server.Field;
import ad.server.Form;
import ad.server.Module;
import ad.server.View;
import ad.server.module.handler.bean.ApplicationBeanABHandler;
import ad.server.module.handler.bean.FieldABHandler;
import ad.server.module.handler.bean.FormABHandler;
import ad.server.module.handler.bean.ModuleABHandler;

public class ADModuleHandler extends AbstractModuleHandler {

	public ADModuleHandler() {
		super("AD");
	}

	@Override
	public void initModule() {
		registerApplicationBean("Application", Application.class);
		registerApplicationBean("Module", Module.class, new ModuleABHandler());
		registerApplicationBean("ApplicationBean", ad.server.ApplicationBean.class, new ApplicationBeanABHandler());
		registerApplicationBean("View", View.class);
		registerApplicationBean("Form", Form.class, new FormABHandler());
		registerApplicationBean("Field", Field.class, new FieldABHandler());
	}

	@Override
	public void handleRequest(ApplicationRequest req, ApplicationResponse resp) {
		super.handleRequest(req, resp);

		switch (req.getMethod()) {

		case Load:

			Collection<ApplicationBean> sourceBeans = null;

			if (ARUtils.getAppBeanName(req).equals("Application")) {

				// Application
				String appName = ARUtils.getName(req);
				sourceBeans = getObjectPersistor().findAllObject(new Object[] { " Name = ? " }, new Object[] { appName }, Application.class);

				// Application Handler
				ApplicationHandler applicationHandler = ApplicationHandlerPool.getApplicationHandler(appName);

				ApplicationDynaBean application = new ApplicationDynaBean();
				ApplicationBean srcApp = sourceBeans.iterator().next();
				AppBeanUtils.copyBean(srcApp, application, AppBeanUtils.getServerCopyBeanCtx(), AppBeanUtils.getClientBeanCopyCtx());
				resp.setResult(application);

				// Module
				Long appId = (Long) srcApp.getValue("applicationId");
				sourceBeans = getObjectPersistor().findAllObject(new Object[] { " ApplicationId = ? " }, new Object[] { appId }, Module.class);
				for (ApplicationBean srcModule : sourceBeans) {

					// Module Handler
					Module module = (Module) srcModule;
					ModuleHandler moduleHandler = DefaultModuleHandler.getInstance(module.getName());
					applicationHandler.registerModule(module.getName(), moduleHandler);

					ApplicationDynaBean trgtModule = new ApplicationDynaBean();
					AppBeanUtils.copyBean(srcModule, trgtModule, AppBeanUtils.getServerCopyBeanCtx(), AppBeanUtils.getClientBeanCopyCtx());

					// ApplicationBean
					Long moduleId = (Long) srcModule.getValue("moduleId");
					sourceBeans = getObjectPersistor().findAllObject(new Object[] { " ModuleId = ? " }, new Object[] { moduleId }, ad.server.ApplicationBean.class);
					for (ApplicationBean srcAppBean : sourceBeans) {

						// ApplicationBean Handler
						ad.server.ApplicationBean appBean = (ad.server.ApplicationBean) srcAppBean;

						try {
							moduleHandler.registerApplicationBean(appBean.getName(), (Class<? extends ApplicationBean>) Class.forName(appBean.getClassName()));
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}

						ApplicationDynaBean trgtAppBean = new ApplicationDynaBean();
						AppBeanUtils.copyBean(srcAppBean, trgtAppBean, AppBeanUtils.getServerCopyBeanCtx(), AppBeanUtils.getClientBeanCopyCtx());

						Long appBeanId = (Long) srcAppBean.getValue("applicationBeanId");
						// Form
						sourceBeans = getObjectPersistor().findAllObject(new Object[] { " ApplicationBeanId = ? " }, new Object[] { appBeanId }, Form.class);
						for (ApplicationBean srcForm : sourceBeans) {

							ApplicationDynaBean trgtForm = new ApplicationDynaBean();
							AppBeanUtils.copyBean(srcForm, trgtForm, AppBeanUtils.getServerCopyBeanCtx(), AppBeanUtils.getClientBeanCopyCtx());

							trgtAppBean.addElement("form", trgtForm);
						} // End Form

						// // View
						// sourceBeans = getObjectPersistor().findAllObject(new
						// Object[] { "ApplicationBeanId = ? " }, new Object[] {
						// appBeanId }, View.class);
						// for (ApplicationBean srcView : sourceBeans) {
						//
						// ApplicationDynaBean view = new ApplicationDynaBean();
						// AppBeanUtils.copyBean(srcView, view,
						// AppBeanUtils.getServerCopyBeanCtx(),
						// AppBeanUtils.getClientBeanCopyCtx());
						//
						// appBean.addElement("view", view);
						// }

						trgtModule.addElement("applicationBean", trgtAppBean);
					}// End ApplicationBean

					application.addElement("module", trgtModule);
				}// End Module

			} // End App

			else if (ARUtils.getAppBeanName(req).equals("Form")) {

				// Form
				sourceBeans = getObjectPersistor().findAllObject(new Object[] { " Name = ? " }, new Object[] { ARUtils.getName(req) }, Form.class);
				ApplicationDynaBean form = new ApplicationDynaBean();
				ApplicationBean srcForm = sourceBeans.iterator().next();
				AppBeanUtils.copyBean(srcForm, form, AppBeanUtils.getServerCopyBeanCtx(), AppBeanUtils.getClientBeanCopyCtx());
				resp.setResult(form);

				// Field
				Long formId = (Long) srcForm.getValue("formId");
				sourceBeans = getObjectPersistor().findAllObject(new Object[] { " FormId = ? " }, new Object[] { formId }, Field.class);
				for (ApplicationBean srcField : sourceBeans) {

					ApplicationDynaBean field = new ApplicationDynaBean();
					AppBeanUtils.copyBean(srcField, field, AppBeanUtils.getServerCopyBeanCtx(), AppBeanUtils.getClientBeanCopyCtx());

					form.addElement("field", field);
				}
			} // End Form

		}

	}
}
