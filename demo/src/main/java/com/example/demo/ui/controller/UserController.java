package com.example.demo.ui.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ui.requestModels.CreateUserRequest;
import com.example.demo.ui.requestModels.UpdateUserRequest;
import com.example.demo.ui.responseModels.UserDetails;
import com.example.demo.ui.services.AppService;
import com.example.demo.ui.responseModels.CreateUserResponse;

@RestController
@RequestMapping("users")
public class UserController {
	
	@Autowired
	AppService appService;
	
	@GetMapping
	public ResponseEntity<UserDetails> getUserRp(@RequestParam("userId") String userId, @RequestParam(value="state", defaultValue="") String state) {
		UserDetails response = appService.GetUser(userId);
		if (response != null) {
			return new ResponseEntity<UserDetails>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<UserDetails>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping(path="/{userId}/state/{state}", produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserDetails> getUser(@PathVariable("userId") String userId, @PathVariable("state") String state) {
		UserDetails response = appService.GetUser(userId);
		if (response != null) {
			return new ResponseEntity<UserDetails>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<UserDetails>(HttpStatus.NO_CONTENT);
		} 
	}
	
	@PostMapping(consumes={MediaType.APPLICATION_GRAPHQL_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}, produces={MediaType.APPLICATION_GRAPHQL_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<CreateUserResponse> createUser(@Valid @RequestBody CreateUserRequest userDetails) {
		CreateUserResponse returnData = appService.CreateUser(userDetails);
		return new ResponseEntity<CreateUserResponse>(returnData, HttpStatus.OK);
	}
	
	@PutMapping(path="/{userId}")
	public ResponseEntity<CreateUserResponse> updateUser(@PathVariable("userId") String userId, @RequestBody UpdateUserRequest userDetails) {
		CreateUserResponse returnData = appService.UpdateUser(userId, userDetails);
		return new ResponseEntity<CreateUserResponse>(returnData, HttpStatus.OK);
	}
	
	@DeleteMapping(path="/{userId}")
	public ResponseEntity<CreateUserResponse> deleteUser(@PathVariable("userId") String userId) {
		CreateUserResponse returnData = appService.DeleteUser(userId);
		return new ResponseEntity<CreateUserResponse>(returnData, HttpStatus.OK);
	}

}
