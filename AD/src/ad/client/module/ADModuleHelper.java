package ad.client.module;

import rnd.mywt.client.application.AbstractModuleHelper;
import ad.client.module.form.ApplicationBeanFormHelper;
import ad.client.module.form.ApplicationFormHelper;
import ad.client.module.form.FieldFormHelper;
import ad.client.module.form.FormFormHelper;
import ad.client.module.form.ModuleFormHelper;
import ad.client.module.form.ViewFormHelper;

public class ADModuleHelper extends AbstractModuleHelper {

	public ADModuleHelper() {
		super("AD");
	}

	public String getModuleName() {
		return "AD";
	}

	@Override
	public void initialiseModule() {

		addFormHelper("Application", "Application", new ApplicationFormHelper());
		addFormHelper("Module", "Module", new ModuleFormHelper());
		addFormHelper("ApplicationBean", "ApplicationBean", new ApplicationBeanFormHelper());
		addFormHelper("Form", "Form", new FormFormHelper());
		addFormHelper("Field", "Field", new FieldFormHelper());
		addFormHelper("View", "View", new ViewFormHelper());

	}

}
