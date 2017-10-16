package com.coderlong.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.coderlong.po.ItemsCustom;
import com.coderlong.po.ItemsQueryVo;
import com.coderlong.service.ItemsService;

/***
 * 
 * 
 * <p>Title:</p>
 * <p>Description:商品的controller  </p>
 * <p>Company:</p> 
 * @author code龙
 * @date
 * @version 1.0
 */


//requestMappsing的三大特性 URL映射  窄化请求映射  http请求限制  
@Controller
@RequestMapping("/items")
public class ItemsController {
	
	@Autowired
	private ItemsService itemsService;
	
	@RequestMapping("/queryItems")
	 public ModelAndView queryItems(HttpServletRequest request,ItemsQueryVo itemsQueryVo) throws Exception{
//		List<ItemsCustom> itemsList = itemsService.findItemsList(null);
		//在后面返回modelandview
		
		List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);
//		ItemsCustom itemsCustom1 = new ItemsCustom();
//		itemsCustom1.setName("苏东坡传 ");
//		itemsCustom1.setDetail("这是一本好书 ");
//		itemsCustom1.setPrice(30.5f);
//		ItemsCustom itemsCustom2 = new ItemsCustom();
//		itemsCustom2.setName("了不起的盖茨比");
//		itemsCustom2.setDetail("这也是一本好书 ");
//		
//		itemsList.add(itemsCustom1);
//		itemsList.add(itemsCustom2);
		
//		ItemsCustom itemsCustom1 = new ItemsCustom();
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("itemsList",itemsList);
		modelAndView.setViewName("items/itemsList");
		
		return modelAndView;
		 
	 }
	//修改商品信息 的映射 
	//@requestMapping 可以限制请求的方法  method= get or post 
	@RequestMapping("/editItems" )
	public ModelAndView editItems(int id) throws Exception{
 		ItemsCustom itemsCustom = itemsService.findItemsById(id);
		
		ModelAndView modelAndView  = new ModelAndView();
		modelAndView.addObject("itemsCustom", itemsCustom);
		
		return modelAndView;
		
	}
	
	//商品提交 
	@RequestMapping("editItemsSubmit")
	public ModelAndView editItemsSubmit(){
		return null;
		
	}
	
	
	
	
	
	
	
	
}
