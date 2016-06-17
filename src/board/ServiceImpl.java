package board;

import java.util.List;

public class ServiceImpl implements Service {

	private Dao dao;	
	
	public ServiceImpl() { }
	public ServiceImpl(Dao dao) {
		this.dao = dao;
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}

	@Override
	public void WriteArticle(Article a) {
		dao.insert(a);
	}

	@Override
	public Article getArticleByNum(int num) {
		return dao.select(num);
	}

	@Override
	public List getArticleRoot() {
		return dao.selectAll();
	}

	@Override
	public List getArticleByParentNum(int parentNum) {
		return dao.selectByParentNum(parentNum);
	}

	@Override
	public void editArticle(Article a) {
		dao.update(a);
	}

	@Override
	public void delArticle(int num) {
		dao.delete(num);
	}
	@Override
	public List getArticleByTitle(String title) {
		return dao.selectByTitle(title);
	}
	@Override
	public List getArticleByWriter(String writer) {
		return dao.selectByWriter(writer);
	}	

}
