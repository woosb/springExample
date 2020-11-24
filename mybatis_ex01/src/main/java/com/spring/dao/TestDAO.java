package com.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dto.TestDTO;

@Repository
public class TestDAO {
	static final String namespace = "com.spring.mybatis.myMapper";
	
	@Autowired
	SqlSession sqlSession;
	
	public List<TestDTO> test() {
		return sqlSession.selectList(namespace+".listAll");
	}
	
	public TestDTO list(String num) {
		return sqlSession.selectOne(namespace+".list", num);
	}
	
	public void savedata(TestDTO dto) {
		int result = sqlSession.insert(namespace+".savedata", dto);
		System.out.println("result : " + result);
	}
	
	public void updatedata(TestDTO dto) {
		int result = sqlSession.update(namespace+".updatedata", dto);
		System.out.println("result : " + result);
	}
	
	public void delete(String num) {
		int result = sqlSession.delete(namespace+".delete", Integer.parseInt(num) );
		System.out.println("result : " + result);
	}
}
