package com.example.first.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "oderDetails")
public class OderDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "quantity")
	private int quantity;

	@ManyToOne
	@JoinColumn(name = "oderprd")
	private ProductEntity product;

	@ManyToOne
	@JoinColumn(name = "Oder_id")
	private Oders oders;

	public OderDetails(Long id, int quantity, ProductEntity product, Oders oders) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.product = product;
		this.oders = oders;
	}
	public OderDetails() {

	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public Oders getOders() {
		return oders;
	}

	public void setOders(Oders oders) {
		this.oders = oders;
	}

}
