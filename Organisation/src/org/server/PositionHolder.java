package org.server;

import rnd.webapp.mwt.client.utils.ObjectUtils;
import rnd.webapp.mwt.server.bean.ApplicationJavaBean;

public class PositionHolder extends ApplicationJavaBean {

   private Long positionHolderUserId;
   
   private Long positionId;
   
   private Long parentPositionHolderId;
   
   
   public Long getPositionHolderUserId() {
      return positionHolderUserId;
   }
   
   public void setPositionHolderUserId(Long newPositionHolderUserId) {
      if (ObjectUtils.areEqual(this.positionHolderUserId, newPositionHolderUserId)) { return; }
      this.positionHolderUserId = newPositionHolderUserId;
   }
   
   public Long getPositionId() {
      return positionId;
   }
   
   public void setPositionId(Long newPositionId) {
      if (ObjectUtils.areEqual(this.positionId, newPositionId)) { return; }
      this.positionId = newPositionId;
   }
   
   public Long getParentPositionHolderId() {
      return parentPositionHolderId;
   }
   
   public void setParentPositionHolderId(Long newParentPositionHolderId) {
      if (ObjectUtils.areEqual(this.parentPositionHolderId, newParentPositionHolderId)) { return; }
      this.parentPositionHolderId = newParentPositionHolderId;
   }
}