package com.example.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;




import org.slf4j.LoggerFactory;
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

import com.example.paging.Pagination;
import com.example.service.NoticeTestService;


import ch.qos.logback.classic.Logger;
import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class NoticeController {
	
	private final NoticeTestService ntService;
	private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
	
	
	@GetMapping("/board")
	public Map<String,Object> selectList( @RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "1") int range,
										@RequestParam HashMap<String,Object> param,
										Pagination pagination
										) throws Exception{
			
			Map<String, Object> result = new HashMap<String, Object>();
			int boardCount  = ntService.selectBoardCount(param);
			pagination.pageInfo(page, range, boardCount);
			param.put("pagination", pagination);
			List<NTSelectListVO> list = ntService.noticeSelectList(param);
			result.put("list", list);
			result.put("pagination", pagination);
		  
		   return result;
	}
	

	
	@PostMapping("/board/insert")
	public int insertOne(@RequestBody NTInsertVO paramDto) {
		int row = ntService.insertOne(paramDto);
		logger.info("삽입 성공");
		return row;
	}
	//주석
	@GetMapping("/board/{idx}")
	public NTSelectOneVO noticeSelectOne(@PathVariable int idx) {
		return ntService.noticeSelectOne(idx);
	}
	
	@GetMapping("/board/update/{idx}")
	public NTSelectOneVO updateOne(@PathVariable int idx) {
		return ntService.noticeSelectOne(idx);
	}
	
	@PostMapping("/board/update/{idx}")
	public int updateOne(@RequestBody NTUpdateVO paramDto) {
		int row = ntService.updateOne(paramDto);
		if(row == 1)
		logger.info("수정 성공");
		return row;
	}
	@PostMapping("/board/delete/{idx}")
	public int deleteOne(@PathVariable int idx) {
		int row = ntService.deleteOne(idx);
			if(row == 1)
			logger.info("삭제 성공");
			return row;
			
	}

}
