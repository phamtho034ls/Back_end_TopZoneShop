package com.example.first.model;

public class Product {
	private Long id;
	private String name;
	private int quantity;
	private double price;
	private String description;
	private String image;
	private String colors;
	private String memoy;
	private double discount;
	private String code;

	public Product(Long id, String name, int quantity, double price, String description, String image, String colors,
			String memoy, double discount, String code) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.description = description;
		this.image = image;
		this.colors = colors;
		this.memoy = memoy;
		this.discount = discount;
		this.code = code;
	}

	public Product() {

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getMemoy() {
		return memoy;
	}

	public void setMemoy(String memoy) {
		this.memoy = memoy;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

}
