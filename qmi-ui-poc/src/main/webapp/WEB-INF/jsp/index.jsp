<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	
<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<title>Index</title>
	<s:head />
</head>
<body>
<%-- 	<s:form action="helloWorld"> --%>
<%-- 		<s:textfield label="What is your name?" name="name" /> --%>
<%-- 		<s:textfield label="What is the date?" name="dateNow" /> --%>
<%-- 		<s:submit /> --%>
<%-- 	</s:form> --%>
	<form action='LoginAction.action' method='post'>
		<input type='text' name='accout' placeholder='帳號'><br/>
		<input type='text' name='password' placeholder='密碼'><br/>
		<input type='submit' value='登入'>
	
	</form>
</body>
</html>
	