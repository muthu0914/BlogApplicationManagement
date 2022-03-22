package com.qwerty.blogger.pojo.response;

import java.util.List;

import com.qwerty.blogger.pojo.BaseResponse;
import com.qwerty.blogger.pojo.BlogPostData;

public class GetBlogPostListResponse extends BaseResponse{
	private List<BlogPostData> blogPostDataList;

	public List<BlogPostData> getBlogPostDataList() {
		return blogPostDataList;
	}

	public void setBlogPostDataList(List<BlogPostData> blogPostDataList) {
		this.blogPostDataList = blogPostDataList;
	}
	
}
