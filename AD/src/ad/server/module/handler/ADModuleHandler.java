package ad.server.module.handler;

import java.util.Collection;

import rnd.bean.ApplicationBean;
import rnd.bean.ApplicationDynaBean;
import rnd.mywt.client.rpc.ApplicationRequest;
import rnd.mywt.client.rpc.ApplicationResponse;
import rnd.mywt.client.rpc.util.ARUtils;
import rnd.mywt.server.application.AbstractModuleHandler;
import rnd.mywt.server.util.AppBeanUtils;
import ad.server.Application;
import ad.server.Field;
import ad.server.Form;
import ad.server.Module;
import ad.server.View;
import ad.server.module.handler.bean.ApplicationBeanABHandler;

public class ADModuleHandler extends AbstractModuleHandler {

	public ADModuleHandler() {
		super("AD");
	}

	@Override
	public void initModule() {
		registerApplicationBean("Application", Application.class);
		registerApplicationBean("Module", Module.class);
		registerApplicationBean("ApplicationBean", ad.server.ApplicationBean.class, new ApplicationBeanABHandler());
		registerApplicationBean("View", View.class);
		registerApplicationBean("Form", Form.class);
		registerApplicationBean("Field", Field.class);
	}

	@Override
	public void handleRequest(ApplicationRequest req, ApplicationResponse resp) {
		super.handleRequest(req, resp);

		switch (req.getMethod()) {

		case Load:

			Collection<ApplicationBean> sourceBeans = null;

			if (ARUtils.getAppBeanName(req).equals("Application")) {

				// Application
				sourceBeans = getObjectPersistor().findAllObject(new Object[] { "Name = ? " }, new Object[] { ARUtils.getName(req) }, Application.class);
				ApplicationDynaBean application = new ApplicationDynaBean();
				ApplicationBean srcApp = sourceBeans.iterator().next();
				AppBeanUtils.copyBean(srcApp, application, AppBeanUtils.getServerCopyBeanCtx(), AppBeanUtils.getClientBeanCopyCtx());
				resp.setResult(application);

				// Module
				Long appId = (Long) srcApp.getValue("applicationId");
				sourceBeans = getObjectPersistor().findAllObject(new Object[] { "ApplicationId = ? " }, new Object[] { appId }, Module.class);
				for (ApplicationBean srcModule : sourceBeans) {

					ApplicationDynaBean module = new ApplicationDynaBean();
					AppBeanUtils.copyBean(srcModule, module, AppBeanUtils.getServerCopyBeanCtx(), AppBeanUtils.getClientBeanCopyCtx());

					// ApplicationBean
					Long moduleId = (Long) srcModule.getValue("moduleId");
					sourceBeans = getObjectPersistor().findAllObject(new Object[] { "ModuleId = ? " }, new Object[] { moduleId }, ad.server.ApplicationBean.class);
					for (ApplicationBean srcAppBean : sourceBeans) {

						ApplicationDynaBean appBean = new ApplicationDynaBean();
						AppBeanUtils.copyBean(srcAppBean, appBean, AppBeanUtils.getServerCopyBeanCtx(), AppBeanUtils.getClientBeanCopyCtx());

						Long appBeanId = (Long) srcAppBean.getValue("applicationBeanId");
						// Form
						sourceBeans = getObjectPersistor().findAllObject(new Object[] { "ApplicationBeanId = ? " }, new Object[] { appBeanId }, Form.class);
						for (ApplicationBean srcForm : sourceBeans) {

							ApplicationDynaBean form = new ApplicationDynaBean();
							AppBeanUtils.copyBean(srcForm, form, AppBeanUtils.getServerCopyBeanCtx(), AppBeanUtils.getClientBeanCopyCtx());

							appBean.addElement("form", form);
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

						module.addElement("applicationBean", appBean);
					}// End AppBean

					application.addElement("module", module);
				}// End Module

			} // End App

			else if (ARUtils.getAppBeanName(req).equals("Form")) {

				// Form
				sourceBeans = getObjectPersistor().findAllObject(new Object[] { "Name = ? " }, new Object[] { ARUtils.getName(req) }, Form.class);
				ApplicationDynaBean form = new ApplicationDynaBean();
				ApplicationBean srcForm = sourceBeans.iterator().next();
				AppBeanUtils.copyBean(srcForm, form, AppBeanUtils.getServerCopyBeanCtx(), AppBeanUtils.getClientBeanCopyCtx());
				resp.setResult(form);

				// Field
				Long formId = (Long) srcForm.getValue("formId");
				sourceBeans = getObjectPersistor().findAllObject(new Object[] { "FormId = ? " }, new Object[] { formId }, Field.class);
				for (ApplicationBean srcField : sourceBeans) {

					ApplicationDynaBean field = new ApplicationDynaBean();
					AppBeanUtils.copyBean(srcField, field, AppBeanUtils.getServerCopyBeanCtx(), AppBeanUtils.getClientBeanCopyCtx());

					form.addElement("field", field);
				}
			} // End Form

		}

	}
}
