package org.client;

import rnd.webapp.mwt.client.bean.ApplicationDynaBean;

public class OrganisationChart extends ApplicationDynaBean {

   public String getChartName() {
      return (String) getValue("chartName");
   }
   
   public void setChartName(String newChartName) {
      setValue("chartName", newChartName);
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
   public Long getOrganisationStructureId() {
      return (Long) getValue("organisationStructureId");
   }
   
   public void setOrganisationStructureId(Long newOrganisationStructureId) {
      setValue("organisationStructureId", newOrganisationStructureId);
   }
   
   public Long getOrganisationId() {
      return (Long) getValue("organisationId");
   }
   
   public void setOrganisationId(Long newOrganisationId) {
      setValue("organisationId", newOrganisationId);
   }
   
   public Long getRootPositionHolderId() {
      return (Long) getValue("rootPositionHolderId");
   }
   
   public void setRootPositionHolderId(Long newRootPositionHolderId) {
      setValue("rootPositionHolderId", newRootPositionHolderId);
   }
}