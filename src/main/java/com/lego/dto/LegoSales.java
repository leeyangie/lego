package com.lego.dto;

public class LegoSales {
	
	int sno;
	int pno;
	int amount;
	int tot;
	String id;
	String paymethod;
	String paynum;
	String address;
	String tel;
	String delCom;
	String delTel;
	String delNo;
	String delStatus;
	String st;
	
	public LegoSales() {}
	
	public LegoSales(int sno, int pno, int amount, int tot, String id, String paymethod, String paynum, String address,
			String tel, String delCom, String delTel, String delNo, String delStatus, String st) {
		super();
		this.sno = sno;
		this.pno = pno;
		this.amount = amount;
		this.tot = tot;
		this.id = id;
		this.paymethod = paymethod;
		this.paynum = paynum;
		this.address = address;
		this.tel = tel;
		this.delCom = delCom;
		this.delTel = delTel;
		this.delNo = delNo;
		this.delStatus = delStatus;
		this.st = st;
		
		
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPaymethod() {
		return paymethod;
	}

	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}

	public String getPaynum() {
		return paynum;
	}

	public void setPaynum(String paynum) {
		this.paynum = paynum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getDelCom() {
		return delCom;
	}

	public void setDelCom(String delCom) {
		this.delCom = delCom;
	}

	public String getDelTel() {
		return delTel;
	}

	public void setDelTel(String delTel) {
		this.delTel = delTel;
	}

	public String getDelNo() {
		return delNo;
	}

	public void setDelNo(String delNo) {
		this.delNo = delNo;
	}

	public String getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(String delStatus) {
		this.delStatus = delStatus;
	}

	public String getSt() {
		return st;
	}

	public void setSt(String st) {
		this.st = st;
	}

	
}
