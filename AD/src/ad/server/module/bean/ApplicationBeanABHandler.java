package ad.server.module.bean;

import rnd.mywt.server.application.AbstractABHandler;
import rnd.mywt.server.data.ViewMetaData;
import rnd.mywt.server.data.impl.SQLViewMetaDataImpl;

public class ApplicationBeanABHandler extends AbstractABHandler {

	@Override
	public ViewMetaData getViewMetaData(String viewName) {

		SQLViewMetaDataImpl vmd = new SQLViewMetaDataImpl();
		vmd.setViewQuery("Select * From [ApplicationBean]");
		vmd.setViewName(viewName);
		vmd.addFilter("default", "applicationId = ? and moduleId = ? ");

		return vmd;
	}

}
