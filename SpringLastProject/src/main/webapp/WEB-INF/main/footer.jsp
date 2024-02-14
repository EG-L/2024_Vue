<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="wrapper row4">
  <footer id="footer" class="clear"> 
    <div class="one_third first">
      <h6 class="title">인기 공지</h6>
      <ul class="nospace linklist">
      	<c:forEach var="vo" items="${nList }">
      		<li><a href="#">${vo.subject }</a></li>
      	</c:forEach>
      </ul>
    </div>
    <div class="one_third">
      <h6 class="title">실시간 인기 맛집</h6>
      <ul class="nospace linklist">
      	<c:forEach var="vo" items="${fList }">
      		<li><a href="#">${vo.name }</a></li>
      	</c:forEach>
      </ul>
    </div>
    <div class="one_third">
      <h6 class="title">레시피 뉴스</h6>
      <ul class="nospace linklist">
        <c:forEach var="vo" items="${newList }" varStatus="s">
      		<c:if test="${s.index<7 }">
      			<li><a href="${vo.link }">${vo.title }</a></li>
      		</c:if>
      	</c:forEach>
      </ul>
    </div>
    
  </footer>
</div>
<div class="wrapper row5">
  <div id="copyright" class="clear"> 
    <p class="fl_left">Copyright &copy; 2018 - All Rights Reserved - <a href="#">Domain Name</a></p>
    <p class="fl_right">Template by <a target="_blank" href="https://www.os-templates.com/" title="Free Website Templates">OS Templates</a></p>
  </div>
</div>
</body>
</html>