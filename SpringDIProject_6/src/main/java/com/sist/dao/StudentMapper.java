package com.sist.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
// => MapperFactoryBean
/*
 * 	1. <select> ==> @Select()
 *  2. id       ==> 메소드명
 *  3. resultType ==> 리턴형
 *  4. parameterType ==> 매개변수
 * */
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.*;
public interface StudentMapper {
	//<select id="studentListData" resultType="StudentVO">
	/*	SELECT * FROM student
	 * </select>
	 * */
	@Select("SELECT * FROM student")
	public List<StudentVO> studentListData();
	
	/*
	 *  <select id="studentDetailData" resultType="StudentVO" parameterType="int">
	 *  SELECT * FROM student
	 *  WHERE hakbun=#{hakbun}
	 *  </select>
	 * */
	@Select("SELECT * FROM student WHERE hakbun=#{hakbun}")
	public StudentVO studentDetailData(int hakbun);
	
	/*
	 * 	<insert id="studentInsert" parameterType="StudentVO">
	 *  	INSERT INTO student VALUES(std_hak_seq.nextval,#{name},#{kor},#{eng},#{math})
	 *  </insert>
	 * */
	@Insert("INSERT INTO student VALUES(std_hak_seq.nextval,#{name},#{kor},#{eng},#{math})")
	public void studentInsert(StudentVO vo);
	
	/*
	 *  <delete id="studentDelete" parameterType="int">
	 *  	DELETE FROM student WHERE hakbun=#{hakbun};
	 *  </delete>
	 * */
	@Delete("DELETE FROM student WHERE hakbun=#{hakbun}")
	public void studentDelete(int hakbun);
	
	/*
	 *  CRUD
	 *  Create
	 *  Read
	 *  Update
	 *  Delete
	 *  <update id="studentUpdate" parameterType="StudentVO">
	 *  	UPDATE student SET name=#{name},kor=#{kor},eng=#{eng},math=#{math} WHERE hakbun=#{hakbun}
	 *  </update>
	 * */
	@Update("UPDATE student SET name=#{name},kor=#{kor},eng=#{eng},math=#{math} WHERE hakbun=#{hakbun}")
	public void studentUpdate(StudentVO vo);
}
