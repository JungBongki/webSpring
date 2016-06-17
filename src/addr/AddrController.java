package addr;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddrController {
   private Service service;

   public void setService(Service service) {
      this.service = service;
   }
   
   @RequestMapping(value="/form.do")
   String form(){
      return "form";
   }
   
   @RequestMapping(value="/addMember.do")
   String addMember(@ModelAttribute("x")Member m){
	  service.addMember(m);
	  return "test";
      //return "redirect:list.do";
   }
   
   @RequestMapping(value="/list.do")
   ModelAndView list(){
      ModelAndView mav = new ModelAndView("list");
      System.out.println("-------------------");
      ArrayList<Member> list=
            (ArrayList<Member>) service.getMembers();
      System.out.println(list.toString());
      mav.addObject("list",list);
      return mav;
   }
   
   
   
   
   
}