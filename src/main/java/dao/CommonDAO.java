package dao;

import java.time.LocalDateTime;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class CommonDAO extends JdbcDaoSupport {

	@Autowired
	public CommonDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	public String maHoaSoThe(String cardno) {
		String sql = "select ecd2('111', '') from dual";
		sql = sql.replaceAll("111", cardno);
		return getJdbcTemplate().queryForObject(sql, String.class);
	}

	public String checkCardBrand(String cardno) {
		String sql = "select trim(b.FX_IR121_CONTCLESS_SERV_CDE) from IR025@im a, IR121@im b"
				+ " where PX_IR025_PAN = '111' and trim(a.FX_IR025_CRD_PGM) = trim(b.PX_IR121_CRD_PGM)";
		sql = sql.replaceAll("111", cardno);

		String cardBrand = null;
		try {
			cardBrand = String.valueOf(getJdbcTemplate().queryForObject(sql, String.class));
		} catch (Exception e) {
			// cardBrand = null
		}
		return cardBrand;
	}

	public long get_SystemTime() {
		LocalDateTime now = LocalDateTime.now();
		int year = now.getYear();
		int month = now.getMonthValue();
		int day = now.getDayOfMonth();
		int hour = now.getHour();
		int minute = now.getMinute();
		int second = now.getSecond();
		String ngay_gio_nhap = "";
		ngay_gio_nhap = String.valueOf(year) + _formatTime(month) + _formatTime(day) + _formatTime(hour)
				+ _formatTime(minute) + _formatTime(second);
		return Long.parseLong(ngay_gio_nhap);
	}

	public static String _formatTime(int n) {
		String temp = String.valueOf(n);
		if (n >= 1 && n <= 9) {
			temp = "0" + String.valueOf(n);
		}
		return temp;
	}
}