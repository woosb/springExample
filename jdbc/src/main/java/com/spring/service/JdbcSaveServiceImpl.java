package com.spring.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.dao.JdbcDAO;

public class JdbcSaveServiceImpl implements JdbcService{
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		int id =  Integer.parseInt(request.getParameter("id"));
		String name =  request.getParameter("name");
		JdbcDAO dao = new JdbcDAO();
		dao.save(id, name);
	}
}
