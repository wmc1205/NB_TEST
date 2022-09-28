package com.example.paging;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pagination {
	private int page;	//현재 내가 보고 있는 페이지(요청받은 페이지)
	private int boardCount; //총 게시글 개수
	private int perPage = 10;	//화면 당 출력할 게시글 개수
	private int perSection = 10; //화면 당 출력할 페이지 개수
	private int offset;		//쿼리문에서 건너뛸 레코드 개수(perPage 개수만큼)
	private int pageCount;	//페이지 전체 개수
	private int begin;		//쪽번호 시작[defaultVaule = 1]
	private int end;		//쪽 번호 끝
	
	private boolean prev;	//perSection을 기준으로 이전 버튼을 출력하는 조건
	private boolean next;	//perSection을 기준으로 다믕 버튼을 출력하는 조건
	
	public Pagination(int page, int boardCount) {	//생성자에서 요청받은 페이지와 총 게시글을 받아온다.
		offset = (page -1) * perPage; //1페이지면 건너띌 게시글 0개, 2페이지면 건너띌 게시글 10개...
		begin = ((int) (page - 0.1)/ perSection) * perSection + 1; 
		//페이지는 int이기 때문에 소수점으로 나오는 값을 int로 형변환하여 내림하도록 한다.
		//1페이지에서 시작해서 10페이지(perSection)이 지나면 begin은 11, 또 10페이지(persection *2)가 지나면 21..
		//다음 페이지를 넘기면 쪽 수는 10페이지가 넘어가서 'x1'에 있도록 한다.
		end = begin + perSection - 1; // 10, 20, 30... (n * 10) / begin은 1의자리수가 1인 수
		boolean flag = boardCount % perPage != 0;	
		//나누어 떨어질 경우에는 pageCount를 증가시키지 않는다.
		//boardCount = 500 -> 50페이지
		//boardCount = 501 -> 51페이지
		
		pageCount = boardCount / perPage + (flag ? 1: 0); //조건에 따라 페이지 개수를 1 증가시킨다.
		end = end > pageCount ? pageCount : end;	
		//마지막 쪽 번호는 전체 페이지 수를 초과할 수 없다. 따라서 end와 pageCount 중 더 작은 값을 end 값으로 지정한다.
		int section = (page - 1) / perSection; //section : 현재 섹션 (1페이지는 0번 -> 그 다음부터 1번)
		int lastSection = (pageCount - 1)/ perSection; //페이지 개수를 토대로 마지막 섹션 번호를 구한다.
		prev = begin > perSection ; 	//이전 버튼은 쪽번호가 perSection값보다 클때 존재
		next = lastSection > section;	//다음 버튼은 현재 섹션이 마지막 섹션보다 작을 경우에 존재.
		
	}
}
