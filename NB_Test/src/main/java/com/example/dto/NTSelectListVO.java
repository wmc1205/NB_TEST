package com.example.dto;

import java.math.BigInteger;
import java.sql.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class NTSelectListVO {
	
	private BigInteger idx;
	private String type;
	private String title;
	private String startDt;
	private String endDt;
	private String regUser;
	private String regDt;
	private String regTm;
	

}
