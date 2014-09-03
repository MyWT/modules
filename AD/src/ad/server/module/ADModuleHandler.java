package ad.server.module;

import java.util.Collection;

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
import ad.server.ApplicationBean;
import ad.server.Field;
import ad.server.Form;
import ad.server.Module;

public class ADModuleHandler extends AbstractModuleHandler {

	public ADModuleHandler() {
		super("AD");
	}

	@Override
	public void initModule() {
		//		registerApplicationBean("Application", Application.class);
		//		registerApplicationBean("Module", Module.class, new ModuleABHandler());
		//		registerApplicationBean("ApplicationBean", ApplicationBean.class, new ApplicationBeanABHandler());
		//		registerApplicationBean("View", View.class);
		//		registerApplicationBean("Form", Form.class, new FormABHandler());
		//		registerApplicationBean("Field", Field.class, new FieldABHandler());
	}

	@Override
	public void handleRequest(ApplicationRequest req, ApplicationResponse resp) {
		super.handleRequest(req, resp);

		switch (req.getMethod()) {

		case Load:

			if (ARUtils.getAppBeanName(req).equals("Application")) {

				// Application
				String appName = ARUtils.getName(req);

				Application srcApp = (Application) getObjectPersistor().findAllObject(new Object[] { " Name = ? " }, new Object[] { appName }, Application.class).iterator().next();
				ApplicationDynaBean trgtApp = (ApplicationDynaBean) AppBeanUtils.copy(srcApp, AppBeanUtils.getServerCopyBeanCtx(), AppBeanUtils.getClientBeanCopyCtx());
				resp.setResult(trgtApp);

				ApplicationHandler applicationHandler = ApplicationHandlerPool.getApplicationHandler(appName);

				// Module
				Long appId = (Long) srcApp.getValue("applicationId");
				Collection<Module> modules = getObjectPersistor().findAllObject(new Object[] { " ApplicationId = ? " }, new Object[] { appId }, Module.class);
				for (Module srcModule : modules) {

					ModuleHandler moduleHandler = DefaultModuleHandler.getNewInstance(srcModule.getName());
					applicationHandler.registerModule(srcModule.getName(), moduleHandler);

					ApplicationDynaBean trgtModule = (ApplicationDynaBean) AppBeanUtils.copy(srcModule, AppBeanUtils.getServerCopyBeanCtx(), AppBeanUtils.getClientBeanCopyCtx());
					trgtApp.addElement("module", trgtModule);

					// ApplicationBean
					Long moduleId = (Long) srcModule.getValue("moduleId");
					Collection<ApplicationBean> srcAppBeans = getObjectPersistor().findAllObject(new Object[] { " ModuleId = ? " }, new Object[] { moduleId }, ApplicationBean.class);
					for (ApplicationBean srcAppBean : srcAppBeans) {

						try {
							// ApplicationBean Handler
							moduleHandler.registerApplicationBean(srcAppBean.getName(), (Class<? extends ApplicationBean>) Class.forName(srcAppBean.getClassName()));
							ApplicationDynaBean trgtAppBean = (ApplicationDynaBean) AppBeanUtils.copy(srcAppBean, AppBeanUtils.getServerCopyBeanCtx(), AppBeanUtils.getClientBeanCopyCtx());
							trgtModule.addElement("applicationBean", trgtAppBean);

							Long appBeanId = (Long) srcAppBean.getValue("applicationBeanId");

							// Form
							Collection<Form> srcForms = getObjectPersistor().findAllObject(new Object[] { " ApplicationBeanId = ? " }, new Object[] { appBeanId }, Form.class);
							for (Form srcForm : srcForms) {

								ApplicationDynaBean trgtForm = (ApplicationDynaBean) AppBeanUtils.copy(srcForm, AppBeanUtils.getServerCopyBeanCtx(), AppBeanUtils.getClientBeanCopyCtx());
								trgtAppBean.addElement("form", trgtForm);

							} // End Form

						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}

					} // End AppBean

				} // End Module

			} // End App

			else if (ARUtils.getAppBeanName(req).equals("Form")) {

				// Form
				Form srcForm = (Form) getObjectPersistor().findAllObject(new Object[] { " Name = ? " }, new Object[] { ARUtils.getName(req) }, Form.class).iterator().next();
				ApplicationDynaBean trgtForm = (ApplicationDynaBean) AppBeanUtils.copy(srcForm, AppBeanUtils.getServerCopyBeanCtx(), AppBeanUtils.getClientBeanCopyCtx());
				resp.setResult(trgtForm);

				// Field
				Long formId = (Long) srcForm.getValue("formId");
				Collection<Field> srcFields = getObjectPersistor().findAllObject(new Object[] { " FormId = ? " }, new Object[] { formId }, Field.class);
				for (Field srcField : srcFields) {

					ApplicationDynaBean trgtField = (ApplicationDynaBean) AppBeanUtils.copy(srcField, AppBeanUtils.getServerCopyBeanCtx(), AppBeanUtils.getClientBeanCopyCtx());
					trgtForm.addElement("field", trgtField);
				}
			} // End Form

			else if (ARUtils.getAppBeanName(req).equals("View")) {

			}

		}

	}
}
