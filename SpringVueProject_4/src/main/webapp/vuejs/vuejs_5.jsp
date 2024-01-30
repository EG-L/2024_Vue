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
		width:960px;
	}
	.trs:hover{
		cursor:pointer;
	}
</style>
<script src="https://unpkg.com/vue@3"></script>
</head>
<body>
 <div class="container">
 	<div class="row">
 		start:<input type="text" size="10" class="input-sm" v-model="startPage"><br>
 		end:<input type="text" size="10" class="input-sm" v-model="endPage">
 	</div>
 	<div class="row">
		<ul class="pagination">
			<li><a href="#">&laquo;</a></li>
			<li v-for="i in range(startPage,endPage)"><a href="#">{{i}}</a></li>
			<li><a href="#">&raquo;</a></li>
		</ul>
 	</div>
 </div>
 <script>
 	let app = Vue.createApp({
 		data(){
 			return{
 				startPage:1,
 				endPage:10
 			}
 		},
 		methods:{
 			range(start,end){
 				let arr = []
 				let length = end-start
 				for(let i = 0; i<=length;i++){
 					arr[i] = start
 					start++;
 				}
 				return arr;
 			}
 		}
 	}).mount('.container')
 </script>
</body>
</html>