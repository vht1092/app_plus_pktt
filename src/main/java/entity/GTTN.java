package entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class GTTN implements Serializable {

	private String ngayPhatHanh;
	private String tenKhachHang;
	private String soThe;
	private String loc;
	private String cif;
	private String loaiHinhPhatHanh;
	private String userId;
	private String userDuyet;
	private String maDonViUser;
	private String maDonViThe;
	private String fwBranch;

	public String getFwBranch() {
		return fwBranch;
	}

	public void setFwBranch(String fwBranch) {
		this.fwBranch = fwBranch;
	}

	public String getNgayPhatHanh() {
		return ngayPhatHanh;
	}

	public void setNgayPhatHanh(String ngayPhatHanh) {
		this.ngayPhatHanh = ngayPhatHanh;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getSoThe() {
		return soThe;
	}

	public void setSoThe(String soTHe) {
		this.soThe = soTHe;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getLoaiHinhPhatHanh() {
		return loaiHinhPhatHanh;
	}

	public void setLoaiHinhPhatHanh(String loaiHinhPhatHanh) {
		this.loaiHinhPhatHanh = loaiHinhPhatHanh;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMaDonViUser() {
		return maDonViUser;
	}

	public void setMaDonViUser(String maDonViUser) {
		this.maDonViUser = maDonViUser;
	}

	public String getMaDonViThe() {
		return maDonViThe;
	}

	public void setMaDonViThe(String maDonViThe) {
		this.maDonViThe = maDonViThe;
	}

	public String getuserDuyet() {
		return userDuyet;
	}

	public void setuserDuyet(String userDuyet) {
		this.userDuyet = userDuyet;
	}
}
