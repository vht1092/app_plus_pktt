package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import controller.Common;
import entity.*;

@Repository
public class InfoAtmDAO extends JdbcDaoSupport {

	@Autowired
	private CommonDAO commonDAO;

	@Autowired
	public InfoAtmDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	public List<CardReplace> export_card_replace(String txt_Ngay) {

		List<CardReplace> listCardReplace = new ArrayList<CardReplace>();

		String sql = "select F9_IW104_EMB_DT NGAY_PHAT_HANH_THE\r\n" + ", trim(FX_IW104_CRDH_NAME) CUS_NAME\r\n"
				+ ", PAN_UNLOCK\r\n" + ", F9_IW104_LOC_ACCT LOC\r\n"
				+ ", FX_IW104_CRD_CAT LOAI_HINH, trim(FX_IW104_LVL1_UID) MA_NHAN_VIEN, trim(FX_IW104_LVL2_UID) MA_NV_DUYET\r\n"
				+ ", trim(FX_AZ006_BRCH_CDE) BRN_NHAN_VIEN, trim(FX_IR025_BRCH_CDE) BRN_CARD\r\n"
				+ "from ccps.iw104 left join ccps.az006@am.world on trim(FX_IW104_LVL1_UID) = trim(PX_AZ006_UID)\r\n"
				+ "left join ccps.ir025@im.world on F9_IW104_LOC_ACCT = F9_IR025_LOC_ACCT\r\n"
				+ "where F9_IW104_EMB_DT = _111 and FX_IW104_CRD_CAT <> 'NEW CARD'\r\n"
				+ "and trim(FX_IR025_BRCH_CDE) <> trim(FX_AZ006_BRCH_CDE)";
		sql = sql.replaceAll("_111", txt_Ngay);
		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		int count = list.size();
		if (count == 0) {
			return listCardReplace;
		} else {
			for (Map<String, Object> row : list) {
				CardReplace cardReplace = new CardReplace();
				cardReplace.setNgayPhatHanh(String.valueOf(row.get("NGAY_PHAT_HANH_THE")));
				cardReplace.setTenKhachHang(String.valueOf(row.get("CUS_NAME")));
				cardReplace.setSoThe(String.valueOf(row.get("PAN_UNLOCK")));
				cardReplace.setLoc(String.valueOf(row.get("LOC")));
				cardReplace.setLoaiHinhPhatHanh(String.valueOf(row.get("LOAI_HINH")));
				cardReplace.setUserId(String.valueOf(row.get("MA_NHAN_VIEN")));
				cardReplace.setMaDonViUser(String.valueOf(row.get("BRN_NHAN_VIEN")));
				cardReplace.setMaDonViThe(String.valueOf(row.get("BRN_CARD")));
				cardReplace.setuserDuyet(String.valueOf(row.get("MA_NV_DUYET")));
				listCardReplace.add(cardReplace);
			}
			return listCardReplace;
		}
	}

	public List<CardReplace> export_card_fwbranch(String txt_Ngay) {

		List<CardReplace> listCardReplace = new ArrayList<CardReplace>();

		String sql = "select distinct F9_IW104_EMB_DT NGAY_PHAT_HANH_THE\r\n"
				+ ",(select PX_IRPANMAP_PANMASK from ccps.ir_pan_map@im where PX_IRPANMAP_PAN = FX_IW104_PAN) PAN_UNLOCK\r\n"
				+ ",F9_IW104_LOC_ACCT LOC\r\n" + ",FX_IW104_CRD_CAT LOAI_HINH\r\n"
				+ ",trim(FX_IW104_CRDH_NAME) CUS_NAME\r\n" + ",trim(CARD.BRCH_CDE) BRN_CARD\r\n"
				+ ",trim(CARD.deliv_brch_cde) FWD_BRN\r\n" + "from ccps.iw104 left join \r\n" + "(\r\n"
				+ "select FX_IR025_BRCH_CDE BRCH_CDE, F9_IR025_LOC_ACCT LOC, PX_IR025_PAN PAN, fx_ir025_deliv_brch_cde deliv_brch_cde from ccps.ir025@im\r\n"
				+ "where trim(fx_ir025_deliv_brch_cde) is not null \r\n" + "union all\r\n"
				+ "select FX_IR275_BRCH_CDE BRCH_CDE, F9_IR275_LOC_ACCT LOC, PX_IR275_OWN_PAN PAN, fx_ir275_deliv_brch_cde deliv_brch_cde  from ccps.ir275@im\r\n"
				+ "where trim(fx_ir275_deliv_brch_cde) is not null\r\n"
				+ ")CARD on F9_IW104_LOC_ACCT = CARD.LOC and FX_IW104_PAN = CARD.PAN\r\n"
				+ "where F9_IW104_EMB_DT = _111\r\n"
				+ "      and FX_IW104_CRD_PRD not in ('04', '05', '06', '07', '08', '32')\r\n"
				+ "      and trim(CARD.deliv_brch_cde) <> trim(CARD.BRCH_CDE)";
		sql = sql.replaceAll("_111", txt_Ngay);
		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		int count = list.size();
		if (count == 0) {
			return listCardReplace;
		} else {
			for (Map<String, Object> row : list) {
				CardReplace cardReplace = new CardReplace();
				cardReplace.setNgayPhatHanh(String.valueOf(row.get("NGAY_PHAT_HANH_THE")));
				cardReplace.setTenKhachHang(String.valueOf(row.get("CUS_NAME")));
				cardReplace.setSoThe(String.valueOf(row.get("PAN_UNLOCK")));
				cardReplace.setLoc(String.valueOf(row.get("LOC")));
				cardReplace.setLoaiHinhPhatHanh(String.valueOf(row.get("LOAI_HINH")));
				cardReplace.setUserId(String.valueOf(row.get("MA_NHAN_VIEN")));
				cardReplace.setMaDonViThe(String.valueOf(row.get("BRN_CARD")));
				cardReplace.setFwBranch(String.valueOf(row.get("FWD_BRN")));
				listCardReplace.add(cardReplace);
			}
			return listCardReplace;
		}
	}

	public List<UserCW> search_capgrp() {

		List<UserCW> listUserCW = new ArrayList<UserCW>();

		String sql = "select trim(FX_AZ006_GRP_ID) groupid, trim(PX_AZ006_UID) userid, \r\n"
				+ "trim(FX_AZ006_USR_NAME) username, trim(FX_AZ006_BRCH_CDE) branch_code, trim(FX_AZ006_USR_EMAIL_ADDR) email\r\n"
				+ "from ccps.az006@am where trim(FX_AZ006_GRP_ID) = 'CAPGRP'";
		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		int count = list.size();
		if (count == 0) {
			return listUserCW;
		} else {
			for (Map<String, Object> row : list) {
				UserCW UserCW = new UserCW();
				UserCW.setGroupId(String.valueOf(row.get("groupid")));
				UserCW.setUserId(String.valueOf(row.get("userid")));
				UserCW.setUsername(String.valueOf(row.get("username")));
				UserCW.setBranch(String.valueOf(row.get("branch_code")));
				UserCW.setEmail(String.valueOf(row.get("email")));
				listUserCW.add(UserCW);
			}
			return listUserCW;
		}
	}

	public List<UserCW> check_email(String txt_email) {
		
		List<UserCW> listUserCW = new ArrayList<UserCW>();
		StringBuilder sqlString = new StringBuilder();
		
		sqlString 	.append("select LOWER(trim(FX_DW002_EMAIL_ADDR)) EMAIL_ADDR,\r\n"
				+ "'NAME: ' || trim(FX_DW002_NAME) NAME, \r\n" + "'CIF: ' || trim(FX_DW002_CIF_NO) CIF,\r\n"
				+ "'PHONE: ' || trim(FX_DW002_HP) PHONE\r\n" + "from ccps.dw002@dw\r\n"
				+ "where LOWER(trim(FX_DW002_EMAIL_ADDR)) = '" + txt_email.toLowerCase().replaceAll(" ", "") + "'");
		
		Connection connect = getConnection();
		
		ResultSet rs;
		try {
			PreparedStatement preStmt = connect.prepareStatement(sqlString.toString());
			rs = preStmt.executeQuery();
			while(rs.next()) {
				UserCW user = new UserCW();
				user.setEmail(rs.getString("EMAIL_ADDR"));
				user.setCif(rs.getString("CIF"));
				user.setFullname(rs.getString("NAME"));
				user.setSdt(rs.getString("PHONE"));
				listUserCW.add(user);
			}
			
			preStmt.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listUserCW;

	}

	// CAP NHAT DELIV_BY_BRCH
	public void update_DELIV_BY_BRCH() {
		// THE CHINH
		String sql = "SELECT PAN FROM fpt.ppt_crd_detail aa, ccps.oa051@am bb WHERE issue_date >= 20191201 AND deliv_by_brch IS NULL AND aa.pan = bb.px_oa051_pan AND bb.fx_oa051_cls = ' '";
		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		int count = list.size();
		for (Map<String, Object> row : list) {
			String soThe = String.valueOf(row.get("PAN"));
			String updateTheChinh = "update fpt.ppt_crd_detail set deliv_by_brch = (select FX_IR025_DELIV_BY_BRCH from ccps.ir025@im where PX_IR025_PAN = '_soThe') where PAN = '_soThe' and ISSUE_DATE >= 20191201";
			updateTheChinh = updateTheChinh.replaceAll("_soThe", soThe);
			getJdbcTemplate().update(updateTheChinh);
		}

		// THE PHU
		sql = "SELECT pan, crd_prin_supp, deliv_by_brch FROM fpt.ppt_crd_detail aa, ccps.oa059@am bb WHERE issue_date >= 20191201 AND deliv_by_brch IS NULL AND aa.pan = bb.px_oa059_pan AND bb.fx_oa059_cls = ' '";
		list = getJdbcTemplate().queryForList(sql);
		count = list.size();
		for (Map<String, Object> row : list) {
			String soThe = String.valueOf(row.get("PAN"));
			String updateTheChinh = "update fpt.ppt_crd_detail set deliv_by_brch = (select FX_IR275_DELIV_BY_BRCH from ccps.ir275@im where PX_IR275_OWN_PAN = '_soThe') where PAN = '_soThe' and ISSUE_DATE >= 20191201";
			updateTheChinh = updateTheChinh.replaceAll("_soThe", soThe);
			getJdbcTemplate().update(updateTheChinh);
		}
		return;

	}

	// CAP NHAT DELIV_BY_BRCH
	public void update_MaDonViPPTTheoMaUserThucHien() {
		// THE CHINH, update vao ppt_emb_card_detail
		String sql = "SELECT px_ir025_pan, FX_IR025_UPD_UID,"
				+ " (select trim(FX_AZ006_BRCH_CDE) from az006@am where trim(PX_AZ006_UID) = trim(FX_IR025_UPD_UID)) BRANCH_USER_AZ006"
				+ " FROM ir025@im WHERE px_ir025_pan in (select PAN from fpt.ppt_emb_card_detail where CIF in(1467248,0397087,1766199,1766199,0580246,0432510,1430360,1028605,1128826,1782248,1097413,1515604,0474427,1576729,1652555,1019353,1576670,1617795,1617795,1943476,1011150,1782248,1576670,1429734)and EMB_DT = 20200211 and CRD_CAT <> 'NEW CARD' and PRIN_SUPP = 'P')";
		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);

		for (Map<String, Object> row : list) {
			String soThe = String.valueOf(row.get("px_ir025_pan"));
			String maDonVi = String.valueOf(row.get("BRANCH_USER_AZ006"));
			String updateTheChinh = "update fpt.ppt_emb_card_detail set BRCH_CDE = '_BRCH_CDE' where PAN = '_PAN' and EMB_DT = 20200211";
			updateTheChinh = updateTheChinh.replaceAll("_PAN", soThe);
			updateTheChinh = updateTheChinh.replaceAll("_BRCH_CDE", maDonVi);
			if (!maDonVi.equals("null")) {
				getJdbcTemplate().update(updateTheChinh);
			}
		}
		// THE CHINH, update vao ppt_crd_detail
		// String sql = "SELECT px_ir025_pan, FX_IR025_UPD_UID,"
		// + " (select trim(FX_AZ006_BRCH_CDE) from az006@am where
		// trim(PX_AZ006_UID) = trim(FX_IR025_UPD_UID)) BRANCH_USER_AZ006"
		// + " FROM ir025@im WHERE px_ir025_pan in (SELECT PAN FROM
		// fpt.ppt_crd_detail"
		// + " WHERE issue_date >= 20200101 AND issue_type <> 'NEW CARD' AND
		// crd_prin_supp = 'P')";
		// List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		// int count = list.size();
		// for (Map<String, Object> row : list) {
		// String soThe = String.valueOf(row.get("px_ir025_pan"));
		// String maDonVi = String.valueOf(row.get("BRANCH_USER_AZ006"));
		// String updateTheChinh = "update fpt.ppt_crd_detail set BRCH_CDE =
		// '_BRCH_CDE' where PAN = '_PAN' and issue_date >= 20200101";
		// updateTheChinh = updateTheChinh.replaceAll("_PAN", soThe);
		// updateTheChinh = updateTheChinh.replaceAll("_BRCH_CDE", maDonVi);
		// if (!maDonVi.equals("null")) {
		// getJdbcTemplate().update(updateTheChinh);
		// }
		// }

		// THE PHU
		sql = "SELECT PX_IR275_OWN_PAN, FX_IR275_UPD_UID,"
				+ " (select trim(FX_AZ006_BRCH_CDE) from az006@am where trim(PX_AZ006_UID) = trim(FX_IR275_UPD_UID)) BRANCH_USER_AZ006"
				+ " FROM ir275@im WHERE PX_IR275_OWN_PAN in (SELECT PAN FROM fpt.ppt_crd_detail"
				+ " WHERE issue_date >= 20200101 AND issue_type <> 'NEW CARD' AND crd_prin_supp = 'S')";
		list = getJdbcTemplate().queryForList(sql);

		for (Map<String, Object> row : list) {
			String soThe = String.valueOf(row.get("PX_IR275_OWN_PAN"));
			String maDonVi = String.valueOf(row.get("FX_AZ006_BRCH_CDE"));
			String updateThePhu = "update fpt.ppt_crd_detail set BRCH_CDE = '_BRCH_CDE' where PAN = '_PAN' and issue_date >= 20200101";
			updateThePhu = updateThePhu.replaceAll("_PAN", soThe);
			updateThePhu = updateThePhu.replaceAll("_BRCH_CDE", maDonVi);
			if (!maDonVi.equals("null")) {
				// getJdbcTemplate().update(updateThePhu);
			}
		}
		return;
	}

	public void xuLyImportTT_POS() throws InterruptedException {
		String sql = "select * from TT_POS_LIVE where USERNHAP = 'IMPORT_20200224' and LENGTH(MA_POS) <= 12";
		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);

		for (Map<String, Object> row : list) {
			String maDonVi = String.valueOf(row.get("CHINHANH_QUANLY"));
			String tID = String.valueOf(row.get("TID1"));
			String maNganhNghe = String.valueOf(row.get("TEN_NGANH_NGHE")).substring(0, 4);
			boolean isNumeric = isNumeric(maNganhNghe);

			String sqlupdate = "update TT_POS_LIVE set MA_POS = '_MA_POS', MCC_CODE = '_MCC_CODE' where TID1 = '_TID1'";
			Thread.sleep(500);
			sqlupdate = sqlupdate.replaceAll("_MA_POS", "P" + maDonVi + String.valueOf(commonDAO.get_SystemTime()));
			sqlupdate = sqlupdate.replaceAll("_TID1", tID);
			if (isNumeric == true) {
				sqlupdate = sqlupdate.replaceAll("_MCC_CODE", maNganhNghe);
			} else {
				sqlupdate = sqlupdate.replaceAll("_MCC_CODE", "");
			}
			getJdbcTemplate().update(sqlupdate);
		}
		// String sql1 = "update TT_POS_LIVE set MA_POS = '_MA_POS', MCC_CODE =
		// '_MCC_CODE' where TID1 = '_TID1'";
		// String sql2 = "update TT_POS_LIVE set DONGMAY = 'PAX_P70S' where
		// DONGMAY = 'PAX P70'";
		// String sql3 = "update TT_POS_LIVE set DONGMAY = 'PAX_78' where
		// DONGMAY = 'PAX P78'";
		// String sql4 = "update TT_POS_LIVE set DONGMAY = 'PAX_S78' where
		// DONGMAY = 'PAX S78'";
		// String sql5 = "update TT_POS_LIVE set DONGMAY = 'PAX_S90' where
		// DONGMAY = 'PAX S90'";
		// String sql6 = "update TT_POS_LIVE set DONGMAY = 'PAX_S78' where
		// DONGMAY = 'S78'";
		// String sql7 = "update TT_POS_LIVE set DONGMAY = 'PAX_S90' where
		// DONGMAY = 'S90'";
		// getJdbcTemplate().update(sql1);
		// getJdbcTemplate().update(sql2);
		// getJdbcTemplate().update(sql3);
		// getJdbcTemplate().update(sql4);
		// getJdbcTemplate().update(sql5);
		// getJdbcTemplate().update(sql6);
		// getJdbcTemplate().update(sql7);
		return;
	}

	public void xuLyImportTT_DVCNT() throws InterruptedException {
		String sql = "select * from tt_dvcnt_live where LENGTH(MA_DVCNT) <= 12";
		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);

		for (Map<String, Object> row : list) {
			String maDonVi = String.valueOf(row.get("CN_QUANLY"));
			String maNganhNghe = String.valueOf(row.get("NGANHNGHEKD"));
			String maDvcnt = String.valueOf(row.get("MA_DVCNT"));
			boolean isNumeric = isNumeric(maNganhNghe.substring(0, 4));

			String sqlupdate = "update tt_dvcnt_live set MA_DVCNT = '_MA_DVCNT_NEED_REPLACE', NGANHNGHEKD = '_NGANHNGHEKD' where MA_DVCNT = '_MA_DVCNT_DATABASE'";
			Thread.sleep(1000);
			sqlupdate = sqlupdate.replaceAll("_MA_DVCNT_NEED_REPLACE",
					"M" + maDonVi + String.valueOf(commonDAO.get_SystemTime()));
			if (isNumeric == true) {
				sqlupdate = sqlupdate.replaceAll("_NGANHNGHEKD",
						maNganhNghe.replaceAll(maNganhNghe.substring(0, 5), ""));
			} else {
				sqlupdate = sqlupdate.replaceAll(", NGANHNGHEKD = '_NGANHNGHEKD'", "");
			}
			sqlupdate = sqlupdate.replaceAll("_MA_DVCNT_DATABASE", maDvcnt);
			getJdbcTemplate().update(sqlupdate);
		}
		return;
	}

	public void capNhatMID_Tu_TTDVCNT_Sang_TTPOS() {
		// Xoa ky tu ' trong bang tt_dvcnt_live
		String sql = "select * from tt_dvcnt_live";
		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		for (Map<String, Object> row : list) {
			String maDvcnt = String.valueOf(row.get("MA_DVCNT"));
			String tenDvcnt = String.valueOf(row.get("TEN_DVCNT_VN")).replaceAll("'", "");
			String sqlUpdate = "update tt_dvcnt_live set TEN_DVCNT_VN = '_TEN_DVCNT_VN' where MA_DVCNT = '_MA_DVCNT'";
			sqlUpdate = sqlUpdate.replaceAll("_TEN_DVCNT_VN", tenDvcnt);
			sqlUpdate = sqlUpdate.replaceAll("_MA_DVCNT", maDvcnt);
			getJdbcTemplate().update(sqlUpdate);
		}
		// Xoa ky tu ' trong bang TT_POS_LIVE
		sql = "select * from TT_POS_LIVE";
		list = getJdbcTemplate().queryForList(sql);
		for (Map<String, Object> row : list) {
			String maPos = String.valueOf(row.get("MA_POS"));
			String tenDvcnt = String.valueOf(row.get("TEN_DVCNT")).replaceAll("'", "");
			String sqlUpdate = "update TT_POS_LIVE set TEN_DVCNT = '_TEN_DVCNT' where MA_POS = '_MA_POS'";
			sqlUpdate = sqlUpdate.replaceAll("_TEN_DVCNT", tenDvcnt);
			sqlUpdate = sqlUpdate.replaceAll("_MA_POS", maPos);
			getJdbcTemplate().update(sqlUpdate);
		}

		// Cap nhat MID tu tt_dvcnt_live qua bang TT_POS_LIVE thong qua
		// TEN_DVCNT
		sql = "select * from tt_dvcnt_live";
		list = getJdbcTemplate().queryForList(sql);
		for (Map<String, Object> row : list) {
			String maDvcnt = String.valueOf(row.get("MA_DVCNT"));
			String tenDvcnt = String.valueOf(row.get("TEN_DVCNT_VN"));
			String sqlUpdatePos = "update TT_POS_LIVE set MID = '_MID' where TEN_DVCNT = '_TEN_DVCNT'";
			sqlUpdatePos = sqlUpdatePos.replaceAll("_MID", maDvcnt);
			sqlUpdatePos = sqlUpdatePos.replaceAll("_TEN_DVCNT", tenDvcnt);
			getJdbcTemplate().update(sqlUpdatePos);
		}
		return;
	}

	public static boolean isNumeric(String str) {
		for (char c : str.toCharArray()) {
			if (!Character.isDigit(c))
				return false;
		}
		return true;
	}
}
