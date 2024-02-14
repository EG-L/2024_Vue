<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=25f584aced85826b72e1bdc3d53389b6&libraries=services"></script>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<style type="text/css">
	a.link:hover,img.img_click:hover{
		cursor:pointer;
	}
</style>
</head>
<body>
	<div class="wrapper row3" id="foodApp">
	  <main class="container clear">
	     <h2 class="sectiontitle">맛집 상세보기</h2> 
	    <!-- main body --> 
	    <div class="two_third first"> 
	      <table class="table">
				  	<tr>
				  		<td width=30% class="text-center" rowspan="9">
				  			<img :src="'http://www.menupan.com/'+food_detail.poster" style="width:320px;height:500px;">
				  		</td>
				  		<td colspan="2">
				  			<h3><span id="name">{{food_detail.name}}</span>&nbsp;<span style="color:orange">{{food_detail.score}}</span></h3>
				  		</td>
				  	</tr>
				  	<tr>
				  		<th width="15%">주소</th>
				  		<td width="55%">{{food_detail.address}}</td>
				  	</tr>
				  <tr>
	  		<th width="15%">전화</th>
	  		<td width="55%">{{food_detail.phone}}</td>
		  	</tr>
		  	<tr>
		  		<th width="15%">음식종류</th>
		  		<td width="55%">{{food_detail.type}}</td>
		  	</tr>
		  	<tr>
		  		<th width="15%">영업시간</th>
		  		<td width="55%">{{food_detail.time}}</td>
		  	</tr>
		  	<tr>
		  		<th width="15%">가격대</th>
		  		<td width="55%">{{food_detail.price}}</td>
		  	</tr>
		  	<tr>
		  		<th width="15%">좌석</th>
		  		<td width="55%">{{food_detail.seat}}</td>
		  	</tr>
		  	<tr>
		  		<th width="15%">테마</th>
		  		<td width="55%">{{food_detail.theme}}</td>
		  	</tr>
		  	<tr>
		  		<td colspan="3" class="text-right inline">
		  			<input type="button" class="btn-xs btn-success" value="찜하기">&nbsp;
		  			<input type="button" class="btn-xs btn-info" value="예약">&nbsp;
		  			<input type="button" class="btn-xs btn-warning" value="목록" onclick="javascript:history.back()">
		  		</td>
		  	</tr>
		</table>
	    </div>
	    <div class="one_third"> 
	      <div id="map" style="width:100%;height:350px;"></div>
	    </div>
	    <!-- / main body -->
	    <div class="clear"></div>
	  </main>
	</div>
	<script>
		let fApp = Vue.createApp({
			data(){
				return{
					food_detail:{},
					fno:${fno}
				}
			},
			mounted(){
				axios.get('../food/food_detail_vue.do',{
					params:{
						fno:this.fno
					}
				}).then(res=>{
					console.log(res.data)
					this.food_detail=res.data
					
					if(window.kakao && window.kakao.maps){
						this.initMap()
					}
					else{
						this.addScript()
					}
				})
			},
			methods:{
				addScript(){
					const script = document.createElement("script");//스크립트 태그 추가
					/*
						global kakao
					*/
					script.onload=()=>kakao.maps.load(this.initMap)
					script.src=""
					document.head.appendChild(script)
				},
				initMap(){
					var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
				    mapOption = {
				        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
				        level: 3 // 지도의 확대 레벨
				    };  

				// 지도를 생성합니다    
				var map = new kakao.maps.Map(mapContainer, mapOption); 

				// 주소-좌표 변환 객체를 생성합니다
				var geocoder = new kakao.maps.services.Geocoder();

				// 주소로 좌표를 검색합니다
				geocoder.addressSearch(this.food_detail.address, function(result, status) {

				    // 정상적으로 검색이 완료됐으면 
				     if (status === kakao.maps.services.Status.OK) {

				        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

				        // 결과값으로 받은 위치를 마커로 표시합니다
				        var marker = new kakao.maps.Marker({
				            map: map,
				            position: coords
				        });

				        // 인포윈도우로 장소에 대한 설명을 표시합니다
				        var infowindow = new kakao.maps.InfoWindow({
				            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+$('#name').text()+'</div>'
				        });
				        infowindow.open(map, marker);

				        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
				        map.setCenter(coords);
				    } 
				});   
				}
			}
		}).mount('#foodApp')
	</script>
</body>
</html>