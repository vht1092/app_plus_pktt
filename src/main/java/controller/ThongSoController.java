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
import dao.ThongSoDAO;

@Controller
public class ThongSoController {

	private HttpSession _session;
	Common common = new Common();

	@Autowired
	private ThongSoDAO ThongSoDAO;

	@RequestMapping(value = "/search_parameter_cw", method = RequestMethod.POST)
	public String search_parameter_cw(Model m, HttpServletRequest request) {
		_session = request.getSession();

		String txt_cardType = request.getParameter("txt_cardType");
		String ts_cardBranch = request.getParameter("ts_cardBranch");
		String ts_hangThe = request.getParameter("ts_hangThe");
		String ts_loaiKhachHang = request.getParameter("ts_loaiKhachHang");
		String ts_isContactless = request.getParameter("ts_isContactless");
		String ts_mienPhiPH = request.getParameter("ts_mienPhiPH");
		String ts_phiThuongNien = request.getParameter("ts_phiThuongNien");

		_session.setAttribute("list", ThongSoDAO.search_parameter_cw(txt_cardType, ts_cardBranch, ts_hangThe,
				ts_loaiKhachHang, ts_isContactless, ts_mienPhiPH, ts_phiThuongNien));

		_session.setAttribute("txt_cardType", txt_cardType);
		_session.setAttribute("ts_cardBranch", ts_cardBranch);
		_session.setAttribute("ts_hangThe", ts_hangThe);
		_session.setAttribute("ts_loaiKhachHang", ts_loaiKhachHang);
		_session.setAttribute("ts_isContactless", ts_isContactless);
		_session.setAttribute("ts_mienPhiPH", ts_mienPhiPH);
		_session.setAttribute("ts_phiThuongNien", ts_phiThuongNien);

		return "redirect:danhsach.html";
	}
}
