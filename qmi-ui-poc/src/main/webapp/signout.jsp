<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%//將session移除，使用者登出我們的網站
	session.invalidate();	
%>
<script>
	location.href="index.action";
</script>
</body>
</html>