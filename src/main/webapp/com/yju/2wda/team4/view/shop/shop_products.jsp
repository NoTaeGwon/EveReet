<%@page import="EveReet.model.shop.ShopDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EveReet-All Product</title>
</head>
<body>
	<%@ include file="/header.jsp"%>

	<%
	ArrayList<ShopDTO> allproductlist = (ArrayList<ShopDTO>)request.getAttribute("allproductlist");
%>

	<!-- Header-->
	<header class="bg-dark py-5">
		<div class="container px-4 px-lg-5 my-5">
			<div class="text-center text-white">
				<h1 class="display-4 fw-bolder">All Product</h1>
				<p class="lead fw-normal text-white-50 mb-0">All Products from EveReet</p>
			</div>
		</div>
	</header>
	<!-- Section-->
	<section class="py-5">
		<div class="container px-4 px-lg-5 mt-5">
			<div
				class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
				<%
                for (ShopDTO list : allproductlist) {
                %>
                <a href="./getDetailProductInfo.sh?prodnum=<%= list.getProdnum() %>">
					<div class="col mb-5">
						<div class="card h-100">
							<!-- Product image-->
							<img class="card-img-top"
								src="/EveReet/com/yju/2wda/team4/images/<%= list.getImage() %>"
								width="450px" />
							<!-- Product details-->
							<div class="card-body p-4">
								<div class="text-center">
									<!-- Product name-->
									<h5 class="fw-bolder"><%= list.getName() %></h5>
									<!-- Product price--> 
									<%= list.getPrice1() %> &#8361;
								</div>
							</div>
							
						</div>
					</div>
				</a>
				<%
                }
                %>

			</div>
		</div>
	</section>
</body>
</html>