package com.lego.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductVO {
	private String productid;
	private String productcategory;
	private String productname;
	private String description;
	private String img1;
	private String img2;
	private String img3;
	private int iprice;
	private int oprice;
	private int amount;
	private int price;
}