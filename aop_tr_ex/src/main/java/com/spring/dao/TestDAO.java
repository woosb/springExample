package com.spring.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.spring.daodto.SystemDTO;
import com.spring.daodto.UserDTO;

@Repository
public interface TestDAO {
	@Insert("insert into user_info values(#{u})")
	public int userInsert(@Param("u") int user_num);
	
	@Insert("insert into system_info values(#{s})")
	public int systemInsert(@Param("s") int sys_num);
	
	@Select("select * from user_info")
	public ArrayList<UserDTO> user_db_result();
	
	@Select("select * from system_info")
	public ArrayList<SystemDTO> sys_db_result();
	
	
}
