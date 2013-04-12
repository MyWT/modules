package ad.server;

import rnd.mywt.server.bean.ApplicationJavaBean;

public class ApplicationBean extends ApplicationJavaBean {

	private Long applicationBeanId;
	private String name;
	private String className;
	private Long applicationId;
	private Long moduleId;

	public Long getApplicationBeanId() {
		return applicationBeanId;
	}

	public void setApplicationBeanId(Long applicationBeanId) {
		this.applicationBeanId = applicationBeanId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
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

}
