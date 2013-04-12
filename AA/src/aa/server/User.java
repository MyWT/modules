package aa.server;

import rnd.mywt.server.bean.ApplicationJavaBean;
import rnd.utils.ObjectUtils;

public class User extends ApplicationJavaBean {

	private Long userId;

	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String newUserName) {
		if (ObjectUtils.areEqual(this.userName, newUserName)) {
			return;
		}
		this.userName = newUserName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long newUserId) {
		this.userId = newUserId;
	}
}