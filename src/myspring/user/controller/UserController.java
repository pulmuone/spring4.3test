package myspring.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

@Controller
public class UserController {

	@Autowired
	UserService userService;	
	
	@RequestMapping("/getUser.do")
	public ModelAndView getUser(@RequestParam("id") String userid) { //@RequestParam("id") - jsp파일의 폼 컨트롤에서 사용하는 이름과 맞춰준다.
		UserVO userVO = userService.getUser(userid);
		
		return new ModelAndView("userInfo.jsp", "user", userVO);
		
	}
	
	@RequestMapping("/getUserList.do")
	public String getUserList(Model model) {
		List<UserVO> userList = userService.getUserList();
		model.addAttribute("userList", userList);
		
		return "userList.jsp";
	}
}
