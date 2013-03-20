package ad.server;

import rnd.mywt.server.bean.ApplicationJavaBean;

public class Application extends ApplicationJavaBean {

	private Long applicationId;
	private String name;

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
