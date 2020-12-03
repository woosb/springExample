package com.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dto.MemberDTO;
import com.spring.dto.UserLogDTO;

@Repository
public class MemberDAO {
	static final String namespace="com.spring.member.mapper";

	@Autowired
	SqlSession sqlSession;
	
	public MemberDTO login(MemberDTO dto) {
		return sqlSession.selectOne(namespace+".login", dto);
	}
	
	public int join(MemberDTO dto) {
		return sqlSession.insert(namespace+".join", dto);
	}
	
	public List<MemberDTO> memberInfo(){
		return sqlSession.selectList(namespace+".memberInfo");
	}
	
	public int setStartTime(String id) {
		return sqlSession.insert(namespace+".setStartTime", id);
	}

	public int setEndTime(String id) {
		return sqlSession.update(namespace+".setEndTime", id);
	}
	
	public List<UserLogDTO> getLog(){
		return sqlSession.selectList(namespace+".getLog");
	}
}
