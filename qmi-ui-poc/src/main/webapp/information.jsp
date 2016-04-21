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
<style>

    .ag-header-cell-filtered {
        background-color: #e5e5e5;
    }
    #excel{
		float:right;
		
	}
	#signOut{
		float:right;		
	}
	
</style>

</head>
<body>
	<!-- 歡迎使用者 -->
	<h1>Hello! ${bean.account}</h1><br/>
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
	<!-- 資料呈現 -->
	<div id="myGrid" style="width:100%;height: 100%;" class="ag-fresh"></div>

<script src="js/ag-grid.js"></script>
<script src="js/jquery-2.2.3.js"></script>
<script src="js/information.js"></script>
</body>
</html>