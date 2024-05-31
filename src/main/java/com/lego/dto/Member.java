package com.lego.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	private String id;
	private String pw;
	private String name;
	private String email;
	private String tel;
	private String address1;
	private String address2;
	private String postcode;
	private int point;
	private String regdate;


}
