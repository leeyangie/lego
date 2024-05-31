package com.lego.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {
	private int ino;
	private String productid;
	private String productname;
	private int iprice;
	private int oprice;
	private int amount;
	private String remark;
	private String resdate;
}
