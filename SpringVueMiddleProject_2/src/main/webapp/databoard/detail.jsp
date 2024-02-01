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
		<h3 class="text-center">내용보기</h3>
		<div class="row">
			<table class="table">
				<tr>
					<th width=20% class="text-center success">번호</th>
					<td width=30% class="text-center">{{detail_data.no}}</td>
					<th width=20% class="text-center success">작성일</th>
					<td width=30% class="text-center">{{detail_data.dbday}}</td>
				</tr>
				<tr>
					<th width=20% class="text-center success">이름</th>
					<td width=30% class="text-center">{{detail_data.name}}</td>
					<th width=20% class="text-center success">조회수</th>
					<td width=30% class="text-center">{{detail_data.hit}}</td>
				</tr>
				<tr>
					<th width=20% class="text-center success">제목</th>
					<td colspan=3>{{detail_data.subject}}</td>
				</tr>
				<tr v-if="filecount!=0">
					<th width=20% class="text-center success">첨부파일</th>
					<td colspan=3>
						<ul>
							<li v-for="(filename,index) in filenames">
								<a :href="'../databoard/download.do?fn='+filename">
									{{filename}}({{filesizes[index]}} Bytes)
								</a>
							</li>
						</ul>
					</td>
				</tr>
				<tr>
					<td colspan=4 class="text-left" valign="top" height="200">
						<pre style="white-space: pre-wrap;background-color: white;border: none;">{{detail_data.content}}</pre>
					</td>
				</tr>
				<tr>
					<td colspan=4 class="text-right">
						<button class="btn-xs btn-danger">수정</button>
						<button class="btn-xs btn-info">삭제</button>
						<button class="btn-xs btn-success" @click="datalist()">목록</button>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<script>
		let app = Vue.createApp({
			data(){
				return{
					detail_data:{},
					no:${no},
					filenames:[],
					filesizes:[],
					filecount:0
				}
			},
			methods:{
				datalist(){
					location.href="../databoard/list.do";
				}
			},
			mounted(){
				axios.get('../databoard/detail_vue.do',{
					params:{
						no:this.no
					}
				}).then(response=>{
					this.detail_data=response.data;
					let leng=response.data.filecount;
					if(leng>0){
						this.filenames=response.data.filename.split(",");
						this.filesizes=response.data.filesize.split(",");
					}
					this.filecount=leng;
					
					console.log(this.filecount);
				})
			},
			updated(){
				
			}
		}).mount('.container')
	</script>
</body>
</html>