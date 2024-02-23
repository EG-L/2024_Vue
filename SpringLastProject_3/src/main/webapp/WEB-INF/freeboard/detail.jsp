<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
 <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['단어', '단어 횟수'],
          <c:forEach var="vo" items="${list}">
          ['<c:out value="${vo.word}"/>',    <c:out value="${vo.count}"/>],
          </c:forEach>
        ]);

        var options = {
          title: '내용 분석',
          pieHole: 0.4,
        };

        var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
        chart.draw(data, options);
      }
    </script>
</head>
<body>
	<div class="wrapper row3" id="fboardApp">
  		<main class="container clear">
  			<h2 class="sectiontitle">내용 보기</h2>
  			<table class="table">
  				<tr>
  					<th width="20%" class="text-center">번호</th>
  					<td width="30%" class="text-center" v-text="detail_data.no"></td>
  					<th width="20%" class="text-center">작성일</th>
  					<td width="30%" class="text-center" v-text="detail_data.dbday"></td>
  				</tr>
  				<tr>
  					<th width="20%" class="text-center">이름</th>
  					<td width="30%" class="text-center" v-text="detail_data.name"></td>
  					<th width="20%" class="text-center">조회수</th>
  					<td width="30%" class="text-center" v-text="detail_data.hit"></td>
  				</tr>
  				<tr>
  					<th width="20%" class="text-center">제목</th>
  					<td colspan="3" v-text="detail_data.subject"></td>
  				</tr>
  				<tr>
  					<td colspan="4" class="text-center" valign="top" height="200">
  						<pre style="white-space:pre-wrap;border:none;background-color: white;">{{detail_data.content}}</pre>
  					</td>
  				</tr>
  				<tr>
  					<td colspan=4 class="text-right inline">
  						<input type="button" class="btn-xs btn-success" value="수정" @click="updateForm()">&nbsp;
  						<input type="button" class="btn-xs btn-info" value="삭제" ref="delBtn" @click="boardDeleteForm()">&nbsp;
  						<input type="button" class="btn-xs btn-warning" value="목록" @click="boardList()">&nbsp;
  					</td>
  				</tr>
  				<tr v-show="isShow">
  					<td colspan=4 class="text-right inline">
  						비밀번호: <input type="password" ref="pwd" v-model="pwd" class="input-sm" size=15>&nbsp;&nbsp;
  						<input type="button" class="btn-sm btn-primary" value="삭제" @click="boardDelete()">
  					</td>
  				</tr>
  			</table>
  			<div id="donutchart" style="width: 960px; height: 500px;"></div>
  		</main>
  	</div>
  	<script>
  		let fApp = Vue.createApp({
  			data(){
  				return{
  					no:${no},
  					detail_data:{},
  					data_list:[],
  					pwd:'',
  					isShow:false,
  					check:0
  				}
  			},
  			mounted(){
  				axios.get('../freeboard/detail_vue.do',{
  					params:{
  						no:this.no
  					}
  				}).then(res=>{
  					console.log(res.data)
  					this.detail_data = res.data
  					
  				})
  			},
  			methods:{
  				boardList(){
  					location.href="../freeboard/list.do"
  				},
  				boardDeleteForm(){
  					if(this.check===0){
  						this.check=1;
  						this.isShow=true;
  						this.$refs.delBtn.value="취소";
  						this.$refs.pwd.focus();
  					}
  					else{
  						this.check=0;
  						this.isShow=false;
  						this.$refs.delBtn.value="삭제";
  						this.$refs.pwd = '';
  					}
  				},
  				boardDelete(){
  					if(this.pwd===''){
  						this.$refs.pwd.focus();
  						return;
  					}
  					axios.get('../freeboard/delete_vue.do',{
  						params:{
  							no:this.no,
  							pwd:this.pwd
  						}
  					}).then(res=>{
  						if(res.data==="yes"){
  							location.href="../freeboard/list.do"
  						}
  						else{
  							alert("비밀번호가 틀렸습니다.")
  							this.pwd=""
  							this.$refs.pwd.focus();
  						}
  					})
  				},
  				updateForm(){
  					location.href="../freeboard/update.do?no="+this.no;
  				}
  			}
  		}).mount('#fboardApp')
  	</script>
</body>
</html>