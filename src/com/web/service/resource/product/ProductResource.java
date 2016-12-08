package com.web.service.resource.product;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import com.web.service.representation.product.ProductRepresentation;
import com.web.service.representation.product.ProductRequest;
import com.web.service.workflow.ProductActivity;


@Path("/productservice/")
public class ProductResource implements ProductService  {
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/product/prodname/{productname}")
	public Set<ProductRepresentation> searchProduct(@PathParam("productname")String productname) {
		System.out.println("GET METHOD Request for all customers .............");
		ProductActivity proActivity = new ProductActivity();
		return proActivity.searchProductttt(productname)	;
	}


	
	@GET
	@Produces({ "application/xml", "application/json" })
	@Path("/product/{productId}")
	public ProductRepresentation getProduct(@PathParam("productId")  int id)  {
		System.out.println("GET METHOD Request from Client with ProductRequest String ............." + id);
		ProductActivity pdtActivity = new ProductActivity();
		return pdtActivity.getProduct(id);
	}	
	@POST
	@Produces({ "application/xml", "application/json" })
	@Path("/product")
	public ProductRepresentation addProduct( ProductRequest ProductRequest) {
		System.out.println("POST METHOD Request from Client with ............." +ProductRequest.getProductID()+" "+ ProductRequest.getProductname()+" "
	+ProductRequest.getProductdecription()+" "+ProductRequest.getProductquantity()+" "+ProductRequest.getProductprice()
				);
		ProductActivity pdtActivity = new ProductActivity();
		return pdtActivity.addProduct(ProductRequest.getProductID(),ProductRequest.getProductname(),ProductRequest.getProductprice(), ProductRequest.getProductdecription(), 
				ProductRequest.getProductquantity());
	}
	
	
/*
	@DELETE
	@Produces({ "application/xml", "application/json" })
	@Path("/product/{ProductId}")
	public Response deleteProduct(@PathParam("ProductId") int id) {
		System.out.println("Delete METHOD Request from Client with ProductRequest String ............." + id);
		ProductActivity pdtActivity = new ProductActivity();
		String res = pdtActivity.deleteProduct(id);
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}

*/

}
