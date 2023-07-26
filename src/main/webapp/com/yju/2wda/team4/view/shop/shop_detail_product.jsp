<%@page import="EveReet.model.shop.ShopDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<%
ShopDTO shop = (ShopDTO)request.getAttribute("shopDTO");
System.out.println(shop);
%>
<meta charset="UTF-8">
<title><%= shop.getName() %></title>
</head>
<body>
<%
String kind = (Integer.parseInt(shop.getKind()) == 1) ? "상의" : (Integer.parseInt(shop.getKind()) == 2) ? "하의" : "아우터" ;
%>
<style>
/*
.flexbox {
    display: flex;
    flex-direction: row; 
}
.flex-container{
      display: inline-flex;
      flex-flow: row wrap;
}
.flex-container.stretch{align-content: stretch;}
*/
.flex-container {
	display: flex;
	justify-content: center;
}
.flexbox {
	display: flex;
	flex-direction: column;
	align-items: center;

}
.detail-image {
	position: relative;
	right: 7vw;
}

</style>
	<div class="container">
		<div class="row">
			<div class=" flexbox">
				<div class="flex-container stretch">
					<div class="image">
						<img src="/EveReet/com/yju/2wda/team4/images/<%= shop.getImage() %>" width="400" />
					</div>
					<div class="prodinfo">
						<h3><%= shop.getName() %></h3>
					
						<p><%= shop.getContent() %>
						<p> <b>브랜드</b> : <%= shop.getBrand() %>
						<p> <b>분류</b> : <%= kind %>
						<h4><%= shop.getPrice1() %> &#8361</h4>
						<%
						if (session.getAttribute("userInfo") == null) {	
						%>
							<p style="color:red">로그인 후 사용해주십시오</p>
						<% 
						} else {
						%>	
							<p> <a href="./addToCart.sh?prodnum=<%=shop.getProdnum() %>" class="btn btn-info"> 장바구니 &raquo;</a>
						<%
						}
						%>
						
							<a href="./getAllProduct.sh" class="btn btn-secondary">상품목록 &raquo;</a>
					</div>
				</div>
				<div class="detail-image">
					<img src="/EveReet/com/yju/2wda/team4/images/<%= shop.getDetail_image() %>" width="400" />
				</div>
					
			</div>
		</div>
	</div>

</body>
</html>