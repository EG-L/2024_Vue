package com.sist.vo;

import lombok.Data;

/*
 *  NO                                                 NUMBER
 POSTER                                    NOT NULL VARCHAR2(300)
 TITLE                                     NOT NULL VARCHAR2(1000)
 CHEF                                      NOT NULL VARCHAR2(200)
 CHEF_POSTER                                        VARCHAR2(300)
 CHEF_PROFILE                                       VARCHAR2(1000)
 INFO1                                              VARCHAR2(100)
 INFO2                                              VARCHAR2(100)
 INFO3                                              VARCHAR2(100)
 CONTENT                                            VARCHAR2(4000)
 FOODMAKE                                           CLOB
 STUFF                                              CLOB
 * */
@Data
public class RecipeDetailVO {
	private int no;
	private String poster,title,chef,chef_poster,chef_profile,info1,info2,info3,content,foodmake,stuff;
}
