package ad.client.module.form;

import rnd.bean.ApplicationBean;
import rnd.bean.ApplicationDynaBean;
import rnd.mywt.client.MyWTHelper;
import rnd.mywt.client.application.AbstractFormHelper;
import rnd.mywt.client.mvc.field.data.text.TextField;
import rnd.mywt.client.mvc.page.form.Form;

public class ApplicationFormHelper extends AbstractFormHelper {

	public ApplicationFormHelper() {
		super("Application", "Application", "Application");
	}

	public Form createForm() {

		Form form = super.createForm();

		TextField name_TF = MyWTHelper.getMVCFactory().createTextField("Application Name");
		name_TF.setBoundTo("name");
		form.addField(name_TF);

		return form;
	}

	@Override
	public ApplicationBean createApplicationBean() {
		return new ApplicationDynaBean("ad.server.Application");
	}

}
