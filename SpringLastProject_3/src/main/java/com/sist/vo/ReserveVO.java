package com.sist.vo;
import java.util.*;

import lombok.Data;

@Data
public class ReserveVO {
	private int rno,fno,reserve_ok;
	private String userId,rDate,rTime,rInwon,dbday;
	private Date regdate;
	private FoodVO fvo = new FoodVO();
}
