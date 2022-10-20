package com.example.demo.ui.servicesImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.AppBusinessException;
import com.example.demo.ui.requestModels.CreateUserRequest;
import com.example.demo.ui.requestModels.UpdateUserRequest;
import com.example.demo.ui.responseModels.CreateUserResponse;
import com.example.demo.ui.responseModels.UserDetails;
import com.example.demo.ui.services.AppService;
import com.example.demo.ui.shared.SharedUtils;

@Service
public class AppServiceImpl implements AppService {

	Map<String, UserDetails> users;
	SharedUtils utils;

	public AppServiceImpl() {
	};

	// Autowiring is done to instantiate and inject sharedutils service thru
	// dependency injection
	@Autowired
	public AppServiceImpl(SharedUtils utils) {
		this.utils = utils;
	}

	@Override
	public CreateUserResponse CreateUser(CreateUserRequest userDetails) {
		/*
		 * if (true) throw new
		 * AppBusinessException("This is a business/custom exception."); String test =
		 * null; test.length();
		 */
		String userId = utils.generateUUID();
		UserDetails userData = new UserDetails();
		userData.setFirstName(userDetails.getFirstName());
		userData.setLastName(userDetails.getLastName());
		userData.setEmail(userDetails.getEmail());
		userData.setPhone(userDetails.getPhone());
		userData.setUserId(userId);
		userData.setStatus("active");
		if (users == null)
			users = new HashMap<>();
		users.put(userId, userData);

		CreateUserResponse returnData = new CreateUserResponse();
		returnData.setStatus("success");
		returnData.setUserId(userId);
		returnData.setMessage(userDetails.getFirstName() + " " + userDetails.getLastName() + " is now a user");
		return returnData;
	}

	@Override
	public UserDetails GetUser(String userId) {
		if (users != null && users.containsKey(userId)) {
			UserDetails returnData = users.get(userId);
			return returnData;
		} else {
			return null;
		}
	}

	@Override
	public CreateUserResponse UpdateUser(String userId, UpdateUserRequest userDetails) {
		if (users != null && users.containsKey(userId)) {
			UserDetails userData = users.get(userId);
			userData.setFirstName(userDetails.getFirstName());
			userData.setLastName(userDetails.getLastName());
		}
		CreateUserResponse returnData = new CreateUserResponse();
		returnData.setStatus("success");
		returnData.setMessage("User update successful");
		returnData.setUserId(userId);
		return returnData;
	}

	@Override
	public CreateUserResponse DeleteUser(String userId) {
		if (users != null && users.containsKey(userId)) {
			users.remove(userId);
		}
		CreateUserResponse returnData = new CreateUserResponse();
		returnData.setStatus("success");
		returnData.setMessage("User delete successful");
		return returnData;
	}

}
