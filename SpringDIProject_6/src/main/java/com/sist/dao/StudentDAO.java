package com.sist.dao;
import java.util.*;
public class StudentDAO {
	private StudentMapper mapper;
	// 스프링으로부터 값을 받는 경우 => @Autowired
	public void setMapper(StudentMapper mapper) {
		this.mapper = mapper;
	}
	
	public List<StudentVO> studentListData(){
		return mapper.studentListData();
	};
	public StudentVO studentDetailData(int hakbun) {
		return mapper.studentDetailData(hakbun);
	};
	public void studentInsert(StudentVO vo) {
		mapper.studentInsert(vo);
	};
	public void studentDelete(int hakbun) {
		mapper.studentDelete(hakbun);
	};
	public void studentUpdate(StudentVO vo) {
		mapper.studentUpdate(vo);
	};
	
}
