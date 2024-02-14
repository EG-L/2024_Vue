package com.sist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.NoticeMapper;
import com.sist.vo.NoticeVO;

@Repository
public class NoticeDAO {
	@Autowired
	private NoticeMapper mapper;
	
	public List<NoticeVO> noticeTop7(){
		return mapper.noticeTop7();
	}

}
