<%@page import="EveReet.model.shop.ShopDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>EveReet - Cart</title>
</head>
<body>
<%@ include file="/header.jsp"%>

<%
ArrayList<ShopDTO> cartList = (ArrayList<ShopDTO>)session.getAttribute("cartList");

int cartId = 0;

if(cartList == null){
	cartList = new ArrayList<ShopDTO>();
}

for (ShopDTO x : cartList) {
	System.out.println("shop_cart.jsp --> " + x);
}

%>

<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">장바구니</h1>
		</div>
</div>
	<div class="container">
		<div class="row">
			<table width="100%">
				<tr>
					<td align="left">
					<a href="/EveReet/com/yju/2wda/team4/view/shop/deleteCart.jsp?cartId=0" class="btn btn-danger">삭제하기</a>
					</td>
					<td align="right">
					<a href="shippingInfo.jsp?cartId=<%=cartId %>" class="btn btn-success">주문하기</a>
					</td>
				</tr>
			</table> 
		</div>
		<div style="padding-top:50px;">
			<table class="table table-hover">
				<tr>
					<th>상품</th>
					<th>가격</th>
					<th>수량</th>
					<th>가격</th>
					<th>비고</th>
				</tr>
	<%
		
		int sum = 0; 
		if(cartList != null) {
		for(int i=0; i<cartList.size(); i++){
			ShopDTO shopDTO = cartList.get(i);
			// 소계 = 가격 * 수량
			int total = shopDTO.getPrice1() * shopDTO.getQuantity();
			sum = sum + total;
	%>
				<tr>
					<td><%=shopDTO.getName() %></td>
					<td><%=shopDTO.getPrice1() %></td>
					<td><%=shopDTO.getQuantity() %></td>
					<td><%=total%></td>
					<td><a href="/EveReet/com/yju/2wda/team4/view/shop/deleteCart.jsp?cartId=<%=cartId++%>" class="btn btn-danger">
					삭제하기
					</a></td>
				</tr>
	<%
		}
	%>			<tr>
					<th></th>
					<th></th>
					<th>총액</th>
					<th><%=sum %></th>
					<th></th>
				</tr>
			</table>
			<a href="./getAllProduct.sh" class="btn btn-secondary">&raquo; 쇼핑 계속하기</a>
		</div>

	<% 
		}
	%>
	
	
</body>
</html>