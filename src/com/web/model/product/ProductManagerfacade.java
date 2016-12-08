package com.web.model.product;


import com.web.dbconn.*;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class ProductManagerfacade {
	public Set<Product> goProduct(String  productname)
	{

		ProductDB connect = new ProductDB();
		//Product product = connect.searchProduct(productID);
		return connect.searchProduct(productname);

	}
	public void addProduct(int product_id,String product_name,float unitPrice,String productDescription,  
			 int productQty)
	{
	
		ProductDB product = new ProductDB();
		 product.addproduct(product_id,product_name,unitPrice,productDescription,productQty);
		
		
	}
	/*public Set<Product> getAllProducts()
	{
		
		Set<Product> products = new HashSet<Product>();
		ProductDB con = new ProductDB();
		products = con.fetchAllProducts();
		return products;
	}
	
	
	*/
	public Product getProduct (int productid)
	{ProductDB db = new ProductDB();
		return db.getProduct(productid);
		
	}
	
	
	
}