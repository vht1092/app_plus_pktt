package dao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import controller.Common;
import entity.DsChiNhanh;
import entity.GTTN;
import entity.UserCW;
import entity.CardReplace;

@Repository
public class GttnDAO extends JdbcDaoSupport {

	@Autowired
	public GttnDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	public void update_DB_GTTN(String input_4SoCuoiThe, String input_SoLoc, String input_TinhTrang) {
		GTTN theGiaoTanNoi = new GTTN();
		String sql = "select PAN from fpt.ppt_emb_card_detail where SUBSTR(PANMASK, 13, 4) = 'input_4SoCuoiThe' and LOC = 'input_SoLoc'";
		sql = sql.replaceAll("input_4SoCuoiThe", input_4SoCuoiThe);
		sql = sql.replaceAll("input_SoLoc", input_SoLoc);

		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		int count = list.size();

		if (count == 0) {
			return;
		} else {
			for (Map<String, Object> row : list) {
				String _pan = String.valueOf(row.get("PAN"));
				theGiaoTanNoi.setSoThe(_pan);
				break;
			}
		}

		Common common = new Common();
		String updateSql = "update fpt.ppt_crd_detail set GTTN = 'input_TinhTrang', TIME_GTTN = 'input_ThoiGian' where PAN = 'input_SoThe'";
		updateSql = updateSql.replaceAll("input_TinhTrang", input_TinhTrang);
		updateSql = updateSql.replaceAll("input_ThoiGian", String.valueOf(common.get_SystemTime()));
		updateSql = updateSql.replaceAll("input_SoThe", theGiaoTanNoi.getSoThe());
		getJdbcTemplate().update(updateSql);
		return;
	}
}
