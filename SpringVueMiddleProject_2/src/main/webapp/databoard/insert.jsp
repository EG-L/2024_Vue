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
		<h3 class="text-center">글쓰기</h3>
		<div class="row">
			<%--
				form => 기본 기능 (서버로 데이터 전송)
				     => 화면 reset
				     => 기능을 동작하지 못하게 만든다. @submit.prevent
			 --%>
			<form @submit.prevent="submitForm">
			<table class="table">
				<tr>
					<th width=15% class="text-center">이름</th>
					<td width=85%>
						<input type=text size=15 class="input-sm" v-model="name" ref="name">
					</td>
				</tr>
				<tr>
					<th width=15% class="text-center">제목</th>
					<td width=85%>
						<input type=text size=50 class="input-sm0" v-model="subject" ref="subject">
					</td>
				</tr>
				<tr>
					<th width=15% class="text-center">내용</th>
					<td width=85%>
						<textarea rows="10" cols="52" v-model="content" ref="content"></textarea>
					</td>
				</tr>
				<tr>
					<th width=15% class="text-center">첨부파일</th>
					<td width=85%>
						<input type="file" ref="upfiles" class="input-sm" multiple accept="upload/*" v-model="upfiles">
					</td>
				</tr>
				<tr>
					<th width=15% class="text-center">비밀번호</th>
					<td width=85%>
						<input type=password size=15 class="input-sm" v-model="pwd" ref="pwd">
					</td>
				</tr>
				<tr>
					<td colspan=2 class="text-center">
						<input type="submit" value="글쓰기" class="btn-success btn-sm">
						<input type="button" value="취소" onclick="javascript:history.back()" class="btn-info btn-sm">
					</td>
				</tr>
			</table>
			</form>
		</div>
	</div>
	<script>
		//뷰 객체 생성
		let app = Vue.createApp({
			//멤버변수 설정
			data(){
				return{
					name:'',
					subject:'',
					content:'',
					pwd:'',
					upfiles:''
				}
			},
			//멤버함수 설정
			methods:{
				// submit버튼 호출 시 데이터 전송 없이 submitForm 메소드 호출
				//@submit.prevent => 초기 호출 X
				// submit / a => defaultPrevent => 이벤트 동작 중지
				submitForm(){
					// NOT NULL => 유효성 검사
					if(this.name===''){
						this.$refs.name.focus();//ref는 태그를 제어
						return;
					}
					if(this.subject===''){
						this.$refs.subject.focus();//ref는 태그를 제어
						return;
					}
					if(this.content===''){
						this.$refs.content.focus();//ref는 태그를 제어
						return;
					}
					if(this.pwd===''){
						this.$refs.pwd.focus();//ref는 태그를 제어
						return;
					}
					
					let formData = new FormData();
					formData.append("name",this.name);
					formData.append("subject",this.subject);
					formData.append("content",this.content);
					formData.append("pwd",this.pwd);
					
					let leng = this.$refs.upfiles.files.length;
					//alert("leng="+leng);
					if(leng>0){
						for(let i=0;i<leng;i++){
							formData.append("files["+i+"]",this.$refs.upfiles.files[i]);
						}
					}
				
					//서버로 전송
					axios.post('../databoard/insert_vue.do',formData,{
						header:{
							'Content-Type':'multipart/form-data'
						}
						
					}).then(response=>{
						if(response.data==='yes'){
							location.href="../databoard/list.do"
						}
						else{
							alert(response.data)
						}
					}).catch(error=>{
						console.log(error.response)
					})
				}
			},
			//CallBack => Vue에 의해 호출되는 함수
			mounted(){//초기호출
				
			},
			updated(){//갱신호출
				
			}
		}).mount('.container')
	</script>
</body>
</html>