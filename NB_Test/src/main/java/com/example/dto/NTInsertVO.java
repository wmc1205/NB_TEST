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
public class NTInsertVO {
	private String labelType;
	private String title;
	private String contents;
	private String startDt;
	private String endDt;
	private String registor;
	private String customerId;
	
	@Builder
	public NTInsertVO(String labelType, String title, String contents, String startDt, String endDt, String registor,
			String customerId) {
		super();
		this.labelType = labelType;
		this.title = title;
		this.contents = contents;
		this.startDt = startDt;
		this.endDt = endDt;
		this.registor = registor;
		this.customerId = customerId;
	}
	
	
}
