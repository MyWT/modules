package aa.client.module;

import rnd.mywt.client.application.AbstractModuleHelper;
import aa.client.module.form.UserFormHelper;

public class AAModuleHelper extends AbstractModuleHelper {

	public String getModuleName() {
		return "AA";
	}

	@Override
	public void initialiseModule() {
		addFormHelper(new UserFormHelper());
	}

	@Override
	public void initialiseApplication() {
	}

}
