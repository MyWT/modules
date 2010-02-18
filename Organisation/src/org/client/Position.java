package org.client;

import rnd.webapp.mwt.client.bean.ApplicationDynaBean;

public class Position extends ApplicationDynaBean {

   public String getPositionName() {
      return (String) getValue("positionName");
   }
   
   public void setPositionName(String newPositionName) {
      setValue("positionName", newPositionName);
   }
   public String getPositionCode() {
      return (String) getValue("positionCode");
   }
   
   public void setPositionCode(String newPositionCode) {
      setValue("positionCode", newPositionCode);
   }
   public Long getParentPositionId() {
      return (Long) getValue("parentPositionId");
   }
   
   public void setParentPositionId(Long newParentPositionId) {
      setValue("parentPositionId", newParentPositionId);
   }
}