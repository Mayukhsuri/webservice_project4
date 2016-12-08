package com.web.model.product;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {

	private int productID;
	private String productDescription;
	private float unitPrice;
	private int productQty;
	private String product_name;
	
	public String getProduct_name() {
		return product_name;
	}



	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}



	public int getProductQty() {
		return productQty;
	}



	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}



	



	


	public Product(String product_name, int productQty, int productID, String productDescription, float unitPrice, int prodqt) {
		//super();
		this.productID = productID;
		this.productDescription = productDescription;
		this.unitPrice = unitPrice;
		this.product_name=product_name;
		this.productQty=prodqt;
	}
	

	
	public Product()
	{
		super();
		this.productID = productID;
		this.productDescription = productDescription;
		this.unitPrice = unitPrice;
		this.product_name=product_name;
		this.productQty=productQty;
	}
	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	
}
