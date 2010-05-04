package pmt.client.module.helper;

import pmt.client.module.helper.form.ProjectFormHelper;
import pmt.client.module.helper.form.TaskFormHelper;
import rnd.mywt.client.application.AbstractModuleHelper;

public class PMTModuleHelper extends AbstractModuleHelper {

	public String getModuleName() {
		return "PMT";
	}

	@Override
	public void initialiseModule() {
		addFormHelper(new ProjectFormHelper());
		addFormHelper(new TaskFormHelper());
	}

}
