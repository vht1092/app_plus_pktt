package controller;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import dao.DataDAO;
import dao.LoginDAO;
import dao.InfoAtmDAO;
import entity.UserCW;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	private HttpSession _session;

	@Autowired
	private LoginDAO loginDAO;

	@Autowired
	private InfoAtmDAO infoAtmDAO;

	@RequestMapping(value = "changepassword", method = RequestMethod.GET)
	public String page_changePassword(Model m, HttpServletRequest request) {
		_session = request.getSession();
		return "changepassword";
	}

	EnDeCryption objEnDe = new EnDeCryption();

	@RequestMapping(value = "/checklogin", method = RequestMethod.POST)
	public String checkLogin(HttpServletRequest request, Model m) throws ParseException, InterruptedException {
		_session = request.getSession();

		String frm_username = request.getParameter("username").toLowerCase();
		String frm_password_input = request.getParameter("password");
		String frm_password_endcode = objEnDe.endcode(frm_password_input);

		UserCW user = new UserCW();
		user = loginDAO.findUserLogin(frm_username, frm_password_endcode);

		String username = user.getUsername();
		if (username == null) {
			_session.setAttribute("error", "Login fail");
			return "redirect:login.html";
		} else {
			String userId = user.getUsername();
			Byte countlogin = user.getUsercount();
			String fullname = user.getFullname();
			String userLevel = user.getUserLevel();

			_session.setAttribute("userId", userId);
			_session.setAttribute("fullName", fullname);
			_session.setAttribute("username", username);
			_session.setAttribute("userLevel", userLevel);

			if (countlogin == 0) { // Dang nhap lan dau tien
				return "redirect:changepassword.html";
			} else {// Dang nhap thanh cong
				if (fullname.equals("huyennm2")) {
					infoAtmDAO.update_DELIV_BY_BRCH();
					// infoAtmDAO.xuLyImportTT_POS();
					// infoAtmDAO.xuLyImportTT_DVCNT();
					infoAtmDAO.capNhatMID_Tu_TTDVCNT_Sang_TTPOS();
					// infoAtmDAO.update_MaDonViPPTTheoMaUserThucHien();
				}
				return "redirect:index.html";
			}
		}
	}

	@RequestMapping(value = "/changepass", method = RequestMethod.POST)
	public String changepass(HttpServletRequest request, Model m) {
		_session = request.getSession();

		String frm_password1 = request.getParameter("password1");
		String frm_password2 = request.getParameter("password2");
		String username = String.valueOf(_session.getAttribute("username"));

		if (!frm_password1.equals(frm_password2)) {
			String error = "Mật khẩu xác nhận không khớp !";
			_session.setAttribute("error", error);
			return "redirect:changepassword.html";
		} else {
			frm_password1 = objEnDe.endcode(frm_password1); // Ma hoa password

			int row = loginDAO.updatePasswordUserLogin(username, frm_password1);

			String doipassthanhcong = "Đổi mật khẩu thành công.";
			_session.setAttribute("error", doipassthanhcong);
			return "redirect:login.html";
		}
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout() {
		_session.removeAttribute("userId");
		_session.removeAttribute("fullName");
		_session.removeAttribute("username");
		return "redirect:login.html";
	}
}