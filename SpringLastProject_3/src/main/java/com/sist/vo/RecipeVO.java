package com.sist.vo;

import lombok.Data;

/*
 *  NO                                        NOT NULL NUMBER
 TITLE                                     NOT NULL VARCHAR2(2000)
 POSTER                                    NOT NULL VARCHAR2(500)
 CHEF                                      NOT NULL VARCHAR2(200)
 LINK                                      NOT NULL VARCHAR2(300)
 JJIMCOUNT                                          NUMBER
 HIT                                                NUMBER
 * */
@Data
public class RecipeVO {
	private int no,jjimcount,hit;
	private String title,poster,chef,link;
}
