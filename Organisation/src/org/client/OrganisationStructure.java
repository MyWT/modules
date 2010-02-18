package org.client;

import rnd.webapp.mwt.client.bean.ApplicationDynaBean;

public class OrganisationStructure extends ApplicationDynaBean {

   public String getStructureName() {
      return (String) getValue("structureName");
   }
   
   public void setStructureName(String newStructureName) {
      setValue("structureName", newStructureName);
   }
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
   public Long getOrganisationId() {
      return (Long) getValue("organisationId");
   }
   
   public void setOrganisationId(Long newOrganisationId) {
      setValue("organisationId", newOrganisationId);
   }
   
   public Long getRootPositionId() {
      return (Long) getValue("rootPositionId");
   }
   
   public void setRootPositionId(Long newRootPositionId) {
      setValue("rootPositionId", newRootPositionId);
   }
}