package ad.server.module.handler.bean;

import rnd.mywt.server.application.AbstractABHandler;
import rnd.mywt.server.data.ViewMetaData;
import rnd.mywt.server.data.impl.SQLViewMetaDataImpl;

public class FieldABHandler extends AbstractABHandler {

	@Override
	public ViewMetaData getViewMetaData(String viewName) {

		SQLViewMetaDataImpl vmd = new SQLViewMetaDataImpl();
		vmd.setViewQuery("Select * From [Field]");
		vmd.setViewName(viewName);
		vmd.addFilter("default", "applicationId = ? and moduleid = ? and applicationBeanId = ? and formId = ?");

		return vmd;
	}

}
