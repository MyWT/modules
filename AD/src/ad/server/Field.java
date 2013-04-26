package ad.server;

import rnd.mywt.server.bean.ApplicationJavaBean;

public class Field extends ApplicationJavaBean {

	public final static int TYPE_NUMBER = 1;
	public final static int TYPE_ALPHANUMERIC = 2;
	public final static int TYPE_REFERENCE = 3;

	private Long fieldId;
	private int fieldType;
	private String label;
	private String boundTo;

	private Long applicationId;
	private Long moduleId;
	private Long applicationBeanId;
	private Long formId;

	private Long refModuleId;
	private Long refAppBeanId;
	private Long refViewId;
	private String refColumnName;

	public Long getRefModuleId() {
		return refModuleId;
	}

	public void setRefModuleId(Long refModuleId) {
		this.refModuleId = refModuleId;
	}

	public Long getRefAppBeanId() {
		return refAppBeanId;
	}

	public void setRefAppBeanId(Long refAppBeanId) {
		this.refAppBeanId = refAppBeanId;
	}

	public Long getRefViewId() {
		return refViewId;
	}

	public void setRefViewId(Long refViewId) {
		this.refViewId = refViewId;
	}

	public String getRefColumnName() {
		return refColumnName;
	}

	public void setRefColumnName(String refColumnName) {
		this.refColumnName = refColumnName;
	}

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

	public int getFieldType() {
		return fieldType;
	}

	public void setFieldType(int fieldType) {
		this.fieldType = fieldType;
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
