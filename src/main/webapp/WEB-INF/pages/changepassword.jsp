<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="background-color: #EFF0F0">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ĐĂNG NHẬP: CHƯƠNG TRÌNH LƯU TRỮ THÔNG TIN TRA SOÁT</title>
<link rel="SHORTCUT ICON"
	href="<%=request.getContextPath()%>/resources/img/logo/favicon.ico">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style.css" />
<style>
input {
	height: 60px;
	width: 80%;
}

.login:hover {
	background-color: darkblue;
	color: whitesmoke;
}
</style>
</head>
<body onload="startTime()">
	<header>
		<div class="nameProject">
			<p>
			<p>
				<a href="index.html">Chương trình quản lý ATM: <span
					style="color: yellow; font-size: 24px">Change password</span></a>
			</p>
			</p>
		</div>
		<div class="userLogin">
			<p></p>
			</br>
			<p></p>
		</div>
	</header>

	<div class="content">
		<div class="leftContent">
			<div class="left-menu"></div>
		</div>
		<div class="rightContent" style="">
			<div style="visibility: hidden" class="titleContent">
				<p>
				<center>*** Đăng nhập</center>
				</p>
			</div>
			<center>
				<div class="formLogin"
					style="box-shadow: 5px 10px 8px #C8C9CD; border-radius: 8px; background-color: #99CCFF; width: 450px; height: 250px; margin-top: 15%; position: fixed; margin-left: 10%">
					<form action="${pageContext.request.contextPath}/changepass"
						method="post">
						<table width="50"
							style="margin-top: 12%; color: #777777; font-size: 32px; font-weight: bold">
							<tr style="background-color: #061F3D; padding: 25%; height: 50px">
								<td style="width: 15%">TÊN ĐĂNG NHẬP</td>
								<td><c:choose>
										<c:when test="${fullName != ''}">
											<input name="username" value="${fullName}"
												onblur="caps(this.id)" readonly />
										</c:when>
									</c:choose></td>
							</tr>
							<tr>
								<td style="width: 10%"></td>
								<td></td>
							</tr>
							<tr>
								<td style="width: 10%">MẬT KHẨU MỚI</td>
								<td><input type="password" name="password1" maxlength="8"
									minlength="8" required><br /></td>
							</tr>
							<tr>
								<td colspan="2"></td>
							</tr>
							<tr>
								<td style="width: 10%">NHẬP LẠI MẬT KHẨU</td>
								<td><input type="password" name="password2" maxlength="8"
									minlength="8" required><br /></td>
							</tr>
							<tr>
								<td colspan="2">
									<center>
										<div>
											<input class="login"
												style="background-color: #1B87B7; height: 5%; border-radius: 5px; color: whitesmoke; width: 25%; margin-top: 5%; padding-bottom: 2%; padding-top: 2%;"
												type="submit" value="Đăng nhập" />
										</div>
									</center>
								</td>
							</tr>
							<tr>
								<td colspan="2" style="color: red"><c:choose>
										<c:when test="${error != ''}">
											<center>${error}</center>
										</c:when>
									</c:choose></td>
							</tr>
						</table>
					</form>
				</div>
			</center>
		</div>
	</div>

	<footer class="footerHomepage"
		style="background-color: #0073A2; color: white; height: 25px; width: 100%; position: fixed; bottom: 0;">
		<div class=""
			style="line-height: 25px; font-size: 12px; float: right; margin-right: 0; align-content: center; text-align: ce">COPYRIGHT
			&copy; 2018 Phòng KTT&NHĐT - Ngân Hàng TMCP Sài Gòn</div>
	</footer>

	<script src="<%=request.getContextPath()%>/resources/js/common.js"></script>
	<script>
		function caps(id) {
			document.getElementById(id).value = document.getElementById(id).value
					.toUpperCase();
		}
	</script>
</body>
</html>