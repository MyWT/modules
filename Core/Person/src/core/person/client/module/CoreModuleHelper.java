package core.person.client.module;

import rnd.webapp.mwt.client.application.AbstractModuleHelper;
import core.person.client.module.form.PersonFormHelper;

public class CoreModuleHelper extends AbstractModuleHelper {

	@Override
	public void initialiseModule() {
		addFormHelper(new PersonFormHelper());
	}

	public String getModuleName() {
		return "Core";
	}

	@Override
	public void initialiseApplication() {
	}

}
