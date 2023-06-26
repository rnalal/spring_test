package kr.co.tjoeun.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.tjoeun.bean.ContentBean;
import kr.co.tjoeun.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
  
  @Autowired
  private BoardService boardService;
  
  @GetMapping("/main")
  public String boradMain(@RequestParam("board_info_idx") int board_info_idx,
	                      Model model) {
	model.addAttribute("board_info_idx", board_info_idx);	
	return "board/main";
  }
  
  @GetMapping("/read")
  public String boradRead() {
	return "board/read";
  }
    
  @GetMapping("/write")
  public String boradWrite(@ModelAttribute("writeContentBean") ContentBean writeContentBean,
	                       @RequestParam("board_info_idx") int board_info_idx) {
	
	writeContentBean.setContent_board_idx(board_info_idx);
	
	return "board/write";
  }
  
  @PostMapping("/write_procedure")
  public String writeProcedure(@Valid @ModelAttribute("writeContentBean") ContentBean writeContentBean,
	                           BindingResult result) {
	if(result.hasErrors()) {
	  return "board/write";
	}
	boardService.addContentInfo(writeContentBean);
	
	return "board/write_success";	
  }
  
  
  @GetMapping("/modify")
  public String boradModify() {
	return "board/modify";
  }
  
  @GetMapping("/delete")
  public String boradDelete() {
	return "board/delete";
  }
  
}




