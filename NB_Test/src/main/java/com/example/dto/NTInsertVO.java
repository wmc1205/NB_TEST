package com.example.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NTInsertVO {
	
	private String title;
	private String contents;
	private String status;
	private String labelType;
	private String importance;
	private String start_dt,start_tm;
	private String end_dt,end_tm;
	private String reg_dt;
	private String reg_tm;
	private String reg_user;
	
	
	
}
