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
	<div class="container" id="listApp">
		<div class="row">
			<div class="col-md-3" v-for="vo in food_list">
		    <div class="thumbnail">
		      <a :href="'../food/detail.do?fno='+vo.fno">
		        <img :src="'http://www.menupan.com'+vo.poster" style="width:100%">
		        <div class="caption">
		          <p style="font-size:8px">{{vo.name}}</p>
		        </div>
		      </a>
		    </div>
		</div>
		<div style="height: 20px"></div>
		<div class="row">
			<div class="text-center">
				<ul class="pagination">
				  <li v-if="startPage>1"><a class="alink" @click="prev()">&laquo;</a></li>
				  <li v-for="i in range(startPage,endPage)" :class="i===curpage?'active':''" @click="pageChange(i)"><a class="alink">{{i}}</a></li>
				  <li v-if="endPage<totalpage"><a class="alink" @click="next()">&raquo;</a></li>
				</ul>
			</div>
		</div>
	</div>
	</div>
	<script>
		let foodApp = Vue.createApp({
			data(){
				return{
					//멤버변수
					food_list:[],
					curpage:1,
					totalpage:0,
					startPage:0,
					endPage:0
				}
			},
			mounted(){
				this.dataRecv()
				//CallBack => Vue에 의해서 자동 호출되는 생명주기 함수 => onload() => $(function(){})
			},
			updated(){
				
			},
			//사용자 정의 함수 => 이벤트 , 데이터 읽기 , 데이터 보내기
			methods:{
				dataRecv(){
					axios.get("../food/list_vue.do",{
						params:{
							page:this.curpage
						}
					}).then(response=>{
						console.log(response.data)
						this.food_list = response.data 
					})
					
					axios.get("../food/page_vue.do",{
						params:{
							page:this.curpage
						}
					}).then(response=>{
						console.log(response.data)
						this.totalpage = response.data.totalpage;
						this.startPage = response.data.startPage;
						this.endPage = response.data.endPage;
						this.curpage = response.data.curpage;
					})
				},
				range(start,end){
					let arr=[]
					let leng=end-start;
					for(let i=0;i<=leng;i++){
						arr[i] = start;
						start++
					}
					return arr;
				},
				prev(){
					this.curpage=this.startPage-1
					this.dataRecv()
				},
				next(){
					this.curpage=this.endPage+1
					this.dataRecv()
				},
				pageChange(page){
					this.curpage=page
					this.dataRecv()
				}
				
			}
		}).mount('#listApp')
	</script>
</body>
</html>