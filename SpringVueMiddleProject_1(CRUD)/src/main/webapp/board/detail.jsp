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
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
</head>
<body>
	<div class="container">
		<h3 class="text-center">내용보기</h3>
		<div class="row">
			<table class="table">
				<tr>
					<th width=20% class="text-center">번호</th>
					<td width=30% class="text-center">{{board_detail.no}}</td>
					<th width=20% class="text-center">작성일</th>
					<td width=30% class="text-center">{{board_detail.dbday}}</td>
				</tr>
				<tr>
					<th width=20% class="text-center">이름</th>
					<td width=30% class="text-center">{{board_detail.name}}</td>
					<th width=20% class="text-center">조회수</th>
					<td width=30% class="text-center">{{board_detail.hit}}</td>
				</tr>
				<tr>
					<th width=20% class="text-center">제목</th>
					<td colspan=3>{{board_detail.subject}}</td>
				</tr>
				<tr>
					<td colspan=4 class="text-left" valign="top" height="200">
						<pre style="white-space: pre-wrap;">{{board_detail.content}}</pre>
					</td>
				</tr>
				<tr>
					<td colspan="4" class="text-right">
						<input type="button" value="수정" class="btn-success btn-xs" @click="update()">
						<input type="button" value="삭제" class="btn-info btn-xs" @click="deleteData()" id="delBtn">
						<input type="button" value="목록" class="btn-warning btn-xs" @click="listData()">
					</td>
				</tr>
				<tr id="del" style="display: none;">
					<td colspan=4 class="text-right">
						비밀번호:<input type="password" class="input-sm" ref="pwd">
						<input type="button" class="btn-sm btn-success" value="삭제">
					</td>
				</tr>
			</table>
		</div>
	</div>
	<script>
		let app=Vue.createApp({
			data(){
				return{
					board_detail:{},
					no:${no},
					change:0
				}
			},
			mounted(){
				axios.get('../board/detail_vue.do',{
					params:{
						no:this.no
					}
				}).then(response=>{
					console.log(response.data);
					this.board_detail = response.data;
				}).catch(error=>{
					console.log(error.response);
				})
				
				//$(function(){=>mounted})
				
			},
			methods:{
				listData(){
					location.href="../board/list.do"
				},
				update(){
					location.href="../board/update.do?no="+this.no
				},
				deleteData(){
					if(this.change===0){
						this.change=1;
						$('#delBtn').val("취소");
						$('#del').show();
						
					}
					else{
						this.change=0;
						$('#delBtn').val("삭제");
						$('#del').hide();
					}
				}
			}
		}).mount('.container')
	</script>
</body>
</html>