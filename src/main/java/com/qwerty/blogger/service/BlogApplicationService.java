package com.qwerty.blogger.service;

import com.qwerty.blogger.pojo.request.CreateBlogPostRequest;
import com.qwerty.blogger.pojo.request.GetBlogPostByStatusRequest;
import com.qwerty.blogger.pojo.request.GetBlogPostByUserIdRequest;
import com.qwerty.blogger.pojo.request.RegisterUserRequest;
import com.qwerty.blogger.pojo.request.UpdateBlogPostRequest;
import com.qwerty.blogger.pojo.response.CreateBlogPostResponse;
import com.qwerty.blogger.pojo.response.GetBlogPostListResponse;
import com.qwerty.blogger.pojo.response.RegisterUserResponse;
import com.qwerty.blogger.pojo.response.UpdateBlogPostResponse;

public interface BlogApplicationService {

	CreateBlogPostResponse CreateBlogPost(CreateBlogPostRequest createBlogPostRequest);

	UpdateBlogPostResponse UpdateBlogPost(UpdateBlogPostRequest updateBlogPostRequest);

	GetBlogPostListResponse GetBlogPostByUserIdRequest(GetBlogPostByUserIdRequest getBlogPostByUserIdRequest);

	GetBlogPostListResponse GetAllBlogPostByStatus(GetBlogPostByStatusRequest getBlogPostByStatusRequest);

	RegisterUserResponse RegisterUser(RegisterUserRequest registerUserRequest);

}
