<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/ag-grid.css">
<link rel="stylesheet" type="text/css" href="css/theme-fresh.css">
<link rel="stylesheet" type="text/css" href="css/information.css">

</head>
<body>
	<!-- 歡迎使用者 -->
	<h1>Hello! ${bean.account}</h1><br/>
	<!--  -->
	<div>
		<input type='text' placeholder='請輸入基準料號' id='eqNo'>
		<input type='text' placeholder='請輸入色號' id='colorNo'>
		<button id='buyNoButton'>搜尋採購單號</button>	
		<br/>
		<!-- 資料篩選 -->
	    <input placeholder="請輸入篩選條件" type="text"
	           onpaste="onFilterChanged(this.value)"
	           oninput="onFilterChanged(this.value)"
	           onchange="onFilterChanged(this.value)"
	           onchange="onFilterChanged(this.value)"
	           onkeydown="onFilterChanged(this.value)"
	           onkeyup="onFilterChanged(this.value)" id='filter'/>
	    <!-- 登出 -->
		<input type="button" value='登出' onClick="signOut()" id='signOut'>
		<!-- 輸出excel -->
	    <label>
	        <button onclick="onBtExport()" id='excel'>匯出到Excel</button>
	    </label>
  	</div>
  	<!--  -->
  	<div id='blankDiv'></div>	
	<!-- 資料呈現 -->
	<div id="myGrid" style="height: 100%;" class="ag-fresh"></div>
	
<script src="js/ag-grid.js"></script>

<script src="js/jquery-2.2.3.js"></script>
<script src="js/information.js"></script>
</body>
</html>