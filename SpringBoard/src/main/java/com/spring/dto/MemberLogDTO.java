package com.spring.dto;

public class MemberLogDTO {
	private int num;
	private String id;
	private String starttime;
	private String endtime;
	private int resulttime;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public int getResulttime() {
		return resulttime;
	}
	public void setResulttime(int resulttime) {
		this.resulttime = resulttime;
	}
	@Override
	public String toString() {
		return "MemberLogDTO [num=" + num + ", id=" + id + ", starttime=" + starttime + ", endtime=" + endtime
				+ ", resulttime=" + resulttime + "]";
	}
	
}
