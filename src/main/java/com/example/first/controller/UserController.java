package com.example.first.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.first.dto.request.CreateUserRequest;
import com.example.first.dto.response.UserDTO;
import com.example.first.entity.UsersEntity;
import com.example.first.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping("/list")
	public List<UserDTO> getListUsers() {
		return userService.getListUser();
	}

	@PostMapping("/create")
	public UserDTO createUser(@RequestBody CreateUserRequest bodyUserRequest) {
			
		return userService.saveUser(bodyUserRequest);
	}
	
//	@PutMapping("/update/{id}")
//	public UserDTO createUser(@PathVariable Long id , @RequestBody CreateUserRequest bodyUserRequest) {
//		UsersEntity newUser = new UsersEntity();
//		newUser.setId(id);
//		newUser.setAddress(bodyUserRequest.getAddress());
//		newUser.setBirth(bodyUserRequest.getBirth());
//		newUser.setEmail(bodyUserRequest.getEmail());
//		newUser.setFullName(bodyUserRequest.getFullName());
//		newUser.setPassWord(bodyUserRequest.getPassWord());
//		newUser.setPhone(bodyUserRequest.getPhone());
//		newUser.setUserName(bodyUserRequest.getUserName());
//		newUser.setCode(bodyUserRequest.getCode());		
//		return userService.saveUser(newUser);
//	}
	@DeleteMapping("/delete/{id}")
	public boolean deleteUsers(@PathVariable Long id)
	{
		return userService.deleteUser(id);
	}
	@GetMapping ("detail/{id}")
	public UserDTO getDetailUser(@PathVariable Long id)
	{
		return userService.getDetail(id);
	}
}
