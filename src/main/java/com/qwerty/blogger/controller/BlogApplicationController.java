package com.qwerty.blogger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qwerty.blogger.pojo.BlogPostData;
import com.qwerty.blogger.pojo.UserData;
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

@RestController
@RequestMapping("/blogApplicationController")
public class BlogApplicationController {
	
	@Autowired
	BlogApplicationService blogApplicationService;
	
	@PostMapping("/registerUser")
	public RegisterUserResponse Registeruser(@RequestBody UserData userData) {
		RegisterUserRequest registerUserRequest = new RegisterUserRequest();
		registerUserRequest.setUserData(userData);
		return blogApplicationService.RegisterUser(registerUserRequest);
	}
	
	@PostMapping("/createBlogPost")
	public CreateBlogPostResponse CreateBlogPost(@RequestBody BlogPostData blogPostData) {
		CreateBlogPostRequest createBlogPostRequest =  new CreateBlogPostRequest();
		createBlogPostRequest.setBlogData(blogPostData);
		return blogApplicationService.CreateBlogPost(createBlogPostRequest);
	}
	
	@PostMapping("/updateBlogPost")
	public UpdateBlogPostResponse UpdateBlogPost(@RequestBody UpdateBlogPostRequest updateBlogPostRequest) {
		return blogApplicationService.UpdateBlogPost(updateBlogPostRequest);
	}
	
	@PostMapping("/getAllPostByUserId")
	public GetBlogPostListResponse GetAllPostByUserId(@RequestBody GetBlogPostByUserIdRequest getBlogPostByUserIdRequest) {
		return blogApplicationService.GetBlogPostByUserIdRequest(getBlogPostByUserIdRequest);
	}
	
	@PostMapping("/getAllBlogPostByStatus")
	public GetBlogPostListResponse GetAllBlogPostByStatus (@RequestBody GetBlogPostByStatusRequest getBlogPostByStatusRequest) {
		return blogApplicationService.GetAllBlogPostByStatus(getBlogPostByStatusRequest);
	}
}
