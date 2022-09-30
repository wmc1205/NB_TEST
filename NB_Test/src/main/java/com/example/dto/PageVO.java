package com.example.dto;

import java.math.BigInteger;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class PageVO {
	private int limit;
	private int page;
	private int startpage;
	private int endpage;
	private int maxpage;
	
	

}
