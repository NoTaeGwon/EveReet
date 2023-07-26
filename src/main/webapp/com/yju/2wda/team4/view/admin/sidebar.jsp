<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SideBar</title>
<!-- Custom fonts for this template-->
<link href="/EveReet/com/yju/2wda/team4/css/all.min.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="/EveReet/com/yju/2wda/team4/css/sb-admin-2.min.css" rel="stylesheet">

</head>
<body>
	<!-- Sidebar -->
	<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

		<!-- Sidebar - Brand -->
		<a class="sidebar-brand d-flex align-items-center justify-content-center" href="/EveReet/com/yju/2wda/team4/view/admin/index.jsp">
			<div class="sidebar-brand-text mx-3">EveReet Admin</div>
		</a>

		<!-- Divider -->
		<hr class="sidebar-divider my-0">

		<!-- Nav Item - Dashboard -->
		<li class="nav-item active">
			<a class="nav-link" href="/EveReet/com/yju/2wda/team4/view/admin/index.jsp">
				<span>Dashboard</span></a>
		</li>

		<!-- Divider -->
		<hr class="sidebar-divider">

		<!-- Heading -->
		<div class="sidebar-heading">Product</div>

		<!-- Nav Item - Pages Collapse Menu -->
		<!-- Product -->
		<li class="nav-item">
			<a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
				aria-expanded="true" aria-controls="collapseTwo"> 
				<span>product</span>
			</a>
			<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
				<div class="bg-white py-2 collapse-inner rounded">
					<h6 class="collapse-header">product</h6>
					<a class="collapse-item" href="./getShopListForPage.sh">Product List</a>
					<a class="collapse-item" href="/EveReet/com/yju/2wda/team4/view/shop/shop_c.jsp">Enroll Product</a>
					<a class="collapse-item" href="./updateShopListDisplay.sh">Update Product</a>
					<a class="collapse-item" href="./deleteShopListDisplay.sh">Delete Product</a>
				</div>
			</div>
		</li>
		
		

		<!-- Nav Item - Utilities Collapse Menu -->
		<!-- Order -->
		<li class="nav-item"><a class="nav-link collapsed" href="#"
			data-toggle="collapse" data-target="#collapseUtilities"
			aria-expanded="true" aria-controls="collapseUtilities">
			<span>Order</span></a>
			<div id="collapseUtilities" class="collapse"
				aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
				<div class="bg-white py-2 collapse-inner rounded">
					<h6 class="collapse-header">Order</h6>
					<a class="collapse-item" href="admin_order_list">Order Status</a>
				</div>
			</div>
		</li>

		<!-- Divider -->
		<hr class="sidebar-divider">

		<!-- Heading -->
		<div class="sidebar-heading">Board</div>

		<!-- Nav Item - Pages Collapse Menu -->
		<li class="nav-item"><a class="nav-link collapsed" href="#"
			data-toggle="collapse" data-target="#collapsePages"
			aria-expanded="true" aria-controls="collapsePages">
			<span>Board</span></a>
			<div id="collapsePages" class="collapse"
				aria-labelledby="headingPages" data-parent="#accordionSidebar">
				<div class="bg-white py-2 collapse-inner rounded">
					<h6 class="collapse-header">Q & A</h6>
						<a class="collapse-item" href="admin_qna_list_form">Q & A Status</a>
					<div class="collapse-divider"></div>
					<h6 class="collapse-header">Notice</h6>
						<a class="collapse-item" href="admin_write_notice_form">Write Notice</a> 
						<a class="collapse-item" href="admin_notice_list">Notice List</a>
				</div>
			</div></li>

		<!-- Nav Item - Pages Collapse Menu -->
		<li class="nav-item">
			<a class="nav-link collapsed" href="#"
			data-toggle="collapse" data-target="#collapseMember"
			aria-expanded="true" aria-controls="collapsePages"> 
			<span>Member</span></a>
			<div id="collapseMember" class="collapse"
				aria-labelledby="headingPages" data-parent="#accordionSidebar">
				<div class="bg-white py-2 collapse-inner rounded">
					<h6 class="collapse-header">Member</h6>
					<a class="collapse-item" href="./getMemberListForPage.me">Member List</a>
					<a class="collapse-item" href="./updateMemberListDisplay.me">Member Update</a>
					<a class="collapse-item" href="./deleteMemberListDisplay.me">Member Delete</a>
					<div class="collapse-divider"></div>
				</div>
			</div>
		</li>

		<!-- Divider -->
		<hr class="sidebar-divider d-none d-md-block">

	</ul>
	<!-- End of Sidebar -->
	<script src="/EveReet/com/yju/2wda/team4/jquery/jquery.min.js"></script>
	<script src="/EveReet/com/yju/2wda/team4/jquery/bootstrap.bundle.min.js"></script>
	<script src="/EveReet/com/yju/2wda/team4/jquery/jquery.easing.min.js"></script>
	<script src="/EveReet/com/yju/2wda/team4/js/sb-admin-2.min.js"></script>
	<script src="vendor/chart.js/Chart.min.js"></script>
	<script src="js/demo/chart-area-demo.js"></script>
	<script src="js/demo/chart-pie-demo.js"></script>
</body>
</html>