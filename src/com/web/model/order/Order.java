package com.web.model.order;

import com.web.model.product.Product;



public class Order {

	private int orderID;
	private int customerid;
	private String orderStatus;
	
	public Order(int orderID, int customerid,  String orderStatus 
			) {
		
		this.orderID = orderID;
		this.customerid = customerid;
		this.orderStatus = orderStatus;
		
	}
	public Order()
	{
		super();
		this.orderID = orderID;
		this.customerid = customerid;
		this.orderStatus = orderStatus;
		
	}

	public int getOrderID() {
		return orderID;
	}
	public int setOrderID(int orderID) {
		return this.orderID = orderID;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customer) {
		this.customerid = customer;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
}
