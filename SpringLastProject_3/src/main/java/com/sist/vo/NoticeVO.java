package com.sist.vo;
import java.util.*;

import lombok.Data;

@Data
public class NoticeVO {
	private int no,hit;
	private String name,subject,content,dbday;
	private Date regdate;
}
