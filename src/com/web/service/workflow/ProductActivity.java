package com.web.service.workflow;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.ws.rs.core.Link;

import com.web.model.product.ProductManagerfacade;
import com.web.model.product.Product;
import com.web.model.product.ProductManagerfacade;
import com.web.service.representation.product.ProductRepresentation;

public class ProductActivity {

	private static ProductManagerfacade pm = new ProductManagerfacade();

public Set<ProductRepresentation> searchProductttt(String productname) {
		
		Set<Product> products = new HashSet<Product>();
		Set<ProductRepresentation> productRepresentations = new HashSet<ProductRepresentation>();
		//employees = dao.getAllEmployees();
		products = pm.goProduct(productname);
		System.out.println("size"+products.size());
		
		Iterator<Product> it = products.iterator();
		while(it.hasNext()) {
			Product emp = (Product)it.next();
			ProductRepresentation productRepresentation= new ProductRepresentation();
			productRepresentation.setProductID(emp.getProductID());
			productRepresentation.setProductdecription(emp.getProductDescription());
			productRepresentation.setUnitPrice(emp.getUnitPrice());
			productRepresentation.setProductName(emp.getProduct_name());
			productRepresentation.setProductquantity(emp.getProductQty());
          
          //now add this representation in the list
			productRepresentations.add(productRepresentation);
			System.out.println("productid" + productRepresentation.getProductID());
			System.out.println("productname" + productRepresentation.getProductname());

        }
		return productRepresentations;
	}









	public ProductRepresentation getProduct(int id)  {

		Product pdt = pm.getProduct(id);

		ProductRepresentation pdtRep = new ProductRepresentation();
		pdtRep.setProductID(pdt.getProductID());
		pdtRep.setProductName(pdt.getProduct_name());
		pdtRep.setProductdecription(pdt.getProductDescription());
		//pdtRep.setProductID(pdt.getProductID());
		pdtRep.setProductquantity(pdt.getProductQty());
		pdtRep.setUnitPrice(pdt.getUnitPrice());

				
		// Add the links
		//setLinks(pdtRep);
		
		return pdtRep;
		
		
		
	}

	public ProductRepresentation addProduct(int id,String productname,float productprice, String productdecription,  
			                int productquantity) {

		pm.addProduct(id, productname, productprice,productdecription, productquantity);
		return null;

		
	}

	
	
//	private void setLinks(ProductRepresentation productRep) {
//		// Set up the activities that can be performed on orders
//		Link buy = new Link("buy", 
//				"http://api.ourapiname.com:8082/orderservice/submitorder?proudctID" + productRep.getProductID());	
//		
//	
//		productRep.setLinks(buy);
//	}
}