package com.lego.dto;

public class LeogInventory {
	int ino;
	String productid;
	int iprice;
	int oprice;
	int amount;
	String remark;
	
	public LeogInventory() {}
	public LeogInventory(int ino, String productid, int iprice, int oprice, int amount, String remark) {
		super();
		this.ino = ino;
		this.productid = productid;
		this.iprice = iprice;
		this.oprice = oprice;
		this.amount = amount;
		this.remark = remark;
	}
	public int getIno() {
		return ino;
	}
	public void setIno(int ino) {
		this.ino = ino;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public int getIprice() {
		return iprice;
	}
	public void setIprice(int iprice) {
		this.iprice = iprice;
	}
	public int getOprice() {
		return oprice;
	}
	public void setOprice(int oprice) {
		this.oprice = oprice;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
	
}
