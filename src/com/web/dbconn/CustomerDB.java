package com.web.dbconn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.web.model.customer.Customer;

public class CustomerDB extends CommonDB{
private static Connection con= null;
private static PreparedStatement pp= null;
	public CustomerDB()
	{
		super();
		
	}
	
	public Customer insertcustomer(int idd, String  address, int phone, String fnamee, String lastnamee, int orderid) throws SQLException
	{
	String quert="insert into customer (customer_id,customer_address,customer_phone,firstmane,lastname,order_id) values(?,?,?,?,?,?)";	
Connection connect = getConnection();
Customer custt= new Customer();
custt.setCustomerID(idd);
custt.setCustomerAddress(address);
custt.setCustomerPhone(phone);
custt.setOrderid(orderid);

pp= con.prepareStatement(quert);
pp.setInt(1, custt.getCustomerID());
pp.setString(2, custt.getCustomerAddress());
pp.setInt(3, custt.getCustomerPhone());
pp.setString(4, custt.getFirstName());
pp.setString(5, custt.getLastName());
pp.setInt(6, custt.getOrderid());
pp.executeUpdate();






		
		
		return custt;
		
	}
	
	
	
	
	
	
	
	public Customer getCustomer(int id) throws SQLException
	{
		String query3 = "select customer_id,customer_address,customer_phone,firstmane,lastname,order_id from customer where Customer_id= "+id + " ;" ;
		con = super.getConnection();
		//Statement stmt = null;
		
			pp=(PreparedStatement)con.prepareStatement(query3);
			PreparedStatement pp= con.prepareStatement(query3);
			//pp.setInt(1, productID);
			ResultSet rs= pp.executeQuery(query3);
			Customer cusss= new Customer();
			
			//ResultSet result1 = null;
			//result1 = statement.executeQuery(query3);
		
		if(rs.next())
		{
			cusss.setCustomerID(rs.getInt(1));
			System.out.println("customer id is "+ rs.getInt(1));
			cusss.setCustomerAddress(rs.getString(2));
			//System.out.println("name is "+rs.getString(2)());

			cusss.setCustomerPhone(rs.getInt(3));
			//System.out.println("price is "+pd.getUnitPrice());
			cusss.setFirstName(rs.getString(4));
			//System.out.println("desp  is"+product.getProductDescription());
			cusss.setLastName(rs.getString(5));
			cusss.setOrderid(rs.getInt(6));

			
		}			//System.out.println("price is "+pd.getProductQty());
			//products.add(product);
			//System.out.println("products is "+products.size());
			
		
		
		return cusss;
		
	}
	 public void deletecustomer(String firstname) throws SQLException
	 {
		 String delete= "delete from customer where customer_id=  " + firstname+";";
		 pp=(PreparedStatement)con.prepareStatement(delete);
		 pp.executeUpdate();
		 
	 }
}
