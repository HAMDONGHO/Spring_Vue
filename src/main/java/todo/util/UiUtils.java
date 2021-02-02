package todo.util;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import todo.constant.Method;

@Controller
public class UiUtils {
	public String showMessageWithRedirect(@RequestParam(value = "message", required = false) String message,
			  @RequestParam(value = "redirectUri", required = false) String redirectUri,
			  @RequestParam(value = "method", required = false) Method method,
			  @RequestParam(value = "params", required = false) Map<String, Object> params, Model model) {

		//사용자에게 전달할 메시지를 의미
		model.addAttribute("message", message);
		//리다이렉트 할 URI를 의미! 게시글 작성하고 메시지를 사용자에게 전달, 게시글 리스트 페이지로 리다이렉트
		model.addAttribute("redirectUri", redirectUri);
		//Method Enum 클래스에 선언한 HTTP 요청 메서드
		model.addAttribute("method", method);
		model.addAttribute("params", params);

	return "utils/message-redirect";
}
}
