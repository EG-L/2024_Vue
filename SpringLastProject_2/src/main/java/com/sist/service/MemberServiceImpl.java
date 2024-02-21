package com.sist.service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.*;
import com.sist.vo.*;


@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDAO mDao;

	@Override
	public int memberIdCount(String id) {
		// TODO Auto-generated method stub
		return mDao.memberIdCount(id);
	}

	@Override
	public void memberInsert(MemberVO vo) {
		// TODO Auto-generated method stub
		mDao.memberInsert(vo);
		
	}

	@Override
	public void memberAuthorityInsert(String userId) {
		// TODO Auto-generated method stub
		mDao.memberAuthorityInsert(userId);
		
	}

	@Override
	public MemberVO memberLogin(String userId, String userPwd) {
		// TODO Auto-generated method stub
		return mDao.memberLogin(userId, userPwd);
	}
}
