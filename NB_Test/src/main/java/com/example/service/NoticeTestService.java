package com.example.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;


import com.example.dto.NTInsertVO;
import com.example.dto.NTSelectListVO;
import com.example.dto.NTSelectOneVO;
import com.example.dto.NTUpdateVO;
import com.example.mapper.NoticeTestMapper;
import com.example.paging.Pagination;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class NoticeTestService {
	
	private final NoticeTestMapper nbMapper;
	
	public List<NTSelectListVO> noticeSelectList(HashMap<String,Object> param) {
		
		return nbMapper.noticeSelectList(param);
	}
//	public List<NTSelectListVO> noticeSelectList(Pagination pagination) throws Exception{
//		return nbMapper.noticeSelectList(pagination);
//	}

	public int insertOne(NTInsertVO paramDto) {
		
		return nbMapper.insertOne(paramDto);
	}

	public NTSelectOneVO noticeSelectOne(int idx) {
		
		return nbMapper.noticeSelectOne(idx);
	}

	public int updateOne(NTUpdateVO paramDto) {
		
		return nbMapper.updateOne(paramDto);
	}

	public int deleteOne(int idx) {
		
		return nbMapper.deleteOne(idx);
	}

	public int selectBoardCount(HashMap<String,Object> param) {
		int boardCount = nbMapper.selectBoardCount(param);
		return boardCount;
	}
	
}
