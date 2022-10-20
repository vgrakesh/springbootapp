package com.example.demo.ui.services;

import com.example.demo.ui.requestModels.CreateUserRequest;
import com.example.demo.ui.requestModels.UpdateUserRequest;
import com.example.demo.ui.responseModels.CreateUserResponse;
import com.example.demo.ui.responseModels.UserDetails;

public interface AppService {
	CreateUserResponse CreateUser(CreateUserRequest userDetails);
	UserDetails GetUser(String userId);
	CreateUserResponse UpdateUser(String userId, UpdateUserRequest userDetails);
	CreateUserResponse DeleteUser(String userId);
}
