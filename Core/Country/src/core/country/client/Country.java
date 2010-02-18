/***********************************************************************
 * Module:  Country.java
 * Author:  Administrator
 * Purpose: Defines the Class Country
 ***********************************************************************/

package core.country.client;

import rnd.webapp.mwt.client.bean.ApplicationDynaBean;

public class Country extends ApplicationDynaBean {

	public Country() {
	}

	public Continent getContinent() {
		return (Continent) getValue("continent");
	}

	public void setContinent(Continent newContinent) {
		setValue("continent", newContinent);
	}

	public java.util.Collection getCountryAliases() {
		return getListValue("countryAliases");
	}

	public void setCountryAliases(java.util.Collection newCountryAliases) {
		setListValue("countryAliases", newCountryAliases);
	}

	public Long getCountryId() {
		return (Long) getValue("countryId");
	}

	public void setCountryId(long newCountryId) {
		setValue("countryId", newCountryId);
	}

	public java.lang.String getCountryName() {
		return (String) getValue("countryName");
	}

	public void setCountryName(java.lang.String newCountryName) {
		setValue("countryName", newCountryName);
	}

}