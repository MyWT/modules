package ad.server.module.handler.bean;

import rnd.mywt.server.application.AbstractABHandler;
import rnd.mywt.server.data.ViewMetaData;
import rnd.mywt.server.data.impl.SQLViewMetaDataImpl;

public class FormABHandler extends AbstractABHandler {

	@Override
	public ViewMetaData getViewMetaData(String viewName) {

		SQLViewMetaDataImpl vmd = new SQLViewMetaDataImpl();
		vmd.setViewQuery("Select * From Form");
		vmd.setViewName(viewName);
		vmd.addFilter("default", "applicationId = ? and moduleid = ? and applicationBeanId = ?");

		return vmd;
	}

}
