package controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import dao.CommonDAO;
import dao.InfoAtmDAO;

@Controller
public class InfoAtmController {

	private static final String destinationDir = "C:/Info_Atm_Tool/";
	private HttpSession _session;
	Common common = new Common();

	@Autowired
	private InfoAtmDAO InfoAtmDAO;

	@Autowired
	private CommonDAO commonDAO;

	@RequestMapping(value = "/search_replace_card", method = RequestMethod.POST)
	public String search_replace_card(Model m, HttpServletRequest request) {
		_session = request.getSession();
		_session.removeAttribute("alert_success");

		// Check login?
		String user = (String) _session.getAttribute("fullName");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}

		String txt_fromDate = request.getParameter("txt_fromDate");
		String txt_toDate = request.getParameter("txt_toDate");

		if (txt_fromDate == null) {
			txt_fromDate = (String) _session.getAttribute("txt_fromDate");
		}

		// SERVICE_CODE = 201: THE CREDIT
		_session.setAttribute("list", InfoAtmDAO.export_card_replace(common.formatTime(txt_fromDate)));

		_session.setAttribute("txt_cardNo", request.getParameter("txt_cardNo"));
		_session.setAttribute("txt_fromDate", txt_fromDate);
		_session.setAttribute("txt_toDate", txt_toDate);

		return "redirect:export_card_replace.html";
	}

	@RequestMapping(value = "/export_card_fwbranch", method = RequestMethod.POST)
	public String export_card_fwbranch(Model m, HttpServletRequest request) {
		_session = request.getSession();
		_session.removeAttribute("alert_success");

		// Check login?
		String user = (String) _session.getAttribute("fullName");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}

		String txt_fromDate = request.getParameter("txt_fromDate");
		String txt_toDate = request.getParameter("txt_toDate");

		if (txt_fromDate == null) {
			txt_fromDate = (String) _session.getAttribute("txt_fromDate");
		}

		// SERVICE_CODE = 201: THE CREDIT
		_session.setAttribute("list_fw", InfoAtmDAO.export_card_fwbranch(common.formatTime(txt_fromDate)));

		_session.setAttribute("txt_cardNo", request.getParameter("txt_cardNo"));
		_session.setAttribute("txt_fromDate", txt_fromDate);
		_session.setAttribute("txt_toDate", txt_toDate);

		return "redirect:export_card_fwbranch.html";
	}

	@RequestMapping(value = "/search_capgrp", method = RequestMethod.POST)
	public String search_capgrp(Model m, HttpServletRequest request) {
		_session = request.getSession();
		_session.removeAttribute("alert_success");

		// Check login?
		String user = (String) _session.getAttribute("fullName");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}

		// SERVICE_CODE = 201: THE CREDIT
		_session.setAttribute("list_capgrp", InfoAtmDAO.search_capgrp());

		return "redirect:export_capgrp.html";
	}

	@RequestMapping(value = "/check_email", method = RequestMethod.POST)
	public String check_email(Model m, HttpServletRequest request) {
		_session = request.getSession();
		_session.removeAttribute("alert_success");

		// Check login?
		String user = (String) _session.getAttribute("fullName");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}

		String txt_keyword = request.getParameter("txt_keyword");
		txt_keyword = txt_keyword.replaceAll(" ", "");

		// SERVICE_CODE = 201: THE CREDIT
		_session.setAttribute("list_email", InfoAtmDAO.check_email(txt_keyword));
		_session.setAttribute("txt_keyword", txt_keyword);

		return "redirect:check_email.html";
	}

}
