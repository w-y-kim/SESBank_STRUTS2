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
			<h1>게시판</h1>
		</caption>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>작성일</th>
		</tr>

		<c:forEach var="i" items="${list}">
			<tr>
				<td>${i.boardnum}</td>

				<td><a href="boardView.action?boardnum=${i.boardnum}">${i.title}</a></td>
				<td>${i.id}</td>

				<td>${i.hits}</td>
				<td>${i.inputdate}</td>
			</tr>
		</c:forEach>

		<%
			String spage = request.getParameter("page");
			int ipage = 1;
			if (spage != null)
				ipage = Integer.parseInt(spage);
		%>

	</table>
	<ul>
		<li><a href="BoardServlet?action=boardlist&page=<%=ipage - 1%>"><
				이전글</a>&nbsp;&nbsp;</li>
		<li>&nbsp;&nbsp;<a
			href="BoardServlet?action=boardlist&page=<%=ipage + 1%>">다음글</a> >
		</li>
	</ul>

	<div class="button">
		<div class="control">
			<a href="BoardServlet?action=boardwrite"> 글쓰기 </a>
		</div>
		<div class="control">
			<a href="BoardServlet?action=delete"> 글삭제 </a>
		</div>
		<div class="control">
			<a href="BoardServlet?action=update"> 글수정 </a>
		</div>
	</div>

</body>
</html>