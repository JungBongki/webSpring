package board;

import java.util.List;

public interface Service {
	void WriteArticle(Article a); // 글 작성

	Article getArticleByNum(int num);

	List getArticleRoot();

	List getArticleByParentNum(int parentNum); // 댓글이 누구의 댓글인가 확인해주는 Method

	void editArticle(Article a); // 글수정

	void delArticle(int num); // 글삭제

	List getArticleByTitle(String title);

	List getArticleByWriter(String writer);
}
