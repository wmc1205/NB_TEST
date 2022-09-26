package com.example.dto;

import java.math.BigInteger;

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
	private String labelType;
	private String title;
	private String content;
	private String startDt;
	private String endDt;
	private String reg_user;
	private String regDt;
	private String regTm;
	

	
}
