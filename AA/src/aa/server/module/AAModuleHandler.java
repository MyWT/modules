package aa.server.module;

import rnd.mywt.server.application.AbstractModuleHandler;
import rnd.mywt.server.application.ModuleHandler;
import aa.server.User;
import aa.server.module.appbean.UserHandler;

public class AAModuleHandler extends AbstractModuleHandler implements ModuleHandler {

	@Override
	public void initModule() {
		registerApplicationBean("User", User.class, new UserHandler());
	}
	
	@Override
	public String getModuleName() {
		return "AA";
	}

}
