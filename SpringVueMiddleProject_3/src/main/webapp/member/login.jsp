<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
	<div class="container" id="logApp">
		<c:if test="${sessionScope.id==null }">
			<div class="row">
				<div class="text-right">
					ID: <input type="text" ref="id" class="input-sm" v-model="id">&nbsp;
					PW: <input type="password" ref="pwd" class="input-sm" v-model="pwd">&nbsp;
					<input type="button" value="로그인" class="btn-sm btn-danger" @click="login()">
				</div>
			</div>
		</c:if>
		<c:if test="${sessionScope.id!=null }">
			<div class="row">
				<div class="text-right">
					${sessionScope.name}님 로그인하셨습니다.
					<input type="button" value="로그아웃" class="btn-sm btn-danger" @click="logout()">
				</div>
			</div>
		</c:if>
	</div>
	<script>
		let logapp = Vue.createApp({
			data(){
				return{
					id:'',
					pwd:'',
					msg:''
					
				}
			},
			mounted(){
				
			},
			updated(){
				
			},
			methods:{
				login(){
					if(this.id===''){
						this.$refs.id.focus();
						return;
					}
					if(this.pwd===''){
						this.$refs.pwd.focus();
						return;
					}
					
					axios.get('../member/login_vue.do',{
						params:{
							id:this.id,
							pwd:this.pwd
						}
					}).then(response=>{
						if(response.data==='NOID'){
							this.id='';
							this.pwd='';
							this.$refs.id.focus();
							alert("아이디가 존재하지 않습니다.")
						}
						else if(response.data==='NOPWD'){
							this.pwd='';
							this.$refs.pwd.focus();
							alert("비밀번호가 틀렸습니다.")
						}
						else{
							location.href='../food/list.do'
						}
					})
				},
				logout(){
					location.href="../member/logout.do"
				}
			}
		}).mount('#logApp')
	</script>
</body>
</html>