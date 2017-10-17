package com.coderlong.controller.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;



/***
 * 
 * 
 * <p>Title:</p>
 * <p>Description: 自定义的日期转换类 </p>
 * <p>Company:</p> 
 * @author code龙
 * @date
 * @version 1.0
 */
public class CustomDateConverter implements Converter<String, Date>{

	@Override
	public Date convert(String source) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			return simpleDateFormat.parse(source);
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		return null;
	}


}
