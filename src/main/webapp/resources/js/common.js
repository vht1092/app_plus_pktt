/* When the user clicks on the button, 
 toggle between hiding and showing the dropdown content */
function myFunction() {
	document.getElementById("myDropdown").classList.toggle("show");
}

// Close the dropdown if the user clicks outside of it
window.onclick = function(event) {
	if (!event.target.matches('.dropbtn')) {

		var dropdowns = document.getElementsByClassName("dropdown-content");
		var i;
		for (i = 0; i < dropdowns.length; i++) {
			var openDropdown = dropdowns[i];
			if (openDropdown.classList.contains('show')) {
				openDropdown.classList.remove('show');
			}
		}
	}
}

function startTime() {
	var today = new Date();
	var day = today.getDate();
	var month = today.getMonth() + 1;
	var year = today.getFullYear();
	var h = today.getHours();
	var m = today.getMinutes();
	var s = today.getSeconds();
	m = checkTime(m);
	s = checkTime(s);
	document.getElementById('txt').innerHTML = day + "/" + month + "/" + year
			+ " | " + h + ":" + m + ":" + s;
	var t = setTimeout(startTime, 500);
}
function checkTime(i) {
	if (i < 10) {
		i = "0" + i
	}
	; // add zero in front of numbers < 10
	return i;
}

function NgayHoanTra() {
	// document.getElementById("lblNgayHoanTra").style.visibility = "visible";
	// document.getElementById("datepicker5").style.visibility = "visible";

	if (document.getElementById("crdTxnProcResult").value == "1") {
		document.getElementById("lblNgayHoanTra").style.visibility = 'hidden';
		document.getElementById("datepicker6").style.visibility = 'hidden';
		document.getElementById("datepicker6").focus();
	}
	if (document.getElementById("crdTxnProcResult").value == "2") {
		document.getElementById("lblNgayHoanTra").style.visibility = 'visible';
		document.getElementById("datepicker6").style.visibility = 'visible';
		document.getElementById("datepicker6").focus();
	}
}
function nguyennhantrasoat_lydokhac() {
	if (document.getElementById("lyDoTraSoat").value == "9") {
		document.getElementById("lyDoTraSoatKhac").style.visibility = 'visible';
		document.getElementById("lyDoTraSoatKhac").focus();
	} else {
		document.getElementById("lyDoTraSoatKhac").style.visibility = 'hidden';
		document.getElementById("lyDoTraSoatKhac").focus();
	}
}

function caps(id) {
	document.getElementById(id).value = document.getElementById(id).value
			.toUpperCase();
}

function clearForms() {
	$(':input').not(':button, :submit, :reset, :hidden, :checkbox, :radio')
			.val('');
	$(':checkbox, :radio').prop('checked', false);
}
function keyPressWord(e) {
	var keyword = null;
	if (window.event) {
		keyword = window.event.keyCode;
	} else {
		keyword = e.which; // NON IE;
	}

	if (keyword < 47 || keyword > 57) {
		if (keyword == 48 || keyword == 127) {
			return;
		}
		return false;
	}
}
function keyPressWord_USD(e) {
	var keyword = null;
	if (window.event) {
		keyword = window.event.keyCode;
	} else {
		keyword = e.which; // NON IE;
	}

	if (keyword < 46 || keyword == 47 || keyword > 57) {
		if (keyword == 48 || keyword == 127) {
			return;
		}
		return false;
	}
}

function blockSpecialChar(e) {
	var k = e.keyCode;
	return ((k > 64 && k < 91) || (k > 96 && k < 123) || k == 8 || k == 32 || (k >= 48 && k <= 57));
}

function format_curency(a) {
	a.value = a.value.replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,");
}

function onchange_CaseStatus() {
	var crdCaseStatusValue = document.getElementById("crdCaseStatus").value;
	if (crdCaseStatusValue == "Pending" || crdCaseStatusValue == "Offline") {
		document.getElementById("thoigianxulyconlai").style.background = '#ADFF52';
		document.getElementById("RR1").style.background = 'white';
		document.getElementById("RR2").style.background = 'white';
		document.getElementById("CB1").style.background = 'white';
		document.getElementById("CB2").style.background = 'white';
		document.getElementById("CB3").style.background = 'white';
		document.getElementById("CB4").style.background = 'white';
		document.getElementById("AR1").style.background = 'white';
		document.getElementById("AR2").style.background = 'white';
		document.getElementById("PRE_ARB_RESP").style.background = 'white';
		document.getElementById("PR1").style.background = 'white';
		document.getElementById("PR2").style.background = 'white';
		document.getElementById("PR3").style.background = 'white';
		document.getElementById("PR4").style.background = 'white';
		document.getElementById("AC1").style.background = 'white';
		document.getElementById("AC2").style.background = 'white';
		document.getElementById("Done1").style.background = 'white';
		document.getElementById("Done2").style.background = 'white';
		document.getElementById("Done3").style.background = 'white';
		document.getElementById("Done4").style.background = 'white';
		document.getElementById("Done5").style.background = 'white';
	} else if (crdCaseStatusValue == "Retrieval Request") {
		document.getElementById("RR1").style.background = '#ADFF52';
		document.getElementById("RR2").style.background = '#ADFF52';

		document.getElementById("CB1").style.background = 'white';
		document.getElementById("CB2").style.background = 'white';
		document.getElementById("CB3").style.background = 'white';
		document.getElementById("CB4").style.background = 'white';
		document.getElementById("AR1").style.background = 'white';
		document.getElementById("AR2").style.background = 'white';
		document.getElementById("PRE_ARB_RESP").style.background = 'white';
		document.getElementById("PR1").style.background = 'white';
		document.getElementById("PR2").style.background = 'white';
		document.getElementById("PR3").style.background = 'white';
		document.getElementById("PR4").style.background = 'white';
		document.getElementById("AC1").style.background = 'white';
		document.getElementById("AC2").style.background = 'white';
		document.getElementById("Done1").style.background = 'white';
		document.getElementById("Done2").style.background = 'white';
		document.getElementById("Done3").style.background = 'white';
		document.getElementById("Done4").style.background = 'white';
		document.getElementById("Done5").style.background = 'white';
	} else if (crdCaseStatusValue == "Chargeback/Dispute") {
		document.getElementById("CB1").style.background = '#ADFF52';
		document.getElementById("CB2").style.background = '#ADFF52';
		document.getElementById("CB3").style.background = '#ADFF52';
		document.getElementById("CB4").style.background = '#ADFF52';
		// document.getElementById("thoigianxulyconlai").style.background =
		// '#ADFF52';

		document.getElementById("RR1").style.background = 'white';
		document.getElementById("RR2").style.background = 'white';
		document.getElementById("AR1").style.background = 'white';
		document.getElementById("AR2").style.background = 'white';
		document.getElementById("PRE_ARB_RESP").style.background = 'white';
		document.getElementById("PR1").style.background = 'white';
		document.getElementById("PR2").style.background = 'white';
		document.getElementById("PR3").style.background = 'white';
		document.getElementById("PR4").style.background = 'white';
		document.getElementById("AC1").style.background = 'white';
		document.getElementById("AC2").style.background = 'white';
		document.getElementById("Done1").style.background = 'white';
		document.getElementById("Done2").style.background = 'white';
		document.getElementById("Done3").style.background = 'white';
		document.getElementById("Done4").style.background = 'white';
		document.getElementById("Done5").style.background = 'white';
	} else if (crdCaseStatusValue == "Arbitration Chargeback") {
		document.getElementById("AR1").style.background = '#ADFF52';
		document.getElementById("AR2").style.background = '#ADFF52';

		document.getElementById("RR1").style.background = 'white';
		document.getElementById("RR2").style.background = 'white';
		document.getElementById("CB1").style.background = 'white';
		document.getElementById("CB2").style.background = 'white';
		document.getElementById("CB3").style.background = 'white';
		document.getElementById("CB4").style.background = 'white';
		document.getElementById("PRE_ARB_RESP").style.background = 'white';
		document.getElementById("PR1").style.background = 'white';
		document.getElementById("PR2").style.background = 'white';
		document.getElementById("PR3").style.background = 'white';
		document.getElementById("PR4").style.background = 'white';
		document.getElementById("AC1").style.background = 'white';
		document.getElementById("AC2").style.background = 'white';
		document.getElementById("Done1").style.background = 'white';
		document.getElementById("Done2").style.background = 'white';
		document.getElementById("Done3").style.background = 'white';
		document.getElementById("Done4").style.background = 'white';
		document.getElementById("Done5").style.background = 'white';
	} else if (crdCaseStatusValue == "Pre-Arbitration Response") {
		document.getElementById("PRE_ARB_RESP").style.background = '#ADFF52';

		document.getElementById("RR1").style.background = 'white';
		document.getElementById("RR2").style.background = 'white';
		document.getElementById("CB1").style.background = 'white';
		document.getElementById("CB2").style.background = 'white';
		document.getElementById("CB3").style.background = 'white';
		document.getElementById("CB4").style.background = 'white';
		document.getElementById("AR1").style.background = 'white';
		document.getElementById("AR2").style.background = 'white';
		document.getElementById("PR1").style.background = 'white';
		document.getElementById("PR2").style.background = 'white';
		document.getElementById("PR3").style.background = 'white';
		document.getElementById("PR4").style.background = 'white';
		document.getElementById("AC1").style.background = 'white';
		document.getElementById("AC2").style.background = 'white';
		document.getElementById("Done1").style.background = 'white';
		document.getElementById("Done2").style.background = 'white';
		document.getElementById("Done3").style.background = 'white';
		document.getElementById("Done4").style.background = 'white';
		document.getElementById("Done5").style.background = 'white';
	} else if (crdCaseStatusValue == "Pre-Arbitration") {
		document.getElementById("PR1").style.background = '#ADFF52';
		document.getElementById("PR2").style.background = '#ADFF52';
		document.getElementById("PR3").style.background = '#ADFF52';
		document.getElementById("PR4").style.background = '#ADFF52';

		document.getElementById("RR1").style.background = 'white';
		document.getElementById("RR2").style.background = 'white';
		document.getElementById("CB1").style.background = 'white';
		document.getElementById("CB2").style.background = 'white';
		document.getElementById("CB3").style.background = 'white';
		document.getElementById("CB4").style.background = 'white';
		document.getElementById("AR1").style.background = 'white';
		document.getElementById("AR2").style.background = 'white';
		document.getElementById("PRE_ARB_RESP").style.background = 'white';
		document.getElementById("AC1").style.background = 'white';
		document.getElementById("AC2").style.background = 'white';
		document.getElementById("Done1").style.background = 'white';
		document.getElementById("Done2").style.background = 'white';
		document.getElementById("Done3").style.background = 'white';
		document.getElementById("Done4").style.background = 'white';
		document.getElementById("Done5").style.background = 'white';
	} else if (crdCaseStatusValue == "Arbitration") {
		document.getElementById("AC1").style.background = '#ADFF52';
		document.getElementById("AC2").style.background = '#ADFF52';

		document.getElementById("RR1").style.background = 'white';
		document.getElementById("RR2").style.background = 'white';
		document.getElementById("CB1").style.background = 'white';
		document.getElementById("CB2").style.background = 'white';
		document.getElementById("CB3").style.background = 'white';
		document.getElementById("CB4").style.background = 'white';
		document.getElementById("AR1").style.background = 'white';
		document.getElementById("AR2").style.background = 'white';
		document.getElementById("PRE_ARB_RESP").style.background = 'white';
		document.getElementById("PR1").style.background = 'white';
		document.getElementById("PR2").style.background = 'white';
		document.getElementById("PR3").style.background = 'white';
		document.getElementById("PR4").style.background = 'white';
		document.getElementById("Done1").style.background = 'white';
		document.getElementById("Done2").style.background = 'white';
		document.getElementById("Done3").style.background = 'white';
		document.getElementById("Done4").style.background = 'white';
		document.getElementById("Done5").style.background = 'white';
	} else if (crdCaseStatusValue == "Done") {
		document.getElementById("Done1").style.background = '#ADFF52';
		document.getElementById("Done2").style.background = '#ADFF52';
		document.getElementById("Done3").style.background = '#ADFF52';
		document.getElementById("Done4").style.background = '#ADFF52';
		document.getElementById("Done5").style.background = '#ADFF52';

		document.getElementById("RR1").style.background = 'white';
		document.getElementById("RR2").style.background = 'white';
		document.getElementById("CB1").style.background = 'white';
		document.getElementById("CB2").style.background = 'white';
		document.getElementById("CB3").style.background = 'white';
		document.getElementById("CB4").style.background = 'white';
		document.getElementById("AR1").style.background = 'white';
		document.getElementById("AR2").style.background = 'white';
		document.getElementById("PRE_ARB_RESP").style.background = 'white';
		document.getElementById("PR1").style.background = 'white';
		document.getElementById("PR2").style.background = 'white';
		document.getElementById("PR3").style.background = 'white';
		document.getElementById("PR4").style.background = 'white';
		document.getElementById("AC1").style.background = 'white';
		document.getElementById("AC2").style.background = 'white';
	}
}

function addPosModeKhac() {
	if (document.getElementById("posModeKhac").value == "other") {
		document.getElementById("txt_otherPosmode").style.visibility = 'visible';
		document.getElementById("txt_otherPosmode").focus();
	}
	if (document.getElementById("posModeKhac").value != "other") {
		document.getElementById("txt_otherPosmode").style.visibility = 'hidden';
	}
}

function checkForm_createIssEbank() {
	var ngayGD = document.getElementById("datepicker1").value;
	ngayGD = ngayGD.replace("-", "");
	ngayGD = ngayGD.replace("-", "");
	var result_ngayGD = ngayGD.slice(4, 8) + ngayGD.slice(2, 4)
			+ ngayGD.slice(0, 2);

	var ngayTiepNhan = document.getElementById("datepicker2").value;
	ngayTiepNhan = ngayTiepNhan.replace("-", "");
	ngayTiepNhan = ngayTiepNhan.replace("-", "");
	var result_ngayTiepNhan = ngayTiepNhan.slice(4, 8)
			+ ngayTiepNhan.slice(2, 4) + ngayTiepNhan.slice(0, 2);

	if (result_ngayGD > result_ngayTiepNhan) {
		alert("Ngày tiếp nhận phải sau ngày giao dịch !");
		returnToPreviousPage();
		document.getElementById("datepicker2").focus();
	}
}

function returnToPreviousPage(e) {
	e = e || window.event;
	// validation code

	// if invalid
	if (e.preventDefault) {
		e.preventDefault();
	} else {
		e.returnValue = false;
	}
}

function selectedTrxn_Click(clicked_id) {
	var createTimeOfTrxn = document.getElementById(clicked_id).value;
	var selectedTrxn = document.getElementById("selectedTrxn").value;
	if (selectedTrxn == "") {
		document.getElementById("selectedTrxn").value = "-" + createTimeOfTrxn;
	} else {
		if (selectedTrxn.search(createTimeOfTrxn) < 0) {
			document.getElementById("selectedTrxn").value = document
					.getElementById("selectedTrxn").value
					+ "-" + createTimeOfTrxn;
		} else {
			createTimeOfTrxn = "-" + createTimeOfTrxn;
			document.getElementById("selectedTrxn").value = selectedTrxn
					.replace(createTimeOfTrxn, "");
		}
	}
}

function onchange_CaseStatus_Local() {
	var crdCaseStatusValue = document.getElementById("tinhTrangCase").value;
	if (crdCaseStatusValue == "TS lan 1") {
		document.getElementById("crdTsLan1").style.background = '#ADFF52';
		document.getElementById("crdNgayTsLan1").style.background = '#ADFF52';
		document.getElementById("crdNgayTsLan1Txt").style.background = '#ADFF52';
		document.getElementById("crdNgayTsLan1TxtTime").style.background = '#ADFF52';

		document.getElementById("crdTsLan2").style.background = 'white';
		document.getElementById("crdNgayTsLan2").style.background = 'white';
		document.getElementById("crdNgayThuongLuong").style.background = 'white';
		document.getElementById("crdNgayHoaGiaiNapas").style.background = 'white';
		document.getElementById("donex").style.background = 'white';

	}
	if (crdCaseStatusValue == "TS lan 2") {
		document.getElementById("crdTsLan2").style.background = '#ADFF52';
		document.getElementById("crdNgayTsLan2").style.background = '#ADFF52';

		document.getElementById("crdTsLan1").style.background = 'white';
		document.getElementById("crdNgayTsLan1").style.background = 'white';
		document.getElementById("crdNgayTsLan1Txt").style.background = 'white';
		document.getElementById("crdNgayTsLan1TxtTime").style.background = 'white';
		document.getElementById("crdNgayThuongLuong").style.background = 'white';
		document.getElementById("crdNgayHoaGiaiNapas").style.background = 'white';
		document.getElementById("donex").style.background = 'white';
	}
	if (crdCaseStatusValue == "Thuong luong, hoa giai") {
		document.getElementById("crdNgayThuongLuong").style.background = '#ADFF52';

		document.getElementById("crdTsLan2").style.background = 'white';
		document.getElementById("crdNgayTsLan2").style.background = 'white';
		document.getElementById("crdTsLan1").style.background = 'white';
		document.getElementById("crdNgayTsLan1").style.background = 'white';
		document.getElementById("crdNgayTsLan1Txt").style.background = 'white';
		document.getElementById("crdNgayTsLan1TxtTime").style.background = 'white';
		document.getElementById("crdNgayHoaGiaiNapas").style.background = 'white';
		document.getElementById("donex").style.background = 'white';
	}
	if (crdCaseStatusValue == "HD hoa giai Napas/Trong tai/Toa an") {
		document.getElementById("crdNgayHoaGiaiNapas").style.background = '#ADFF52';

		document.getElementById("crdTsLan2").style.background = 'white';
		document.getElementById("crdNgayTsLan2").style.background = 'white';
		document.getElementById("crdTsLan1").style.background = 'white';
		document.getElementById("crdNgayTsLan1").style.background = 'white';
		document.getElementById("crdNgayTsLan1Txt").style.background = 'white';
		document.getElementById("crdNgayTsLan1TxtTime").style.background = 'white';
		document.getElementById("donex").style.background = 'white';
		document.getElementById("crdNgayThuongLuong").style.background = 'white';
	}
	if (crdCaseStatusValue == "Done") {
		document.getElementById("donex").style.background = '#ADFF52';

		document.getElementById("crdTsLan2").style.background = 'white';
		document.getElementById("crdNgayTsLan2").style.background = 'white';
		document.getElementById("crdTsLan1").style.background = 'white';
		document.getElementById("crdNgayTsLan1").style.background = 'white';
		document.getElementById("crdNgayTsLan1Txt").style.background = 'white';
		document.getElementById("crdNgayTsLan1TxtTime").style.background = 'white';
		document.getElementById("crdNgayThuongLuong").style.background = 'white';
		document.getElementById("crdNgayHoaGiaiNapas").style.background = 'white';
	}
}