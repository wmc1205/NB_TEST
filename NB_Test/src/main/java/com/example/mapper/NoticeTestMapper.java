package com.example.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.dto.NTInsertVO;
import com.example.dto.NTSelectListVO;
import com.example.dto.NTSelectOneVO;
import com.example.dto.NTUpdateVO;
import com.example.paging.Pagination;

@Mapper
public interface NoticeTestMapper {
	
	/**
	 * 게시글 전체 조회
	 * @return 게시글 리스트
	 */
	//전체 조회
	public List<NTSelectListVO> noticeSelectList(HashMap<String,Object> param);
	
	//게시물 갯수 조회
	public int selectBoardCount(HashMap<String,Object> param);

	//데이터 추가
	public int insertOne(NTInsertVO paramDto); 
	//데이터 개별 조회
	public NTSelectOneVO noticeSelectOne(int idx);
	//데이터 개별 수정
	public int updateOne(NTUpdateVO paramDto);
	//데이터 개별 삭제
	public int deleteOne(int idx);

}
