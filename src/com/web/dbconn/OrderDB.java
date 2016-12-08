package com.web.dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;















import javax.mail.search.OrTerm;

import com.web.model.order.Order;
import com.web.model.product.Product;

public class OrderDB extends CommonDB {
	
	
	private static String dbUrl = "jdbc:mysql://localhost:3306/lastcart";
	private static String dbUsername = "Shefali";
	private static String dbPassword = "shefali123";
	private static Statement statement = null;
	private static Set<Order> orders = new HashSet<Order>();
	public OrderDB()
	{
		Order db = new Order();
		db.setCustomerid(11);
		db.setOrderID(111);
		db.setOrderStatus("shipped");
		orders.add(db);
	}

public Order addorder(int id,int pcidname,String status)
{

Order proo = new Order();
String sql3 = "INSERT INTO orderr  (orderid, customerid, orderstatus )values( ?,?,?);";
String select="Select * from orderr where orderr= ?";
    Statement stm = null;
    Connection connection= super.getConnection();
   

try{




stm = connection.createStatement();
PreparedStatement psta = (PreparedStatement)connection.prepareStatement(sql3);
psta.setInt(1, id);
psta.setInt(2, pcidname);
psta.setString(3, "status");

psta.executeUpdate();
PreparedStatement prr= (PreparedStatement)connection.prepareStatement(select);
ResultSet rs1= psta.executeQuery();


System.out.println("Inserting records into the table...");

proo.setOrderID(rs1.getInt(1));
proo.setCustomerid(rs1.getInt(2));
proo.setOrderStatus(rs1.getString(3));



} 
catch (SQLException  ex) {



	   // handle any errors

	   System.out.println("SQLException: " + ex.getMessage());

	   //System.out.println("SQLState: " + ((SQLException) ex).getSQLState());

	  // System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());

	}
return proo;
}


	
	
	
	public Set<Order> getAllOrders() throws SQLException {
		
			String getquery = "SELECT orderid, orderstatus, customerid from orderr;";
			Connection connection = super.getConnection();
			Statement stmt = null;
			try{
				stmt = connection.createStatement();
				PreparedStatement pp =(PreparedStatement)connection.prepareStatement(getquery);
				ResultSet resultset3 = pp.executeQuery();
				
				while (resultset3.next()) {
		            for (int i = 1; i < resultset3.getMetaData().getColumnCount() + 1; i++) {
		              orders.add((Order)resultset3.getObject(i));
		            }
				}
			}
		 catch (SQLException e) {
			System.out.println(e.toString());
		}
		

		return orders;
	}
	
	
	
	
		

/*	public Order getOrder(int orderID)    {
		Order product = new Order();
		String query3 = "select * from orderr where orderid= "+orderID ;
		Connection connection = super.getConnection();
		Statement stmt = null;
		try
		{
			stmt=connection.createStatement();
			PreparedStatement pp= (PreparedStatement)connection.prepareStatement(query3);
			pp.setInt(1, orderID);
			//pp.setInt(1, productID);
			ResultSet rs= stmt.executeQuery(query3);
			
			//ResultSet result1 = null;
			//result1 = statement.executeQuery(query3);
		
		if(rs.next())
		{
			product.setOrderID(rs.getInt(1));
			System.out.println("order id is "+ rs.getInt(1));
			product.setCustomerid(rs.getInt(2));
			//System.out.println("name is "+rs.getString(2)());

			product.setOrderStatus(rs.getString(3));
			//System.out.println("price is "+pd.getUnitPrice());
			//product.setProductDescription(rs.getString(4));
			//System.out.println("desp  is"+product.getProductDescription());
			
			
			//product.setProductQty(rs.getInt(5));
			//System.out.println("price is "+pd.getProductQty());
			//products.add(product);
			//System.out.println("products is "+products.size());
			



			
		}
		stmt.close();
		rs.close();
		}
		catch (SQLException ex) {



			   // handle any errors

			   System.out.println("SQLException: " + ex.getMessage());

			   //System.out.println("SQLState: " + ((SQLException) ex).getSQLState());

			  // System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());

			}
		return product;

	}
	*/
	public Order getstatus(int orderid)

	{Order proo = new Order();

		String st= null;
		String  getquery="select orderstatus from orderr where orderid=?" ;
		Connection con = super.getConnection();
		Statement stm = null;
		try
		{
			stm=con.createStatement();
			//PreparedStatement pp= connection.prepareStatement(query3);
			//pp.setInt(1, productID);
			ResultSet rs= stm.executeQuery(getquery);
			
			//ResultSet result1 = null;
			/*stm= con.createStatement();
			
			PreparedStatement pre = (PreparedStatement)con.prepareStatement(getquery);
			pre.setInt(1, orderid);
			ResultSet rs = pre.executeQuery();
			st= rs.getString(1);
			
			*/
			if(rs.next())
			{
				proo.setOrderID(rs.getInt(1));
				System.out.println("order id is "+ rs.getInt(1));
				//order.setCustomerid(rs.getInt(2));
				//order.setOrderStatus(rs.getString(3));
				//product.setProductDescription(rs.getString(4));}\
			}
				
			
		}
		catch(SQLException e)
		{
			System.out.println(e.toString());
			
		}
		return proo;
	
	}
	public Order deleteorder(int id)
	{
		
		
		Order proo = new Order();

		String st= null;
		String  getquery="delete orderid from orderr where orderid=?";
		Connection con = super.getConnection();
		Statement stm = null;
		
		try
		{
			stm=con.createStatement();
			//PreparedStatement pp= connection.prepareStatement(query3);
			//pp.setInt(1, productID);
			ResultSet rs= stm.executeQuery(getquery);
			
			if(rs.next())
			{
				proo.setOrderID(rs.getInt(1));
				System.out.println("order id is "+ rs.getInt(1));
				//order.setCustomerid(rs.getInt(2));
				//order.setOrderStatus(rs.getString(3));
				//product.setProductDescription(rs.getString(4));}\
			}
			
		}
		catch(SQLException e)
		{
			System.out.println(e.toString());
			
		}
		return proo;
			
		}
	
	
	public Order getOrder(int orderid)    {
		Order order = new Order();
		String query3 = "select orderid,customerid,orderstatus from orderr where orderid="+orderid ;
		Connection connection = super.getConnection();
		Statement stmt = null;
		try
		{
			stmt=connection.createStatement();
			//PreparedStatement pp= connection.prepareStatement(query3);
			//pp.setInt(1, productID);
			ResultSet rs= stmt.executeQuery(query3);
			
			//ResultSet result1 = null;
			//result1 = statement.executeQuery(query3);
		
		if(rs.next())
		{
			order.setOrderID(rs.getInt(1));
			System.out.println("order id is "+ rs.getInt(1));
			order.setCustomerid(rs.getInt(2));
			order.setOrderStatus(rs.getString(3));
			//product.setProductDescription(rs.getString(4));
			
			
			
			//product.setProductQty(rs.getInt(5));
			



			
		}
		stmt.close();
		rs.close();
		}
		catch (SQLException ex) {



			   // handle any errors

			   System.out.println("SQLException: " + ex.getMessage());

			   //System.out.println("SQLState: " + ((SQLException) ex).getSQLState());

			  // System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());

			}
		return order;

	}
}
	
	
	
	
	
	
	
	

