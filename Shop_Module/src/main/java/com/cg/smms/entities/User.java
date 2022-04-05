package com.cg.smms.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "user")
public class User {

	@Id // PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AI
	private Integer userId;

	private String name;
	private String type;
	private String password;

	@OneToOne(mappedBy = "user") // 1:1
	private Customer customer;

	@OneToOne(mappedBy = "user") // 1:1
	private ShopOwner shopOwner;

//	@OneToOne(mappedBy = "user") // 1:1
//	private MallAdmin mallAdmin;

	/* ------------------- GS------------------- */

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@JsonBackReference
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@JsonBackReference
	public ShopOwner getShopOwner() {
		return shopOwner;
	}

	public void setShopOwner(ShopOwner shopOwner) {
		this.shopOwner = shopOwner;
	}

//	@JsonBackReference
//	public MallAdmin getMallAdmin() {
//		return mallAdmin;
//	}
//
//	public void setMallAdmin(MallAdmin mallAdmin) {
//		this.mallAdmin = mallAdmin;
//	}

//	@Override
//	public String toString() {
//		return "User [userId=" + userId + ", name=" + name + ", type=" + type + ", password=" + password + "]";
//	}

}
