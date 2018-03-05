package net.codejava.hibernate.dto;

import javax.persistence.Entity; //Instead of using hibernate api we'll use persistence api
import javax.persistence.Id;

@Entity
public class UserDetails {
	@Id
	private int userId;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	private String userName;
}
