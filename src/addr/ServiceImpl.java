package addr;

import java.util.List;

public class ServiceImpl implements Service {

	private Dao dao;
	
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	public ServiceImpl(){}
	
	public ServiceImpl(Dao dao){
		this.dao = dao;
	}
	
	@Override
	public void addMember(Member m) {
		dao.insert(m);
	}

	@Override
	public Member getMember(int num) {
		return dao.select(num);
	}

	@Override
	public List getMembers() {
		return dao.selectAll();
	}

	@Override
	public void editMember(Member m) {
		dao.update(m);
	}

	@Override
	public void delMember(int num) {
		dao.delete(num);
	}

}
