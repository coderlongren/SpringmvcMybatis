package com.coderlong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderlong.po.ItemsCustom;


/****
 * 
 * 
 * <p>Title:</p>
 * <p>Description:  requestBody 把请求的json格式转化为java 对象  responseBody 把java对象转化为json格式</p>
 * <p>Company:</p> 
 * @author code龙
 * @date
 * @version 1.0
 */

@Controller
public class JsonController {
	@RequestMapping("requestJson")
	public @ResponseBody ItemsCustom requestJson(@RequestBody ItemsCustom itemsCustom){
		return itemsCustom;
	}
	@RequestMapping("responseJson")
	public @ResponseBody ItemsCustom responseJson(ItemsCustom itemsCustom){
		return itemsCustom;
	}
	
	
}

