package board;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import addr.Member;

@Controller
public class BoardController {
	private Service service;

	public void setService(Service service) {
		this.service = service;
	}
	
	
	@RequestMapping(value="/board/list.do") // 리스트 뿌려주기
	public ModelAndView list(){
		ModelAndView mav = new ModelAndView("board/list");
		ArrayList<Member> list = (ArrayList<Member>) service.getArticleRoot();
		mav.addObject("list", list);
		return mav;
	}

	@RequestMapping(value="/board/writeboard.do") // 게시물작성 폼 넘기기
	public String editBoard(Article a, HttpServletRequest req){
		return "board/writeBoard";
	}

	@RequestMapping(value="/board/write.do") // 글 쓰기
	public String write(Article a){
		service.WriteArticle(a);
		return "redirect:/board/list.do";
	}
	
	
	@RequestMapping(value="/board/read.do") // 링크 -> 게시물 상세보기
	public ModelAndView readBoard(Article a, HttpServletRequest req){
		int num = Integer.parseInt(req.getParameter("num"));
		a = service.getArticleByNum(num);
		ModelAndView mav = new ModelAndView("board/read");
		mav.addObject("a", a);
		return mav;
	}
	
	@RequestMapping(value="/board/delBoard.do") // 글 삭제
	public String delBoard(@RequestParam(value="num")int num){
		service.delArticle(num);
		return "redirect:/board/list.do";
	}
	
	@RequestMapping(value="/board/revise.do") // 수정페이지 넘기기
	public ModelAndView reviseBoard(Article a, HttpServletRequest req){
		int num = Integer.parseInt(req.getParameter("num"));
		ModelAndView mav = new ModelAndView("board/reviseBoard");
		a = service.getArticleByNum(num);
		mav.addObject("a", a);
		return mav;
	}
	
	@RequestMapping(value="/board/revise_OK.do") // 수정완료시
	public String reviseBoard_OK(Article a, HttpServletRequest req){
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		a.setContent(title);
		a.setContent(content);
		
		service.editArticle(a);
		return "redirect:/board/list.do";
	}
	
	@RequestMapping(value="/board/preview.do")  //???
	public ModelAndView read(@RequestParam(value="num")int num){
		ModelAndView mav = new ModelAndView("board/readResult");
		Article a = service.getArticleByNum(num);
		mav.addObject("a", a);
		return mav;
	}
	
	@RequestMapping(value="/board/searchById.do") // 작성자로 게시물검색
	public ModelAndView selectById(@RequestParam(value="writer")String writer){
		ModelAndView mav = new ModelAndView("board/searchByIdResult");
		ArrayList<Article> list = (ArrayList<Article>)service.getArticleByWriter(writer);
		mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping(value="/board/searchByTitle.do") // 제목으로 게시물검색
	public ModelAndView selectByTitle(@RequestParam(value="title")String title){
		ModelAndView mav = new ModelAndView("board/searchByTitleResult");
		ArrayList<Article> list = (ArrayList<Article>)service.getArticleByWriter(title);
		mav.addObject("list", list);
		return mav;
	}
}