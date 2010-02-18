package org.server;

import rnd.webapp.mwt.client.utils.ObjectUtils;
import rnd.webapp.mwt.server.bean.ApplicationJavaBean;

public class OrganisationChart extends ApplicationJavaBean {

   private String chartName;
   
   private java.util.Date validFrom;
   
   private java.util.Date validUpto;
   
   private Long organisationStructureId;
   
   private Long organisationId;
   
   private Long rootPositionHolderId;
   
   public String getChartName() {
      return chartName;
   }
   
   public void setChartName(String newChartName) {
      if (ObjectUtils.areEqual(this.chartName, newChartName)) { return; }
      this.chartName = newChartName;
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
   public Long getOrganisationStructureId() {
      return organisationStructureId;
   }
   
   public void setOrganisationStructureId(Long newOrganisationStructureId) {
      if (ObjectUtils.areEqual(this.organisationStructureId, newOrganisationStructureId)) { return; }
      this.organisationStructureId = newOrganisationStructureId;
   }
   
   public Long getOrganisationId() {
      return organisationId;
   }
   
   public void setOrganisationId(Long newOrganisationId) {
      if (ObjectUtils.areEqual(this.organisationId, newOrganisationId)) { return; }
      this.organisationId = newOrganisationId;
   }
   
   public Long getRootPositionHolderId() {
      return rootPositionHolderId;
   }
   
   public void setRootPositionHolderId(Long newRootPositionHolderId) {
      if (ObjectUtils.areEqual(this.rootPositionHolderId, newRootPositionHolderId)) { return; }
      this.rootPositionHolderId = newRootPositionHolderId;
   }
}