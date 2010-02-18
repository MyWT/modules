package org.client;

import rnd.webapp.mwt.client.bean.ApplicationDynaBean;

public class PositionHolder extends ApplicationDynaBean {

   
   public Long getPositionHolderUserId() {
      return (Long) getValue("positionHolderUserId");
   }
   
   public void setPositionHolderUserId(Long newPositionHolderUserId) {
      setValue("positionHolderUserId", newPositionHolderUserId);
   }
   
   public Long getPositionId() {
      return (Long) getValue("positionId");
   }
   
   public void setPositionId(Long newPositionId) {
      setValue("positionId", newPositionId);
   }
   
   public Long getParentPositionHolderId() {
      return (Long) getValue("parentPositionHolderId");
   }
   
   public void setParentPositionHolderId(Long newParentPositionHolderId) {
      setValue("parentPositionHolderId", newParentPositionHolderId);
   }
}