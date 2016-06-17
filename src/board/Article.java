package board;

import java.sql.Date;

public class Article {
	private int num;
	private Date w_date;
	private String writer;
	private String title;
	private String content;
	private int parent;
	
	public Article() {  }
	
	public Article(int num, Date w_date, String writer, String title, String content, int parent) {
		this.num = num;
		this.w_date = w_date;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.parent = parent;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Date getW_date() {
		return w_date;
	}
	public void setW_date(Date w_date) {
		this.w_date = w_date;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
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
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	
}
