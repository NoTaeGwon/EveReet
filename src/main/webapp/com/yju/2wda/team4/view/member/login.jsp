<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/header.jsp"%>
<html>
<head>
<meta charset="UTF-8">
<title>EveReet-Login</title>
<style>
.fogetAlign {
	display: flex;
  	justify-content : center;
}
</style>
</head>
<body>
	<div class="container">
<%
String alert = (String) request.getAttribute("alert");
if (alert != null && !alert.equals("") && !alert.equals("null")) {
%>
<script>
	alert('<%=alert%>');
</script>
<%
	}
%>
		<div class="row">
			<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
				<div class="card card-signin my-5">
					<div class="card-body">
						<h5 class="card-title text-center">Log In</h5>
						<form action="./loginMember.me" method="post">
							<div class="form-label-group">
								<input type="text" id="id" name="id" class="form-control"
									placeholder="id" required autofocus>
							</div>
							<br>

							<div class="form-label-group">
								<input type="password" id="pwd" name="pwd" class="form-control"
									placeholder="Password" required>
							</div>

							<hr>

							<div class="form-label-group">
								<c:if test="${check == 1 }">
									<label>${message }</label>
								</c:if>
							</div>
							<div class="d-grid gap-2 col-6 mx-auto">
								<button class="btn btn-lg btn-primary btn-block text-uppercase"
									type="submit">Sign in</button>
							</div>
							<hr class="my-4">
							<div class="fogetAlign">Forgot your&nbsp;<a href="javascript:void(0)" onclick="findid()">ID</a>
							&nbsp;or&nbsp;<a href="javascript:void(0)" onclick="findpassword()">Password</a>?
							</div>
							<div class="d-grid gap-2 col-6 mx-auto">
								<button class="btn btn-lg btn-secondary btn-block text-uppercase"
									onclick="location='/EveReet/com/yju/2wda/team4/view/member/member_c.jsp'">Join</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
  function findid(){
		var url="find_id_form";
		
		window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=500");
	}
  
  function findpassword(){
	  var url="find_password_form";
	  
	  window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=500");
  }
  </script>