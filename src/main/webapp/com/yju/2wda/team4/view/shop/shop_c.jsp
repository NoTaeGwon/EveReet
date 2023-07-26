<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/globalData.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EveReet - 상품자료입력(C)</title>
</head>
<body>

<h1>EveReet - 상품자료입력(C)</h1>
<hr>
<h2>b_id와 같은 DB에서 결정(auto increment)</h2>
<form method="post" action="./insertShop.sh" enctype="multipart/form-data">
	<br>상품이름: <input type="text" name="name" size="30"> 
    <br>상품종류: 
	<select name="kind">
		<option value=''>--종류선택--</option>
        <option value="1">상의</option>
        <option value="2">하의</option>
        <option value="3">아웃터</option>
    </select><br>
	<br>브랜드: <input type="text" name="brand" size="30">
	<br>원가: <input type="text" name="price1" size="30">
	<br>판매가: <input type="text" name="price2" size="30">
	<br>설명: <input type="text" name="content" size="30">
	<br>사진: <input type="file" name="image"> 
	<br>상세 사진: <input type="file" name="detail_image"> 
	<br><input type="hidden" name="actionType" value="C">
	<br><input type="submit" value="저장"> 
</form>

<br><a href="<%= adminViewDir %>/index.jsp">홈으로 돌아가기</a>
</body>
</html>