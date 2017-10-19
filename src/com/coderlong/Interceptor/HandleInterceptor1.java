package com.coderlong.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/***\
 * 
 * 
 * <p>Title:</p>
 * <p>Description: 测试拦截器1 </p>
 * <p>Company:</p> 
 * @author code龙
 * @date
 * @version 1.0
 */
public class HandleInterceptor1 implements HandlerInterceptor{

	
	
	
	//执行handler之后 执行
	//经常用做 日志文件的处理
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception exception)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("之后 ");
	}
	
	
	
	//进入 handler 方法之后 返回modelandview 之前执行 
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("handleInterceptor1   postHandle");
	}
	
	
	//在进入到 handler方法之前执行 
	//用于身份认证 身份授权 如果说认证没有通过 表示此用户 没有登录 此方法不再往下面执行 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		System.out.println("HandleInterceptor1 preHandle（） ");		
		//FALSE 不再往下执行
		return true;
	}
	
	
}
