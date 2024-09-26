package com.example.first.dto.request;

public class CreateOderDetailRequest {
	private int quantity;
	private Long oderprd;
	private Long Oder_id;
	private String color;
	private String memory;
	
	
	
	public CreateOderDetailRequest(int quantity, Long oderprd, Long oder_id, String color, String memory) {
		super();
		this.quantity = quantity;
		this.oderprd = oderprd;
		Oder_id = oder_id;
		this.color = color;
		this.memory = memory;
	}
	public CreateOderDetailRequest() {
		
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Long getOderprd() {
		return oderprd;
	}
	public void setOderprd(Long oderprd) {
		this.oderprd = oderprd;
	}
	public Long getOder_id() {
		return Oder_id;
	}
	public void setOder_id(Long oder_id) {
		Oder_id = oder_id;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMemory() {
		return memory;
	}
	public void setMemory(String memory) {
		this.memory = memory;
	}
	
	
	
}
