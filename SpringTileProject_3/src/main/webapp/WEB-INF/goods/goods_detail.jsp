<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="row">
		<table class="table">
			<tr>
				<td width=30% rowspan=2 class="text-center">
					<img src="${vo.goods_poster }" style="width:100%">
				</td>
				<td width=70%><h3>${vo.goods_name }</h3></td>
			</tr>
			<tr>
				<td width=70%>${vo.goods_price }</td>
			</tr>
			<tr>
				<td colspan="2" class="text-right">
					<input type="button" class="btn-sm btn-danger" value="목록" onclick="javascript:history.back()">
				</td>
			</tr>
		</table>
	</div>
</body>
</html>