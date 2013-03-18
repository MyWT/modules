package ad.server.module.handler;

import java.io.Serializable;
import java.util.Collection;

import ad.server.Application;
import ad.server.ApplicationBean;
import ad.server.Form;
import ad.server.Module;
import ad.server.View;
import rnd.mywt.client.rpc.ApplicationRequest;
import rnd.mywt.client.rpc.ApplicationResponse;
import rnd.mywt.client.rpc.util.ARUtils;
import rnd.mywt.server.application.AbstractModuleHandler;

public class ADModuleHandler extends AbstractModuleHandler {

	@Override
	public void initModule() {
		registerApplicationBean("Application", Application.class);
		registerApplicationBean("Module", Module.class);
		registerApplicationBean("ApplicationBean", ApplicationBean.class);
		registerApplicationBean("View", View.class);
		registerApplicationBean("Form", Form.class);
	}

	@Override
	public String getModuleName() {
		return "AA";
	}

	@Override
	public void handleRequest(ApplicationRequest req, ApplicationResponse resp) {
		super.handleRequest(req, resp);

		switch (req.getMethod()) {

		case Load:
			Collection children = null;
			if (ARUtils.getAppBeanName(req).equals("Module")) {
				children = getObjectPersistor().findAllObject(//
						new Object[] { "ApplicationId = (Select ApplicationId From Applicaion Where Name = ? )" }, //
						new Object[] { ARUtils.getParent(req) }, //
						Module.class);
			}
			resp.setResult((Serializable) children);
			return;
		}

	}
}
