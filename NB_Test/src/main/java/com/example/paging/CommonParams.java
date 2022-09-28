package com.example.paging;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonParams {
	
	private int page;	//현재 페이지 번호
	private int recordPerPage; // 페이지당 출력할 데이터 개수
	private int pageSize; // 화면 하단에 출력할 페이지 개수
	private String titleSH;	//타이틀 키워드
	private String labelTypeSH; //타입 선택
	private String regUserSH; //유저이름 키워드
	
}
