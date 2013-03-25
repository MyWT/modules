package ad.client.module.form;

import rnd.mywt.client.application.AbstractFormHelper;
import rnd.mywt.client.bean.ApplicationBean;
import rnd.mywt.client.bean.ApplicationDynaBean;
import rnd.mywt.client.mvc.field.data.ReferenceField;
import rnd.mywt.client.mvc.field.data.text.TextField;
import rnd.mywt.client.mvc.page.board.DataBoard;
import rnd.mywt.client.mvc.page.form.Form;

public class ApplicationBeanFormHelper extends AbstractFormHelper {

	public ApplicationBeanFormHelper() {
		super("ApplicationBean", "ApplicationBean", "ApplicationBean");
	}

	public Form createForm() {

		Form form = super.createForm();

		ReferenceField applicationId_RF = createReferenceField("Application", "applicationId", "AD", "Application", "Application", "Name");
		form.addField(applicationId_RF);

		ReferenceField moduleId_RF = createReferenceField("Module", "moduleId", "AD", "Module", "Module", "Name");
		form.addField(moduleId_RF);

		TextField name_TF = createTextField("Name", "name");
		form.addField(name_TF);

		return form;
	}

	@Override
	public DataBoard createDataBoard() {

		DataBoard dataBoard = createDataBoard("AD", "ApplicationBean", "ApplicationBean");

		ReferenceField applicationId_RF = createReferenceField("Application", "AD", "Application", "Application", "Name");
		dataBoard.addContextField("applicationId", applicationId_RF);

		ReferenceField moduleId_RF = createReferenceField("Module", "AD", "Module", "Module", "Name");
		dataBoard.addContextField("moduleId", moduleId_RF);

		return dataBoard;

	}

	@Override
	public ApplicationBean createApplicationBean() {
		return new ApplicationDynaBean("ad.server.ApplicationBean");
	}

}
