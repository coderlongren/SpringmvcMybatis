package com.coderlong.Custom.Exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/***
 * 
 * 
 * <p>Title:</p>
 * <p>Description: 全局异常 处理器 </p>
 * <p>Company:</p> 
 * @author code龙
 * @date
 * @version 1.0
 */
public class CustomExceptionHandleExceptionRelove implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception exception) {
		//解析出 异常类型 在页面显示 
		String message;
		Exception exception2 = null;
		if (exception instanceof CustomException) {
			exception2 = (CustomException)exception;
		}
		else {
			//如果 不是我们自定义的 异常   构造一个 未知的异常   
			//如果是我们的 异常 网上抛出
			exception2 = new Exception("未知错误");
			
		}
		
		message = exception2.getMessage();
		ModelAndView modelAndView = new ModelAndView();
		//把错误信息 传到页面 
		modelAndView.addObject("message", message);
		modelAndView.setViewName("error");
		
		return modelAndView;
	}

}
