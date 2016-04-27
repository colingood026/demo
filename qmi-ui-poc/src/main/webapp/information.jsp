<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/ag-grid.css">
<link rel="stylesheet" type="text/css" href="css/theme-blue.css">
<link rel="stylesheet" type="text/css" href="css/information.css">
<link rel="stylesheet" type="text/css" href="<c:url value='css/styles/displaytag.css'/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value='css/styles/default.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='css/styles/ui.jqgrid.custom.css'/>"  />
<link rel="stylesheet" type="text/css" href="<c:url value='css/styles/font-awesome/css/font-awesome.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='css/styles/jquery.multiselect.filter.css'/>" />
</head>
<body>
	<!-- 歡迎使用者 -->
	<h1>Hello! ${bean.account}</h1><br/>
	<!--  -->
	<div class='searchContainer'>
		<input type='text' placeholder='請輸入基準料號' id='MAT_01'>
		<input type='text' placeholder='請輸入色號' id='COL_NO'>
		<a id='buyNoButton' class='css_btn'>搜尋</a>		
	           
	    <!-- 登出 -->
		<a onClick="signOut()" id='signOut' class='css_btn'>登出</a>
		<!-- 輸出excel -->
	    <label>
	        <a onclick="onBtExport()" id='excel' class='css_btn'>匯出到Excel</a>
	    </label>
		<!-- 資料篩選 -->
	    <input placeholder="請輸入篩選條件" type="text"
	           onchange="onFilterChanged(this.value)" id='filter'/>
  	</div>
  	<!--  -->
  	<div id='blankDiv'></div>	
	<!-- 資料呈現 -->
	<div id="myGrid" style="height: 100%;" class="ag-blue"></div>

<script src="js/ag-grid-enterprise.js"></script>

<script src="js/jquery-2.2.3.js"></script>
<!-- <script src="js/information.js"></script> -->
<script src="js/informationForIE.js"></script>
</body>
</html>