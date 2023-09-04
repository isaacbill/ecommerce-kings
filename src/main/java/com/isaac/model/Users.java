package com.isaac.model;

import java.time.LocalDateTime;

public class Users {
	
	private long id;
	private String firstname;
	private String lastname;
	private String email;
	private long phonenumber;
	private String password;
	private String passwordResetToken;
    private LocalDateTime passwordResetTokenExpiration;
    
	
	public Users(long id, String firstname, String lastname, String email, long phonenumber, String password,
			String passwordResetToken, LocalDateTime passwordResetTokenExpiration) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phonenumber = phonenumber;
		this.password = password;
		this.passwordResetToken = passwordResetToken;
		this.passwordResetTokenExpiration = passwordResetTokenExpiration;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordResetToken() {
		return passwordResetToken;
	}
	public void setPasswordResetToken(String passwordResetToken) {
		this.passwordResetToken = passwordResetToken;
	}
	public LocalDateTime getPasswordResetTokenExpiration() {
		return passwordResetTokenExpiration;
	}
	public void setPasswordResetTokenExpiration(LocalDateTime passwordResetTokenExpiration) {
		this.passwordResetTokenExpiration = passwordResetTokenExpiration;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", phonenumber=" + phonenumber + ", password=" + password + ", passwordResetToken="
				+ passwordResetToken + ", passwordResetTokenExpiration=" + passwordResetTokenExpiration + "]";
	}
	
	

}
