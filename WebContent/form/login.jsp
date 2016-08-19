<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<s:form action="loginResult.action">
		<s:textfield label="아이디" name="id" errorPosition="bottom" />
		<!--객체로들어감,소문자 -->
		<s:password label="패스워드" name="pw" errorPosition="bottom" />
		<!-- value를 지정하지 않으면 name 속성 값을 따라감 -->
		<s:submit value="Login" />
	</s:form>

	<!-- //TODO key속성으로 주면 에러가 난다 -->
	<!-- 
8월 18, 2016 9:30:58 오후 org.apache.struts2.util.TextProviderHelper warn
경고: The first TextProvider in the ValueStack (action.LoginAction) could not locate the message resource with key 'Login'
8월 18, 2016 9:30:58 오후 org.apache.struts2.util.TextProviderHelper warn
경고: The default value expression 'Login' was evaluated and did not match a property.  The literal value 'Login' will be used.
	-->

</body>
</html>

