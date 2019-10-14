<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<th>商品id</th>
		<th>商品名称</th>
		<th>商品价格</th>
		<th>商品出售百分比</th>
	</tr>
		<c:forEach items="${list }" var="product">
			<tr>
				<td>${product.id }</td>
				<td>${product.name }</td>
				<td>${product.price }</td>
				<td>${product.baifen }</td>
			</tr>
		</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath }/findAll?page=${prePage}">上一页</a>
	<a href="${pageContext.request.contextPath }/findAll?page=${nextPage}">下一页</a>
</body>
</html>