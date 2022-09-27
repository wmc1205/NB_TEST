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
	private String labelType;
	private String title;
	private Date startDt;
	private Date endDt;
	private String regUser;
	private String regDt;
	private String regTm;
	

}
