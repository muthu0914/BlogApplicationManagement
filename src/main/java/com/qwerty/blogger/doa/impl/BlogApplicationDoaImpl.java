package com.qwerty.blogger.doa.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.qwerty.blogger.doa.BlogApplicationDoa;
import com.qwerty.blogger.pojo.BlogPostData;
import com.qwerty.blogger.pojo.BlogPostStatus;
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

@Repository
public class BlogApplicationDoaImpl implements BlogApplicationDoa {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public String GetUser(String userId) {
		String query = "SELECT user_type FROM user_management.user_details WHERE user_id =:userIdValue";
		MapSqlParameterSource params= new MapSqlParameterSource("userIdValue", userId);
		return namedParameterJdbcTemplate.queryForObject(query, params, String.class);		
	}
	
	@Override
	public CreateBlogPostResponse CreateBlogPost(CreateBlogPostRequest createBlogPostRequest) {
		CreateBlogPostResponse createBlogPostResponse =  new CreateBlogPostResponse();
		
		String query = "INSERT INTO blog_post_management.blog_post(blog_id,header_block,footer_block,body_block,contact_block,status,user_id) VALUES(:blogIdValue,:headerValue,:footerValue,:bodyValue,:contactValue,:statusValue,:userIdValue)";
		MapSqlParameterSource params = new MapSqlParameterSource();
		String blogId = UUID.randomUUID().toString();
		params.addValue("blogIdValue", blogId);
		params.addValue("headerValue", createBlogPostRequest.getBlogData().getHeaderBlock());
		params.addValue("footerValue", createBlogPostRequest.getBlogData().getFooterBlock());
		params.addValue("bodyValue", createBlogPostRequest.getBlogData().getBodyBlock());
		params.addValue("contactValue", createBlogPostRequest.getBlogData().getContactInfoBlock());
		params.addValue("statusValue", BlogPostStatus.IN_PROGRESS.name());
		params.addValue("userIdValue", createBlogPostRequest.getBlogData().getUserId());
		int insertStatus = namedParameterJdbcTemplate.update(query, params);
		createBlogPostResponse.setResponseStatus(false);
		if(insertStatus>0) {
			createBlogPostResponse.setResponseStatus(true);
		}
		return createBlogPostResponse;
	}
	
	@Override
	public UpdateBlogPostResponse UpdateBlogPost(UpdateBlogPostRequest updateBlogPostRequest) {
		UpdateBlogPostResponse updateBlogPostResponse = new UpdateBlogPostResponse();
		
		String query = "UPDATE blog_post_management.blog_post SET status =:statusValue WHERE blog_id =:blogIdValue AND user_id =:userIdValue";
		String statusValue = BlogPostStatus.POSTED.name();
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("statusValue", statusValue);
		params.addValue("blogIdValue", updateBlogPostRequest.getBlogId());
		params.addValue("userIdValue", updateBlogPostRequest.getUserId());
		int updateStatus = namedParameterJdbcTemplate.update(query, params);
		updateBlogPostResponse.setResponseStatus(false);
		if(updateStatus>0) {
			updateBlogPostResponse.setResponseStatus(true);
		}
		return updateBlogPostResponse;
	}

	@Override
	public GetBlogPostListResponse GetBlogPostByUserIdRequest(GetBlogPostByUserIdRequest getBlogPostByUserIdRequest) {
		GetBlogPostListResponse getBlogPostByUserIdResponse = new GetBlogPostListResponse();
		String query="SELECT * FROM blog_post_management.blog_post WHERE user_id =:userIdValue";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("userIdValue", getBlogPostByUserIdRequest.getUserId());
		List<BlogPostData> listOfBlogData = (List<BlogPostData>) namedParameterJdbcTemplate.query(query, params,
				new BeanPropertyRowMapper<>(BlogPostData.class));
		getBlogPostByUserIdResponse.setBlogPostDataList(listOfBlogData);
		return getBlogPostByUserIdResponse;
	}

	@Override
	public GetBlogPostListResponse GetAllBlogPostByStatus(GetBlogPostByStatusRequest getBlogPostByStatusRequest) {
		GetBlogPostListResponse getBlogPostListResponse = new GetBlogPostListResponse();
		String query = "SELECT * FROM blog_post_management.blog_post WHERE status =:statusValue";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("statusValue", getBlogPostByStatusRequest.getStatus());
		List<BlogPostData> listOfBlogData = (List<BlogPostData>) namedParameterJdbcTemplate.query(query, params,
					new BeanPropertyRowMapper<>(BlogPostData.class));
		getBlogPostListResponse.setBlogPostDataList(listOfBlogData);
		return getBlogPostListResponse;
	}

	@Override
	public RegisterUserResponse RegisterUser(RegisterUserRequest registerUserRequest) {
		RegisterUserResponse registerUserResponse = new RegisterUserResponse();
		String query ="INSERT INTO user_management.user_details(user_id,name,email,date_of_birth,user_type) VALUES(:userIdValue,:nameValue,:emailValue,:dateOfBirthValue,:userTypeValue)";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("userIdValue", UUID.randomUUID().toString());
		params.addValue("nameValue", registerUserRequest.getUserData().getName());
		params.addValue("emailValue", registerUserRequest.getUserData().getEmail());
		params.addValue("dateOfBirthValue", registerUserRequest.getUserData().getDateOfBirth());
		params.addValue("userTypeValue", UserType.USER.name());
		int insertStatus = namedParameterJdbcTemplate.update(query, params);
		registerUserResponse.setResponseStatus(false);
		if(insertStatus>0) {
			registerUserResponse.setResponseStatus(true);
		}
		return registerUserResponse;
	}

}
