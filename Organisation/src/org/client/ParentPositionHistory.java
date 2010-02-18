package org.client;

import rnd.webapp.mwt.client.bean.ApplicationDynaBean;

public class ParentPositionHistory extends ApplicationDynaBean {

   public java.util.Date getValidFrom() {
      return (java.util.Date) getValue("validFrom");
   }
   
   public void setValidFrom(java.util.Date newValidFrom) {
      setValue("validFrom", newValidFrom);
   }
   public java.util.Date getValidUpto() {
      return (java.util.Date) getValue("validUpto");
   }
   
   public void setValidUpto(java.util.Date newValidUpto) {
      setValue("validUpto", newValidUpto);
   }
   public Long getPositionId() {
      return (Long) getValue("positionId");
   }
   
   public void setPositionId(Long newPositionId) {
      setValue("positionId", newPositionId);
   }
   
   public Long getParentPositionId() {
      return (Long) getValue("parentPositionId");
   }
   
   public void setParentPositionId(Long newParentPositionId) {
      setValue("parentPositionId", newParentPositionId);
   }
}