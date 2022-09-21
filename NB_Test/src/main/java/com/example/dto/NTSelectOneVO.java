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
	private String registor;
	private String regDt;
	private String regTm;
	
	@Builder
	public NTSelectOneVO(BigInteger idx, String labelType, String title, String content, String startDt, String endDt,
			String registor, String regDt, String regTm) {
		super();
		this.idx = idx;
		this.labelType = labelType;
		this.title = title;
		this.content = content;
		this.startDt = startDt;
		this.endDt = endDt;
		this.registor = registor;
		this.regDt = regDt;
		this.regTm = regTm;
	}

	
}
