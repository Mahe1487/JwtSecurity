package com.kmb.SpringBootJWT.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kmb.SpringBootJWT.Entity.UserEntity;
import com.kmb.SpringBootJWT.Repository.UserRepository;
import com.kmb.SpringBootJWT.Service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	
	@Autowired
	private UserRepository userRepository; //HAS-A
	
	@Override
	public Integer saveUser(UserEntity user) {
		// TODO : encode password
		return userRepository.save(user).getId();
	}

}
