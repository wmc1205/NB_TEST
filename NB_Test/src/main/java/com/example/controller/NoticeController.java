package com.example.controller;

import java.util.HashMap;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.dto.NTInsertVO;
import com.example.dto.NTSelectListVO;
import com.example.dto.NTSelectOneVO;
import com.example.dto.NTUpdateVO;
import com.example.service.NoticeTestService;

import ch.qos.logback.classic.Logger;
import lombok.RequiredArgsConstructor;

@RequestMapping("/board")
@RestController
@RequiredArgsConstructor
public class NoticeController {
	
	private final NoticeTestService ntService;
	private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
	
	
	@GetMapping
	public List<NTSelectListVO> selectList(){
		List<NTSelectListVO> list = ntService.noticeSelectList();
		return list;
	}
	@PostMapping("/insert")
	public int insertOne(@RequestBody NTInsertVO paramDto) {
		int row = ntService.insertOne(paramDto);
		logger.info("삽입 성공");
		return row;
	}
	
	@GetMapping("/{idx}")
	public NTSelectOneVO noticeSelectOne(@PathVariable int idx) {
		return ntService.noticeSelectOne(idx);
	}
	
	@GetMapping("/update/{idx}")
	public String updateOne(@PathVariable int idx,Model model) {
		NTSelectOneVO dto = ntService.noticeSelectOne(idx);
		model.addAttribute("update",dto);
		return "/edit";
	}
	
	
	@PostMapping("/update/{idx}")
	public String updateOne(@RequestBody NTUpdateVO paramDto) {
		int row = ntService.updateOne(paramDto);
		if(row == 1)
		logger.info("수정 성공");
		return "redirect:/selectList/" + paramDto.getIdx();
		
	}
	@PostMapping("/delete/{idx}")
	public String deleteOne(@PathVariable int idx) {
		ntService.deleteOne(idx);
		return "redirect:/selectList";
			
	}
	

}
