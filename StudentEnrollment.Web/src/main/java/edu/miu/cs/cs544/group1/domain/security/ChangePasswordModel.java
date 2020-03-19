package edu.miu.cs.cs544.group1.domain.security;

import javax.validation.constraints.NotBlank;

public class ChangePasswordModel {
	private String oldPwd;
	@NotBlank
	private String newPwd;
	@NotBlank
	private String confirmPwd;
	public String getOldPwd() {
		return oldPwd;
	}
	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}
	public String getNewPwd() {
		return newPwd;
	}
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	public String getConfirmPwd() {
		return confirmPwd;
	}
	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}
	
}
