package com.example.first.dto.response;

public class OdersDTO {
	private Long id;
	private String date;
	private String status;
	private UserDTO userDto;
	private OdersDetailDTO oderDetailDto;

	public OdersDTO(Long id, String date, String status, UserDTO userDto, OdersDetailDTO oderDetailDto) {
		super();
		this.id = id;
		this.date = date;
		this.status = status;
		this.userDto = userDto;
		this.oderDetailDto = oderDetailDto;
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

	public UserDTO getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDTO userDto) {
		this.userDto = userDto;
	}

	public OdersDetailDTO getOderDetailDto() {
		return oderDetailDto;
	}

	public void setOderDetailDto(OdersDetailDTO oderDetailDto) {
		this.oderDetailDto = oderDetailDto;
	}

}
