package imgBoard_rep;

public class ImgRep {
	private int num;
	private int imgNum;
	private String writer;
	private String content;
	
	public ImgRep() { }
	public ImgRep(int num, int imgNum, String writer, String content) {
		this.num = num;
		this.imgNum = imgNum;
		this.writer = writer;
		this.content = content;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getImgNum() {
		return imgNum;
	}
	public void setImgNum(int imgNum) {
		this.imgNum = imgNum;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
