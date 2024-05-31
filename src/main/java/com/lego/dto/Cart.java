package com.lego.dto;

public class Cart {
	
	int cart;
	String productid;
	String id;
	int quantity;
	String added_date;
	
	
	public Cart() {}
	public Cart(int cart, String productid, String id, int quantity, String added_date) {
		super();
		this.cart = cart;
		this.productid = productid;
		this.id = id;
		this.quantity = quantity;
		this.added_date = added_date;
	}
	public int getCart() {
		return cart;
	}
	public void setCart(int cart) {
		this.cart = cart;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getAdded_date() {
		return added_date;
	}
	public void setAdded_date(String added_date) {
		this.added_date = added_date;
	}
	

}
