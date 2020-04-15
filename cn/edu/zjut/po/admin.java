package cn.edu.zjut.po;

import java.io.Serializable;

public class admin implements Serializable{
	private int adminID;
	private String account;
	private String password;
	private int power;//权限等级（1级可以创建管理员，2级不可以)
	public int getAdminID() {
		return adminID;
	}
	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	@Override
	public String toString() {
		return "admin [adminID=" + adminID + ", account=" + account + ", password=" + password + ", power=" + power
				+ "]";
	}
	
}
