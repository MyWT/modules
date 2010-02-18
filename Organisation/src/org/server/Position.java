package org.server;

import rnd.webapp.mwt.client.utils.ObjectUtils;
import rnd.webapp.mwt.server.bean.ApplicationJavaBean;

public class Position extends ApplicationJavaBean {

   private String positionName;
   
   private String positionCode;
   
   private Long parentPositionId;
   
   public String getPositionName() {
      return positionName;
   }
   
   public void setPositionName(String newPositionName) {
      if (ObjectUtils.areEqual(this.positionName, newPositionName)) { return; }
      this.positionName = newPositionName;
   }
   public String getPositionCode() {
      return positionCode;
   }
   
   public void setPositionCode(String newPositionCode) {
      if (ObjectUtils.areEqual(this.positionCode, newPositionCode)) { return; }
      this.positionCode = newPositionCode;
   }
   public Long getParentPositionId() {
      return parentPositionId;
   }
   
   public void setParentPositionId(Long newParentPositionId) {
      if (ObjectUtils.areEqual(this.parentPositionId, newParentPositionId)) { return; }
      this.parentPositionId = newParentPositionId;
   }
}