package com.example.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;




import org.slf4j.LoggerFactory;

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
import com.example.dto.PageVO;
import com.example.paging.Pagination;
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
	public HashMap<String,Object> selectList( @RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
											@RequestParam HashMap<String,Object> param,
											NTSelectListVO vo) throws Exception{
			
			HashMap<String, Object> result = new HashMap<String, Object>();
		
			int limit = 5;
			int boardCount = ntService.selectBoardCount(param);
			
			//총 페이지 수
			int maxpage = (boardCount + limit -1) / limit;
			
			//시작 페이지 수
			int startpage = ((currentPage - 1) / 10) * 10 + 1;
			
			//마지막 페이지 수 
			int endpage = startpage + 10 - 1;
			
			if(endpage > maxpage)
				endpage = maxpage;
			
			vo.setLimit(limit);
			vo.setStartpage(startpage);
			vo.setPage(endpage);
			vo.setPage(currentPage);
			vo.setMaxpage(maxpage);
			
		   currentPage = currentPage == null? 1: currentPage;
		  
		   List<NTSelectListVO> list = ntService.noticeSelectList(param);
		   result.put("list", list);
		   result.put("page", currentPage);
		   result.put("startpage", startpage);
		   result.put("endpage", endpage);
		   return result;
	}
	
//	@GetMapping("/getSearchList")
//	public List<NTSelectListVO> getSearchList(@RequestParam HashMap<String,Object> param,
//										@RequestParam(defaultValue="1")Integer page,
//										Model model){
//		NTSelectListVO dto = new NTSelectListVO();
//		
//		
//		
//		return ntService.getSearchList(dto);
//	}
	
	@PostMapping("/insert")
	public int insertOne(@RequestBody NTInsertVO paramDto) {
		int row = ntService.insertOne(paramDto);
		logger.info("삽입 성공");
		return row;
	}
	//주석
	@GetMapping("/{idx}")
	public NTSelectOneVO noticeSelectOne(@PathVariable int idx) {
		return ntService.noticeSelectOne(idx);
	}
	
	@GetMapping("/update/{idx}")
	public NTSelectOneVO updateOne(@PathVariable int idx) {
		return ntService.noticeSelectOne(idx);
	}
	
	@PostMapping("/update/{idx}")
	public int updateOne(@RequestBody NTUpdateVO paramDto) {
		int row = ntService.updateOne(paramDto);
		if(row == 1)
		logger.info("수정 성공");
		return row;
	}
	@PostMapping("/delete/{idx}")
	public int deleteOne(@PathVariable int idx) {
		int row = ntService.deleteOne(idx);
			if(row == 1)
			logger.info("삭제 성공");
			return row;
			
	}

}
