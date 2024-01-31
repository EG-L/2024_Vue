<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
	.container{
		margin-top:50px;
	}
	.row{
		margin:0px auto;
		width:700px;
	}
</style>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
	<div class="container">
		<h3 class="text-center">자유 게시판</h3>
		<div class="row">
			<table class="table">
				<tr>
					<td>
						<a href="insert.do" class="btn btn-sm btn-danger">새글</a>
					</td>
				</tr>
			</table>
			<table class="table">
				<tr class="success">
					<th class="text-center" width="10%">번호</th>
					<th class="text-center" width="45%">제목</th>
					<th class="text-center" width="15%">이름</th>
					<th class="text-center" width="20%">작성일</th>
					<th class="text-center" width="10%">조회수</th>
				</tr>
				<tr v-for="vo in board_list">
					<td class="text-center" width="10%">{{vo.no}}</td>
					<td width="45%"><a :href="'detail.do?no='+vo.no">{{vo.subject}}</a></td>
					<td class="text-center" width="15%">{{vo.name}}</td>
					<td class="text-center" width="20%">{{vo.dbday}}</td>
					<td class="text-center" width="10%">{{vo.hit}}</td>
				</tr>
				<tr>
					<td colspan=5 class="text-center">
						<input type="button" href="btn btn-sm btn-primary" value="이전" @click="prev()">
						{{curpage}} page / {{totalpage}} pages
						<input type="button" href="btn btn-sm btn-primary" value="다음" @click="next()">
					</td>
				</tr>
			</table>
		</div>
	</div>
	<script>
		let app = Vue.createApp({
			data(){
				return {
					//변수 선언
					board_list:[],
					curpage:1,
					totalpage:0
				}
			},
			mounted(){
				this.dataSend()
			},
			methods:{
				dataSend(){
					axios.get('../board/list_vue.do',{
						params:{
							page:this.curpage	
						}
					}).then(response=>{
						console.log(response.data)
						this.board_list = response.data
					})
					
					axios.get('../board/page_vue.do',{
						params:{
							page:this.curpage	
						}
					}).then(response=>{
						console.log(response.data)
						this.curpage = response.data.curpage
						this.totalpage = response.data.totalpage
					})
				},
				prev(){
					this.curpage = this.curpage>1?this.curpage-1:this.curpage;
					this.dataSend();
				},
				next(){
					this.curpage = this.curpage<this.totalpage?this.curpage+1:this.curpage;
					this.dataSend();
				}
			}
		}).mount('.container')
	</script>
</body>
</html>