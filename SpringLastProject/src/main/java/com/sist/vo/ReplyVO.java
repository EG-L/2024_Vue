package com.sist.vo;
import java.util.*;

import lombok.Data;

@Data
public class ReplyVO {
	private int no,rno;
	private String userId,userName,msg,dbday;
	private Date regdate;
}
