package ad.server;

import rnd.mywt.server.bean.ApplicationJavaBean;

public class Form extends ApplicationJavaBean {

	private Long formId;
	private String name;
	private Long applicationId;
	private Long moduleId;
	private Long applicationBeanId;

	public Long getFormId() {
		return formId;
	}

	public void setFormId(Long formId) {
		this.formId = formId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public Long getModuleId() {
		return moduleId;
	}

	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

	public Long getApplicationBeanId() {
		return applicationBeanId;
	}

	public void setApplicationBeanId(Long applicationBeanId) {
		this.applicationBeanId = applicationBeanId;
	}

}
