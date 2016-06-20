package imgBoard;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import imgBoard_img.*;
import imgBoard_rep.*;

@Controller
public class ImgBoardController {
	private ImgService imgService;
	private RepService repService;
	
	public void setImgService(ImgService imgService) {
		this.imgService = imgService;
	}

	public void setRepService(RepService repService) {
		this.repService = repService;
	}
	@RequestMapping(value="/imgBoard/add.do")
	public String add(Img i){
		String fileName = i.getFile().getOriginalFilename();
		String path = "C:\\Workspace\\Network\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\img\\" + fileName;
		File f = new File(path);
		try {
			i.getFile().transferTo(f);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		i.setPath("/img/"+fileName);
		imgService.AddImg(i);
		return "redirect:/imgBoard/list.do";
	}

	@RequestMapping(value="/imgBoard/list.do") // list와 댓글을 하나로 묶어서 뿌려주기
	public ModelAndView list(){
		ModelAndView mav = new ModelAndView("imgBoard/list");
		ArrayList<Img> list = imgService.getAll();
		for(int i =0; i<list.size(); i++){
			list.get(i).setReps(repService.getAll(list.get(i).getNum()));
		}
		mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping(value="/imgBoard/addrep.do")
	public String addrep(ImgRep ir){
		repService.addRep(ir);
		return "redirect:/imgBoard/list.do";
	}
	
	@RequestMapping(value="/imgBoard/delete_rep.do")
	public String delete_rep(@RequestParam(value="num") int num){
		repService.delImgrep(num);
		return "redirect:/imgBoard/list.do";
	}
}
