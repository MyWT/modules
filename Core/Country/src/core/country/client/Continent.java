/***********************************************************************
 * Module:  Continent.java
 * Author:  Administrator
 * Purpose: Defines the Class Continent
 ***********************************************************************/

package core.country.client;

import rnd.webapp.mwt.client.bean.ApplicationDynaBean;


public class Continent extends ApplicationDynaBean {

	public Continent() {
	}

	public Long getContinentId() {
		return (Long) getValue("continentId");
	}

	public void setContinentId(Long newContinentId) {
		setValue("continentId", newContinentId);
	}

	public java.lang.String getContinentName() {
		return (String) getValue("continentName");
	}

	public void setContinentName(java.lang.String newContinentName) {
		setValue("continentName", newContinentName);
	}
}