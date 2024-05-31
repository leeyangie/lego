package com.lego.dto;

import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class IamPortClient {
	private final static String CODE="imp32543374";
	private final static String KEY="1041612764428142";
	private final static String SECRET="BTyTZJUNQSoT12BaHROGRZZbftNkwWhXKcaCVRy7jmuZcInzAvCfYDQ0hdpeTyoQTn7y69ZJIpBBKaTa";
	private String randChar;


	public static String getCode() {
		return CODE;
	}

	public static String getKey() {
		return KEY;
	}

	public static String getSecret() {
		return SECRET;
	}

	public IamPortClient() {
		Date date = new Date();
		this.randChar =  date + RandomStringUtils.randomAlphanumeric(12);
	}

	
}
