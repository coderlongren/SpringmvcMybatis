package com.coderlong.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterception implements  HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		// TODO Auto-generated method stub
		String url = request.getRequestURI();
		//indexof ()  返回 子串的索引地址  就是公开地址 放行 
		if (url.indexOf("login.action") >= 0){
			return true;
		}
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username != null){
			//身份信息存在 放行
			return true;
		}
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
			
			return  false;
	}

	
}
