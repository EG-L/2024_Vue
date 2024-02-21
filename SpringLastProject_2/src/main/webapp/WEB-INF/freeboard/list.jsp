<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>

</head>
<body>
	<div class="wrapper row3" id="fboardApp">
  		<main class="container clear">
  			<h2 class="sectiontitle">자유 게시판</h2>
  			<table class="table">
  				<tr>
  					<td>
  						<a href="../freeboard/insert.do" class="btn btn-sm btn-danger">새글</a>
  					</td>
  				</tr>
  			</table>
  			<table class="table">
  				<tr>
  					<th width="10%" class="text-center">번호</th>
  					<th width="45%" class="text-center">제목</th>
  					<th width="15%" class="text-center">이름</th>
  					<th width="20%" class="text-center">작성일</th>
  					<th width="10%" class="text-center">조회수</th>
  				</tr>
  				<tr v-for="vo in board_list">
  					<td width="10%" class="text-center">{{vo.no}}</td>
  					<td width="45%"><a :href="'../freeboard/detail.do?no='+vo.no">{{vo.subject}}</a></td>
  					<!-- 
  						v-text = text()
  						v-html = html()
  					 -->
  					<td width="15%" class="text-center" v-text="vo.name"></td>
  					<td width="20%" class="text-center" v-text="vo.dbday"></td>
  					<td width="10%" class="text-center" v-text="vo.hit"></td>
  				</tr>
  				<tr>
  					<td colspan="5" class="text-center">
  						<input type="button" class="btn btn-sm btn-info" value="이전" @click="prev()">
  						{{curpage}} page / {{totalpage}} pages
  						<input type="button" class="btn btn-sm btn-info" value="다음" @click="next()">
  					</td>
  				</tr>
  			</table>
  		</main>
  	</div>
  	<!-- 
  		1. 검색 => 다이얼로그
  		2. CRUD => 게시판 / 댓글
  		3. 채팅
  		4. 추천
  		5. 로그인, 아이디 찾기, 비밀번호 찾기
  		============================ Vue
  		react ==== spring-boot
  	 -->
  	<script>
  		let fboardApp = Vue.createApp({
  			data(){
  				return{
  					board_list:[],
  					curpage:1,
  					totalpage:0,
  					startPage:0,
  					endPage:0
  				}
  			},
  			mounted(){
  				//시작과 동시에 처리
  				this.dataRecv()
  			},
  			updated(){
  				
  			},
  			methods:{
  				//mounted , prev , next 
  				dataRecv(){
  					axios.get('../freeboard/list_vue.do',{
  						params:{
  							page:this.curpage
  						}
  					}).then(res=>{
  						console.log(res.data)
  						this.board_list = res.data
  						/*
  							response={
  								config: ,
	  							data: ,
	  							header: ,
	  							  ...
  							}
  						*/
  					})
  					
  					axios.get('../freeboard/page_vue.do',{
  						params:{
  							page:this.curpage
  						}
  					}).then(res=>{
  						
  						this.curpage = res.data.curpage;
  						this.totalpage = res.data.totalpage;
  					})
  				},
  				prev(){
  					this.curpage=this.curpage>1?this.curpage-1:this.curpage;
  					this.dataRecv();
  				},
  				next(){
  					this.curpage=this.curpage<this.totalpage?this.curpage+1:this.curpage;
  					this.dataRecv();
  				}
  			}
  		}).mount('#fboardApp')
  	</script>
</body>
</html>