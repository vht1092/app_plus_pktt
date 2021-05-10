package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.EnumSet;
import java.util.Set;

public class Common {
	public String formatTime(String txtDate) {
		txtDate = txtDate.replaceAll("-", "");
		String day = txtDate.substring(0, 2);
		String month = txtDate.substring(2, 4);
		String year = txtDate.substring(4, 8);
		return year + month + day;
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

	public int TruThoiGian(String dateStart) throws ParseException {
		String KQ = null;
		// Lay ngay gio hien tai
		LocalDateTime now = LocalDateTime.now();
		int year = now.getYear();
		int month = now.getMonthValue();
		int day = now.getDayOfMonth();
		int hour = now.getHour();
		int minute = now.getMinute();
		int second = now.getSecond();

		String dateStop = _formatTime(month) + "/" + _formatTime(day) + "/" + String.valueOf(year) + " "
				+ _formatTime(hour) + ":" + _formatTime(minute) + ":" + _formatTime(second);

		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

		Date d1 = null;
		Date d2 = null;

		d1 = format.parse(dateStart);
		d2 = format.parse(dateStop);

		// in milliseconds
		long diff = d2.getTime() - d1.getTime();
		// long diffSeconds = diff / 1000 % 60;
		// long diffMinutes = diff / (60 * 1000) % 60;
		// long diffHours = diff / (60 * 60 * 1000) % 24;
		long diffDays = diff / (24 * 60 * 60 * 1000);

		return Integer.parseInt(String.valueOf(diffDays));
	}

	public int tinhSoNgayLamViec(LocalDate toDate, LocalDate fromDate) {
		int count = 0;
		Set<DayOfWeek> weekend = EnumSet.of(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY);
		LocalDate ld = toDate;
		while (ld.isBefore(fromDate)) {
			if (!weekend.contains(ld.getDayOfWeek())) {
				count++;
			}
			ld = ld.plusDays(1);
		}
		return count;
	}
}
