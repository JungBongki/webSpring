package imgBoard_img;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

import imgBoard_rep.ImgRep;

public class Img {
	private int num;
	private String title;
	private String writer;
	private String path;
	private MultipartFile file;
	ArrayList<ImgRep> reps;
	
	
	public Img() { }
	public Img(int num, String title, String writer, String path) {
		this.num = num;
		this.title = title;
		this.writer = writer;
		this.path = path;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public ArrayList<ImgRep> getReps() {
		return reps;
	}
	public void setReps(ArrayList<ImgRep> reps) {
		this.reps = reps;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
}
