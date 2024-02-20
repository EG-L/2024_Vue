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
<style type="text/css">
	.row1{
		margin: 0px auto;
		width: 400px;
	}
</style>
</head>
<body>
	<div class="wrapper row3" id="loginApp">
  		<main class="container clear">
  			<h2 class="sectiontitle">로그인</h2>
  			<div class="row row1">
  				<table class="table">
  					<tr>
  						<td width=20% class="text-right">ID</td>
  						<td width=80%>
  							<input type="text" name="id" class="input-sm" ref=id v-model="id">
  						</td>
  					</tr>
  					<tr>
  						<td width=20% class="text-right">Password</td>
  						<td width=80%>
  							<input type="password" name="pwd" class="input-sm" ref=pwd v-model="pwd">
  						</td>
  					</tr>
  					<tr>
  						<td colspan="2" class="inline">
  							<input type="checkbox" ref="ck" v-model="ck">ID저장
  							<!-- true/false -->
  						</td>
  					</tr>
  					<tr>
  						<td colspan="2" class="text-center inline">
  							<input type="button" value="로그인" class="btn-danger btn-sm" @click="login()">
  							<input type="button" value="취소" class="btn-danger btn-sm" onclick="javascript:history.back()">
  						</td>
  					</tr>
  				</table>
  			</div>
  		</main>
  	</div>
  	<script>
  		let loginApp = Vue.createApp({
  			data(){
  				return{
  					id:'${userId}',
  					pwd:'',
  					ck:true
  				}
  			},
  			mounted(){
  				
  			},
  			methods:{
  				login(){
  					if(this.id===''){
  						alert('아이디를 입력해주세요')
  						this.$refs.id.focus();
  						return ;
  					}
  					
  					if(this.pwd===''){
  						alert('비밀번호를 입력해주세요')
  						this.$refs.pwd.focus();
  						return ;
  					}
  					
  					axios.get('../member/login_ok_vue.do',{
  						params:{
  							userId:this.id,
  							userPwd:this.pwd,
  							ck:this.ck
  						}
  					}).then(res=>{
  						// NOID , NOPWD , OK
  						if(res.data==='NOID'){
  							alert('아이디가 존재하지 않습니다.')
  							this.id='';
  							this.pwd='';
  							this.ck = false;
  							this.$refs.id.focus();
  						}
  						else if(res.data==='NOPWD'){
  							alert('비밀번호가 틀립니다')
  							this.pwd = '';
  							this.ck = false;
  							this.$refs.pwd.focus();
  						}
  						else{
  							location.href = '../main/main.do';
  						}
  					})
  				}
  			}
  		}).mount('#loginApp')
  	</script>
</body>
</html>