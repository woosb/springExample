package com.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dto.Criteria;
import com.spring.dto.MemberDTO;
import com.spring.dto.MemberLogDTO;

@Repository
public class MemberDAO {
	
	final String namespace="com.spring.mybatis.myMapper";
	
	@Autowired
	SqlSession sqlSession;
	
	public int register(MemberDTO dto) {
		try {
			return sqlSession.insert(namespace+".register", dto);
		}catch(Exception e) {
			return 0;
		}
	}
	public MemberDTO getMember(MemberDTO dto) {
		return sqlSession.selectOne(namespace+".getMember", dto);
	}
	
	public List<MemberDTO> getMemberList() {
		return sqlSession.selectList(namespace+".getMemberList");
	}
	
	public List<MemberLogDTO> getLog(Criteria cri){
		return sqlSession.selectList(namespace+".getLog", cri);
	}
	
	public int loginLog(MemberLogDTO dto) {
		return sqlSession.insert(namespace+".loginLog", dto);
	}
	public int logoutLog(MemberLogDTO dto) {
		return sqlSession.update(namespace+".logoutLog", dto);
	}
	
	public MemberLogDTO getLoginMember(String id) {
		return sqlSession.selectOne(namespace+".getLoginMember", id);
	}
	
	public Integer getLogCount() {
		return sqlSession.selectOne(namespace+".getLogCount");
	}
}
