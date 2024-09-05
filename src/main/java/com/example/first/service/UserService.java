package com.example.first.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.first.dto.response.UserDTO;
import com.example.first.entity.UsersEntity;
import com.example.first.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;

	}

	public List<UserDTO> getListUser() {
		List<UsersEntity> result = userRepository.findAll();
		List<UserDTO> ListDto = new ArrayList<UserDTO>();

		for (UsersEntity userE : result) {
			UserDTO dto = new UserDTO(userE.getId(), userE.getFullName(), userE.getPhone(), userE.getAddress(),
					userE.getEmail(), userE.getBirth(), userE.getUserName(), userE.getPassWord());
			ListDto.add(dto);
		}
		return ListDto;
	}
	public UserDTO saveUser(UsersEntity newUser)
	{
		UsersEntity User = userRepository.save(newUser);
		UserDTO dto = new UserDTO();
		dto.setId(User.getId());
		dto.setFullName(User.getFullName());
		dto.setPhone(User.getPhone());
		dto.setAddress(User.getAddress());
		dto.setEmail(User.getEmail());
		dto.setBirth(User.getBirth());
		dto.setUserName(User.getUserName());
		dto.setPassWord(User.getPassWord());
		
		return dto;
	}
	public boolean deleteUser(Long id)
	{
		boolean isExit = userRepository.existsById(id);
		if (isExit)
		{
			userRepository.deleteById(id);
			return true;
		}
		return false ; 
	}
	public UserDTO getDetail(Long id )
	{
		UsersEntity User = userRepository.findById(id).get();
		UserDTO dto = new UserDTO();
		dto.setId(User.getId());
		dto.setFullName(User.getFullName());
		dto.setPhone(User.getPhone());
		dto.setAddress(User.getAddress());
		dto.setEmail(User.getEmail());
		dto.setBirth(User.getBirth());
		dto.setUserName(User.getUserName());
		dto.setPassWord(User.getPassWord());
		
		return dto;
	}
}
