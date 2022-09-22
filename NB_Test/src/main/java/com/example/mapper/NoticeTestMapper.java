package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.dto.NTInsertVO;
import com.example.dto.NTSelectListVO;
import com.example.dto.NTSelectOneVO;
import com.example.dto.NTUpdateVO;

@Mapper
public interface NoticeTestMapper {
	
	/**
	 * 게시글 전체 조회
	 * @return 게시글 리스트
	 */
	public List<NTSelectListVO> noticeSelectList();
	public int insertOne(NTInsertVO paramDto); 

	public NTSelectOneVO noticeSelectOne(int idx);

	public int updateOne(NTUpdateVO paramDto);

	public int deleteOne(int idx);
}
