package dao;

import java.math.BigDecimal;
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
public class ThongSoDAO extends JdbcDaoSupport {

	@Autowired
	private CommonDAO commonDAO;

	@Autowired
	public ThongSoDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	public List<ThongSoEntity> search_parameter_cw(String txt_cardType, String ts_cardBranch, String ts_hangThe,
			String ts_loaiKhachHang, String ts_isContactless, String ts_mienPhiPH, String ts_phiThuongNien) {

		List<ThongSoEntity> listThongSoEntity = new ArrayList<ThongSoEntity>();

		String sql = "select * from (SELECT   a.px_ir269_crd_pgm," + " a.px_ir269_src_cde," + " a.px_ir269_campgn_cde,"
				+ " b.fx_ir047_schm_cde," + " (CASE"
				+ " WHEN (SELECT fx_ir121_crd_brn FROM ir121 WHERE px_ir121_crd_pgm = a.px_ir269_crd_pgm and fx_ir121_crd_brn = 'MC' and FX_IR121_SERV_CDE = 201) = 'MC' THEN 'MC CREDIT'"
				+ " WHEN (SELECT fx_ir121_crd_brn FROM ir121 WHERE px_ir121_crd_pgm = a.px_ir269_crd_pgm and fx_ir121_crd_brn = 'VS' and FX_IR121_SERV_CDE = 201) = 'VS' THEN 'VS CREDIT'"
				+ " WHEN (SELECT fx_ir121_crd_brn FROM ir121 WHERE px_ir121_crd_pgm = a.px_ir269_crd_pgm and fx_ir121_crd_brn = 'MC' and FX_IR121_SERV_CDE = 221) = 'MC' THEN 'MC DEBIT'"
				+ " WHEN (SELECT fx_ir121_crd_brn FROM ir121 WHERE px_ir121_crd_pgm = a.px_ir269_crd_pgm and fx_ir121_crd_brn = 'VS' and FX_IR121_SERV_CDE = 221) = 'VS' THEN 'VS DEBIT'"
				+ " ELSE 'LC DEBIT'" + " END) AS BRANCH_CARD,"
				+ " nvl((SELECT 'CONTACTLESS' FROM ir121 WHERE px_ir121_crd_pgm = a.px_ir269_crd_pgm and FX_IR121_CRD_ID in(005, 006, 007, 008, '009')),'CONTACT') as IS_CONTACTLESS,"
				+ " (CASE"
				+ " WHEN (SELECT fx_ir121_crd_prd FROM ir121 WHERE px_ir121_crd_pgm = a.px_ir269_crd_pgm) = 'R' THEN 'STANDARD'"
				+ " WHEN (SELECT fx_ir121_crd_prd FROM ir121 WHERE px_ir121_crd_pgm = a.px_ir269_crd_pgm) = 'G' THEN 'GOLD'"
				+ " WHEN (SELECT fx_ir121_crd_prd FROM ir121 WHERE px_ir121_crd_pgm = a.px_ir269_crd_pgm) = 'W' THEN 'WORLD'"
				+ " WHEN (SELECT fx_ir121_crd_prd FROM ir121 WHERE px_ir121_crd_pgm = a.px_ir269_crd_pgm) = 'P' THEN 'PLATINUM'"
				+ " WHEN (SELECT fx_ir121_crd_prd FROM ir121 WHERE px_ir121_crd_pgm = a.px_ir269_crd_pgm) = 'B' THEN 'BUSSINESS'"
				+ " END) AS crd_product," + " (CASE"
				+ " WHEN (SELECT fx_ir121_pgm_desc FROM ir121 WHERE px_ir121_crd_pgm = a.px_ir269_crd_pgm) LIKE '%CBNV SCB%' THEN 'CBNV SCB'"
				+ " WHEN (SELECT fx_ir121_pgm_desc FROM ir121 WHERE px_ir121_crd_pgm = a.px_ir269_crd_pgm) LIKE '%STAFF%' THEN 'CBNV SCB'"
				+ " WHEN (SELECT fx_ir121_pgm_desc FROM ir121 WHERE px_ir121_crd_pgm = a.px_ir269_crd_pgm) LIKE '%LIEN KET%' THEN 'CTY CON-LK'"
				+ " WHEN (SELECT fx_ir121_pgm_desc FROM ir121 WHERE px_ir121_crd_pgm = a.px_ir269_crd_pgm) LIKE '%LK%' THEN 'CTY CON-LK'"
				+ " WHEN (SELECT f9_ir121_prfx FROM ir121 WHERE px_ir121_crd_pgm = a.px_ir269_crd_pgm) in('512454', '5471391', '5471390') THEN 'KHDN'"
				+ " ELSE 'KH THUONG'" + " END) AS cust_type,"
				+ " (SELECT trim(fx_ir121_pgm_desc) FROM ir121 WHERE px_ir121_crd_pgm = a.px_ir269_crd_pgm) AS pgm_desc,"
				+ " (CASE"
				+ " WHEN (SELECT count(*) FROM ir513 WHERE PX_IR513_CRD_PGM = a.px_ir269_crd_pgm and PX_IR513_FEE_TYP in('F01', 'F02')) = 0 THEN 'MIEN PHI PH' ELSE ' '"
				+ " END) AS MIEN_PHI_PH," + " (CASE"
				+ " WHEN (SELECT count(*) FROM ir513 WHERE PX_IR513_CRD_PGM = a.px_ir269_crd_pgm and PX_IR513_FEE_TYP in('F01')) >= 1 THEN 'THU PHI PH THUONG' ELSE ' '"
				+ " END) AS THUPHI_PH_THUONG," + " (CASE"
				+ " WHEN (SELECT count(*) FROM ir513 WHERE PX_IR513_CRD_PGM = a.px_ir269_crd_pgm and PX_IR513_FEE_TYP in('F02')) >= 1 THEN 'THU PHI PH NHANH' ELSE ' '"
				+ " END) AS THUPHI_PH_NHANH," + " (CASE"
				+ " WHEN (SELECT count(*) FROM ir513 WHERE PX_IR513_CRD_PGM = a.px_ir269_crd_pgm and PX_IR513_FEE_TYP in('F03')) >= 1 THEN 'THU PHI TN'"
				+ " WHEN (SELECT count(*) FROM ir513 WHERE PX_IR513_CRD_PGM = a.px_ir269_crd_pgm and PX_IR513_FEE_TYP in('F20')) >= 1 THEN 'MIEN PHI TN NAM DAU'"
				+ " ELSE 'MIEN PHI TN'" + " END) AS FEE_TN" + " FROM ccps.ir269 a, ccps.ir047 b"
				+ " WHERE a.px_ir269_campgn_cde = b.px_ir047_campgn_cde"
				+ " and a.px_ir269_src_cde not in('DM410', 'DM409', 'DM408') and fx_ir047_schm_cde <> 'SCH001')"
				+ " where trim(PX_IR269_CRD_PGM) = '111' and BRANCH_CARD like ('%222%')"
				+ " and CRD_PRODUCT like ('%333%') and CUST_TYPE like ('%444%')"
				+ " and IS_CONTACTLESS = '555' and MIEN_PHI_PH like ('%666%') and THUPHI_PH_THUONG like ('%777%') and FEE_TN = '888' order by PX_IR269_CRD_PGM";

		txt_cardType = txt_cardType.replaceAll(" ", "").toUpperCase();
		if (txt_cardType.equals("")) {
			sql = sql.replaceAll("= '111'", "LIKE('%%')");
		} else {
			sql = sql.replaceAll("111", txt_cardType);
		}
		sql = sql.replaceAll("222", ts_cardBranch);
		sql = sql.replaceAll("333", ts_hangThe);
		sql = sql.replaceAll("444", ts_loaiKhachHang);

		if (ts_isContactless.equals("")) {
			sql = sql.replaceAll("= '555'", "LIKE('%%')");
		} else {
			sql = sql.replaceAll("555", ts_isContactless);
		}

		if (ts_mienPhiPH.equals("")) {
			sql = sql.replaceAll("666", "");
			sql = sql.replaceAll("777", "");
		} else if (ts_mienPhiPH.equals("mienphiphathanh")) {
			sql = sql.replaceAll("666", "MIEN PHI PH");
			sql = sql.replaceAll("777", "");
		} else if (ts_mienPhiPH.equals("thuphiphathanhthuong")) {
			sql = sql.replaceAll("666", "");
			sql = sql.replaceAll("777", "THU PHI PH THUONG");
		} else if (ts_mienPhiPH.equals("thuphiphathanhnhanh")) {
			sql = sql.replaceAll("666", "");
			sql = sql.replaceAll("777", "");
		}

		if (ts_phiThuongNien.equals("")) {
			sql = sql.replaceAll("= '888'", "LIKE('%%')");
		} else {
			sql = sql.replaceAll("888", ts_phiThuongNien);
		}

		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		int count = list.size();
		if (count == 0) {
			return listThongSoEntity;
		} else {
			for (Map<String, Object> row : list) {
				ThongSoEntity ThongSoEntity = new ThongSoEntity();
				ThongSoEntity.setTs_cardType(String.valueOf(row.get("PX_IR269_CRD_PGM")));
				ThongSoEntity.setTs_sourceCode(String.valueOf(row.get("PX_IR269_SRC_CDE")));
				ThongSoEntity.setTs_promoCode(String.valueOf(row.get("PX_IR269_CAMPGN_CDE")));
				ThongSoEntity.setTs_schemeCode(String.valueOf(row.get("FX_IR047_SCHM_CDE")));
				ThongSoEntity.setTs_loaiKhachHang(String.valueOf(row.get("CUST_TYPE")));
				ThongSoEntity.setts_cardBranch(String.valueOf(row.get("BRANCH_CARD")));
				ThongSoEntity.setTs_hangThe(String.valueOf(row.get("CRD_PRODUCT")));
				ThongSoEntity.setTs_isContactless(String.valueOf(row.get("IS_CONTACTLESS")));
				ThongSoEntity.setTs_dienGiai(String.valueOf(row.get("PGM_DESC")));
				ThongSoEntity.setTs_mienPhiPH(String.valueOf(row.get("MIEN_PHI_PH")));
				ThongSoEntity.setts_thuPhiPHThuong(String.valueOf(row.get("THUPHI_PH_THUONG")));
				ThongSoEntity.setts_thuPhiPHNhanh(String.valueOf(row.get("THUPHI_PH_NHANH")));
				ThongSoEntity.setTs_phiThuongNien(String.valueOf(row.get("FEE_TN")));
				listThongSoEntity.add(ThongSoEntity);
			}
			return listThongSoEntity;
		}
	}
}
