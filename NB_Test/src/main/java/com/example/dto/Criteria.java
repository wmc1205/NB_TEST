package com.example.dto;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Criteria {
	private String labelType;
	private String title;
	private String reg_user;
	
	public String makeQuery() {
		UriComponentsBuilder ucb = UriComponentsBuilder.newInstance();
		if(labelType != null && labelType != "" ) {
			ucb.queryParam("labelType", this.labelType);
		}
		if(title != null && title != "") {
			ucb.queryParam("title", this.labelType);
		}
		if(reg_user != null && reg_user != "") {
			ucb.queryParam("reg_user", this.reg_user);
		}
		return ucb.build().encode().toString();
	}	
	@Override
	public String toString() {
		return "Criteria [labelType= " + labelType  + ",title=" +title
				 + ",reg_user=" + reg_user;
	}

}
