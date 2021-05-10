<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.io.*"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>THÔNG SỐ PHÁT HÀNH THẺ TRÊN CHƯƠNG TRÌNH CARDWORKS</title>
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

.form-search-iss td {
	width: 20%;
}

.form-search-iss .form-control {
	height: 30px;
}

.header-table th {
	width: 10%
}
</style>

</head>
<body onload="startTime()">
	<header style="margin-bottom: 25px">
		<div class="nameProject">
			<p>
				<a href="index.html" style="font-size: 14px; font-weight: bold;">TRANG
					QUẢN LÝ THÔNG SỐ PHÁT HÀNH THẺ TRÊN CHƯƠNG TRÌNH CARDWORKS</a>
			</p>
		</div>
		<div class="userLogin">
			<p></p>
			<p></p>
			<p id="txt" style="margin-left: 180px; margin-top: -15px"></p>
		</div>
	</header>

	<div class="menu-bar"
		style="background-color: white; position: fixed; margin-top: 50px; z-index: 1;">
		<form action="${pageContext.request.contextPath}/search_parameter_cw"
			method="post" style="position: fixed; margin-top: 0px;">
			<table class="form-search-iss"
				style="width: 100%; margin-left: -5%; font-size: 18px">
				<tr>
					<td colspan="4"></td>
				</tr>

				<tr>
					<td><c:choose>
							<c:when test="${txt_cardType == '' || txt_cardType == null}">
								<input name="txt_cardType" class="form-control"
									style="width: 100%"
									placeholder="Nhập tên CardType muốn tìm kiếm..." value="" />
							</c:when>
						</c:choose> <c:choose>
							<c:when test="${txt_cardType != '' && txt_cardType != null}">
								<input name="txt_cardType" class="form-control"
									style="width: 100%"
									placeholder="Nhập tên CardType muốn tìm kiếm..."
									value="${txt_cardType}" />
							</c:when>
						</c:choose></td>
					<td><select name="ts_cardBranch" class="form-control"
						style="width: 100%">
							<c:choose>
								<c:when test="${ts_cardBranch == '' || ts_cardBranch == null}">
									<option value="" selected>-- LOẠI THẺ --</option>
									<option value="LC DEBIT">LC DEBIT</option>
									<option value="MC DEBIT">MC DEBIT</option>
									<option value="MC CREDIT">MC CREDIT</option>
									<option value="VS DEBIT">VS DEBIT</option>
									<option value="VS CREDIT">VS CREDIT</option>
								</c:when>
							</c:choose>
							<c:choose>
								<c:when test="${ts_cardBranch == 'LC DEBIT' }">
									<option value="">-- LOẠI THẺ --</option>
									<option value="LC DEBIT" selected>LC DEBIT</option>
									<option value="MC DEBIT">MC DEBIT</option>
									<option value="MC CREDIT">MC CREDIT</option>
									<option value="VS DEBIT">VS DEBIT</option>
									<option value="VS CREDIT">VS CREDIT</option>
								</c:when>
							</c:choose>
							<c:choose>
								<c:when test="${ts_cardBranch == 'MC DEBIT' }">
									<option value="">-- LOẠI THẺ --</option>
									<option value="LC DEBIT">LC DEBIT</option>
									<option value="MC DEBIT" selected>MC DEBIT</option>
									<option value="MC CREDIT">MC CREDIT</option>
									<option value="VS DEBIT">VS DEBIT</option>
									<option value="VS CREDIT">VS CREDIT</option>
								</c:when>
							</c:choose>
							<c:choose>
								<c:when test="${ts_cardBranch == 'MC CREDIT' }">
									<option value="">-- LOẠI THẺ --</option>
									<option value="LC DEBIT">LC DEBIT</option>
									<option value="MC DEBIT">MC DEBIT</option>
									<option value="MC CREDIT" selected>MC CREDIT</option>
									<option value="VS DEBIT">VS DEBIT</option>
									<option value="VS CREDIT">VS CREDIT</option>
								</c:when>
							</c:choose>
							<c:choose>
								<c:when test="${ts_cardBranch == 'VS DEBIT' }">
									<option value="">-- LOẠI THẺ --</option>
									<option value="LC DEBIT">LC DEBIT</option>
									<option value="MC DEBIT">MC DEBIT</option>
									<option value="MC CREDIT">MC CREDIT</option>
									<option value="VS DEBIT" selected>VS DEBIT</option>
									<option value="VS CREDIT">VS CREDIT</option>
								</c:when>
							</c:choose>
							<c:choose>
								<c:when test="${ts_cardBranch == 'VS CREDIT' }">
									<option value="">-- LOẠI THẺ --</option>
									<option value="LC DEBIT">LC DEBIT</option>
									<option value="MC DEBIT">MC DEBIT</option>
									<option value="MC CREDIT">MC CREDIT</option>
									<option value="VS DEBIT">VS DEBIT</option>
									<option value="VS CREDIT" selected>VS CREDIT</option>
								</c:when>
							</c:choose>

					</select></td>
					<td><select name="ts_hangThe" class="form-control"
						style="width: 100%">
							<c:choose>
								<c:when test="${ts_hangThe == '' || ts_hangThe == null }">
									<option value="" selected>-- HẠNG THẺ --</option>
									<option value="STANDARD">THẺ CHUẨN</option>
									<option value="GOLD">THẺ VÀNG</option>
									<option value="WORLD">THẺ WORLD</option>
									<option value="PLATINUM">THẺ PLATINUM</option>
									<option value="BUSSINESS">THẺ DOANH NGHIỆP</option>
								</c:when>
							</c:choose>
							<c:choose>
								<c:when test="${ts_hangThe == 'STANDARD' }">
									<option value="">-- HẠNG THẺ --</option>
									<option value="STANDARD" selected>THẺ CHUẨN</option>
									<option value="GOLD">THẺ VÀNG</option>
									<option value="WORLD">THẺ WORLD</option>
									<option value="PLATINUM">THẺ PLATINUM</option>
									<option value="BUSSINESS">THẺ DOANH NGHIỆP</option>
								</c:when>
							</c:choose>
							<c:choose>
								<c:when test="${ts_hangThe == 'GOLD' }">
									<option value="">-- HẠNG THẺ --</option>
									<option value="STANDARD">THẺ CHUẨN</option>
									<option value="GOLD" selected>THẺ VÀNG</option>
									<option value="WORLD">THẺ WORLD</option>
									<option value="PLATINUM">THẺ PLATINUM</option>
									<option value="BUSSINESS">THẺ DOANH NGHIỆP</option>
								</c:when>
							</c:choose>
							<c:choose>
								<c:when test="${ts_hangThe == 'WORLD' }">
									<option value="">-- HẠNG THẺ --</option>
									<option value="STANDARD">THẺ CHUẨN</option>
									<option value="GOLD">THẺ VÀNG</option>
									<option value="WORLD" selected>THẺ WORLD</option>
									<option value="PLATINUM">THẺ PLATINUM</option>
									<option value="BUSSINESS">THẺ DOANH NGHIỆP</option>
								</c:when>
							</c:choose>
							<c:choose>
								<c:when test="${ts_hangThe == 'PLATINUM' }">
									<option value="">-- HẠNG THẺ --</option>
									<option value="STANDARD">THẺ CHUẨN</option>
									<option value="GOLD">THẺ VÀNG</option>
									<option value="WORLD">THẺ WORLD</option>
									<option value="PLATINUM" selected>THẺ PLATINUM</option>
									<option value="BUSSINESS">THẺ DOANH NGHIỆP</option>
								</c:when>
							</c:choose>
							<c:choose>
								<c:when test="${ts_hangThe == 'BUSSINESS' }">
									<option value="">-- HẠNG THẺ --</option>
									<option value="STANDARD">THẺ CHUẨN</option>
									<option value="GOLD">THẺ VÀNG</option>
									<option value="WORLD">THẺ WORLD</option>
									<option value="PLATINUM">THẺ PLATINUM</option>
									<option value="BUSSINESS" selected>THẺ DOANH NGHIỆP</option>
								</c:when>
							</c:choose>

					</select></td>
					<td><select name="ts_loaiKhachHang" class="form-control"
						style="width: 90%">
							<c:choose>
								<c:when
									test="${ts_loaiKhachHang == '' || ts_loaiKhachHang == null }">
									<option value="" selected>-- LOẠI KH --</option>
									<option value="CBNV SCB">CBNV SCB</option>
									<option value="CTY CON-LK">CBNV CTY CON-LK</option>
									<option value="KH THUONG">KHÁCH HÀNG THƯỜNG</option>
									<option value="KHDN">KHÁCH HÀNG DOANH NGHIỆP</option>
								</c:when>
							</c:choose>
							<c:choose>
								<c:when test="${ts_loaiKhachHang == 'CBNV SCB' }">
									<option value="">-- LOẠI KH --</option>
									<option value="CBNV SCB" selected>CBNV SCB</option>
									<option value="CTY CON-LK">CBNV CTY CON-LK</option>
									<option value="KH THUONG">KHÁCH HÀNG THƯỜNG</option>
									<option value="KHDN">KHÁCH HÀNG DOANH NGHIỆP</option>
								</c:when>
							</c:choose>
							<c:choose>
								<c:when test="${ts_loaiKhachHang == 'CTY CON-LK' }">
									<option value="">-- LOẠI KH --</option>
									<option value="CBNV SCB">CBNV SCB</option>
									<option value="CTY CON-LK" selected>CBNV CTY CON-LK</option>
									<option value="KH THUONG">KHÁCH HÀNG THƯỜNG</option>
									<option value="KHDN">KHÁCH HÀNG DOANH NGHIỆP</option>
								</c:when>
							</c:choose>
							<c:choose>
								<c:when test="${ts_loaiKhachHang == 'KH THUONG' }">
									<option value="">-- LOẠI KH --</option>
									<option value="CBNV SCB">CBNV SCB</option>
									<option value="CTY CON-LK">CBNV CTY CON-LK</option>
									<option value="KH THUONG" selected>KHÁCH HÀNG THƯỜNG</option>
									<option value="KHDN">KHÁCH HÀNG DOANH NGHIỆP</option>
								</c:when>
							</c:choose>
							<c:choose>
								<c:when test="${ts_loaiKhachHang == 'KHDN' }">
									<option value="">-- LOẠI KH --</option>
									<option value="CBNV SCB">CBNV SCB</option>
									<option value="CTY CON-LK">CBNV CTY CON-LK</option>
									<option value="KH THUONG">KHÁCH HÀNG THƯỜNG</option>
									<option value="" selected>KHÁCH HÀNG DOANH NGHIỆP</option>
								</c:when>
							</c:choose>

					</select></td>
				</tr>
				<tr>
					<td><select name="ts_isContactless" class="form-control"
						style="width: 100%">
							<c:choose>
								<c:when
									test="${ts_isContactless == '' || ts_isContactless == NULL}">
									<option value="" selected>-- PHƯƠNG THỨC THANH TOÁN --</option>
									<option value="CONTACT">THẺ CONTACT</option>
									<option value="CONTACTLESS">THẺ CONTACTLESS</option>
								</c:when>
							</c:choose>
							<c:choose>
								<c:when test="${ts_isContactless == 'CONTACT' }">
									<option value="">-- PHƯƠNG THỨC THANH TOÁN --</option>
									<option value="CONTACT" selected>THẺ CONTACT</option>
									<option value="CONTACTLESS">THẺ CONTACTLESS</option>
								</c:when>
							</c:choose>
							<c:choose>
								<c:when test="${ts_isContactless == 'CONTACTLESS' }">
									<option value="">-- PHƯƠNG THỨC THANH TOÁN --</option>
									<option value="CONTACT">THẺ CONTACT</option>
									<option value="CONTACTLESS" selected>THẺ CONTACTLESS</option>
								</c:when>
							</c:choose>
					</select></td>
					<td><select name="ts_mienPhiPH" class="form-control"
						style="width: 100%">
							<c:choose>
								<c:when test="${ts_mienPhiPH == '' || ts_mienPhiPH == NULL}">
									<option value="" selected>-- PHÍ PHÁT HÀNH --</option>
									<option value="mienphiphathanh">MIỄN PHÍ PH</option>
									<option value="thuphiphathanhthuong">THU PHÍ PH THƯỜNG</option>
								</c:when>
							</c:choose>
							<c:choose>
								<c:when test="${ts_mienPhiPH == 'mienphiphathanh'}">
									<option value="">-- PHÍ PHÁT HÀNH --</option>
									<option value="mienphiphathanh" selected>MIỄN PHÍ PH</option>
									<option value="thuphiphathanhthuong">THU PHÍ PH THƯỜNG</option>
								</c:when>
							</c:choose>
							<c:choose>
								<c:when test="${ts_mienPhiPH == 'thuphiphathanhthuong'}">
									<option value="">-- PHÍ PHÁT HÀNH --</option>
									<option value="mienphiphathanh">MIỄN PHÍ PH</option>
									<option value="thuphiphathanhthuong" selected>THU PHÍ
										PH THƯỜNG</option>
								</c:when>
							</c:choose>
							<c:choose>
								<c:when test="${ts_mienPhiPH == 'thuphiphathanhnhanh'}">
									<option value="">-- PHÍ PHÁT HÀNH --</option>
									<option value="mienphiphathanh">MIỄN PHÍ PH</option>
									<option value="thuphiphathanhthuong">THU PHÍ PH THƯỜNG</option>
								</c:when>
							</c:choose>
					</select></td>
					<td><select name="ts_phiThuongNien" class="form-control"
						style="width: 100%">
							<c:choose>
								<c:when
									test="${ts_phiThuongNien == '' || ts_phiThuongNien == NULL}">
									<option value="" selected>-- PHÍ THƯỜNG NIÊN --</option>
									<option value="MIEN PHI TN">MIỄN PHÍ TN</option>
									<option value="MIEN PHI TN NAM DAU">MIỄN PHÍ TN NĂM
										ĐẦU</option>
									<option value="THU PHI TN">THU PHÍ TN</option>
								</c:when>
							</c:choose>
							<c:choose>
								<c:when test="${ts_phiThuongNien == 'MIEN PHI TN'}">
									<option value="">-- PHÍ THƯỜNG NIÊN --</option>
									<option value="MIEN PHI TN" selected>MIỄN PHÍ TN</option>
									<option value="MIEN PHI TN NAM DAU">MIỄN PHÍ TN NĂM
										ĐẦU</option>
									<option value="THU PHI TN">THU PHÍ TN</option>
								</c:when>
							</c:choose>
							<c:choose>
								<c:when test="${ts_phiThuongNien == 'MIEN PHI TN NAM DAU'}">
									<option value="">-- PHÍ THƯỜNG NIÊN --</option>
									<option value="MIEN PHI TN">MIỄN PHÍ TN</option>
									<option value="MIEN PHI TN NAM DAU" selected>MIỄN PHÍ
										TN NĂM ĐẦU</option>
									<option value="THU PHI TN">THU PHÍ TN</option>
								</c:when>
							</c:choose>
							<c:choose>
								<c:when test="${ts_phiThuongNien == 'THU PHI TN'}">
									<option value="">-- PHÍ THƯỜNG NIÊN --</option>
									<option value="MIEN PHI TN">MIỄN PHÍ TN</option>
									<option value="MIEN PHI TN NAM DAU">MIỄN PHÍ TN NĂM
										ĐẦU</option>
									<option value="THU PHI TN" selected>THU PHÍ TN</option>
								</c:when>
							</c:choose>
					</select></td>
					<td><input type="submit" value="TÌM KIẾM"
						style="float: left; text-align: center;"
						class="form-control btn btn-success" /></td>
				</tr>
				<tr>
					<td colspan="4"></td>
				</tr>
			</table>
		</form>
	</div>
	<div class="rightContent"
		style="margin-top: 120px; margin-left: 0px; height: 10px; position: fixed;">
		<div class="themThongTinTraSoatISS" style="height: 50px">
			<div id="thediv_scroll"
				style="margin-top: 0px; margin-left: 130px; box-shadow: 0px 0px 12px 0px #5E9BB4"">
				<table rules="groups" frame="hsides" id="testTable"
					class="tableTruyVanISS1 scroll"
					style="width: 180%; table-layout: fixed; height: auto;">
					<thead valign="top">
						<tr class="header-table">
							<th>CARD TYPE</th>
							<th>SOURCE CODE</th>
							<th>PROMO CODE</th>
							<th>SCHEME CODE</th>
							<th>LOẠI KH</th>
							<th>LOẠI THẺ</th>
							<th>HẠNG THẺ</th>
							<th>CONTACT/CONTACTLESS</th>
							<th>MIỄN PHÍ PH</th>
							<th>THU PHÍ PH THƯỜNG</th>
							<th>THU PHÍ PH NHANH</th>
							<th>PHÍ THƯỜNG NIÊN</th>
							<th style="width: 80%">DIỄN GIẢI TRÊN CW</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="p">
							<tr id="rows" class="rows">
								<td>${p.ts_cardType }</td>
								<td>${p.ts_sourceCode }</td>
								<td>${p.ts_promoCode }</td>
								<td>${p.ts_schemeCode }</td>
								<td>${p.ts_loaiKhachHang }</td>
								<td>${p.ts_cardBranch }</td>
								<td>${p.ts_hangThe }</td>
								<td>${p.ts_isContactless }</td>
								<td><c:choose>
										<c:when test="${p.ts_mienPhiPH == ' '}">KHÔNG</c:when>
										<c:otherwise>CÓ</c:otherwise>
									</c:choose></td>
								<td><c:choose>
										<c:when test="${p.ts_thuPhiPHThuong == ' '}">KHÔNG</c:when>
										<c:otherwise>CÓ</c:otherwise>
									</c:choose></td>
								<td><c:choose>
										<c:when test="${p.ts_thuPhiPHNhanh == ' '}">KHÔNG</c:when>
										<c:otherwise>CÓ</c:otherwise>
									</c:choose></td>
								<td>${p.ts_phiThuongNien }</td>
								<td style="width: 80%">${p.ts_dienGiai }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<input style="height: 30px; width: 150px; float: left;"
					class="btn btn-danger" type="button"
					onclick="tableToExcel('testTable', 'DISPUTE-TOOL-BY-P.KTT&NHDT')"
					value="XUẤT FILE EXCEL">
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
		$(document).ready(
				function() {
					$("#testTable").children("tbody").children("tr").children(
							"td").click(function() {
						$(this.parentNode).toggleClass("active");
					});
				});
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
</body>
</html>