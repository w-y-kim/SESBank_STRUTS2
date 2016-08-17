<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="vo.Customer"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
	function idSelected(id) {
		//아이디값 부모의 필드로 내보냄 
		alert(opener.document.getElementById("custid").value);
		opener.document.getElementById("custid").value = id;//getElementsById 했다가 디버깅지옥
		self.close();
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
	//팝업창의 URL의 id값을 필드에 넣어주기 위한 
	//서블릿에서 forward로 넘겨준 request 다시 받음 
	String inputID = request.getParameter("checkedID");
	System.out.println("리퀘스트(jsp) : " + inputID);
	String returnID = (String) request.getAttribute("id");
	System.out.println("리턴 (jsp) : " + returnID);
%>
<body>
	<form action="idcheck.action" method="post">
		<!-- post방식으로 보내는 경우는 form태그 안의 value가 들어가기 때문에 hidden을 써주어야 한다 -->
		<!-- <input type="hidden" name="action" value="idCheck"> -->
		<h1>ID체크</h1>
		<!-- <input type="hidden" name="action" value="idCheck"> -->
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="checkedID"
					value="${param.checkedID}"></td>
				<td rowspan="1"><input type="submit" value="확인하기"></td>
			</tr>

			<c:if test="${checkResult == false}">
				<tr>
					<td>확인결과</td>
					<td>${param.custid}사용가능</td>
					<td rowspan="1"><input type="button" value="사용하기"
						onClick="idSelected('${param.checkedID}')"></td>
				</tr>
			</c:if>

			<c:if test="${checkResult == true}">
				<tr>
					<td>확인결과</td>
					<td>${id}는사용할수없습니다.</td>

				</tr>
			</c:if>
		</table>


	</form>
</body>
</html>
