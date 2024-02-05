<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<style type="text/css">
	.alink:hover{
		cursor:pointer;
	}
</style>
</head>
<body>
	<div class="container" id="detailApp">
		<div class="row">
			<table class="table">
				<tr>
					<td width=30% class="text-center" rowspan=8>
						<img :src="'http://www.menupan.com'+detail_data.poster" style="width:100%">
					</td>
					<td colspan="2">
						<h3>{{detail_data.name}}&nbsp;<span style="color:orange">{{detail_data.score}}</span></h3>
					</td>
				</tr>
				<tr>
					<td width="10%">주소</td>
					<td width="60%">{{detail_data.address}}</td>
				</tr>
				<tr>
					<td width="10%">전화</td>
					<td width="60%">{{detail_data.phone}}</td>
				</tr>
				<tr>
					<td width="10%">음식종류</td>
					<td width="60%">{{detail_data.type}}</td>
				</tr>
				<tr>
					<td width="10%">가격대</td>
					<td width="60%">{{detail_data.price}}</td>
				</tr>
				<tr>
					<td width="10%">영업시간</td>
					<td width="60%">{{detail_data.time}}</td>
				</tr>
				<tr>
					<td width="10%">좌석</td>
					<td width="60%">{{detail_data.seat}}</td>
				</tr>
				<tr>
					<td width="10%">테마</td>
					<td width="60%">{{detail_data.theme}}</td>
				</tr>
				<tr>
					<td colspan=3 class="text-right">
						<a href="javascript:history.back()" class="btn btn-sm btn-danger">목록</a>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<!-- component -->
	<div class="container" id="replyApp">
		<div class="row">
			<table class="table">
				<tr>
					<td>
						<table class="table" v-for="vo in reply_list">
							<tr>
								<td class="text-left">
									▶{{vo.name}}({{vo.dbday}})
								</td>
								<td class="text-right">
									<span v-if="vo.id===sessionId">
										<input type="button" :value="((isShow===true)&&(vo.rno===rno)?'취소':'수정')" class="btn-xs btn-success" style="margin-left:3px" @click="replyUpdateForm(vo.rno)">
										<input type="button" value="삭제" class="btn-xs btn-info" @click="replyDelete(vo.rno)">
									</span>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<pre style="white-space: pre-wrap;background-color: white;border:none">{{vo.msg}}</pre>
								</td>
							</tr>
							<tr v-if="isShow===true && rno===vo.rno">
							<td colspan=2>
									<textarea rows="5" cols="60" style="float:left;" ref="umsg" :id="'msg'+vo.rno">{{vo.msg}}</textarea>
									<input type="button" value="댓글수정" style="float:left;height:96px" class="btn-danger" @click="replyupdate(vo.rno)">
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<table class="table" v-show="sessionId!=''">
				<tr>
					<td class="text-left">
						<textarea rows="5" cols="60" style="float:left;" v-model="msg" ref="msg"></textarea>
						<input type="button" value="댓글쓰기" style="float:left;height:96px" class="btn-danger" @click="replyInsert()">
					</td>
				</tr>
			</table>
		</div>
	</div>
	<script>
		let detailApp = Vue.createApp({
			data(){
				return{
					fno:${fno},
					detail_data:{}
				}
			},
			// $(function(){}),componentDidMount(), window.onload=function(){}
			mounted(){
				axios.get("../food/detail_vue.do",{
					params:{
						fno:this.fno
					}
				}).then(response=>{
					console.log(response.data)
					this.detail_data=response.data
				})
			},
			updated(){
				
			},
			methods:{
				
			}
		}).mount('#detailApp')
		
		let replyApp = Vue.createApp({
			data(){
				return{
					fno:${fno},
					sessionId:'${id}',
					reply_list:[],
					rno:0,
					msg:'',
					umsg:'',
					isShow:false,
					bCheck:true
				}
			},
			mounted(){
				axios.get('../reply/list_vue.do',{
					params:{
						fno:this.fno
					}
				}).then(response=>{
					this.reply_list=response.data
				})
			},
			updated(){
				// 시작과 동시에 댓글 읽기
			},
			methods:{
				//수정
				replyUpdateForm(rno){
					if(this.bCheck===true){
						this.isShow=true
						this.rno=rno
						this.bCheck=false
					}
					else{
						this.isShow=false
						this.rno=rno
						this.bCheck=true
					}
					
				},
				replyupdate(rno){
					let msg=$('#msg'+rno).value();
					axios.get('../reply/upate_vue.do',{
						params:{
							rno:rno,
							fno:this.fno,
							msg:msg
						}
					}).then(response=>{
						// 상태 관리 => 데이터 변경
						this.reply_list=response.data
						$('#u'+rno).hide()
						this.isShow=false
						this.rno=rno
						this.bCheck=true
					})
				},
				//삭제
				replyDelete(rno){
					axios.get("../reply/delete_vue.do",{
						params:{
							rno:rno,
							fno:this.fno
						}
					}).then(response=>{
						this.reply_list=response.data;
					})
				},
				//추가
				replyInsert(){
					if(this.msg===""){
						this.$refs.msg.focus();
						return;
					}
					
					axios.get('../reply/insert_vue.do',{
						params:{
							fno:this.fno,
							msg:this.msg,
						}
					}).then(response=>{
						this.reply_list=response.data
						this.$refs.msg='';
					})
				}
			}
		}).mount('#replyApp')
	</script>
</body>
</html>