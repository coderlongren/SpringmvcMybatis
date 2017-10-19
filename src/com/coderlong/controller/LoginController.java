package com.coderlong.controller;

import javax.jms.Session;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * 
 * <p>Title:</p>
 * <p>Description: 登录用户 控制器 </p>
 * <p>Company:</p> 
 * @author code龙
 * @date
 * @version 1.0
 */

@Controller
public class LoginController {
	@RequestMapping("/login")
	String login(HttpSession session,String username,String password) throws Exception{
		
		session.setAttribute("username", username);
		
		return "redirect:/items/queryItems.action";
		
		
	}
	@RequestMapping("/logout")
	String logout(HttpSession session) throws Exception{
		//ssession.removeAttribute("username");
		session.invalidate();
		return "redirect:/items/queryItems.action";
		
	}

}
