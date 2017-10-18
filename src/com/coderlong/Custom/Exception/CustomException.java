package com.coderlong.Custom.Exception;
/***
 * 
 * 
 * <p>Title:</p>
 * <p>Description: 自定义的 异常处理 </p>
 * <p>Company:</p> 
 * @author code龙
 * @date
 * @version 1.0
 */

public class CustomException extends Exception {
	private String message;
	public CustomException(String message){
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
