package ad.server;

import rnd.mywt.server.bean.ApplicationJavaBean;

public class Module extends ApplicationJavaBean {
	
	private String name;
	private Long applicationId;

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
	
	
	
}
