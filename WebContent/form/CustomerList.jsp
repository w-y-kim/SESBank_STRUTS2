<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="dao.BoardDAO, vo.Board, java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="kr">
<head>
<meta charset="UTF-8">
<title>TableTest</title>
<style>
* {
	margin: 0;
	padding: 0;
	
}

table, tr {
	width: 900px;
	margin: 0 auto;
	position: relative;
	text-align: center;
	border-collapse: collapse;
	border: 3px aqua solid;
}

th, td {
	border: 3px aqua solid;
}

div.control {
	float: right;
	padding: 3px;
	border-radius: 10px;
	border-style: solid;
	background-color: #01e1e9;
	font-size: 20px;
	margin: 0 10px;
}

div.control:hover {
	background-color: black;
	font-weight: bold;
	color: white;
}

div.button {
	margin-top: 10px;
	margin-right: 100px;
	margin-bottom:50px;
}

a {
	text-decoration: none;
}

a:hover {
	color: red;
}

.control>a:hover {
	color: red;
}

a:link {
	text-decoration: none;
}

ul {
	list-style-type: none;
	margin: 10px 100px;
}

li {
	float: left;
}
</style>
</head>
<body>


	<table border="1">
		<caption>
			<h1>회원목록</h1>
		</caption>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>메일</th>
			<th>구분</th>
			<th>주소</th>
		</tr>

		<c:forEach var="i" items="${cusList}">
			<tr>
				<td>${i.CUSTID}</td>

				<td>${i.NAME}</td>
				<td>${i.EMAIL}</td>

				<td>${i.DIVISION}</td>
				<td>${i.ADDRESS}</td>
			</tr>
		</c:forEach>



	</table>
	<ul>
		<li><a href="#">
				이전</a>&nbsp;&nbsp;</li>
		<li>&nbsp;&nbsp;<a
			href="#">다음</a> 
		</li>
	</ul>
&nbsp;&nbsp; 

</body>
</html>