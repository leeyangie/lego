package com.lego.dto;

public class Board {
	private int bno;
	private String title;
	private String content;
	private String author;
	private int vcnt;
	private String resdate;
	private String url;
	
	public Board() {}

	public Board(int bno, String title, String content, String author, int vcnt, String resdate, String url) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.author = author;
		this.vcnt = vcnt;
		this.resdate = resdate;
		this.url = url;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getVcnt() {
		return vcnt;
	}

	public void setVcnt(int vcnt) {
		this.vcnt = vcnt;
	}

	public String getResdate() {
		return resdate;
	}

	public void setResdate(String resdate) {
		this.resdate = resdate;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	

}