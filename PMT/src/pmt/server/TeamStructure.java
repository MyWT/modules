package pmt.server;

import rnd.mywt.server.bean.ApplicationJavaBean;
import rnd.utils.ObjectUtils;

public class TeamStructure extends ApplicationJavaBean {

   private String structureName;
   
   private Long rootPositionId;
   
   public String getStructureName() {
      return structureName;
   }
   
   public void setStructureName(String newStructureName) {
      if (ObjectUtils.areEqual(this.structureName, newStructureName)) { return; }
      this.structureName = newStructureName;
   }
   public Long getRootPositionId() {
      return rootPositionId;
   }
   
   public void setRootPositionId(Long newRootPositionId) {
      if (ObjectUtils.areEqual(this.rootPositionId, newRootPositionId)) { return; }
      this.rootPositionId = newRootPositionId;
   }
}