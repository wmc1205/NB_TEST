package com.example.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NTDeleteVO {
	
	private int idx;
	private String user;
	private String customerId;
	
	@Builder
	public NTDeleteVO(int idx, String user, String customerId) {
		super();
		this.idx = idx;
		this.user = user;
		this.customerId = customerId;
	}
	
	

}
