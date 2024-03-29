<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="EveReet.model.shop.*" %>
<%@ page import="java.util.*" %>
<%@ include file="/globalData.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EveReet - 상품정보조회 레코드 카운트 설정(R_DRC)</title>
</head>
<body>
<h1>EveReet - 상품정보조회 레코드 카운트 설정(R_DRC)</h1>
<hr>
<%
	ShopPageInfoVO bpiVO;
	bpiVO = (ShopPageInfoVO)session.getAttribute("shopPageInfoVO");
	int limitCnt;
	
	if( bpiVO == null )
		limitCnt = 10;
	else
		limitCnt = bpiVO.getLimitCnt();
%>

<h2>현재 DISPLAY RECORDS NUMBER : <%= limitCnt %></h2>
<hr>
<form method="post" action="./adjustBPI.be">
	디스플레이 레코드수 변경 : 
	<select name="displayRecordCnt">
		<option SELECTED value="10">10</option>
		<option value="20">20</option>
		<option value="50">50</option>
		<option value="100">100</option>
	</select>
	<input type="hidden" name="currentPageNo" value="0">
	<input type="submit" value="확인">
</form>      

<br><a href="<%=rootDir %>/index.jsp">홈으로 돌아가기</a>         
</body>
</html>



</body>
</html>