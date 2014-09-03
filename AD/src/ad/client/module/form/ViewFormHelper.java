package ad.client.module.form;

import rnd.bean.ApplicationBean;
import rnd.bean.ApplicationDynaBean;
import rnd.mywt.client.MyWTHelper;
import rnd.mywt.client.application.AbstractFormHelper;
import rnd.mywt.client.mvc.field.data.ReferenceField;
import rnd.mywt.client.mvc.field.data.text.TextField;
import rnd.mywt.client.mvc.page.form.Form;

public class ViewFormHelper extends AbstractFormHelper {

	public ViewFormHelper() {
		super("AD", "View", "View", "View");
	}

	public Form createForm() {

		Form form = super.createForm();

		ReferenceField applicationId_RF = createReferenceField("Application", "AD", "Application", "Application", "Name", "applicationId");
		form.addField(applicationId_RF);

		ReferenceField moduleId_RF = createReferenceField("Module", "AD", "Module", "Module", "Name", "moduleId");
		form.addField(moduleId_RF);

		ReferenceField appBeanId_RF = createReferenceField("ApplicationBean", "AD", "ApplicationBean", "ApplicationBean", "Name", "ApplicationBeanId");
		form.addField(appBeanId_RF);

		TextField name_TF = MyWTHelper.getMVCFactory().createTextField("View Name");
		name_TF.setBoundTo("name");
		form.addField(name_TF);

		return form;
	}

	@Override
	public ApplicationBean createApplicationBean() {
		return new ApplicationDynaBean("ad.server.View");
	}

}
