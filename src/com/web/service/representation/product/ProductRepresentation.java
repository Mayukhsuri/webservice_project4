package com.web.service.representation.product;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



@XmlRootElement(name = "Product")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class ProductRepresentation {

	int productID;
	String productname;
	String productdescription;
	float UnitPrice;
	int productquantity;

	public void setProductID(int productID){
		this.productID = productID;
	}
	
	public int getProductID(){
		return productID;
	}	
	
	public void setProductName(String productname){
		this.productname = productname;
	}
	
	public String getProductname(){
		return productname;
	}
	
	public void setProductdecription(String productdescription){
		this.productdescription = productdescription;
	}
	
	public String getProductdecription(){
		return productdescription;
	}
	
	public void setUnitPrice(float UnitPrice){
		this.UnitPrice = UnitPrice;
	}
	
	public double getUnitPrice(){
		return UnitPrice;
	}
	
	
	public void setProductquantity(int productquantity){
		this.productquantity = productquantity;
	}
	
	public int getProductquantity(){
		return productquantity;
	}

}
