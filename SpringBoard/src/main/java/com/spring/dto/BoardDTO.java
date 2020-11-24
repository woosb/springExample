package com.spring.dto;

import java.util.Date;

public class BoardDTO {
	private int id;
	
	private String name;
	private String title;
	private String content;
	
	private Date savedate;

	private int hit;
	private int idgroup;
	private int step;
	private int indent;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getSavedate() {
		return savedate;
	}
	public void setSavedate(Date savedate) {
		this.savedate = savedate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getIdgroup() {
		return idgroup;
	}
	public void setIdgroup(int idgroup) {
		this.idgroup = idgroup;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getIndent() {
		return indent;
	}
	public void setIndent(int indent) {
		this.indent = indent;
	}
	@Override
	public String toString() {
		return "BoardDTO [id=" + id + ", name=" + name + ", title=" + title + ", content=" + content + ", savedate="
				+ savedate + ", hit=" + hit + ", idgroup=" + idgroup + ", step=" + step + ", indent=" + indent + "]";
	}
	
}
