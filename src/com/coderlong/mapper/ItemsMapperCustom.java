package com.coderlong.mapper;

import com.coderlong.po.Items;
import com.coderlong.po.ItemsCustom;
import com.coderlong.po.ItemsExample;
import com.coderlong.po.ItemsQueryVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemsMapperCustom {
	
    //商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)throws Exception;
	
}