package com.example.dto;


import java.sql.Date;

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
	private Date startDt,startTm;
	private Date endDt,endTm;
	private String reg_user;
	private String reg_dt;
	private String reg_tm;
	
	
	
}
