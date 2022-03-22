package com.qwerty.blogger.pojo.request;

import com.qwerty.blogger.pojo.BlogPostData;

public class CreateBlogPostRequest {
	private BlogPostData blogData;

	public BlogPostData getBlogData() {
		return blogData;
	}

	public void setBlogData(BlogPostData blogData) {
		this.blogData = blogData;
	}
	
}
