package test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
	
	@RequestMapping(value="/test1.do", method=RequestMethod.POST)
	public ModelAndView test1_post(@RequestParam(value="id")String id, @RequestParam(value="pwd")String pwd){
		ModelAndView mav = new ModelAndView("test1");
		mav.addObject("id", id);
		mav.addObject("pwd", pwd);
		return mav;
	}
	
	@RequestMapping(value="/test1.do", method=RequestMethod.GET)
	public ModelAndView test1_get(){
		ModelAndView mav = new ModelAndView("test1");
		mav.addObject("id", "aaa");
		mav.addObject("pwd", "111");
		return mav;
	}
	
	@RequestMapping(value="/test2.do")
	public ModelAndView test2(HttpServletRequest req){
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		ModelAndView mav = new ModelAndView("test1");
		mav.addObject("id", "aaa");
		mav.addObject("pwd", "111");
		return mav;
	}
	@RequestMapping(value="/test3.do")
	public String test3(HttpServletRequest req, @RequestParam(value="id")String id, @RequestParam(value="pwd")String pwd){
		HttpSession session = req.getSession();
		if(id.equals("aaa") && pwd.equals("111")){
			session.setAttribute("result", "로그인성공");
		} else {
			session.setAttribute("result", "로그인실패");
		}
		return "result";
	}
}
