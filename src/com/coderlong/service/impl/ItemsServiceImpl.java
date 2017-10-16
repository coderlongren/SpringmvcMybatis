package com.coderlong.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.coderlong.mapper.ItemsMapper;
import com.coderlong.mapper.ItemsMapperCustom;
import com.coderlong.po.Items;
import com.coderlong.po.ItemsCustom;
import com.coderlong.po.ItemsQueryVo;
import com.coderlong.service.ItemsService;

public class ItemsServiceImpl implements ItemsService{
	
	@Autowired
	ItemsMapperCustom itemsMapperCustom;
	
	@Autowired
	ItemsMapper itemsMapper;
	
	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)
			throws Exception {
		
		List<ItemsCustom> itemsList = itemsMapperCustom.findItemsList(itemsQueryVo);
		
		return itemsList;
	}

	@Override
	public ItemsCustom findItemsById(Integer id) throws Exception {
		//通过商品的id寻找商品 
		Items items = itemsMapper.selectByPrimaryKey(id);
		
		ItemsCustom itemsCustom = new ItemsCustom();
		BeanUtils.copyProperties(items, itemsCustom);
		
		return itemsCustom;
		
	}

	@Override
	public void updateItems(Integer id, ItemsCustom itemsCustom)
			throws Exception {
		//  更新商品信息 
		//在这里传入的 Itemscustom对象 是没有id的  ，，，，，，，？id=，，，，
		//在这里 封装id 
		itemsCustom.setId(id);
		itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
		
		
		
	}

}
