package com.spring.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.BoardDAO;
import com.spring.dto.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	BoardDAO dao;
	
	@Override
	public int register(BoardDTO dto) {
		Date date = new Date();
		dto.setSavedate(date);
		dto.setIndent(0);
		dto.setHit(0);
		dto.setStep(0);
		return dao.register(dto);
	}

	@Override
	public List<BoardDTO> getList() {
		return dao.getList(); 
	}

	@Override
	public BoardDTO getBoard(String id) {
		return dao.getBoard(id);
	}

	@Override
	public int updateBoard(BoardDTO dto) {
		Date date = new Date();
		dto.setSavedate(date);
		return dao.updateBoard(dto);
	}

	@Override
	public int deleteBoard(String id) {
		return dao.deleteBoard(id);
	}

	@Override
	public int upHit(String id) {
		return dao.upHit(id);
	}

	@Override
	public int reply(BoardDTO dto, HttpSession session) {
		dao.upStep(dto);
		String name = (String)session.getAttribute("id");
		dto.setName(name);
		dto.setSavedate(new Date());
		dto.setIndent(dto.getIndent()+1);
		dto.setStep(dto.getStep()+1);
		System.out.println(dto.toString());
		return dao.registerReply(dto);
	}
}
