package com.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.spring.dto.MemberDTO;

@Repository
public interface MemberDAO {
	@Insert("insert into test_jdbc(id, name) values(#{id}, #{name})")
	public void insertMember(MemberDTO dto);
	
	@Select("select * from test_jdbc")
	public List<MemberDTO> memberview();
}
