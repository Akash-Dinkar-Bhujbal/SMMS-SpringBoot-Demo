package com.cg.smms.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "shopOwner")
public class ShopOwner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AI
	private Integer shopOwnerId;

	private String phone;

	@OneToOne(cascade = CascadeType.ALL) // 1:1
	@JoinColumn(name = "userId") // FK
	private User user;

	@OneToOne(cascade = CascadeType.ALL) // 1:1
	@JoinColumn(name = "shopId") // FK
	private Shop shop;

	/* ------------------- GS------------------- */

	public Integer getShopOwnerId() {
		return shopOwnerId;
	}

	public void setShopOwnerId(Integer shopOwnerId) {
		this.shopOwnerId = shopOwnerId;
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

	@JsonBackReference
	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

//	@Override
//	public String toString() {
//		return "Admin [mallAdminId=" + shopOwnerId + ", phone=" + phone + ", user=" + user + "]";
//	}

}
