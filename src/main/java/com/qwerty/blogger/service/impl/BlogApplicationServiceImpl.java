package com.qwerty.blogger.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qwerty.blogger.doa.BlogApplicationDoa;
import com.qwerty.blogger.pojo.UserData;
import com.qwerty.blogger.pojo.UserType;
import com.qwerty.blogger.pojo.request.CreateBlogPostRequest;
import com.qwerty.blogger.pojo.request.GetBlogPostByStatusRequest;
import com.qwerty.blogger.pojo.request.GetBlogPostByUserIdRequest;
import com.qwerty.blogger.pojo.request.RegisterUserRequest;
import com.qwerty.blogger.pojo.request.UpdateBlogPostRequest;
import com.qwerty.blogger.pojo.response.CreateBlogPostResponse;
import com.qwerty.blogger.pojo.response.GetBlogPostListResponse;
import com.qwerty.blogger.pojo.response.RegisterUserResponse;
import com.qwerty.blogger.pojo.response.UpdateBlogPostResponse;
import com.qwerty.blogger.service.BlogApplicationService;

@Service
public class BlogApplicationServiceImpl implements BlogApplicationService{
	
	@Autowired
	BlogApplicationDoa blogApplicationDoa;
	
	public CreateBlogPostResponse CreateBlogPost(CreateBlogPostRequest createBlogPostRequest) {
		return blogApplicationDoa.CreateBlogPost(createBlogPostRequest);
	}

	public UpdateBlogPostResponse UpdateBlogPost(UpdateBlogPostRequest updateBlogPostRequest) {
		//only SUPER_USER should update status of any blog posts
		String userType = blogApplicationDoa.GetUser(updateBlogPostRequest.getUserId());
		if(userType!=UserType.SUPER_USER.name()) {
			UpdateBlogPostResponse updateBlogPostResponse = new UpdateBlogPostResponse();
			updateBlogPostResponse.setResponseStatus(false);
			updateBlogPostResponse.setMessage("User Access Denied");
			return updateBlogPostResponse;
		}else {			
			return blogApplicationDoa.UpdateBlogPost(updateBlogPostRequest);
		}
	}

	@Override
	public GetBlogPostListResponse GetBlogPostByUserIdRequest(GetBlogPostByUserIdRequest getBlogPostByUserIdRequest) {
		return blogApplicationDoa.GetBlogPostByUserIdRequest(getBlogPostByUserIdRequest);
	}

	@Override
	public GetBlogPostListResponse GetAllBlogPostByStatus(GetBlogPostByStatusRequest getBlogPostByStatusRequest) {
		//only SUPER_USER should get all the blog post by STATUS
		String userType = blogApplicationDoa.GetUser(getBlogPostByStatusRequest.getUserId());
		if(userType!=UserType.SUPER_USER.name()) {
			GetBlogPostListResponse getBlogPostListResponse = new GetBlogPostListResponse();
			getBlogPostListResponse.setResponseStatus(false);
			getBlogPostListResponse.setMessage("User Access Denied");
			return getBlogPostListResponse;
		}else {	
			return blogApplicationDoa.GetAllBlogPostByStatus(getBlogPostByStatusRequest);
		}
	}

	@Override
	public RegisterUserResponse RegisterUser(RegisterUserRequest registerUserRequest) {
		return blogApplicationDoa.RegisterUser(registerUserRequest);
	}

}
