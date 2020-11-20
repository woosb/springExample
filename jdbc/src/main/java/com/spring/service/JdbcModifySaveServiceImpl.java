package com.spring.service;

import java.util.Map;

import org.springframework.ui.Model;

import com.spring.dao.JdbcDAO;

public class JdbcModifySaveServiceImpl implements JdbcService{
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		String id = (String)map.get("id");
		String name  = (String)map.get("name");
		JdbcDAO dao = new JdbcDAO();
		dao.modifySave(id, name);
	}
}
