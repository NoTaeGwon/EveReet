<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="EveReet.model.shop.*"%>
<%@ page import="java.util.*"%>
<%@ include file="/globalData.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EveReet - 상품자료수정(U2)</title>
</head>
<body>
	<%@ include file="/header.jsp"%>
	<h1>EveReet - 상품자료수정(U2)</h1>
	<hr>
	<%
	ShopDTO shop = (ShopDTO)request.getAttribute("shop");
%>

	<form method="post" action="./updateShopForID.sh" enctype="multipart/form-data">
		<br>상품번호 : <input type="text" name="prodnum" value="<%=shop.getProdnum()%>" readonly> 
		<br>상품이름 : <input type="text" name="name" value="<%=shop.getName()%>" size="30">
		<br>상품종류: <select name="kind">
			<option value=''>--종류선택--</option>
			<option value="1">상의</option>
			<option value="2">하의</option>
			<option value="3">아우터</option>
		</select><br> 
		<br>상품브랜드 : <input type="text" name="brand" value="<%=shop.getBrand()%>" size="30"> 
		<br>상품원가 : <input type="text" name="price1" value="<%=shop.getPrice1()%>" size="30">
		<br>상품판매가 : <input type="text" name="price2" value="<%=shop.getPrice2()%>" size="30"> 
		<br>상품설명: <input type="text" name="content" value="<%=shop.getContent()%>" size="30">
		<br>상품사진 : <input type="file" name="image">
		<br>상품상세사진 : <input type="file" name="detil_image">  
		<br>판매유무 : <input type="text" name="useyn" value="<%=shop.getUseyn()%>" size="30">
		<br>
		<input type="hidden" name="actionType" value="U_ID"> <br>
		<input type="submit" value="저장">

	</form>


	

	<br>
	<a href="<%= adminViewDir %>/index.jsp">홈으로 돌아가기</a>

</body>
</html>