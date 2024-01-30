<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
	[{"rank":1,"title":"신과함께-죄와 벌"},{"rank":2,"title":"1987"},{"rank":3,"title":"쥬만지: 새로운 세계"},{"rank":4,"title":"페르디난드"},{"rank":5,"title":"강철비"},{"rank":6,"title":"위대한 쇼맨"},{"rank":7,"title":"원더"},{"rank":8,"title":"극장판 포켓몬스터 너로 정했다!"},{"rank":9,"title":"너의 이름은."},{"rank":10,"title":"뽀로로 극장판 공룡섬 대모험"}]
 -->
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
		width:960px;
	}
	.images:hover{
		cursor:pointer;
	}
</style>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
	<div class="cotainer" id="app">
		<div class="row">
		<div class="col-sm-4">
			<h3 class="text-center">박스오피스</h3>
			<table class="table">
				<tr>
					<th class="text-center">순위</th>
					<th class="text-center">제목</th>
				</tr>
				<tr v-for="vo in box">
					<td class="text-center">{{vo.rank}}</td>
					<td>{{vo.title}}</td>
				</tr>
			</table>
			</div>
		<div class="col-sm-4">
			<h3 class="text-center">영화순위</h3>
			<table class="table">
				<tr>
					<th class="text-center">순위</th>
					<th class="text-center">제목</th>
				</tr>
				<tr v-for="vo in rank">
					<td class="text-center">{{vo.rank}}</td>
					<td>{{vo.title}}</td>
				</tr>
			</table>
			</div>
		<div class="col-sm-4">
			<h3 class="text-center">예매율 순위</h3>
			<table class="table">
				<tr>
					<th class="text-center">순위</th>
					<th class="text-center">제목</th>
				</tr>
				<tr v-for="vo in reserve">
					<td class="text-center">{{vo.rank}}</td>
					<td>{{vo.title}}</td>
				</tr>
			</table>
			</div>
		</div>
		</div>
	<script>
		let app = Vue.createApp({
			//데이터 관리
			data(){
				return{
					box:[{"rank":1,"title":"신과함께-죄와 벌"}
					,{"rank":2,"title":"1987"}
					,{"rank":3,"title":"쥬만지: 새로운 세계"}
					,{"rank":4,"title":"페르디난드"}
					,{"rank":5,"title":"강철비"}
					,{"rank":6,"title":"위대한 쇼맨"}
					,{"rank":7,"title":"원더"}
					,{"rank":8,"title":"극장판 포켓몬스터 너로 정했다!"}
					,{"rank":9,"title":"너의 이름은."}
					,{"rank":10,"title":"뽀로로 극장판 공룡섬 대모험"}],
					rank:[{"rank":1,"title":"1987"},{"rank":2,"title":"신과함께-죄와 벌"},{"rank":3,"title":"쥬만지: 새로운 세계"},{"rank":4,"title":"코코"},{"rank":5,"title":"강철비"},{"rank":6,"title":"위대한 쇼맨"},{"rank":7,"title":"다운사이징"},{"rank":8,"title":"페르디난드"},{"rank":9,"title":"원더"},{"rank":10,"title":"쏘아올린 불꽃, 밑에서 볼까? 옆에서 볼까?"}],
					reserve:[{"rank":1,"title":"1987"},{"rank":2,"title":"코코"},{"rank":3,"title":"신과함께-죄와 벌"},{"rank":4,"title":"쥬만지: 새로운 세계"},{"rank":5,"title":"페르디난드"},{"rank":6,"title":"위대한 쇼맨"},{"rank":7,"title":"쏘아올린 불꽃，밑에서 볼까? 옆에서 볼까?"},{"rank":8,"title":"다운사이징"},{"rank":9,"title":"원더"},{"rank":10,"title":"강철비"}]
				}
			}
			//데이터 처리
		}).mount('#app')
	</script>
</body>
</html>