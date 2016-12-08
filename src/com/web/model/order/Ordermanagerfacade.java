package com.web.model.order;


import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.web.dbconn.OrderDB;
import com.web.dbconn.ProductDB;
import com.web.model.product.Product;

public class Ordermanagerfacade extends OrderDB {

 /*
	public Order goOrder(String orderID)
	{

		OrderDB connect = new OrderDB();
		Order ord = connect.searchorder(orderID);
		return ord;

	}*/
	public Order addOrder(int orser_id,String status, 
			 int customerid)
	{
	
		Order product = new Order();
		product.setOrderID(orser_id);
		product.setCustomerid(customerid);
		product.setOrderStatus(status);
	//String st= OrderDB.
		//return null;
		return product;
		
	}
	public Set<Order> getAllOrderss() throws SQLException 
	{
		
		Set<Order> order = new HashSet<Order>();
		OrderDB con = new OrderDB();
		order = con.getAllOrders();
		return order;
	}
	public Order getOrder(int id) {
		OrderDB con = new OrderDB();
		return con.getOrder(id);
	}
	
	public Order getorderstatus(int id)
	{		OrderDB con = new OrderDB();
	return con.getOrder(id);
	}
	public Order cancelorder(int id)
	{
		OrderDB con = new OrderDB();
return con.deleteorder(id);
	}
	
	
}



