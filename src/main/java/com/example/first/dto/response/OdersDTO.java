package com.example.first.dto.response;

import java.util.List;

import com.example.first.dto.request.CreateOderDetailRequest;
import com.example.first.dto.request.CreateUserRequest;

public class OdersDTO {
	private Long id;
	private String date;
	private String status;
	private UserDTO userDTO;
	private List<OdersDetailDTO> listodeDetailDTOs ; 
	


	public OdersDTO(Long id, String date, String status, UserDTO userDTO, List<OdersDetailDTO> listodeDetailDTOs) {
		super();
		this.id = id;
		this.date = date;
		this.status = status;
		this.userDTO = userDTO;
		this.listodeDetailDTOs = listodeDetailDTOs;
	}

	public OdersDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public List<OdersDetailDTO> getListodeDetailDTOs() {
		return listodeDetailDTOs;
	}

	public void setListodeDetailDTOs(List<OdersDetailDTO> listodeDetailDTOs) {
		this.listodeDetailDTOs = listodeDetailDTOs;
	}

	

	

	



	
}
