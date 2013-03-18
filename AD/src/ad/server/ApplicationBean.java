package ad.server;

import rnd.mywt.server.bean.ApplicationJavaBean;

public class ApplicationBean extends ApplicationJavaBean {

	private String name;
	private Long applicationId;
	private Long moduleId;

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
	
	
}
