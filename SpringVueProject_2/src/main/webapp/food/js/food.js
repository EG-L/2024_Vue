let app = Vue.createApp({
			data(){
				return {
					food_list:[], //ArrayList [{},{}...]
					food_detail:{},//VO
					fno:0,
					isShow:false
				}
			},
			// 브라우저 실행 처리 => window.onload / $(function(){})
			mounted(){
				axios.get('http://localhost:8080/web/food/list_vue.do').then(response=>{
					console.log(response.data)
					this.food_list = response.data;
				})
			},
			methods:{
				detail(fno){
					this.isShow=true;
					this.fno = fno;
					axios.get('http://localhost:8080/web/food/detail_vue.do',{
						params:{
							fno:this.fno
						}
					}).then(response=>{
						console.log(response.data)
						this.food_detail = response.data
					})
				}
			}
		}).mount('#app')