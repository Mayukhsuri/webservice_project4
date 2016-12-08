package com.web.model.customer;

import java.util.ArrayList;
import java.util.List;

import com.web.model.link.Link;



public class Customer {
	
	private int customerID;
	private String customerAddress;
	private int customerPhone;
	private int orderid;
	private String FirstName;
	private String LastName;
	private List <Link> links= new ArrayList<>();
	
	
	public Customer()
	{
		
	}
	public Customer(int id,String add, int phone, int ordd, String fname, String lname )
	{
		this.customerID= id;
		this.customerAddress=add;
		this.customerPhone=phone;
		this.orderid=ordd;
		this.FirstName=fname;
		this.LastName=lname;
		
		
	}
	
	
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public int getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(int customerPhone) {
		this.customerPhone = customerPhone;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
}

