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
			<ul>
				<!-- 
					v-for = "받는 변수 in 배열" v-for="{실제 데이터, 인덱스} in 배열"
					
					디렉티브
					 v-for : 반복문 (for-each)
					 v-if : 조건문  v-if="조건(true/false)" v-show="true/false"
					 v-if ~ v-else
					 v-if ~ v-else-if
					 
					 v-model => 멤버변수 매칭
					 v-on : 이벤트 ==> @
					 
					 화면 출력 : {{}}
					    속성 :  :속석명
					 
					 서버 연결 => 데이터값을 가지고 오는 라이브러리
					 axios.get("URL",{ ===> @GetMapping
					 	params:{
					 		키:값 ===> ?키=값
					 	},
					 	options:{
					 	} =======> 서버 전송
					 }).then(변수(결과값을 읽어온 변수){
					    ==========> 서버에서 실행된 결과값 처리
					 }
					 catch(e){
					    ==========> 오류 발생시 처리
					 }
					 axios.post("URL",{ ==> @PostMapping
					 	=> 보낼 데이터 
					 }).then(){
					 }
				 -->
				<li v-for="(name,index) in names">
					{{index+1}}.{{name}}
				</li>
			</ul>
		</div>
	</div>
	<script>
		let app = Vue.createApp({
			data(){
				return{
					names:["홍길동","이순신","심청이","박문수","강감찬"]
				}
			}
		}).mount(".container")
	</script>
	
</body>
</html>