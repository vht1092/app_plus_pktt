package entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class ThongSoEntity implements Serializable {

	private String ts_cardType;
	private String ts_sourceCode;
	private String ts_promoCode;
	private String ts_schemeCode;
	private String ts_loaiKhachHang;
	private String ts_cardBranch;
	private String ts_hangThe;
	private String ts_isContactless;
	private String ts_dienGiai;
	private String ts_mienPhiPH;
	private String ts_thuPhiPHThuong;
	private String ts_thuPhiPHNhanh;
	private String ts_phiThuongNien;

	public String getTs_cardType() {
		return ts_cardType;
	}

	public void setTs_cardType(String ts_cardType) {
		this.ts_cardType = ts_cardType;
	}

	public String getTs_sourceCode() {
		return ts_sourceCode;
	}

	public void setTs_sourceCode(String ts_sourceCode) {
		this.ts_sourceCode = ts_sourceCode;
	}

	public String getTs_promoCode() {
		return ts_promoCode;
	}

	public void setTs_promoCode(String ts_promoCode) {
		this.ts_promoCode = ts_promoCode;
	}

	public String getTs_schemeCode() {
		return ts_schemeCode;
	}

	public void setTs_schemeCode(String ts_schemeCode) {
		this.ts_schemeCode = ts_schemeCode;
	}

	public String getTs_loaiKhachHang() {
		return ts_loaiKhachHang;
	}

	public void setTs_loaiKhachHang(String ts_loaiKhachHang) {
		this.ts_loaiKhachHang = ts_loaiKhachHang;
	}

	public String getts_cardBranch() {
		return ts_cardBranch;
	}

	public void setts_cardBranch(String ts_cardBranch) {
		this.ts_cardBranch = ts_cardBranch;
	}

	public String getTs_hangThe() {
		return ts_hangThe;
	}

	public void setTs_hangThe(String ts_hangThe) {
		this.ts_hangThe = ts_hangThe;
	}

	public String getTs_isContactless() {
		return ts_isContactless;
	}

	public void setTs_isContactless(String ts_isContactless) {
		this.ts_isContactless = ts_isContactless;
	}

	public String getTs_dienGiai() {
		return ts_dienGiai;
	}

	public void setTs_dienGiai(String ts_dienGiai) {
		this.ts_dienGiai = ts_dienGiai;
	}

	public String getTs_mienPhiPH() {
		return ts_mienPhiPH;
	}

	public void setTs_mienPhiPH(String ts_mienPhiPH) {
		this.ts_mienPhiPH = ts_mienPhiPH;
	}

	public String getts_thuPhiPHThuong() {
		return ts_thuPhiPHThuong;
	}

	public void setts_thuPhiPHThuong(String ts_thuPhiPHThuong) {
		this.ts_thuPhiPHThuong = ts_thuPhiPHThuong;
	}

	public String getts_thuPhiPHNhanh() {
		return ts_thuPhiPHNhanh;
	}

	public void setts_thuPhiPHNhanh(String ts_thuPhiPHNhanh) {
		this.ts_thuPhiPHNhanh = ts_thuPhiPHNhanh;
	}

	public String getTs_phiThuongNien() {
		return ts_phiThuongNien;
	}

	public void setTs_phiThuongNien(String ts_phiThuongNien) {
		this.ts_phiThuongNien = ts_phiThuongNien;
	}

}
