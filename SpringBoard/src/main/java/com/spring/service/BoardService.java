package com.spring.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.spring.dto.BoardDTO;

public interface BoardService {
	public int register(BoardDTO dto);
	public List<BoardDTO> getList();
	public BoardDTO getBoard(String id);
	public int updateBoard(BoardDTO dto);
	public int deleteBoard(String id);
	public int upHit(String id);
	public int reply(BoardDTO dto, HttpSession session);
}
