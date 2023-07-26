<%@page import="EveReet.model.member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>EveReet-main</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon"
	href="EveReet/com/yju/2wda/team4/images/favicon.ico" />
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="/EveReet/com/yju/2wda/team4/css/styles.css" rel="stylesheet" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
	crossorigin="anonymous"></script>

</head>
<body>
<%
MemberDTO member = (MemberDTO) session.getAttribute("userInfo");
%>
<!-- Navigation-->
 <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">
            <a href="/EveReet/index.jsp">
            	<img src="/EveReet/com/yju/2wda/team4/images/logo/EveReet_logo.JPG" class="navbar-brand" href="/EveReet/index.jsp" width="120px"></a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="/EveReet/index.jsp">Home</a></li>
                        <li class="nav-item"><a class="nav-link" href="#!">About</a></li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Shop</a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="./getAllProduct.sh">All Products</a></li>
                                <li><hr class="dropdown-divider" /></li>
                                <li><a class="dropdown-item" href="#!">Popular Items</a></li>
                                <li><a class="dropdown-item" href="#!">New Arrivals</a></li>
                            </ul>
                        </li>
                    <!-- MyPage 메뉴 -->
           			<%
           			if (null == member) {

           			%>
					<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" 
					data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Mypage </a>
						<ul class="dropdown-menu dropdown-menu-right"
							aria-labelledby="navbarDropdown">
							<li> <a class="dropdown-item" href="/EveReet/com/yju/2wda/team4/view/member/login.jsp">Login</a></li> 
						</ul>
					</li>
					<%
           			} else {
					%>
					 <!-- 로그인을 했을 경우 -->
					 
					<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown"  role="button"
					data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <%= member.getName() %></a>
						<ul class="dropdown-menu dropdown-menu-right"
							aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="/EveReet/com/yju/2wda/team4/view/shop/shop_cart.jsp">Cart</a></li> 
							<li><a class="dropdown-item" href="#!">Order</a></li> 
							<li><a class="dropdown-item" href="#!">Modify Info</a></li> 
							<li><a class="dropdown-item" href="./logoutMember.me">Logout</a></li> 
						</ul>
					</li>
					<%
           			}
					%>
                    </ul>
                    
                </div>
            </div>
        </nav>
<!-- Header-->
<!--  
<header class="py-5">
	<div class="container px-5">
		<div class="row justify-content-center">
			<div class="col-lg-8 col-xxl-6"></div>
		</div>
	</div>
</header> 
-->

</body>
</html>