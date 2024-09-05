package com.example.first.dto.request;



public class CreateProductRequest {
	private Long cid;
	private String name;
	private int quantity;
	private double price;
	private String description;
	private  String image;
	private String colors;
	private String memory;
	private double discount;
	private String code;  
	
	
	public CreateProductRequest(Long cid, String name, int quantity, double price, String description, String image,
			String colors, String memory, double discount, String code) {
		super();
		this.cid = cid;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.description = description;
		this.image = image;
		this.colors = colors;
		this.memory = memory;
		this.discount = discount;
		this.code = code;
	}
	public CreateProductRequest() {
		
	}
	public Long getCid() {
		return cid;
	}
	public void setCid(Long cid) {
		this.cid = cid;
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
	
	
	
	
}
