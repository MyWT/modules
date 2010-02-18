package org.server;

import rnd.webapp.mwt.client.utils.ObjectUtils;
import rnd.webapp.mwt.server.bean.ApplicationJavaBean;

public class ParentPositionHistory extends ApplicationJavaBean {

   private java.util.Date validFrom;
   
   private java.util.Date validUpto;
   
   private Long positionId;
   
   private Long parentPositionId;
   
   public java.util.Date getValidFrom() {
      return validFrom;
   }
   
   public void setValidFrom(java.util.Date newValidFrom) {
      if (ObjectUtils.areEqual(this.validFrom, newValidFrom)) { return; }
      this.validFrom = newValidFrom;
   }
   public java.util.Date getValidUpto() {
      return validUpto;
   }
   
   public void setValidUpto(java.util.Date newValidUpto) {
      if (ObjectUtils.areEqual(this.validUpto, newValidUpto)) { return; }
      this.validUpto = newValidUpto;
   }
   public Long getPositionId() {
      return positionId;
   }
   
   public void setPositionId(Long newPositionId) {
      if (ObjectUtils.areEqual(this.positionId, newPositionId)) { return; }
      this.positionId = newPositionId;
   }
   
   public Long getParentPositionId() {
      return parentPositionId;
   }
   
   public void setParentPositionId(Long newParentPositionId) {
      if (ObjectUtils.areEqual(this.parentPositionId, newParentPositionId)) { return; }
      this.parentPositionId = newParentPositionId;
   }
}