package com.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dto.MemberDTO;

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
}
