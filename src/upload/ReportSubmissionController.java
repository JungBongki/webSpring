package upload;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReportSubmissionController {
	/*@RequestMapping(value = "/report/submitReport1.do", method = report)
	public String submitReport1(
			@RequestParam("studentnumber") String studentNumber,
			@RequestParam("report") MultipartFile report){
		PrinterInfo(studentNumber, report);
		String filename = 
	}*/
	
	@RequestMapping(value = "/report/submitReport3.do")
	public String submitReport3(ReportCommand reportCommand){ 
		String fileName = reportCommand.getReport().getOriginalFilename();
		String path = "C:\\Workspace\\Network\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\img\\" + fileName;
		File f = new File(path);
		try {
			reportCommand.getReport().transferTo(f);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/report/imgList.do"; // 하단 imgList로 redirecting
	}
	
	@RequestMapping(value = "/report/imgList.do")
	public ModelAndView imgList(){
		ModelAndView mav = new ModelAndView("report/submissionComplete");
		String path = "C:\\Workspace\\Network\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\img\\";
		File dir = new File(path); 
		String[] files = dir.list();  
		mav.addObject("files", files);
		return mav;
	}
}
