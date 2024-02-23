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
	<div class="wrapper row3">
  <main class="container clear"> 
    <div class="content" id="foodApp"> 
      <div id="gallery">
        <figure>
          <h3>맛집 목록</h3>
          <header class="heading"></header>
          <ul class="nospace clear">
            <li v-for="(vo,index) in food_list" :class="index%4==0?'one_quarter first':'one_quarter'"><a :href="'../food/food_before_list_detail.do?fno='+vo.fno"><img :src="'http://www.menupan.com/'+vo.poster" :title="vo.name" alt=""></a></li>
          </ul>
          <figcaption></figcaption>
        </figure>
      </div>
      <nav class="pagination">
        <ul>
          <li v-if="startPage>1"><a @click="prev()" class="link">&laquo; Previous</a></li>
          <li v-for="i in range(startPage,endPage)" :class="i==curpage?'current':''"><a @click="pageChange(i)" class="link">{{i}}</a></li>
          <li v-if="endPage<totalpage"><a @click="next()" class="link">Next &raquo;</a></li>
        </ul>
      </nav>
      <div class="clear"></div>
    <div>
    	<h3>최근 방문 맛집</h3>
    	<hr>
    	<span v-for="vo in cookie_list">
    		<a :href="'../food/food_list_detail.do?fno='+vo.fno"><img :src="'http://www.menupan.com/'+vo.poster" style="width:100px;height:100px;margin-left:5px;"></a>
    	</span>
    </div>
    </div>
  </main>
</div>
<script>
	let foodApp = Vue.createApp({
		//데이터 관리 => 멤버 변수 => this.
		data(){
			return{
				food_list:[],
				curpage:1,
				totalpage:0,
				startPage:0,
				endPage:0,
				cookie_list:[]
			}
		},
		//시작과 동시에 처리
		mounted(){
			// 브라우저에 화면이 HTML에 보일때 처리 => 자동 호출 함수
			/*
				자동 호출 함수 => Vue의 생명주기
				beforeCreate()
				created()
				------------------------- Vue객체 생성
				beforeMount() => mount : 가상 메모리에 HTML을 올리는 경우
				mounted() => window.onload , $(function(){}), componentDidMount()
				                                              => HOOKS
				                                              => useEffect()
				                                              => class / function
			    beforeUpdate()
				updated()
				
			*/
			this.dataRecv()
		},
		updated(){
			
		},
		methods:{
			//공통으로 사용되는 함수 => 반복제거
			dataRecv(){
				axios.get('../food/food_list_vue.do',{
					params:{
						page:this.curpage
					}
				}).then(res=>{
					console.log(res.data)
					this.food_list=res.data
				})
				
				axios.get('../food/food_page_vue.do',{
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
				
				axios.get('../food/food_cookie_vue.do').then(res=>{
					console.log(res.data)
					this.cookie_list=res.data
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
	}).mount('#foodApp')
</script>
</body>
</html>