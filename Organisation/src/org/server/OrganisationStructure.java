package org.server;

import rnd.webapp.mwt.client.utils.ObjectUtils;
import rnd.webapp.mwt.server.bean.ApplicationJavaBean;

public class OrganisationStructure extends ApplicationJavaBean {

   private String structureName;
   
   private java.util.Date validFrom;
   
   private java.util.Date validUpto;
   
   private Long organisationId;
   
   private Long rootPositionId;
   
   public String getStructureName() {
      return structureName;
   }
   
   public void setStructureName(String newStructureName) {
      if (ObjectUtils.areEqual(this.structureName, newStructureName)) { return; }
      this.structureName = newStructureName;
   }
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
   public Long getOrganisationId() {
      return organisationId;
   }
   
   public void setOrganisationId(Long newOrganisationId) {
      if (ObjectUtils.areEqual(this.organisationId, newOrganisationId)) { return; }
      this.organisationId = newOrganisationId;
   }
   
   public Long getRootPositionId() {
      return rootPositionId;
   }
   
   public void setRootPositionId(Long newRootPositionId) {
      if (ObjectUtils.areEqual(this.rootPositionId, newRootPositionId)) { return; }
      this.rootPositionId = newRootPositionId;
   }
}