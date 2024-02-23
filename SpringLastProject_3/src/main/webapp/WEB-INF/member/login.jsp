<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<!-- <script type="text/javascript">
	$(function(){
		$('#logBtn').click(function(){
			let id=$('#id').val()
			if(id.trim()===""){
				$('#id').focus();
				return ;
			}
			let pwd=$('#pwd').val()
			if(pwd.trim()===""){
				$('#pwd').focus();
				return ;
			}
			$('#frm').submit()
		})
	})
</script> -->

</head>
<body>
	<div class="wrapper row3" id="loginApp">
  		<main class="container clear">
  			<h2 class="sectiontitle">로그인</h2>
  			<div class="row row1">
  				<form method="POST" action="../member/login.do" id="frm">
	  				<table class="table">
	  					<tr>
	  						<td width=20% class="text-right">ID</td>
	  						<td width=80%>
	  							<input type="text" name="userId" class="input-sm" id="id" ref="id" v-model="id">
	  						</td>
	  					</tr>
	  					<tr>
	  						<td width=20% class="text-right">Password</td>
	  						<td width=80%>
	  							<input type="password" name="userPwd" class="input-sm" id="pwd" ref="pwd" v-model="pwd">
	  						</td>
	  					</tr>
	  					<tr>
	  						<td colspan="2" class="inline">
	  							<input type="checkbox" name="remember-me">자동로그인
	  							<!-- true/false -->
	  						</td>
	  					</tr>
	  					<tr>
	  						<td colspan="2" class="text-center" style="color:red">${message }</td>
	  					</tr>
	  					<tr>
	  						<td colspan="2" class="text-center inline">
	  							<input type="button" value="로그인" class="btn-danger btn-sm" id="logBtn" @click="login()">
	  							<input type="button" value="취소" class="btn-danger btn-sm" onclick="javascript:history.back()">
	  						</td>
	  					</tr>
	  				</table>
  				</form>
  			</div>
  		</main>
  	</div>
  	<script>
  		let logApp = Vue.createApp({
  			data(){
  				return{
  					id:'',
  					pwd:''
  				}
  			},
  			mounted(){
  				
  			},
  			methods:{
  				login(){
  					if(this.id===''){
  						this.$refs.id.focus();
  						return;
  					}
  					if(this.pwd===''){
  						this.$refs.pwd.focus();
  						return;s
  					}
  					$('#frm').submit();
  				}
  			}
  		}).mount('#loginApp')
  	</script>
</body>
</html>