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
public class NTUpdateVO {
	private int idx;
	private String customerId;
	private String title;
	private String contents;
	private String startDt;
	private String endDt;
	private String udtUser;
	private String labelType;
	
	@Builder
	public NTUpdateVO(int idx, String customerId, String title, String contents, String startDt, String endDt,
			String udtUser, String labelType) {
		super();
		this.idx = idx;
		this.customerId = customerId;
		this.title = title;
		this.contents = contents;
		this.startDt = startDt;
		this.endDt = endDt;
		this.udtUser = udtUser;
		this.labelType = labelType;
	}
	
	
}
