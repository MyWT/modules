package ad.client.module.form;

import rnd.bean.ApplicationBean;
import rnd.bean.ApplicationDynaBean;
import rnd.expression.Expression;
import rnd.mywt.client.application.AbstractFormHelper;
import rnd.mywt.client.data.impl.FilterInfoImpl;
import rnd.mywt.client.mvc.field.data.ReferenceField;
import rnd.mywt.client.mvc.page.board.DataBoard;
import rnd.mywt.client.mvc.page.form.Form;

public class ModuleFormHelper extends AbstractFormHelper {

	public ModuleFormHelper() {
		super("Module", "Module", "Module");
	}

	public Form createForm() {

		Form form = super.createForm();
		form.addField(createTextField("Module Name", "name"));

		return form;
	}

	@Override
	public DataBoard createDataBoard() {

		DataBoard dataBoard = createDataBoard("AD", "Module", "Module");

		ReferenceField applicationId_RF = createReferenceField("Application", "applicationId", "AD", "Application", "Application", "Name");
		Expression applicationIdCtxExp = dataBoard.addContextField("applicationId", applicationId_RF);

		FilterInfoImpl filterInfo = new FilterInfoImpl("default");

		filterInfo.setFilterParamExpressionObjects(dataBoard.getModel());
		filterInfo.setFilterParamExpressions(applicationIdCtxExp);

		dataBoard.setFilter(filterInfo);

		return dataBoard;
	}

	@Override
	public ApplicationBean createApplicationBean() {
		return new ApplicationDynaBean("ad.server.Module");
	}

}
