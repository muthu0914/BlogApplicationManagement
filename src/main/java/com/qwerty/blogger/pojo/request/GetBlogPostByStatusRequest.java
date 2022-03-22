package com.qwerty.blogger.pojo.request;

public class GetBlogPostByStatusRequest {
	private String status;
	private String userId;

	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
