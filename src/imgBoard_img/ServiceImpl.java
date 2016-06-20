package imgBoard_img;

import java.util.ArrayList;

public class ServiceImpl implements ImgService {
	
	private ImgDao dao;	
	
	public ServiceImpl() { }
	public ServiceImpl(ImgDao dao) {
		this.dao = dao;
	}
	
	public void setDao(ImgDao dao) {
		this.dao = dao;
	}
	@Override
	public void AddImg(Img i) {
		dao.insert(i);
	}

	@Override
	public Img getImg(int num) {
		return dao.select(num);
	}

	@Override
	public ArrayList<Img> getAll() {
		return dao.selectAll();
	}

	@Override
	public void delimg(int num) {
		dao.delete(num);
	}

}
