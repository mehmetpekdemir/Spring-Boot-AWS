package com.mehmetpekdemir.awsdeployment.service;

import java.util.List;

import com.mehmetpekdemir.awsdeployment.dto.UserResponse;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public interface UserService {

	List<UserResponse> getUsers();
	
}
