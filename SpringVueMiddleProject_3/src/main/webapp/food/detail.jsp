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
		<div class="row">
			<table class="table">
				<tr>
					<td width=30% class="text-center" rowspan=8>
						<img :src="'http://www.menupan.com'+vo.poster" alt="Lights" style="width:100%">
					</td>
					<td colspan=2>
						<h3>{{vo.name}}&nbsp;<span style="color:orange">{{vo.score}}</span></h3>
					</td>
				</tr>
				<tr>
					<td class="text-center" width=10%>음식종류</td>
					<td width=60%>{{vo.type}}</td>
				</tr>
				<tr>
					<td class="text-center" width=10%>주소</td>
					<td width=60%>{{vo.address}}</td>
				</tr>
				<tr>
					<td class="text-center" width=10%>전화</td>
					<td width=60%>{{vo.phone}}</td>
				</tr>
				<tr>
					<td class="text-center" width=10%>테마</td>
					<td width=60%>{{vo.theme}}</td>
				</tr>
				<tr>
					<td class="text-center" width=10%>가격대</td>
					<td width=60%>{{vo.price}}</td>
				</tr>
				<tr>
					<td class="text-center" width=10%>영업시간</td>
					<td width=60%>{{vo.time}}</td>
				</tr>
				<tr>
					<td class="text-center" width=10%>좌석</td>
					<td width=60%>{{vo.seat}}</td>
				</tr>
			</table>
		</div>
		<div style="height:20px"></div>
		<div class="row">
			
		</div>
	</div>
	<script>
		let app = Vue.createApp({
			data(){
				return{
					vo:{},
					fno:${fno}, // EL 태그
					address:'',
					name:''
				}
			},
			methods:{
				
			},
			mounted(){
				axios.get('../food/detail_vue.do',{
					params:{
						fno:this.fno
					}
				}).then(response=>{
					console.log(response.data)
					this.vo=response.data
				})
			},
			updated(){
				
			}
		}).mount('.container')
	</script>
</body>
</html>