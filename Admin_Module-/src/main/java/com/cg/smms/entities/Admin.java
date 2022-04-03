package com.cg.smms.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
//@Table(name = "mallAdmin")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AI
	private Integer mallAdminId;

	private String phone;

	@OneToOne(cascade = CascadeType.ALL) // 1:1
	@JoinColumn(name = "userId") // FK
	private User user;

	/* ------------------- GS------------------- */

	public Integer getMallAdminId() {
		return mallAdminId;
	}

	public void setMallAdminId(Integer mallAdminId) {
		this.mallAdminId = mallAdminId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@JsonManagedReference
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Admin [mallAdminId=" + mallAdminId + ", phone=" + phone + ", user=" + user + "]";
	}

}
