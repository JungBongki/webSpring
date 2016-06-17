package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JoinController {
	private Service service;

	public void setService(Service service) {
		this.service = service;
	}
	
	@RequestMapping(value="/join/join.do")
	public String join(Join j){
		service.addJoin(j);
		return "join/loginForm";
	}

	@RequestMapping(value="/join/idCheck.do")
	public ModelAndView idCheck(@RequestParam(value="id") String id){ //회원의 중복 정보 체크
		Join j = service.getJoin(id); // service라는 인터페이스 내 getJoin을 호출한다.
		boolean flag = false;
		if(j==null){
			flag = true;
		}
		System.out.println(flag);
		ModelAndView mav = new ModelAndView("join/check");
		mav.addObject("flag", flag);
		return mav;
	}
	
	@RequestMapping(value="/join/login.do")
	public String login(Join j, HttpServletRequest req){
		HttpSession session = null;
		String result = "join/loginForm";
		boolean flag = service.login(j); // 로그인의 성공실패를 따진다.
		System.out.println(flag);
		if(flag){
			session = req.getSession();
			session.setAttribute("id", j.getId());
			result = "join/main";
		}
		return result; //실패시도 포함
	}
	
	@RequestMapping(value="/join/Logout.do")
	public String Logout(Join j, HttpServletRequest req){
		HttpSession session = req.getSession();
		session.invalidate();
		return "join/loginForm"; 
	}
	
	@RequestMapping(value="/join/out.do")
	public String out(HttpServletRequest req){
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("id");
		service.delJoin(id);
		System.out.println("탈퇴완료");
		return "join/loginForm";
	}
	
	@RequestMapping(value="/join/editForm.do")
	public String editForm(Join j, HttpServletRequest req){
		return "join/editForm";
	}
	
	@RequestMapping(value="/join/edit_OK.do")	
	public String edit_OK(Join j){
		service.editJoin(j);
		return "join/main";
	}
}
