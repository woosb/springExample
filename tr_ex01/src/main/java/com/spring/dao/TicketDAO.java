package com.spring.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.spring.dto.TicketDTO;

import jdk.internal.org.jline.utils.Log;

public class TicketDAO {
	private JdbcTemplate template;
	private TransactionTemplate transactionTemplate;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}
	
	
	public int[] buyTicket(TicketDTO dto) {
		String sql_user = "insert into userticket(id, ticketnum) values(?, ?)";
		String sql_system="insert into systemticket(id, ticketnum) values(?,?)";
		int arr[] = new int[2];
		
		try {
			transactionTemplate.execute(new TransactionCallbackWithoutResult() {
				@Override
				protected void doInTransactionWithoutResult(TransactionStatus status) {
					//update success => return 1, else return 0;
					arr[0] = template.update(sql_user, ps->{
						ps.setString(1, dto.getId());
						ps.setInt(2, dto.getTicketnum());
					});
					arr[1] = template.update(sql_system, ps->{
						ps.setString(1, dto.getId());
						ps.setInt(2, dto.getTicketnum());
					});
				}
			});
		}catch(Exception e) {
			e.printStackTrace();
		}
		return arr;
	}
	
	public Map<String, ArrayList<TicketDTO>> resultTicket() {
		String sql_user = "select * from userticket";
		String sql_system = "select * from systemticket";
		
		Map<String, ArrayList<TicketDTO>> map = new HashMap<String, ArrayList<TicketDTO>>();
		ArrayList<TicketDTO> userticket = null;
		ArrayList<TicketDTO> systemticket = null;
		
		userticket = (ArrayList<TicketDTO>)template.query(sql_user, new BeanPropertyRowMapper(TicketDTO.class));
		systemticket = (ArrayList<TicketDTO>)template.query(sql_system	, new BeanPropertyRowMapper(TicketDTO.class));
		
		map.put("userticket", userticket);
		map.put("systemticket", systemticket);
		
		return map;
	}
}
