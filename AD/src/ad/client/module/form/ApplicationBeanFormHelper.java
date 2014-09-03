package ad.client.module.form;

import rnd.bean.ApplicationBean;
import rnd.bean.ApplicationDynaBean;
import rnd.mywt.client.application.AbstractFormHelper;
import rnd.mywt.client.data.impl.FilterInfoImpl;
import rnd.mywt.client.mvc.field.data.text.TextField;
import rnd.mywt.client.mvc.page.board.DataBoard;
import rnd.mywt.client.mvc.page.form.Form;

public class ApplicationBeanFormHelper extends AbstractFormHelper {

	public ApplicationBeanFormHelper() {
		super("AD", "ApplicationBean", "ApplicationBean", "ApplicationBean");
	}

	public Form createForm() {

		Form form = super.createForm();

		TextField name_TF = createTextField("Name", "name");
		form.addField(name_TF);

		TextField className_TF = createTextField("Class Name", "className");
		form.addField(className_TF);

		return form;
	}

	@Override
	public DataBoard createDataBoard() {

		DataBoard dataBoard = createDataBoard("AD", "ApplicationBean", "ApplicationBean");
		FilterInfoImpl filterInfo = new FilterInfoImpl("default");

		filterInfo.setFilterParamExpressionObjects(dataBoard.getModel(), dataBoard.getModel());
		filterInfo.setFilterParamExpressions(//
				dataBoard.addContextField("applicationId", createReferenceField("Application", "AD", "Application", "Application", "Name")), //
				dataBoard.addContextField("moduleId", createReferenceField("Module", "AD", "Module", "Module", "Name")));

		dataBoard.setFilter(filterInfo);

		return dataBoard;

	}

	@Override
	public ApplicationBean createApplicationBean() {
		return new ApplicationDynaBean("ad.server.ApplicationBean");
	}

}
