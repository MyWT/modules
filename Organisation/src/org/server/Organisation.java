package org.server;

import rnd.webapp.mwt.client.utils.ObjectUtils;
import rnd.webapp.mwt.server.bean.ApplicationJavaBean;

public class Organisation extends ApplicationJavaBean {

   private String organisationName;
   
   private String organisationCode;
   
   public String getOrganisationName() {
      return organisationName;
   }
   
   public void setOrganisationName(String newOrganisationName) {
      if (ObjectUtils.areEqual(this.organisationName, newOrganisationName)) { return; }
      this.organisationName = newOrganisationName;
   }
   public String getOrganisationCode() {
      return organisationCode;
   }
   
   public void setOrganisationCode(String newOrganisationCode) {
      if (ObjectUtils.areEqual(this.organisationCode, newOrganisationCode)) { return; }
      this.organisationCode = newOrganisationCode;
   }
}