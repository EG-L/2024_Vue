package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.sist.vo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.*;
// Vue와 데이터 통신
// Vue / React ==> Router => 데이터 통신(송수신) => 화면 변경 => Spring 
@RestController
public class DataBoardRestController {
	@Autowired
	private DataBoardDAO dao;
	
	@GetMapping(value = "databoard/list_vue.do",produces = "text/plain;charset=UTF-8")
	public String databoard_list(int page) throws Exception{
		int rowSize = 10;
		int start = (rowSize*page)-(rowSize-1);
		int end = (rowSize*page);
		List<DataBoardVO> list = dao.databoardListData(start, end);
		ObjectMapper mapper=  new ObjectMapper();
		String json = mapper.writeValueAsString(list);
		
		return json;
	}
	
	@GetMapping(value = "databoard/page_vue.do",produces = "text/plain;charset=UTF-8")
	public String databoard_page(int page) throws Exception{
		int totalpage = dao.databoardTotalPage();
		Map map = new HashMap();
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(map);
		return json;
	}
	
	@PostMapping(value = "databoard/insert_vue.do",produces = "text/plain;charset=UTF-8")
	public String databoard_insert(DataBoardVO vo,HttpServletRequest request) {
		String result = "";
		try {
			String path = request.getSession().getServletContext().getRealPath("/")+"upload\\";
			path=path.replace("\\", File.separator);//운영체제의 호환
			//Hosting => AWS(리눅스)
			File dir = new File(path);
			if(!dir.exists()) {
				dir.mkdir();
			}
			List<MultipartFile> list = vo.getFiles();
			if(list==null) {//업로드가 없는 상태
				vo.setFilename("");
				vo.setFilesize("");
				vo.setFilecount(0);
			}
			else {// 업로드가 있는 상태
				String filename = "";
				String filesize = "";
				for(MultipartFile mf:list) {
					String name = mf.getOriginalFilename();
					File file = new File(path+name);
					mf.transferTo(file);
					
					filename+=name+",";
					filesize+=file.length()+",";
				}
				filename = filename.substring(0,filename.lastIndexOf(","));
				filesize = filesize.substring(0,filesize.lastIndexOf(","));
				vo.setFilename(filename);
				vo.setFilesize(filesize);
				vo.setFilecount(list.size());
			}
			dao.databoardInsert(vo);
			
			result = "yes";
		} catch (Exception e) {
			// TODO: handle exception
			result=e.getMessage();
		}
		return result;
	}
}
