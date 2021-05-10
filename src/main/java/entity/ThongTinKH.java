package entity;

import java.io.Serializable;

public class ThongTinKH implements Serializable {

	private String hoTen;
	private String loc;
	private String cif;
	private String cardProgram;

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
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

	public String getcardProgram() {
		return cardProgram;
	}

	public void setcardProgram(String cardProgram) {
		this.cardProgram = cardProgram;
	}
}
