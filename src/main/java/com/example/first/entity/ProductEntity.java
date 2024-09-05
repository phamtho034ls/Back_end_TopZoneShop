package com.example.first.entity;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "price")
	private double price;

	@Column(name = "image")
	private String image;

	@Column(name = "colors")
	private String colors;

	@Column(name = "memory")
	private String memory;

	@Column(name = "discount")
	private double discount;

	@Column(name = "code")
	private String code;

	@ManyToOne
	@JoinColumn(name = "cid")
	private CategoryEntity category;

	@OneToMany(mappedBy = "product")
	List<OderDetails> listOderDetail = new ArrayList<>();

	public ProductEntity() {

	}

	public ProductEntity(Long id, String name, String description, int quantity, double price, String image,
			String colors, String memory, double discount, String code, CategoryEntity category,
			List<OderDetails> listOderDetail) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
		this.image = image;
		this.colors = colors;
		this.memory = memory;
		this.discount = discount;
		this.code = code;
		this.category = category;
		this.listOderDetail = listOderDetail;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getColors() {
		return colors;
	}

	public void setColors(String colors) {
		this.colors = colors;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public List<OderDetails> getListOderDetail() {
		return listOderDetail;
	}

	public void setListOderDetail(List<OderDetails> listOderDetail) {
		this.listOderDetail = listOderDetail;
	}

}
