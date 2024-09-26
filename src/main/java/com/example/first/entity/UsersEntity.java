package com.example.first.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UsersEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column(name = "fullName")
	private String fullName;
	
	@Column(name = "address")
	private String address;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="email")
	private String email;
	
	@Column(name="birth")
	private String birth;
	
	@Column(name="userName")
	private String userName;
	
	@Column(name="passWord")
	private String passWord;
	
	@Column(name="code")
	private String code;

	@OneToMany(mappedBy = "usersEntity")
	List<Oders> oderList = new ArrayList<Oders>();
	
	public UsersEntity(Long id, String fullName, String address, String phone, String email, String birth,
			String userName, String passWord, String code) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.birth = birth;
		this.userName = userName;
		this.passWord = passWord;
		this.code = code;
	}
	
	public UsersEntity(Long id, String fullName, String address, String phone, String email, String birth,
			String userName, String passWord, String code, List<Oders> oderList) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.birth = birth;
		this.userName = userName;
		this.passWord = passWord;
		this.code = code;
		this.oderList = oderList;
	}

	public UsersEntity() {
		
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = "client";
	}

	public List<Oders> getOderList() {
		return oderList;
	}

	public void setOderList(List<Oders> oderList) {
		this.oderList = oderList;
	}	
}
