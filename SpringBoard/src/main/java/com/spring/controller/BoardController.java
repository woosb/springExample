package com.spring.controller;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.dto.BoardDTO;
import com.spring.dto.Criteria;
import com.spring.dto.PageDTO;
import com.spring.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Autowired
	BoardService service;
	
	@GetMapping("/list")
	public void list(Model model,  Criteria cri) {
		int total = service.getTotal();
		PageDTO pageMaker = new PageDTO(cri, total);
		List<BoardDTO> list = service.getList(cri);
		model.addAttribute("list", list);
		model.addAttribute("pageMaker", pageMaker);
	}
	
	@GetMapping("/register")
	public void register() {
		
	}
	@PostMapping("register")
	public String register(BoardDTO dto, Model model) {
		service.register(dto);
		return "redirect:/board/list";
	}
	
	@GetMapping("detail")
	public void detail(@RequestParam("id") String id,Model model, HttpServletRequest request, @CookieValue(value="detail", required=false) Cookie detail) {
		service.upHit(id);
		BoardDTO dto = service.getBoard(id);
		model.addAttribute("dto", dto);
	}
	
	@GetMapping("delete")
	public String delete(@RequestParam("id") String id) {
		service.deleteBoard(id);
		return "redirect:/board/list";
	}
	
	@PostMapping("reply")
	public String reply(BoardDTO dto, HttpSession session){
		service.reply(dto, session);
		return "redirect:/board/list";
	}
	
	@PostMapping("modify")
	public String modify(BoardDTO dto) {
		service.updateBoard(dto);
		return "redirect:/board/detail?id="+dto.getId();
	}
}
