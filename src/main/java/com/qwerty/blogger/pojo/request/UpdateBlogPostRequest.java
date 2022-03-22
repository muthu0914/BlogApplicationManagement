package com.qwerty.blogger.pojo.request;

import com.qwerty.blogger.pojo.BlogPostStatus;

public class UpdateBlogPostRequest {
	private String blogId;
	private String userId;
	private BlogPostStatus status;
	public String getBlogId() {
		return blogId;
	}
	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public BlogPostStatus getStatus() {
		return status;
	}
	public void setStatus(BlogPostStatus status) {
		this.status = status;
	}
		
}
