package com.example.first.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "oders")
public class Oders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="date")
	private String date;
	
	@Column(name="status")
	private String stautus;
	
	@OneToOne(mappedBy = "oders")
	OderDetails oderDetail = new OderDetails();
	
	@ManyToOne
	@JoinColumn(name = "Userid")
	private UsersEntity usersEntity;

	public Oders(Long id, String date, String stautus, OderDetails oderDetail, UsersEntity usersEntity) {
		super();
		this.id = id;
		this.date = date;
		this.stautus = stautus;
		this.oderDetail = oderDetail;
		this.usersEntity = usersEntity;
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

	public String getStautus() {
		return stautus;
	}

	public void setStautus(String stautus) {
		this.stautus = stautus;
	}

	public OderDetails getOderDetail() {
		return oderDetail;
	}

	public void setOderDetail(OderDetails oderDetail) {
		this.oderDetail = oderDetail;
	}

	public UsersEntity getUsersEntity() {
		return usersEntity;
	}

	public void setUsersEntity(UsersEntity usersEntity) {
		this.usersEntity = usersEntity;
	}

}
