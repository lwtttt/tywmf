package com.four.chatroom.web.controller;


import com.four.chatroom.domain.ChatUser;
import com.four.entity.User;
import com.four.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;


@Controller
@RequestMapping("/chat")
public class ChatController {

	@Resource
	private UserService userService;

	// 跳转到登录页面
	/*@RequestMapping(value = "/loginpage", method = RequestMethod.GET)
	public ModelAndView loginpage()
	{
		return new ModelAndView("chatRoomLoginer");
	}
*/
	// 登录进入聊天主页面
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(ChatUser loginUser, HttpServletRequest request, @RequestParam(value = "userId", required = false) String userId) {
		User user = new User();
		user =  userService.getUserById(userId).get(0);
		String nickname=user.getUserName();
		HttpSession session = request.getSession();
		// 登录操作
		// 判断是否是一个已经登录的用户，没有则登录
		if (null != session.getAttribute("loginUser")) {
			// 清除旧的用户
			session.removeAttribute("loginUser");
		}
		// 新登录，需要构建一个用户
		// 随机生成一个用户
		/*String id = UUID.randomUUID().toString();*/
		loginUser.setId(userId);
		loginUser.setNickname(nickname);
		// 将用户放入session
		session.setAttribute("loginUser", loginUser);

		// 将登录信息放入数据库，便于协查跟踪聊天者
		System.out.println("新用户诞生了：" + loginUser);
		return new ModelAndView("redirect:mainpage");
	}
	
	// 跳转到聊天室页面
	@RequestMapping(value = "/mainpage", method = RequestMethod.GET)
	public ModelAndView mainpage(HttpServletRequest request) {
		//判断，如果没有session，则跳到登录页面
		HttpSession session = request.getSession();
		if(null==session.getAttribute("loginUser")){
			return new ModelAndView("login");
		}else{
			return new ModelAndView("main");
		}
	}



}
