package ModelAttributeTest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	@RequestMapping(value = "/test/test1.do") //실제경로는 아니고 
	public Map test1(){
		Map m = new HashMap();
		m.put("data1", "aaaa");
		m.put("data2", "1111");
		return m;
	}
	/*public String test(Map<String, String> m){
		m.put("data1", "wtw2wew");
		m.put("data2", "wertwre");
		return "test1";
	}*/
	
	@RequestMapping(value = "/test/test2.do")
	public ModelAndView test2(){
		ModelAndView mav = new ModelAndView("test2");
		mav.addObject("data2", "test2");
		return mav;
	}
}
