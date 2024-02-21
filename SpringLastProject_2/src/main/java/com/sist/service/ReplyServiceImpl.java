package com.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.ReplyDAO;
import com.sist.vo.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService{
	@Autowired
	private ReplyDAO rDao;
	
	@Override
	public List<ReplyVO> replyListData(int rno) {
		// TODO Auto-generated method stub
		return rDao.replyListData(rno);
	}

	@Override
	public void replyInsert(ReplyVO vo) {
		// TODO Auto-generated method stub
		rDao.replyInsert(vo);
	}

	@Override
	public void replyUpdate(ReplyVO vo) {
		// TODO Auto-generated method stub
		rDao.replyUpdate(vo);
	}

	@Override
	public void replyDelete(int no) {
		// TODO Auto-generated method stub
		rDao.replyDelete(no);
	}

}
