<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.3.0/sockjs.min.js"></script>
<script type="text/javascript">
	let websocket;
	//서버 연결
	function connection(){
		// 소켓연결
		websocket=new WebSocket("ws://localhost:8080/web/chat/chat-ws")
		websocket.onopen = onOpen
		websocket.onclose = onClose
		websocket.onmessage = onMessage
	}
	//연결 처리 => Callback
	function onOpen(event){
		alert("채팅 서버와 연결되었습니다...")
	}
	//퇴장 처리 => Callback
	function onClose(event){
		alert("채팅 서버와 연결 해제되었습니다.")
	}
	//메시지 전송 => Callback
	function onMessage(event){
		let data = event.data // 전송된 데이터 
		if(data.substring(0,4)==='msg:'){// oto , makeroom ==> 100 200 300
			//msg:[이름] 메시지
			appendMessage(data.substring(4))
			
		}
	}
	
	function disConnection(){
		websocket.close();
	}
	
	function appendMessage(msg){
		$('#recvMsg').append(msg+"<br>");
		let ch = $('#chatArea').height();
		let m = $('#recvMsg').height()-ch;
		$('#chatArea').scrollTop(m);
	}
	
	function send(){
		let name = $('#name').val()
		if(name.trim===''){
			$('#name').focus();
			return;
		}
		
		let msg = $('#sendMsg').val()
		if(msg.trim()===''){
			$('#sendMsg').focus();
			return;
		}
		websocket.send("msg:["+name+"]"+msg)
		$('#sendMsg').val("")
		$('#sendMsg').focus();
	}
	
	$(function(){
		$('#inputBtn').click(function(){
			connection()
		})
		$('#outputBtn').click(function(){
			disConnection()
		})
		$('#sendBtn').click(function(){
			send()
		})
		$('#sendMsg').keydown(function(key){
			if(key.keyCode===13){
				send()
			}
		})
	})
</script>
<style type="text/css">
	#chatArea{
		height:500px;
		overflow-y:auto;
		border:1px solid black;
	}
</style>
</head>
<body>
	<div class="wrapper row3" id="foodApp">
	  <main class="container clear">
	     <h2 class="sectiontitle">실시간 채팅</h2>
	     <div class="row">
	     	<table class="table">
	     		<tr>
	     			<td class="inline">
	     				이름:<input type="text" id="name" size=15 class="input-sm">
	     				<input type="button" value="입장" class="btn-danger btn-sm" id="inputBtn">
	     				<input type="button" value="퇴장" class="btn-success btn-sm" id="outputBtn">
	     			</td>
	     		</tr>
	     		<tr>
	     			<td>
	     				<div id="chatArea">
	     					<div id="recvMsg"></div>
	     				</div>
	     			</td>
	     		</tr>
	     		<tr>
	     			<td class="inline">
	     				<input type="text" id="sendMsg" size=80 class="input-sm">
	     				<input type="button" id="sendBtn" value="전송" class="btn-sm btn-primary">
	     			</td>
	     		</tr>
	     	</table>
	     </div>
	  </main>
	</div>

</body>
</html>