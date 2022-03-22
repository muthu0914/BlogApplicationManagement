package com.qwerty.blogger.pojo;

public class BaseResponse {
	private boolean responseStatus;
	private String message;
	
	public boolean isResponseStatus() {
		return responseStatus;
	}
	public void setResponseStatus(boolean responseStatus) {
		this.responseStatus = responseStatus;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
