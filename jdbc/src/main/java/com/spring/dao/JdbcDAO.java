package com.spring.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.spring.controller.MemberController;
import com.spring.dto.JdbcDTO;

public class JdbcDAO {
	/*
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "system";
	private String pwd = "1234";
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	*/
	private JdbcTemplate template;
	
	public JdbcDAO() {
		this.template = MemberController.template;
		/*
		try {
			Class.forName(driver);
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		*/
	}
	
	public ArrayList<JdbcDTO> list (){
		String sql = "select * from test_jdbc order by id desc";
		ArrayList<JdbcDTO> list = null;
		try {
			 list = (ArrayList<JdbcDTO>)template.query(sql, new BeanPropertyRowMapper<JdbcDTO>(JdbcDTO.class));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		/*
		ArrayList<JdbcDTO> list = new ArrayList<JdbcDTO>();
		try {
			con = DriverManager.getConnection(url, user, pwd);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				JdbcDTO dto = new JdbcDTO();
				dto.setId(rs.getInt("id"));
				dto.setName(rs.getString("name"));
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		*/
	}
	
	public void save(final int id, final String name) {
		String sql = "insert into test_jdbc(id, name) values(?,?)";
		template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, id);
				ps.setString(2, name);
			}
		});
		/*
		try {
			con = DriverManager.getConnection(url, user, pwd);
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
		*/
	}
	
	public JdbcDTO modify(int id) {
		String sql = "select * from test_jdbc where id = " + id;
		JdbcDTO dto = null;
		dto = template.queryForObject(sql, new BeanPropertyRowMapper<JdbcDTO>(JdbcDTO.class));
		return dto;
		/*
		try {
			con = DriverManager.getConnection(url, user, pwd);
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto = new JdbcDTO();
				dto.setId(rs.getInt("id"));
				dto.setName(rs.getString("name"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		*/
	}
	
	public void modifySave(final String id, final String name) {
		String sql = "update test_jdbc set name = ? where id=?";
		template.update(sql, ps->{
			ps.setString(1, name);
			ps.setString(2, id);
		});
		/*
		try {
			con = DriverManager.getConnection(url, user, pwd);
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			rs = ps.executeQuery();
		}catch(Exception e) {
			e.printStackTrace();
		}
		*/
	}
	
	public void delete(String id) {
		String sql = "delete from test_jdbc where id="+id;
		template.update(sql);
		/*
		try {
			con = DriverManager.getConnection(url, user, pwd);
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
		}catch(Exception e) {
			e.printStackTrace();
		}
		*/
	}
	
	public int count() {
		String sql = "select count(*) from test_jdbc";
		return template.queryForObject(sql, Integer.class);
	}
}
