package com.lego.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sales {
	private int sno;
	private String productid;
	private int amount;
	private int tot;
	private String id;
	private String paymethod;
	private String paynum;
	private String address;
	private String tel;
	private String delcom;
	private String deltel;
	private String delno;
	private String delstatus;
	private String st;
	private String gtid;
	private String rname;
	private String resdate;
}
