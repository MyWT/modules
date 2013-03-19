package ad.server.module.handler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import rnd.mywt.client.rpc.ApplicationRequest;
import rnd.mywt.client.rpc.ApplicationResponse;
import rnd.mywt.client.rpc.util.ARUtils;
import rnd.mywt.server.application.AbstractModuleHandler;
import rnd.mywt.server.util.AppBeanUtils;
import ad.server.Application;
import ad.server.ApplicationBean;
import ad.server.Form;
import ad.server.Module;
import ad.server.View;

public class ADModuleHandler extends AbstractModuleHandler {

	public ADModuleHandler() {
		super("AD");
	}
	
	@Override
	public void initModule() {
		registerApplicationBean("Application", Application.class);
		registerApplicationBean("Module", Module.class);
		registerApplicationBean("ApplicationBean", ApplicationBean.class);
		registerApplicationBean("View", View.class);
		registerApplicationBean("Form", Form.class);
	}

	@Override
	public void handleRequest(ApplicationRequest req, ApplicationResponse resp) {
		super.handleRequest(req, resp);

		switch (req.getMethod()) {

		case Load:
			Collection sourceBeans = null;
			if (ARUtils.getAppBeanName(req).equals("Module")) {
				sourceBeans = getObjectPersistor().findAllObject(//
						new Object[] { "ApplicationId = (Select ApplicationId From Applicaion Where Name = ? )" }, //
						new Object[] { ARUtils.getParent(req) }, //
						Module.class);
			}
			ArrayList targetBeans = new ArrayList();
			AppBeanUtils.copyAllBean(sourceBeans, targetBeans, AppBeanUtils.getServerCopyBeanCtx(), AppBeanUtils.getClientBeanCopyCtx());
			resp.setResult((Serializable) targetBeans);
			return;
		}

	}
}
