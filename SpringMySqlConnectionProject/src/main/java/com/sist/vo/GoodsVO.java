package com.sist.vo;

import lombok.Data;

/*
 * NO int 
GOODS_NAME text 
GOODS_SUB text 
GOODS_PRICE text 
GOODS_DISCOUNT int 
GOODS_FIRST_PRICE text 
GOODS_DELIVERY text 
GOODS_POSTER text 
HIT int
 * */
@Data
public class GoodsVO {
	private int no,goods_discount,hit;
	private String goods_name,goods_price,goods_first_price,goods_delivery,goods_poster;
}
