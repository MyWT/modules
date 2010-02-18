package org.client;

import rnd.webapp.mwt.client.bean.ApplicationDynaBean;

public class Organisation extends ApplicationDynaBean {

   public String getOrganisationName() {
      return (String) getValue("organisationName");
   }
   
   public void setOrganisationName(String newOrganisationName) {
      setValue("organisationName", newOrganisationName);
   }
   public String getOrganisationCode() {
      return (String) getValue("organisationCode");
   }
   
   public void setOrganisationCode(String newOrganisationCode) {
      setValue("organisationCode", newOrganisationCode);
   }
}