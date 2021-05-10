package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import dao.*;

@Controller
public class HomeAppPlusController {

	private HttpSession _session;
	@Autowired
	private DataDAO dataDAO;

	@Autowired
	private InfoAtmDAO InfoAtmDAO;

	// @RequestMapping(value = "uploadOneFile", method = RequestMethod.GET)
	// public String uploadOneFile(Model m, HttpServletRequest request) {
	// _session = request.getSession();
	// _session.removeAttribute("alert_success");
	// // Check login?
	// String user = (String) _session.getAttribute("fullName");
	// if (user == null || user.equals("")) {
	// return "redirect:login.html";
	// }
	// return "uploadOneFile";
	// }

	@RequestMapping(value = "danhsach", method = RequestMethod.GET)
	public String thongso(Model m, HttpServletRequest request) throws IOException {
		return "danhsach";
	}

	@RequestMapping(value = "giaothetannoi", method = RequestMethod.GET)
	public String giaothetannoi(Model m, HttpServletRequest request) throws IOException {
		_session = request.getSession();
		_session.removeAttribute("alert_success");
		// Check login?
		String user = (String) _session.getAttribute("fullName");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}
		// XU LY UPLOAD FILE

		//

		// XU LY DOC FILE & CAP NHAT DB

		return "giaothetannoi";
	}

	@RequestMapping(value = "check_email", method = RequestMethod.GET)
	public String check_email(Model m, HttpServletRequest request) {
		_session = request.getSession();
		_session.removeAttribute("alert_success");
		// Check login?
		String user = (String) _session.getAttribute("fullName");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}
		return "check_email";
	}

	@RequestMapping(value = "export_capgrp", method = RequestMethod.GET)
	public String export_capgrp(Model m, HttpServletRequest request) {
		_session = request.getSession();
		_session.removeAttribute("alert_success");
		// Check login?
		String user = (String) _session.getAttribute("fullName");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}
		return "export_capgrp";
	}

	@RequestMapping(value = "export_card_fwbranch", method = RequestMethod.GET)
	public String export_card_fwbranch(Model m, HttpServletRequest request) {
		_session = request.getSession();
		_session.removeAttribute("alert_success");
		// Check login?
		String user = (String) _session.getAttribute("fullName");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}
		return "export_card_fwbranch";
	}

	@RequestMapping(value = "export_card_replace", method = RequestMethod.GET)
	public String export_card_replace(Model m, HttpServletRequest request) {
		_session = request.getSession();
		_session.removeAttribute("alert_success");
		// Check login?
		String user = (String) _session.getAttribute("fullName");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}
		return "export_card_replace";
	}

	@RequestMapping(value = "search_edit_atm", method = RequestMethod.GET)
	public String search_edit_atm(Model m, HttpServletRequest request) {
		_session = request.getSession();
		_session.removeAttribute("alert_success");
		// Check login?
		String user = (String) _session.getAttribute("fullName");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}
		return "search_edit_atm";
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String page_login(Model m, HttpServletRequest request) {
		_session = request.getSession();
		// Check login?
		String user = String.valueOf(_session.getAttribute("fullName"));
		if (!user.equals("null")) {
			return "index";
		}
		return "login";
	}

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String TrangChu(Model m, HttpServletRequest request) {
		_session = request.getSession();
		// Check login?
		String user = (String) _session.getAttribute("fullName");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}
		return "index";
	}

	@RequestMapping(value = { "/advertiser/list" }, method = RequestMethod.GET)
	public String advertiser(Model model) throws SQLException {

		List<String> list = dataDAO.queryAdvertisers();
		model.addAttribute("advertisers", list);

		return "advertiser";
	}

	@RequestMapping(value = { "/publisher/list" }, method = RequestMethod.GET)
	public String publisher(Model model) throws SQLException {

		List<String> list = dataDAO.queryPublishers();
		model.addAttribute("publishers", list);

		return "publisher";
	}
}
