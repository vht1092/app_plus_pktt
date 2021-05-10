<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.io.*"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ứng dụng hỗ trợ nghiệp vụ thẻ</title>
<link rel="SHORTCUT ICON"
	href="<%=request.getContextPath()%>/resources/img/logo/favicon.ico">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style_old_version2.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="http://code.jquery.com/jquery-1.7.2.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


<script>
	$(function() {
		$('#datepicker1').datepicker({
			dateFormat : 'dd-mm-yy'
		});
		$('#datepicker2').datepicker({
			dateFormat : 'dd-mm-yy'
		});
		$('#datepicker3').datepicker({
			dateFormat : 'dd-mm-yy'
		});
	});
</script>
<style>
.dropdown-submenu {
	position: relative;
}

.dropdown-submenu .dropdown-menu {
	top: 0;
	left: 100%;
	margin-top: -1px;
}

.dtHorizontalVerticalExampleWrapper {
	max-width: 600px;
	margin: 0 auto;
}

#dtHorizontalVerticalExample th, td {
	white-space: nowrap;
}

table, table tr, table tr td {
	cursor: pointer;
}

table tr.active td {
	background-color: #D5EAD5;
}

.scroll {
	width: 100%;
	height: 10px;
	text-align: center;
	vertical-align: middle;
}

.scroll center {
	font-size: 12px;
}

table.scroll thead {
	width: 100%;
	background: #29827B;
}

table.scroll thead tr:after {
	content: '';
	overflow-y: scroll;
	visibility: hidden;
}

table.scroll thead th {
	flex: 1 auto;
	display: block;
	color: #fff;
}

table.scroll tbody {
	display: block;
	width: 100%;
	overflow-y: auto;
	height: 300px;
	max-height: 600px;
}

table.scroll thead tr, table.scroll tbody tr {
	display: flex;
	text-align: center;
	vertical-align: middle;
}

table.scroll tbody tr td {
	flex: 1 auto;
	word-wrap: break;
	text-align: center;
	vertical-align: middle;
}

table.scroll thead tr th, table.scroll tbody tr td {
	width: 25%;
	padding: 3px;
	text-align: center;
	text-align: center;
	vertical-align: middle;
}
</style>

</head>
<body onload="startTime()">
	<header style="margin-bottom: 50px">
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
					href="#"><a href="export_card_replace.html">Báo cáo thẻ cấp lại</a></li>
				<li class="dropdown-submenu"><a class="test" tabindex="-1"
					href="#"><a href="export_card_fwbranch.html">Báo cáo thẻ chuyển tiếp đơn vị</a></li>
				<li class="dropdown-submenu"><a class="test" tabindex="-1"
					href="#"><a href="export_capgrp.html">Xuất danh sách CAPGRP</a></li>
			</ul>
		</div>

		<div class="title-content">Xuất thông tin thẻ chuyển đơn vị</div>
		<form action="${pageContext.request.contextPath}/export_card_fwbranch"
			method="post" style="position: fixed; margin-top: 75px;"
			autocomplete="off">
			<table class="form-search-iss" style="width: 100%;">
				<tr>
					<td><c:choose>
							<c:when test="${txt_fromDate != ''}">
								<input autocomplete="off" name="txt_fromDate"
									class="form-control" type="text" value="${txt_fromDate}"
									placeholder="dd-mm-yyyy" id="datepicker1" required />
							</c:when>
							<c:otherwise>
								<input autocomplete="off" name="txt_fromDate"
									class="form-control" type="text"
									placeholder="Từ ngày: dd-mm-yyyy" id="datepicker1" required />
							</c:otherwise>
						</c:choose></td>
					<td><input type="submit" class="btn btn-success"
						style="height: 30px" value="TRUY VẤN" /></td>
					<td></td>
				</tr>
			</table>
		</form>
	</div>
	<div class="rightContent"
		style="margin-top: 180px; margin-left: 0px; height: 10px; position: fixed;">
		<div class="themThongTinTraSoatISS" style="height: 50px">
			<div id="thediv_scroll"
				style="margin-top: -65px; margin-left: 130px; box-shadow: 0px 0px 12px 0px #5E9BB4"">
				<table rules="groups" frame="hsides" id="testTable"
					class="tableTruyVanISS1 scroll"
					style="width: 100%; table-layout: fixed; height: 50px;">
					<thead valign="top">
						<tr class="header-table">
							<th>NGAY_PHAT_HANH</th>
							<th style="width: 40%">TEN_KHACH_HANG</th>
							<th>SO_THE</th>
							<th>LOC</th>
							<th>LOAI_HINH</th>
							<th>BRN_CARD</th>
							<th>FWD_CARD</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list_fw}" var="p">
							<tr id="rows" class="rows">
								<td>${p.ngayPhatHanh}</td>
								<td style="width: 40%">${p.tenKhachHang}</td>
								<td>${p.soThe}</td>
								<td>${p.loc}</td>
								<td>${p.loaiHinhPhatHanh}</td>
								<td>&nbsp;${p.maDonViThe}</td>
								<td>&nbsp;${p.fwBranch}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<input style="height: 30px; width: 100px; float: left;"
					class="btn btn-danger" type="button"
					onclick="tableToExcel('testTable', 'DISPUTE-TOOL-BY-P.KTT&NHDT')"
					value="Export">
				<marquee
					style="font-weight: bold; float: left; color: red; width: 20%; margin-left: 5px"
					behavior="alternate">${alert_success}</marquee>
			</div>
		</div>
	</div>
	<footer> </footer>
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
	<script>
		document.getElementById('slitCardNo').addEventListener(
				'input',
				function(e) {
					e.target.value = e.target.value.replace(/[^\dA-Z]/g, '')
							.replace(/(.{4})/g, '$1 ').trim();
				});
		function caps(id) {
			document.getElementById(id).value = document.getElementById(id).value
					.toUpperCase();
		}
	</script>
	<script>
		var tableToExcel = (function() {
			var uri = 'data:application/vnd.ms-excel;base64,', template = '<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>', base64 = function(
					s) {
				return window.btoa(unescape(encodeURIComponent(s)))
			}, format = function(s, c) {
				return s.replace(/{(\w+)}/g, function(m, p) {
					return c[p];
				})
			}
			return function(table, name) {
				if (!table.nodeType)
					table = document.getElementById(table)
				var ctx = {
					worksheet : name || 'Worksheet',
					table : table.innerHTML
				}
				window.location.href = uri + base64(format(template, ctx))
			}
		})()
	</script>
	<script>
		$(document).ready(
				function() {
					$("#testTable").children("tbody").children("tr").children(
							"td").click(function() {
						$(this.parentNode).toggleClass("active");
					});
				});
	</script>
</body>
</html>