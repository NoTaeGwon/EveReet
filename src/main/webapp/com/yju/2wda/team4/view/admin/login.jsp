<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EveReet - Admin Login</title>
<!-- Custom fonts for this template-->
    <link href="/EveReet/com/yju/2wda/team4/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">
        
         <!-- Custom styles for this template-->
    <link href="/EveReet/com/yju/2wda/team4/css/sb-admin-2.min.css" rel="stylesheet">
</head>
<body class="bg-gradient-primary">
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
        <!-- Outer Row -->
        <div class="row justify-content-center">

            <div class="col-xl-10 col-lg-12 col-md-9">

                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
                            <div class="col-lg-6">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">Admin</h1>
                                    </div>
                                    <form class="user" method="post" action="./loginAdmin.ad">
                                        <div class="form-group">
                                            <input type="text" class="form-control form-control-user"
                                                id="id" name="id" placeholder="Enter ID">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control form-control-user"
                                                id="pwd" name="pwd" placeholder="Password">
                                        </div>
                                        <label>${message }</label>
                                        <input type="submit" class="btn btn-primary btn-user btn-block" value="Login">
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
				<a href="/EveReet/index.jsp" class="btn btn-secondary">Go EveReet &raquo;</a>
            </div>

        </div>

    </div>
            <!-- Bootstrap core JavaScript-->
    <script src="/EveReet/com/yju/2wda/team4/jquery/jquery.min.js"></script>
    <script src="/EveReet/com/yju/2wda/team4/jquery/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="/EveReet/com/yju/2wda/team4/jquery/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="/EveReet/com/yju/2wda/team4/js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="/EveReet/com/yju/2wda/team4/js/Chart.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="/EveReet/com/yju/2wda/team4/js/chart-area-demo.js"></script>
    <script src="/EveReet/com/yju/2wda/team4/js/chart-pie-demo.js"></script>
</body>
</html>