package com.example.dto;

import java.math.BigInteger;
import java.sql.Date;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NTUpdateVO {
	private BigInteger idx;
	private String title;
	private String contents;
	private String type;
	private String start_dt;
	private String end_dt;
	//private String udt_user;
	
//	@Builder
//	public NTUpdateVO(int idx, String title, String contents, String start_dt, String end_dt,
//			String udt_user, String labelType) {
//		super();
//		this.idx = idx;
//		this.title = title;
//		this.contents = contents;
//		this.start_dt = start_dt;
//		this.end_dt = end_dt;
//		this.udt_user = udt_user;
//		this.labelType = labelType;
//	}
//	
	
}
