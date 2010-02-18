/***********************************************************************
 * Module:  CountryAlias.java
 * Author:  kuldeep.punia
 * Purpose: Defines the Class CountryAlias
 ***********************************************************************/

package core.country.client;

import rnd.webapp.mwt.client.bean.ApplicationDynaBean;

public class CountryAlias extends ApplicationDynaBean {

	public CountryAlias() {
	}

	public Country getCountry() {
		return (Country) getValue("country");
	}

	public void setCountry(Country newCountry) {
		setValue("country", newCountry);
	}

	public Long getCountryAliasId() {
		return (Long) getValue("CountryAliasId");
	}

	public void setCountryAliasId(Long newCountryAliasId) {
		setValue("countryAliasId", newCountryAliasId);
	}

	public java.lang.String getCountryAliasName() {
		return (String) getValue("countryAliasName");
	}

	public void setCountryAliasName(java.lang.String newCountryAliasName) {
		setValue("countryAliasName", newCountryAliasName);
	}
}