package imgBoard_rep;

import java.util.ArrayList;

public class ServiceImpl implements RepService {
	private RepDao dao;
	
	public ServiceImpl() {}
	public ServiceImpl(RepDao dao) {
		this.dao = dao;
	}

	public void setDao(RepDao dao) {
		this.dao = dao;
	}

	@Override
	public void addRep(ImgRep ir) {
		dao.insert(ir);
	}

	@Override
	public ImgRep getRep(int num) {
		return dao.select(num);
	}

	@Override
	public ArrayList<ImgRep> getAll(int imgNum) {
		return dao.selectAll(imgNum);
	}

	@Override
	public void delImgrep(int num) {
		dao.delete(num);
	}

}
