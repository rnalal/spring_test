package kr.co.tjoeun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
  
  @GetMapping("/main")
  public String boradMain() {
	return "board/main";
  }
  
  @GetMapping("/read")
  public String boradRead() {
	return "board/read";
  }
    
  @GetMapping("/write")
  public String boradWrite() {
	return "board/write";
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




