package ad.client.module.form;

import rnd.bean.ApplicationBean;
import rnd.bean.ApplicationDynaBean;
import rnd.expression.Expression;
import rnd.mywt.client.application.AbstractFormHelper;
import rnd.mywt.client.data.impl.FilterInfoImpl;
import rnd.mywt.client.mvc.field.data.ReferenceField;
import rnd.mywt.client.mvc.field.data.text.TextField;
import rnd.mywt.client.mvc.page.board.DataBoard;
import rnd.mywt.client.mvc.page.form.Form;

public class FieldFormHelper extends AbstractFormHelper {

	public FieldFormHelper() {
		super("AD", "Field", "Field", "Field");
	}

	public Form createForm() {

		Form form = super.createForm();

		TextField name_TF = createTextField("Field Name", "label");
		form.addField(name_TF);

		TextField boundTo_TF = createTextField("Bound To", "boundTo");
		form.addField(boundTo_TF);

		TextField type_TF = createTextField("Field Type", "fieldType");
		form.addField(type_TF);

		//	ReferenceField refModuleId_RF = createReferenceField("Module", "AD", "Module", "Module", "Name", "refModuleId");
		//	form.addField(refModuleId_RF);
		//
		//	ReferenceField refAppBeanId_RF = createReferenceField("ApplicationBean", "AD", "ApplicationBean", "ApplicationBean", "Name", "refAppBeanId");
		//	form.addField(refAppBeanId_RF);
		//		
		//	ReferenceField refViewId_RF = createReferenceField("View", "AD", "View", "View", "Name", "refViewId");
		//	form.addField(refViewId_RF);

		TextField refModule_TF = createTextField("Module", "refModuleName");
		form.addField(refModule_TF);

		TextField refAppBean_TF = createTextField("Application Bean", "refAppBeanName");
		form.addField(refAppBean_TF);

		TextField refView_TF = createTextField("View", "refViewName");
		form.addField(refView_TF);

		TextField refColumnName_TF = createTextField("Column Name", "refColumnName");
		form.addField(refColumnName_TF);

		return form;
	}

	@Override
	public DataBoard createDataBoard() {

		DataBoard dataBoard = createDataBoard("AD", "Field", "Field");

		ReferenceField applicationId_RF = createReferenceField("Application", "AD", "Application", "Application", "Name", "applicationId");
		Expression applicationIdCtxExp = dataBoard.addContextField("applicationId", applicationId_RF);

		ReferenceField moduleId_RF = createReferenceField("Module", "AD", "Module", "Module", "Name", "moduleId");
		Expression moduleIdCtxExp = dataBoard.addContextField("moduleId", moduleId_RF);

		ReferenceField appBeanId_RF = createReferenceField("ApplicationBean", "AD", "ApplicationBean", "ApplicationBean", "Name", "applicationBeanId");
		Expression applicationBeanIdCtxExp = dataBoard.addContextField("applicationBeanId", appBeanId_RF);

		ReferenceField formId_RF = createReferenceField("Form", "AD", "Form", "Form", "Name", "formId");
		Expression formIdCtxExp = dataBoard.addContextField("formId", formId_RF);

		FilterInfoImpl filterInfo = new FilterInfoImpl("default");
		filterInfo.setFilterParamExpressionObjects(dataBoard.getModel(), dataBoard.getModel(), dataBoard.getModel(), dataBoard.getModel());
		filterInfo.setFilterParamExpressions(applicationIdCtxExp, moduleIdCtxExp, applicationBeanIdCtxExp, formIdCtxExp);
		dataBoard.setFilter(filterInfo);

		return dataBoard;
	}

	@Override
	public ApplicationBean createApplicationBean() {
		return new ApplicationDynaBean("ad.server.Field");
	}

}
