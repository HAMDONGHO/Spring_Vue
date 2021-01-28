package todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import todo.service.BoardService;

//해당 클래스가 유저 요청과 응답을 처리하는 UI 컨트롤러 클래스임을 의미
@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	//URI매핑!! value = ""
	@GetMapping(value = "/board/write.do")
	//Model인터페이스는 데이터를 뷰로 전달함
	public String openBoardWrite(Model model) {
		//return은 html 재외하도됨
		
		String title = "제목";
		String content = "내용";
		String writer= "홍길동";
		
		//addAttribute메서드는 html로 데이터를 전달 가능(html은 ${}으로 데이터에 접근
		model.addAttribute("t", title);
		model.addAttribute("c",content);
		model.addAttribute("w", writer);
		return "board/write";
	}
}
