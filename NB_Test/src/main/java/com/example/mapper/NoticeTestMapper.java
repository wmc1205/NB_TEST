package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.dto.NTSelectListVO;

@Mapper
public interface NoticeTestMapper {

	public List<NTSelectListVO> noticeSelectList();
	public int insertOne(NTSelectListVO paramDto); 

	public NTSelectListVO noticeSelectOne(int idx);

	public int updateOne(NTSelectListVO paramDto);

	public int deleteOne(int idx);
}
