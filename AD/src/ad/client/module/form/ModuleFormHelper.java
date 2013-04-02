package ad.client.module.form;

import rnd.bean.ApplicationBean;
import rnd.bean.ApplicationDynaBean;
import rnd.mywt.client.MyWTHelper;
import rnd.mywt.client.application.AbstractFormHelper;
import rnd.mywt.client.mvc.field.data.ReferenceField;
import rnd.mywt.client.mvc.field.data.text.TextField;
import rnd.mywt.client.mvc.page.form.Form;

public class ModuleFormHelper extends AbstractFormHelper {

	public ModuleFormHelper() {
		super("Module", "Module", "Module");
	}

	public Form createForm() {

		Form form = super.createForm();

		ReferenceField applicationId_RF = createReferenceField("Application", "applicationId", "AD", "Application", "Application", "Name");
		form.addField(applicationId_RF);

		TextField name_TF = MyWTHelper.getMVCFactory().createTextField("Module Name");
		name_TF.setBoundTo("name");
		form.addField(name_TF);

		return form;
	}

	@Override
	public ApplicationBean createApplicationBean() {
		return new ApplicationDynaBean("ad.server.Module");
	}

}
