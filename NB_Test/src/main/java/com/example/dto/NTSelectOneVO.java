package com.example.dto;

import java.math.BigInteger;
import java.sql.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NTSelectOneVO {
	private BigInteger idx;
	private String title;
	private String contents;
	private String labelType;
	private Date startDt;
	private Date endDt;
	private String regUser;
	private String regDt;
	private String regTm;
	

	
}
