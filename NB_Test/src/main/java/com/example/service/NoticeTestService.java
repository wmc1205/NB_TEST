package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dto.NTInsertVO;
import com.example.dto.NTSelectListVO;
import com.example.dto.NTSelectOneVO;
import com.example.dto.NTUpdateVO;
import com.example.mapper.NoticeTestMapper;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class NoticeTestService {
	
	private final NoticeTestMapper nbMapper;
	
	public List<NTSelectListVO> noticeSelectList() {
		
		return nbMapper.noticeSelectList();
	}

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

}
