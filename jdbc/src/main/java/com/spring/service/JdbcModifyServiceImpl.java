package com.spring.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.dao.JdbcDAO;

public class JdbcModifyServiceImpl implements JdbcService{
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String id = request.getParameter("id");
		JdbcDAO dao = new JdbcDAO();
		model.addAttribute("list", dao.modify(Integer.parseInt(id)));
	}
}
