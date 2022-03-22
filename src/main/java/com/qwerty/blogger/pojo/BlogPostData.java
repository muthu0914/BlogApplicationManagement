package com.qwerty.blogger.pojo;

public class BlogPostData {
	private String blogId;
	private String userId;
	private String headerBlock;
	private String footerBlock;
	private String bodyBlock;
	private String contactInfoBlock;
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
	public String getHeaderBlock() {
		return headerBlock;
	}
	public void setHeaderBlock(String headerBlock) {
		this.headerBlock = headerBlock;
	}
	public String getFooterBlock() {
		return footerBlock;
	}
	public void setFooterBlock(String footerBlock) {
		this.footerBlock = footerBlock;
	}
	public String getBodyBlock() {
		return bodyBlock;
	}
	public void setBodyBlock(String bodyBlock) {
		this.bodyBlock = bodyBlock;
	}
	public String getContactInfoBlock() {
		return contactInfoBlock;
	}
	public void setContactInfoBlock(String contactInfoBlock) {
		this.contactInfoBlock = contactInfoBlock;
	}
	public BlogPostStatus getStatus() {
		return status;
	}
	public void setStatus(BlogPostStatus status) {
		this.status = status;
	}
	
}
