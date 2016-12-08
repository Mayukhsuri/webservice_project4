package com.web.dbconn;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.management.Query;

import com.web.model.product.*;
import com.web.dbconn.*;

public class ProductDB extends CommonDB{
	
	
	private static String dbUrl = "jdbc:mysql://localhost:3306/lastcart";
	private static String dbUsername = "Shefali";
	private static String dbPassword = "shefali123";
	private static Set<Product> products = new HashSet<Product>();

	public ProductDB() {
		// TODO Auto-generated constructor stub
	super();
	} 
	//private static Statement statement = null;

	public Set<Product >searchProduct(String product_name){
	products.clear();
	String searchquery= "Select * from product where Product_name like '%"+product_name+"%';";
	Connection connection = super.getConnection();
	Statement stm= null;
	
	
		
	
		try {
			
			stm = connection.createStatement();
			ResultSet result = stm.executeQuery(searchquery);
			
		   
			while(result.next())
			{
				Product pd = new Product();
				System.out.println("Inserting records into the table...");
				
				pd.setProductID(result.getInt(1));
				System.out.println("product id is "+ pd.getProductID());
				pd.setProduct_name(result.getString(2));
				System.out.println("name is "+pd.getProduct_name());

				pd.setUnitPrice(result.getFloat(3));
				System.out.println("price is "+pd.getUnitPrice());
				pd.setProductDescription(result.getString(4));
				System.out.println("desp  is"+pd.getProductDescription());
				
				
				pd.setProductQty(result.getInt(5));
				System.out.println("price is "+pd.getProductQty());
				products.add(pd);
				System.out.println("products is "+products.size());
				




			}
stm.close();result.close();

		} catch(SQLException e) {
			System.err.print(e.toString());
		} 
		super.closeConnection(connection);
		System.out.println("products is "+products.size());



		
		return products;
	}
	
	public Product addproduct(int id,String pname,Float price,  String desp,  int quant)

	{

	Product proo = new Product();
	String sql3 = "INSERT INTO Product  ('product_id','product_name','unit_price','product_Description','Product_quantity')values(?,?,?,?,?);";
String select="Select * from Product where Product_id= ?";
	    Statement stm = null;
	    Connection connection= super.getConnection();
	   

	try{

	


	stm = connection.createStatement();
	PreparedStatement psta = (PreparedStatement)connection.prepareStatement(sql3);
	psta.setInt(1, id);
	psta.setString(2, "pname");
	psta.setFloat(3, price);
	psta.setString(4, "desp");
	psta.setInt(5,quant);
	psta.executeUpdate();
	PreparedStatement prr= (PreparedStatement)connection.prepareStatement(select);
	ResultSet rs1= psta.executeQuery();
	

	System.out.println("Inserting records into the table...");
	
	proo.setProductID(rs1.getInt(1));
	proo.setProduct_name(rs1.getString(2));
	proo.setUnitPrice(rs1.getFloat(3));
	proo.setProductDescription(rs1.getString(4));
	proo.setProductQty(rs1.getInt(5));
	stm.close();
	
	
	}
	
	

	
	

	catch (SQLException  ex) {



	   // handle any errors

	   System.out.println("SQLException: " + ex.getMessage());

	   //System.out.println("SQLState: " + ((SQLException) ex).getSQLState());

	  // System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());

	}
	return proo;


	}

	
	/*public Set<Product> fetchAllProducts(){
		try
		{
			Class.forName("com.mysql.jdbc.Driver");

			Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

			statement = connection.createStatement();

			ResultSet resultset3 = null;

			
			String hql = "from product ";
			resultset3 = statement.executeQuery(hql);
			

			
			while (resultset3.next()) {
				Product product = new Product();                        //needs to create a new Product Object for every loop, other wise all the "products" will have the same hashcode and thus be considered the same object
				product.setProductID(resultset3.getInt("Product_id"));
				product.setProductDescription(resultset3.getString("Product_Description"));
				product.setUnitPrice(resultset3.getFloat("Unit_Price"));
				product.setProduct_name(resultset3.getString("Product_name"));
				product.setProductQty(resultset3.getInt("product_quantity"));

				products.add(product);
				System.out.println("Records fetched");
				//return  products;  

			}
		}
		
			
		catch (SQLException | ClassNotFoundException ex) {



			   // handle any errors

			   System.out.println("SQLException: " + ex.getMessage());

			   //System.out.println("SQLState: " + ((SQLException) ex).getSQLState());

			  // System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());

			}
		return products;
		
		

			 

		
	}	
	*/
	
	
	
	
	public Product getProduct(int productID)    {
		Product product = new Product();
		String query3 = "select Product_id,Product_name,unit_price,Product_Description,Product_Quantity from product where Product_id="+productID ;
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
			product.setProductID(rs.getInt(1));
			System.out.println("product id is "+ rs.getInt(1));
			product.setProduct_name(rs.getString(2));

			product.setUnitPrice(rs.getFloat(3));
			product.setProductDescription(rs.getString(4));
			
			
			
			product.setProductQty(rs.getInt(5));
			



			
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
}
	
	