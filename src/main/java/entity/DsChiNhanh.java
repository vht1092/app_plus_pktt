package entity;

import java.io.Serializable;

public class DsChiNhanh implements Serializable {

	private String maCN;
	private String tenCN;

	public String getMaCN() {
		return maCN;
	}

	public void setMaCN(String maCN) {
		this.maCN = maCN;
	}

	public String getTenCN() {
		return tenCN;
	}

	public void setTenCN(String tenCN) {
		this.tenCN = tenCN;
	}
}
