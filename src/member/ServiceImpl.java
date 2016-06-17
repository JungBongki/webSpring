package member;

public class ServiceImpl implements Service {

	private Dao dao;
	
	public void setDao(Dao dao) {
		this.dao = dao;
	}

	@Override
	public void addJoin(Join j) {
		dao.insert(j);
	}

	@Override
	public Join getJoin(String id) {
		return dao.select(id);
	}

	@Override
	public boolean login(Join j) {
		Join y = getJoin(j.getId());
		if(y!= null && y.getPwd().equals(j.getPwd())){
			return true;
		}
		return false;
	}

	@Override
	public void editJoin(Join j) {
		dao.update(j);
	}

	@Override
	public void delJoin(String id) {
		dao.delete(id);
	}

}
