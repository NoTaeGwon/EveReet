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
<title>EveReet - 상품정보삭제(D)</title>
</head>
<body>
<h1>EveReet - 상품정보삭제(D)</h1>
<hr>
<%
	ShopDTO shop;
	ArrayList<ShopDTO> shopList;
	ShopPageInfoVO bpiVO;
	
	bpiVO = (ShopPageInfoVO)session.getAttribute("shopPageInfoVO");
	shopList = (ArrayList<ShopDTO>)request.getAttribute("shopList");
	
	int currentPageNo = bpiVO.getCurrentPageNo();
%>

<h2>현재 DISPLAY RECORDS NUMBER : <%= bpiVO.getLimitCnt() %></h2>
<hr>
<br>
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
				<th>삭제</th>
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
				<td><a href="./deleteShopForID.sh?prodnum=<%=shop.getProdnum()%>">DELETE</a>
			</tr>
<%
	}
%>
		</tbody>
	</table>

<a href="./deleteShopListDisplay.sh?currentPageNo=0">[FIRST]</a>
<%
	if( currentPageNo > 0){		
%>
	<a href="./deleteShopListDisplay.sh?currentPageNo=<%=(currentPageNo-1) %>">[PRE]</a>
<%
	}else{
%>	
	[PRE]
<%
	}

	for(int i = bpiVO.getStartPageNo(); i < bpiVO.getEndPageNo(); i++) {
		
		if( i == currentPageNo ) {
%>
		[<%=(i+1) %>]
<%
		}else{
%>
			<a href="./deleteShopListDisplay.sh?currentPageNo=<%=i%>">[<%=(i+1)%>]</a>
<%
		}
	}
%>
<%
	if( currentPageNo < bpiVO.getPageCnt() - 1) {		
%>
	<a href="./deleteShopListDisplay.sh?currentPageNo=<%=(currentPageNo+1)%>">[NXT]</a>
<%
	}else{
%>
	[NXT]	
<%
	}
%>
 	<a href="./deleteShopListDisplay.sh?currentPageNo=<%=(bpiVO.getPageCnt()-1)%>">[END]</a>

<br><a href="<%= adminViewDir %>/index.jsp">홈으로 돌아가기</a>
</body>
</html>