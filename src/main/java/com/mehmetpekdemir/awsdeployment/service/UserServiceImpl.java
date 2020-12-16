package com.mehmetpekdemir.awsdeployment.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mehmetpekdemir.awsdeployment.dto.UserResponse;
import com.mehmetpekdemir.awsdeployment.entity.UserEntity;
import com.mehmetpekdemir.awsdeployment.repository.UserRepository;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<UserResponse> getUsers() {
		return userRepository.findAll().stream() //
				.map(userEntity -> mapToUserResponse(userEntity)) //
				.collect(Collectors.toList()); //

	}

	private UserResponse mapToUserResponse(UserEntity userEntity) {
		return UserResponse.builder() //
				.id(userEntity.getId()) //
				.username(userEntity.getUsername()) //
				.build(); //
	}

}
