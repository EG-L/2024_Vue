<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<style type="text/css">
	a.link:hover,img.img_click:hover{
		cursor:pointer;
	}
</style>
</head>
<body>
	<div class="wrapper row3" id="chefApp">
  		<main class="container clear">
  			<h3>쉐프 목록</h3>
  			<table class="table" v-for="vo in chef_list">
  				<tr>
  					<td width=20% rowspan=2 class="text-center"><a :href="'../recipe/chef_detail.do?cno='+vo.cno"><img :src="vo.poster" class="img-circle" style="width:120px;height:120px;"></a></td>
  					<td colspan="4">
  						<h3 style="color:orange"><a :href="'../recipe/chef_detail.do?cno='+vo.cno">{{vo.chef}}</a></h3>
  					</td>
  				</tr>
  				<tr>
  					<td class="text-center"><img src="../images/icon/m1.png">&nbsp;{{vo.mem_cont1.toLocaleString()}}</td>
  					<td class="text-center"><img src="../images/icon/m2.png">&nbsp;{{vo.mem_cont2.toLocaleString()}}</td>
  					<td class="text-center"><img src="../images/icon/m3.png">&nbsp;{{vo.mem_cont7.toLocaleString()}}</td>
  					<td class="text-center"><img src="../images/icon/m4.png">&nbsp;{{vo.mem_cont3.toLocaleString()}}</td>
  				</tr>
  			</table>
  			<div style="height:20px;"></div>
			<div class="pagination">
				<ul>
					<li v-if="startPage>1"><a @click="prev()" class="link">&laquo;</a></li>
					<li v-for="i in range(startPage,endPage)" :class="i===curpage?'current':''"><a @click="pageChange(i)" class="link">{{i}}</a></li>
					<li v-if="endPage<totalpage"><a @click="next()" class="link">&raquo;</a></li>
				</ul>
			</div>
 		</main>
 	</div>
  	<script>
  		let chefApp = Vue.createApp({
  			data(){
  				return{
  					chef_list:[],
  					curpage:1,
  					totalpage:0,
  					startPage:0,
  					endPage:0
  				}
  			},
  			mounted(){
  				this.dataRecv()
  			},
  			methods:{
  				dataRecv(){
  					axios.get('../recipe/chef_list_vue.do',{
  						params:{
  							page:this.curpage
  						}
  					}).then(res=>{
  						console.log(res.data)
  						this.chef_list=res.data
  					})
  					
  					axios.get('../recipe/chef_page_vue.do',{
  						params:{
  							page:this.curpage
  						}
  					}).then(res=>{
  						console.log(res.data)
  						this.curpage = res.data.curpage;
  						this.totalpage = res.data.totalpage;
  						this.startPage = res.data.startPage;
  						this.endPage = res.data.endPage;
  					})

  				},
  				range(start,end){
  					let arr=[]
  					let lang=end-start;
  					for(let i=0;i<=lang;i++){
  						arr[i] = start;
  						start++;
  					}
  					return arr;
  				},
  				prev(){
  					this.curpage = this.startPage-1;
  					this.dataRecv();
  				},
  				next(){
  					this.curpage = this.endPage+1;
  					this.dataRecv()
  				},
  				pageChange(page){
  					this.curpage = page;
  					this.dataRecv()
  				}
  			}
  		}).mount('#chefApp')
  	</script>
</body>
</html>