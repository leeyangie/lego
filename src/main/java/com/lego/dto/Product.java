package com.lego.dto;

public class Product {
	
	private String productid;
	private String productcategory;
	private String productname;
	private String description;
	private int price;
	private String img1;
	private String img2;
	private String img3;
	
	public Product() {}

	public Product(String productid, String productcategory, String productname, String description, int price,
			String img1, String img2, String img3) {
		super();
		this.productid = productid;
		this.productcategory = productcategory;
		this.productname = productname;
		this.description = description;
		this.price = price;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getProductcategory() {
		return productcategory;
	}

	public void setProductcategory(String productcategory) {
		this.productcategory = productcategory;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImg1() {
		return img1;
	}

	public void setImg1(String img1) {
		this.img1 = img1;
	}

	public String getImg2() {
		return img2;
	}

	public void setImg2(String img2) {
		this.img2 = img2;
	}

	public String getImg3() {
		return img3;
	}

	public void setImg3(String img3) {
		this.img3 = img3;
	}
	
	
}