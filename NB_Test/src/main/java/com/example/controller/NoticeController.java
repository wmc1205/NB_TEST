package com.example.controller;

import java.util.HashMap;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.NTSelectListVO;
import com.example.service.NoticeTestService;

import ch.qos.logback.classic.Logger;
import lombok.RequiredArgsConstructor;

@RequestMapping("/board")
@RestController
@RequiredArgsConstructor
public class NoticeController {
	
	private final NoticeTestService ntService;
	private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/selectList")
	public List<NTSelectListVO> noticeSelectList(){
		return ntService.noticeSelectList();
	}
	@PostMapping("/insert")
	public int insertOne(@RequestBody NTSelectListVO paramDto) {
		return ntService.insertOne(paramDto);
	}
	
	@PostMapping("/selectList/{idx}")
	public NTSelectListVO noticeSelectOne(@PathVariable int idx) {
		return ntService.noticeSelectOne(idx);
	}
	
	@PostMapping("/update")
	public int updateOne(@RequestBody NTSelectListVO paramDto) {
		return ntService.updateOne(paramDto);
		
	}
	@PostMapping("/delete/{idx}")
	public int deleteOne(@PathVariable int idx) {
		return ntService.deleteOne(idx);
	}
	

}
