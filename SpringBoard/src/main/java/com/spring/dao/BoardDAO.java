package com.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dto.BoardDTO;

@Repository
public class BoardDAO {
	final String namespace="com.spring.mybatis.myMapper";
	
	@Autowired
	SqlSession sqlSession;
	
	public int register(BoardDTO dto) {
		return sqlSession.insert(namespace+".registerBoard",dto);
	}
	
	public List<BoardDTO> getList(){
		return sqlSession.selectList(namespace+".getBoardList");
	}
	
	public BoardDTO getBoard(String id) {
		return sqlSession.selectOne(namespace+".getBoard", id);
	}
	
	public int updateBoard(BoardDTO dto) {
		return sqlSession.update(namespace+".updateBoard", dto);
	}
	
	public int deleteBoard(String id) {
		return sqlSession.delete(namespace+".deleteBoard", id);
	}
	
	public int upHit(String id) {
		return sqlSession.update(namespace+".upHit", id);
	}
	
	public void upStep(BoardDTO dto) {
		sqlSession.update(namespace+".upStep", dto);
	}
	
	public int registerReply(BoardDTO dto) {
		return sqlSession.insert(namespace+".registerReply", dto);
	}
}
