package core.person.client;

import rnd.webapp.mwt.client.bean.ApplicationDynaBean;

public class Person extends ApplicationDynaBean {

	public String getFirstName() {
		return (String) getValue("firstName");
	}

	public void setFirstName(String firstName) {
		setValue("firstName", firstName);
	}

	public String getLastName() {
		return (String) getValue("lastName");
	}

	public void setLastName(String lastName) {
		setValue("lastName", lastName);
	}

	public String getFullName() {
		return (String) getValue("fullName");
	}

	public void setFullName(String fullName) {
		setValue("fullName", fullName);
	}
}
