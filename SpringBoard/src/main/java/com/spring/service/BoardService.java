package com.spring.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.spring.dto.BoardDTO;
import com.spring.dto.Criteria;

public interface BoardService {
	public int register(BoardDTO dto);
	public List<BoardDTO> getList(Criteria cri);
	public BoardDTO getBoard(String id);
	public int updateBoard(BoardDTO dto);
	public int deleteBoard(String id);
	public int upHit(String id);
	public int reply(BoardDTO dto, HttpSession session);
	public Integer getTotal();
}
