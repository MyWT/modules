package ad.client.module.form;

import rnd.bean.ApplicationBean;
import rnd.bean.ApplicationDynaBean;
import rnd.mywt.client.MyWTHelper;
import rnd.mywt.client.application.AbstractFormHelper;
import rnd.mywt.client.mvc.field.data.ReferenceField;
import rnd.mywt.client.mvc.field.data.text.TextField;
import rnd.mywt.client.mvc.page.form.Form;

public class FieldFormHelper extends AbstractFormHelper {

	public FieldFormHelper() {
		super("Field", "Field", "Field");
	}

	public Form createForm() {

		Form form = super.createForm();

		ReferenceField applicationId_RF = createReferenceField("Application", "applicationId", "AD", "Application", "Application", "Name");
		form.addField(applicationId_RF);

		ReferenceField moduleId_RF = createReferenceField("Module", "moduleId", "AD", "Module", "Module", "Name");
		form.addField(moduleId_RF);

		ReferenceField appBeanId_RF = createReferenceField("ApplicationBean", "ApplicationBeanId", "AD", "ApplicationBean", "ApplicationBean", "Name");
		form.addField(appBeanId_RF);

		ReferenceField formId_RF = createReferenceField("Form", "FormId", "AD", "Form", "Form", "Name");
		form.addField(formId_RF);

		TextField name_TF = MyWTHelper.getMVCFactory().createTextField("Field Name");
		name_TF.setBoundTo("label");
		form.addField(name_TF);

		return form;
	}

	@Override
	public ApplicationBean createApplicationBean() {
		return new ApplicationDynaBean("ad.server.Field");
	}

}
