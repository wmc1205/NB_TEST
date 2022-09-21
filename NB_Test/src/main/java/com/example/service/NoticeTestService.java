package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dto.NTSelectListVO;
import com.example.mapper.NoticeTestMapper;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class NoticeTestService {
	
	private NoticeTestMapper ntMapper;
	
	public List<NTSelectListVO> noticeSelectList() {
		
		return ntMapper.noticeSelectList();
	}

	public int insertOne(NTSelectListVO paramDto) {
		
		return ntMapper.insertOne(paramDto);
	}

	public NTSelectListVO noticeSelectOne(int idx) {
		
		return ntMapper.noticeSelectOne(idx);
	}

	public int updateOne(NTSelectListVO paramDto) {
		
		return ntMapper.updateOne(paramDto);
	}

	public int deleteOne(int idx) {
		
		return ntMapper.deleteOne(idx);
	}

}
