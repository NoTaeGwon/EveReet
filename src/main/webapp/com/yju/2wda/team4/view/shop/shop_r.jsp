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
<title>EveReet - 상품자료조회(R)</title>
</head>
<body>
<h1>EveReet - 상품자료조회(R)</h1>
<hr>
<h2>전체보기(부분조회,페이징기능 미포함)</h2>


<%
	ShopDTO shop;
	ArrayList<ShopDTO> shopList;
	
	shopList = (ArrayList<ShopDTO>)request.getAttribute("shopList");
%>

	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>종류</th>
				<th>브랜드</th>
				<th>원가</th>
				<th>판매가</th>
				<th>이익</th>
				<th>상품 설명</th>
				<th>사진</th>
				<th>판매 유무</th>
				<th>좋아요</th>
				<th>등록일</th>
			</tr>
		</thead>		
		<tbody>
		
<%
for(int i=0; i < shopList.size(); i++) {
	shop = shopList.get(i);
%>		
		<tr>
			<td><%=shop.getProdnum() %></td>
			<td><%=shop.getName() %></td>
			<td><%=shop.getKind() %></td>
			<td><%=shop.getBrand() %></td>
			<td><%=shop.getPrice1() %></td>
			<td><%=shop.getPrice2() %></td>
			<td><%=shop.getPrice3() %></td>
			<td><%=shop.getContent() %></td>
			<td><%=shop.getImage() %></td>
			<td><%=shop.getUseyn() %></td>
			<td><%=shop.getLike() %></td>
			<td><%=shop.getRegdate() %></td>
		</tr>
<%
	}
%>

		</tbody>
	</table>

<br><a href="<%= adminViewDir %>/index.jsp">홈으로 돌아가기</a>
</body>
</html>