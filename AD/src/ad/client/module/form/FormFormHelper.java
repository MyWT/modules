package ad.client.module.form;

import rnd.bean.ApplicationBean;
import rnd.bean.ApplicationDynaBean;
import rnd.expression.Expression;
import rnd.mywt.client.MyWTHelper;
import rnd.mywt.client.application.AbstractFormHelper;
import rnd.mywt.client.data.impl.FilterInfoImpl;
import rnd.mywt.client.mvc.field.data.ReferenceField;
import rnd.mywt.client.mvc.field.data.text.TextField;
import rnd.mywt.client.mvc.page.board.DataBoard;
import rnd.mywt.client.mvc.page.form.Form;

public class FormFormHelper extends AbstractFormHelper {

	public FormFormHelper() {
		super("Form", "Form", "Form");
	}

	public Form createForm() {

		Form form = super.createForm();

		TextField name_TF = MyWTHelper.getMVCFactory().createTextField("Form Name");
		name_TF.setBoundTo("name");
		form.addField(name_TF);

		return form;
	}

	@Override
	public DataBoard createDataBoard() {

		DataBoard dataBoard = createDataBoard("AD", "Form", "Form");

		ReferenceField applicationId_RF = createReferenceField("Application", "AD", "Application", "Application", "Name");
		Expression applicationIdCtxExp = dataBoard.addContextField("applicationId", applicationId_RF);

		ReferenceField moduleId_RF = createReferenceField("Module", "AD", "Module", "Module", "Name");
		Expression moduleIdCtxExp = dataBoard.addContextField("moduleId", moduleId_RF);

		ReferenceField appBeanId_RF = createReferenceField("ApplicationBean", "AD", "ApplicationBean", "ApplicationBean", "Name");
		Expression applicationBeanIdCtxExp = dataBoard.addContextField("applicationBeanId", appBeanId_RF);

		FilterInfoImpl filterInfo = new FilterInfoImpl("default");

		filterInfo.setFilterParamExpressionObjects(dataBoard.getModel(), dataBoard.getModel(), dataBoard.getModel());
		filterInfo.setFilterParamExpressions(applicationIdCtxExp, moduleIdCtxExp, applicationBeanIdCtxExp);

		dataBoard.setFilter(filterInfo);

		return dataBoard;
	}

	@Override
	public ApplicationBean createApplicationBean() {
		return new ApplicationDynaBean("ad.server.Form");
	}

}
