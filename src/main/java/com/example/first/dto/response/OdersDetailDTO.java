package com.example.first.dto.response;

public class OdersDetailDTO {
	private int quantity;
	private ProductDTO product ;
	private OdersDTO oders;
	public OdersDetailDTO(int quantity, ProductDTO product, OdersDTO oders) {
		super();
		this.quantity = quantity;
		this.product = product;
		this.oders = oders;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public ProductDTO getProduct() {
		return product;
	}
	public void setProduct(ProductDTO product) {
		this.product = product;
	}
	public OdersDTO getOders() {
		return oders;
	}
	public void setOders(OdersDTO oders) {
		this.oders = oders;
	}
	
}
