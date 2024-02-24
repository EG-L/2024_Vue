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
	<div class="wrapper row3" id="mypageApp">
  		<main class="container clear">
  		<h2 class="sectiontitle">예약목록</h2>
  		<table class="table">
  			<tr>
  				<th>번호</th>
  				<th></th>
  				<th>아이디</th>
  				<th>업체명</th>
  				<th>예약일</th>
  				<th>예약시간</th>
  				<th>인원</th>
  				<th></th>
  			</tr>
  			<tr v-for="vo in reserve_list">
  				<td>{{vo.rno}}</td>
  				<td><img :src="'http://www.menupan.com/'+vo.fvo.poster" style="width:30px;height:30px;"></td>
  				<td>{{vo.userId}}</td>
  				<td>{{vo.fvo.name}}</td>
  				<td>{{vo.rdate}}</td>
  				<td>{{vo.rtime}}</td>
  				<td>{{vo.rinwon}}</td>
  				<td>
  					<span class="btn btn-xs btn-danger" v-if="vo.rserve_ok==1" @click="ok(vo.rno)">승인대기</span>
  					<span class="btn btn-xs btn-default" v-else>승인완료</span>
  				</td>
  			</tr>
  		</table>
  		</main>
  	</div>
  	<script>
  		let mypageApp=Vue.createApp({
  			data(){
  				return{
  					reserve_list:[]
  				}
  			},
  			mounted(){
  				this.data_recv();
  			},
  			methods:{
  				ok(rno){
  					
  				},
  				data_recv(){
  					axios.get('../reserve/mypage_list_vue.do').then(
  		  					response=>{
  		  						console.log(response.data);
  		  						this.reserve_list=response.data;
  		  					}
  		  				)
  				},
  				reserveCancel(rno){
  					axios.get('../reserve/reserve_cancel_vue.do',{
  						params:{
  							rno:rno
  						}
  					}).then(response=>{
  						if(response.data==='yes'){
  							this.reserve_list = response.data;
  							this.data_recv();
  						}
  						else{
  							alert('예약 취소기 실패하셨습니다.\n다시 취소 바라빈다.');
  						}
  					})
  				}
  			}
  		}).mount('#mypageApp')
  	</script>

</body>
</html>