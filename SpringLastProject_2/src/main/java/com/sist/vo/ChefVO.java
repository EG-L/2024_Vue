package com.sist.vo;

import lombok.Data;

/*
 *  CNO                                       NOT NULL NUMBER
 CHEF                                      NOT NULL VARCHAR2(100)
 POSTER                                    NOT NULL VARCHAR2(500)
 MEM_CONT1                                          NUMBER
 MEM_CONT2                                          NUMBER
 MEM_CONT3                                          NUMBER
 MEM_CONT7                                          NUMBER
 * */
@Data
public class ChefVO {
	private int cno,mem_cont1,mem_cont2,mem_cont3,mem_cont7;
	private String chef,poster;
}
