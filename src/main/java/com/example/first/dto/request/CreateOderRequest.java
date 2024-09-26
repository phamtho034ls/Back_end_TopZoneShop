package com.example.first.dto.request;

import java.util.List;

import com.example.first.dto.response.ProductDTO;
import com.example.first.dto.response.UserDTO;
import com.example.first.entity.OderDetails;
import com.example.first.entity.UsersEntity;

public class CreateOderRequest {
	private String date;
	private String status;
	private Long id;
	private CreateUserRequest user;
	private List<ProductDTO> listPoducts ;
	
	
	public CreateOderRequest() {
		super();
	}
	public CreateOderRequest(String date, String status, Long id, CreateUserRequest user,
			List<ProductDTO> listPoducts) {
		super();
		this.date = date;
		this.status = status;
		this.id = id;
		this.user = user;
		this.listPoducts = listPoducts;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public CreateUserRequest getUser() {
		return user;
	}
	public void setUser(CreateUserRequest user) {
		this.user = user;
	}
	public List<ProductDTO> getListPoducts() {
		return listPoducts;
	}
	public void setListPoducts(List<ProductDTO> listPoducts) {
		this.listPoducts = listPoducts;
	} 
	
	
	
	
}
