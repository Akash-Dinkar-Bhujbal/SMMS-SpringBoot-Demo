package com.cg.smms.entities;

import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@SuppressWarnings("unused")
@Entity
@Table(name = "shop")
public class Shop {

	@Id // PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AI

	private Integer shopId;
	private String shopCategory;
	private String shopName;
	private String shopStatus;
	private String leaseStatus;

	@OneToOne(mappedBy = "shop") // 1:1
	private ShopOwner shopOwner;

	@OneToMany(mappedBy = "shop", cascade = CascadeType.ALL) // 1:M
	private List<Employee> employee = new ArrayList<>();// employee

	@OneToMany(mappedBy = "shop", cascade = CascadeType.ALL) // 1:M
	private List<Item> items = new ArrayList<>();// items
//
//	@OneToMany(mappedBy = "shop", cascade = CascadeType.ALL) // 1:M
//	private List<Order> orders = new ArrayList<>();// orders

	@OneToMany(mappedBy = "shop", cascade = CascadeType.ALL) // 1:M
	private List<Customer> customer = new ArrayList<>();// customers

//	@ManyToOne // M:1
//	@JoinColumn(name = "mallId") // FK
//	private Mall mall;

	/* ------------------- GS------------------- */

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public String getShopCategory() {
		return shopCategory;
	}

	public void setShopCategory(String shopCategory) {
		this.shopCategory = shopCategory;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopStatus() {
		return shopStatus;
	}

	public void setShopStatus(String shopStatus) {
		this.shopStatus = shopStatus;
	}

	public String getLeaseStatus() {
		return leaseStatus;
	}

	public void setLeaseStatus(String leaseStatus) {
		this.leaseStatus = leaseStatus;
	}

	@JsonManagedReference
	public ShopOwner getShopOwner() {
		return shopOwner;
	}

	public void setShopOwner(ShopOwner shopOwner) {
		this.shopOwner = shopOwner;
	}

	@JsonBackReference
	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	@JsonBackReference
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

//	@JsonBackReference
//	public List<Order> getOrders() {
//		return orders;
//	}
//
//	public void setOrders(List<Order> orders) {
//		this.orders = orders;
//	}

	@JsonBackReference
	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}
//
//	@JsonManagedReference
//	public Mall getMall() {
//		return mall;
//	}
//
//	public void setMall(Mall mall) {
//		this.mall = mall;
//	}

//	@Override
//	public String toString() {
//		return "Shop [shopId=" + shopId + ", shopCategory=" + shopCategory + ", shopName=" + shopName + ", shopStatus="
//				+ shopStatus + ", leaseStatus=" + leaseStatus + ", shopOwner=" + shopOwner + ", employee=" + employee
//				+ ", items=" + items + ", orders=" + orders + ", customer=" + customer + ", mall=" + mall + "]";
//	}

}
