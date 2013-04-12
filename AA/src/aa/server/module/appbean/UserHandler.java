//package aa.server.module.appbean;
//
//import rnd.mywt.server.application.AbstractABHandler;
//import rnd.mywt.server.data.ViewMetaData;
//import rnd.mywt.server.data.impl.SQLViewMetaDataImpl;
//
//public class UserHandler extends AbstractABHandler {
//
//	public ViewMetaData getViewMetaData(String viewName) {
//
//		SQLViewMetaDataImpl vmd = new SQLViewMetaDataImpl();
//
//		vmd.setViewQuery("Select UserId, UserName From [User]");
//		vmd.setViewName(viewName);
//		vmd.setIdColumnIndex(0);
//		vmd.setDisplayColumnIndex(1);
//		vmd.setIdColumnName("UserId");
//		vmd.setDisplayColumnName("UserName");
//		
//		return vmd;
//	}
//}
