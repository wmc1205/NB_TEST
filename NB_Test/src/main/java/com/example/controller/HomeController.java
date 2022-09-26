package com.example.controller;

import java.awt.Font;
import java.awt.GraphicsEnvironment;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.dto.NTSelectOneVO;
import com.example.dto.NTUpdateVO;
import com.example.service.NoticeTestService;

import ch.qos.logback.classic.Logger;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class HomeController {
	private final NoticeTestService ntService;
	private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
	@RequestMapping("/home")
	public String home() {
		
		return "home";
	};
	
//	@GetMapping("/update/{idx}")
//	public ModelAndView edit(@PathVariable int idx) {
////      GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
////      Font[] fonts = e.getAllFonts(); 
////      for (Font font : fonts) {
////      System.out.println("폰트 이름 : " + font.getFontName());
////             }
//		ModelAndView mav = new ModelAndView("board/update");
//		
//		NTSelectOneVO dto =  ntService.noticeSelectOne(idx);
//		mav.addObject("dto",dto);
//		 logger.info(idx + "번 조회");
//		return mav;
//	}
//	@PostMapping("/board/update/{idx}")
//	public String edit(@RequestBody NTUpdateVO paramDto) {
//		int row = ntService.updateOne(paramDto);
//		if(row == 1)
//		logger.info("수정 성공");
//		return "redirect:/" + paramDto.getIdx();
//		
//	}
	
}
