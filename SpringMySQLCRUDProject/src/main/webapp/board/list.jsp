<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
	.container{
		margin-top:50px;
	}
	.row{
		margin:0px auto;
		width:800px;
	}
	a.link:hover{
		cursor:pointer;
	}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<h3 class="text-center">자유 게시판(MySQL)</h3>
			<table class="table">
				<tr>
					<td>
						<a href="insert.do" class="btn btn-sm btn-danger">새글</a>
					</td>
				</tr>
			</table>
			<table class="table">
				<tr>
					<th width=10% class="text-center">번호</th>
					<th width=45% class="text-center">제목</th>
					<th width=15% class="text-center">이름</th>
					<th width=20% class="text-center">작성일</th>
					<th width=10% class="text-center">조회수</th>
				</tr>
				<c:forEach var="vo" items="${list }">
					<tr>
						<td width=10% class="text-center">${vo.no }</td>
						<td width=45%><a href="../board/detail.do?no=${vo.no }">${vo.sub }</a></td>
						<td width=15% class="text-center">${vo.name }</td>
						<td width=20% class="text-center">${vo.dbday }</td>
						<td width=10% class="text-center">${vo.hit }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="row">
			<div class="text-center">
				<a href="#" class="btn btn-info btn-sm">이전</a>
				${curpage } page / ${totalpage } pages
				<a href="#" class="btn btn-info btn-sm">다음</a>
			</div>
		</div>
	</div>
</body>
</html>