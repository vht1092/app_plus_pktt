<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>P.KTT&NHS: Ứng dụng hỗ trợ nghiệp vụ thẻ</title>
<link rel="SHORTCUT ICON"
	href="<%=request.getContextPath()%>/resources/img/logo/favicon.ico">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.dropdown-submenu {
	position: relative;
}

.dropdown-submenu .dropdown-menu {
	top: 0;
	left: 100%;
	margin-top: -1px;
}
</style>
</head>
<body onload="startTime()">
	<header>
		<div class="nameProject">
			<p>
				<a href="index.html">Ứng dụng hỗ trợ nghiệp vụ thẻ</a>
			</p>
		</div>
		<div class="userLogin">
			<p>
				Hi, <a href="logout.html" class="logout" title="Đăng xuất">${fullName}</a>
			</p>
			</br>
			<p id="txt" style="margin-left: 180px; margin-top: -15px"></p>
		</div>
	</header>
	<div class="menu-bar"
		style="box-shadow: 8px 8px 16px 0px #5E9BB4; position: fixed; margin-top: 60px; z-index: 1;">
		<div class="dropdown">
			<button class="btn btn-default dropdown-toggle" type="button"
				data-toggle="dropdown">
				Danh mục<span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<li class="dropdown-submenu"><a class="test" tabindex="-1"
					href="#"><a href="export_card_replace.html">Báo cáo thẻ cấp
							lại</a></li>
				<li class="dropdown-submenu"><a class="test" tabindex="-1"
					href="#"><a href="export_card_fwbranch.html">Báo cáo thẻ
							chuyển tiếp đơn vị</a></li>
				<li class="dropdown-submenu"><a class="test" tabindex="-1"
					href="#"><a href="export_capgrp.html">Xuất danh sách CAPGRP</a></li>
				<li class="dropdown-submenu"><a class="test" tabindex="-1"
					href="#"><a href="check_email.html">Kiểm tra thông tin
							email KH</a></li>
				<li class="dropdown-submenu"><a class="test" tabindex="-1"
					href="#"><a href="uploadOneFile.html">Giao thẻ tận nơi</a></li>
<!-- 				<li class="dropdown-submenu"><a class="test" tabindex="-1" -->
<!-- 					href="#"><a href="thongso.html">Giao thẻ tận nơi</a></li> -->
			</ul>
		</div>
	</div>

	<div class="content"></div>

	<footer></footer>
	<script>
		$(document).ready(function() {
			$('.dropdown-submenu a.test').on("click", function(e) {
				$(this).next('ul').toggle();
				e.stopPropagation();
				e.preventDefault();
			});
		});
	</script>
	<script src="<%=request.getContextPath()%>/resources/js/common.js"></script>
</body>
</html>