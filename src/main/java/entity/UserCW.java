package entity;

import java.io.Serializable;

public class UserCW implements Serializable {

	private String username;
	private String password;
	private String fullname;
	private Byte usercount;
	private String userLevel;
	private String groupId;
	private String userId;
	private String branch;
	private String emailKH;
	private String cif;
	private String sdt;

	public void DisputesUsers(String username, String password, String fullname, Byte usercount) {
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.usercount = usercount;
	}

	public String getEmailKH() {
		return emailKH;
	}

	public void setEmailKH(String emailKH) {
		this.emailKH = emailKH;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getEmail() {
		return emailKH;
	}

	public void setEmail(String emailKH) {
		this.emailKH = emailKH;
	}

	public void DisputesUsers() {
	}

	public void DisputesUsers(String username) {
		this.username = username;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String pass) {
		this.password = pass;
	}

	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Byte getUsercount() {
		return this.usercount;
	}

	public void setUsercount(Byte usercount) {
		this.usercount = usercount;
	}

	public String getUserLevel() {
		return this.userLevel;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}
}
