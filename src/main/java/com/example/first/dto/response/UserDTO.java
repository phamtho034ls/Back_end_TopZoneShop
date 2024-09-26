package com.example.first.dto.response;

public class UserDTO {
	private Long id ;
	private String fullName;
	private String phone;
	private String address;
	private String email;
	private String birth;
	private String userName;
	private String passWord;
	
	public UserDTO(Long id, String fullName, String phone, String address, 
			String email, String birth, String userName,
			String passWord) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.birth = birth;
		this.userName = userName;
		this.passWord = passWord;
	}
	public UserDTO() {
	
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	
}
