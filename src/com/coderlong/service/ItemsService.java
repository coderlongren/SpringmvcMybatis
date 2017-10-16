package com.coderlong.service;

import java.util.List;

import com.coderlong.po.ItemsCustom;
import com.coderlong.po.ItemsQueryVo;

/***
 * 
 * 
 * <p>Title:</p>
 * <p>Description:商品订单的 service </p>
 * <p>Company:</p> 
 * @author code龙
 * @date
 * @version 1.0
 */
public interface ItemsService {
	
	//商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
	
	//根据id查询商品信息

	public ItemsCustom findItemsById(Integer id) throws Exception;
	

	public void updateItems(Integer id,ItemsCustom itemsCustom) throws Exception;
	

}
