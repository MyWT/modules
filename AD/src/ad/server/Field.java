package ad.server;

import rnd.mywt.server.bean.ApplicationJavaBean;

public class Field extends ApplicationJavaBean {

	public final static int TYPE_NUMBER = 1;
	public final static int TYPE_ALPHANUMERIC = 2;
	public final static int TYPE_REFERENCE = 3;

	private Long fieldId;
	private String label;
	private int type;
	private String boundTo;

	private Long applicationId;
	private Long moduleId;
	private Long applicationBeanId;
	private Long formId;

	public Long getFieldId() {
		return fieldId;
	}

	public void setFieldId(Long fieldId) {
		this.fieldId = fieldId;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Long getApplicationId() {
		return applicationId;
	}

	public String getBoundTo() {
		return boundTo;
	}

	public void setBoundTo(String boundTo) {
		this.boundTo = boundTo;
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

	public Long getFormId() {
		return formId;
	}

	public void setFormId(Long formId) {
		this.formId = formId;
	}

}
