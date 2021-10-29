package com.companyAssociation.demo.exception;

public class ErrorModel {
	private String errorMessage;
	private Object errorInfo;
	
	
	
	public ErrorModel(String errorMessage, Object errorInfo) {
		super();
		this.errorMessage = errorMessage;
		this.errorInfo = errorInfo;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public Object getErrorInfo() {
		return errorInfo;
	}
	public void setErrorInfo(Object errorInfo) {
		this.errorInfo = errorInfo;
	}
	
	

}
