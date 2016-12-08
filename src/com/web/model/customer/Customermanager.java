package com.web.model.customer;

import java.sql.SQLException;

import com.web.dbconn.CustomerDB;

public class Customermanager {
	public static CustomerDB db= new CustomerDB();
	public Customer getCustomer(int customer_id) throws SQLException 
	{
		return db.getCustomer(customer_id);
		
	}
	
	public Customer addcustomer(int customer_id, String customer_address, int customer_phone,String firstname,String lastname, int order_id) throws SQLException
	{
		return db.insertcustomer(customer_id, customer_address, customer_phone, firstname, lastname, order_id);
		
	}

	public void deletecustomerr(String fistname) throws SQLException
	{
		db.deletecustomer(fistname);

	}
	
	
}
