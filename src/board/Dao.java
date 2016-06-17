package board;

import java.util.List;

public interface Dao {
	void insert(Article a); // 글 작성
	Article select(int num); // 해당되는 글 검색
	List selectAll(); // 전체글 검색
	List selectByParentNum(int parentNum); // 댓글이 누구의 댓글인가 확인해주는 Method
	void update(Article a); // 글수정
	void delete(int num); // 글삭제
	List selectByWriter(String writer);
	List selectByTitle(String title);
}
