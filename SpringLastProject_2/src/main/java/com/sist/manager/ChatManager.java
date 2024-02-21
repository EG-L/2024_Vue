package com.sist.manager;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.*;

@ServerEndpoint("/chat/chat-ws")
public class ChatManager {
	private static List<Session> users = new ArrayList<Session>();
	
	@OnOpen
	public void onOpen(Session session) {
		users.add(session);
		System.out.println("클라이언트 접속...:"+session.getId());
	}
	@OnMessage
	public void onMessage(String message,Session session) throws Exception{
		System.out.println("수신된 메시지..."+message+"==> 보낸사람:"+session.getId());
		for(Session s:users) {
			s.getBasicRemote().sendText(message);
			System.out.println(session.getId()+":메시지 전송 완료!!");
		}
	}
	@OnClose
	public void onClose(Session session) {
		users.remove(session);
		System.out.println("클라이언트 퇴장...:"+session.getId());
	}
}
