package com.cg.smms.entities;

import java.util.*;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@SuppressWarnings("unused")
@Entity
@Table(name = "customer")
public class Customer {

	@Id // PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AI
	private Integer customerId;

	private String phone;
	private String email;

//	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL) // 1:M
//	private List<Order> orders = new ArrayList<>();// order

	@OneToOne(cascade = CascadeType.ALL) // 1:1
	@JoinColumn(name = "userId") // FK
	private User user;

	@ManyToOne // M:1
	@JoinColumn(name = "shop_id") // FK
	private Shop shop;

	/* ------------------- GS------------------- */

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

//	@JsonBackReference
//	public List<Order> getOrders() {
//		return orders;
//	}
//
//	public void setOrders(List<Order> orders) {
//		this.orders = orders;
//	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@JsonManagedReference
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@JsonManagedReference
	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

//	@Override
//	public String toString() {
//		return "Customer [customerId=" + customerId + ", orders=" + orders + ", phone=" + phone + ", email=" + email
//				+ ", user=" + user + ", shop=" + shop + "]";
//	}

}
