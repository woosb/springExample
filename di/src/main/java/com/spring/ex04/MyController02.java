package com.spring.ex04;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/member02")
public class MyController02 {
	@RequestMapping("/index")
	public void memberIndex() {
		
	}
	@RequestMapping(value="/result", method=RequestMethod.GET)
	public void resultGet(@RequestParam String name, @RequestParam String age, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("age", age);
	}
	
	@PostMapping("/result")
	public void resultPost(@RequestParam("name") String n, @RequestParam("age") String a, Model model) {
		model.addAttribute("name", n);
		model.addAttribute("age", a);
	}
	
	@PostMapping("/result01")
	public void resut01Post(MemberDTO dto, Model model){
		model.addAttribute("dto", dto);
	}
	
//	@RequestMapping(value="/result")
//	public void resultGet(HttpServletRequest request, Model model) {
//		model.addAttribute("name", request.getParameter("name"));
//		model.addAttribute("age", request.getParameter("age"));
//	}
	
}
