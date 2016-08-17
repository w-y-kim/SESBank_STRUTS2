<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<head>
<meta charset="UTF-8" lang="ko">
<title>SEBANK 메인페이지</title>
<link href="https://fonts.googleapis.com/css?family=Galada"
	rel="stylesheet">

<link rel="stylesheet" href="main.css">
</head>
<%
	String absolutePath = application.getRealPath("");
%>
<%=absolutePath%>
<body>
	<header id="main_header">

		<hgroup id="title">
			<h1>BMO은행</h1>
			<h2>Struts + myBatis 사용해 게시판 만들기</h2>
		</hgroup>
		<nav id="main_gnb">
			<!--global navigation bar-->
			<ul>
				<li><a href="join.action">가입</a></li>
				<li><a href="">로그인</a></li>
				<li><a href="">정보수정</a></li>
				<li><a href="">로그아웃</a></li>
				<li><a href="">회원조회</a></li>
			</ul>

			<!-- 
 			<%String id = (String) session.getAttribute("id");
			if (id != null) {%>
 			<div style="background-color: gray;"><%=id%>님 로그인 중 </div>
 			<%}%>
		 -->

		</nav>
		<nav id="main_lnb">
			<!--local navigation bar-->
			<ul>
				<li><a href="boardList.action">게시판1</a></li>
				<li><a href="#">게시판2</a></li>
				<li><a href="#">JS</a></li>
				<li><a href="#">JQuery</a></li>
				<li><a href="#">Node.js</a></li>
			</ul>
		</nav>
	</header>

	<div id="content">
		<section id="main_section">

			<br />
			<br />
			<h1>Main section</h1>
			<c:if test="${board.boardnum ne null && board.boardnum != 0 }">
				<article class="main_article">
					<jsp:include page="/bbs/BoardView.jsp"></jsp:include>
				</article>
			</c:if>


			<c:if test="${list ne null}">
				<article class="main_article">

					<jsp:include page="/bbs/BoardList.jsp"></jsp:include>
				</article>
			</c:if>



			<c:if test="${list eq null}">
				<h3>게시판을 선택해주세요. 어차피 1개 밖에 없지만..</h3>
			</c:if>

			<div style="margin-top:50px;margin-bottom:100px">
				<jsp:include page="/bmo.html"></jsp:include>
			</div>
		</section>


	</div>


	<footer id="main_footer">
		<h3>HTML5 + CSS3 Basic</h3>
		<address>website layout basic</address>
	</footer>
</body>


</html>



