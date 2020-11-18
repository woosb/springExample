package com.spring.ex04;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/re")
public class RedirectController {
	@RequestMapping("index")
	public void index() {
		
	}	
	
	@PostMapping("result")
	public String result(@RequestParam("id") String id) {
		if(id.equals("abc")) {
			return "redirect:rsOK";
		}
		return "redirect:rsNO";
	}
	
	@RequestMapping("rsOK")
	public void rsOK() {
		
	}
	@RequestMapping("rsNO")
	public void rsNO() {
		
	}
}
