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
    <div class="content" id="chefApp"> 
      <div id="gallery">
        <figure>
          <h3>쉐프 레시피 리스트</h3>
          <header class="heading inline">
          	<input type="text" class="input-sm" ref="ss" v-model="ss" size=20 placeholder="검색어입력" @keyup.enter="recipeFind()">
          	<input type="button" class="btn-sm btn-info" value="검색" @click="recipeFind()">
          	<input type="button" class="btn-sm btn-success" value="전체" @click="recipeTotal()">
          </header>
          <ul class="nospace clear">
            <li v-for="(vo,index) in chef_list" :class="index%4==0?'one_quarter first':'one_quarter'"><a :href="'../recipe/recipe_before_detail.do?no='+vo.no"><img :src="vo.poster" :title="vo.title" alt=""></a></li>
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
    </div>
    <div class="clear"></div>
  </main>
</div>
<script>
	let chefApp = Vue.createApp({
		//데이터 관리 => 멤버 변수 => this.
		data(){
			return{
				chef_list:[],
				curpage:1,
				totalpage:0,
				startPage:0,
				endPage:0,
				cno:${cno},
				ss:''
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
				axios.get('../recipe/chef_detail_vue.do',{
					params:{
						page:this.curpage,
						cno:this.cno,
						ss:this.ss
					}
				}).then(res=>{
					console.log(res.data)
					this.chef_list=res.data
				})
				
				axios.get('../recipe/chef_detail_page_vue.do',{
					params:{
						page:this.curpage,
						cno:this.cno,
						ss:this.ss
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
			},
			recipeFind(){
				if(this.ss===""){
					this.$refs.ss.focus();
					return;
				}
				this.curpage=1;
				this.dataRecv()
			},
			recipeTotal(){
				this.curpage=1;
				this.ss=''
				this.dataRecv();
			}
		}
	}).mount('#chefApp')
</script>
</body>
</html>