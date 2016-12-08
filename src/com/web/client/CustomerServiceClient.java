package com.web.client;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Response;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import com.web.service.representation.customer.CustomerRequest;
import com.web.service.representation.product.ProductRequest;

public class CustomerServiceClient {
	 private CustomerServiceClient() {
	    } 

	    public static void main(String args[]) throws Exception {

	    	 List<Object> providers = new ArrayList<Object>();
	    	 JacksonJsonProvider provider = new JacksonJsonProvider();
	         provider.addUntouchable(Response.class);
	         providers.add(provider);
	         
	         /*****************************************************************************************
	          * GET METHOD invoke
	          *****************************************************************************************/
	         System.out.println("GET METHOD .........................................................");
	         WebClient getClient = WebClient.create("http://localhost:8081", providers);
	         
	         //Configuring the CXF logging interceptor for the outgoing message
	         WebClient.getConfig(getClient).getOutInterceptors().add(new LoggingOutInterceptor());
	       //Configuring the CXF logging interceptor for the incoming response
	         WebClient.getConfig(getClient).getInInterceptors().add(new LoggingInInterceptor());
	         
	         // change application/xml  to get in xml format
	         getClient = getClient.accept("application/json").type("application/json").path("/customerservice/product/11");
	         
	         //The following lines are to show how to log messages without the CXF interceptors
	         String getRequestURI = getClient.getCurrentURI().toString();
	         System.out.println("Client GET METHOD Request URI:  " + getRequestURI);
	         String getRequestHeaders = getClient.getHeaders().toString();
	         System.out.println("Client GET METHOD Request Headers:  " + getRequestHeaders);
	         
	         //to see as raw XML/json
	         String response = getClient.get(String.class);
	         System.out.println("GET METHOD Response: ...." + response);
	             
	         /*****************************************************************************************
	          * POST METHOD invoke
	         *****************************************************************************************/
	         System.out.println("POST METHOD .........................................................");
	         WebClient postClient = WebClient.create("http://localhost:8081", providers);
	         WebClient.getConfig(postClient).getOutInterceptors().add(new LoggingOutInterceptor());
	         WebClient.getConfig(postClient).getInInterceptors().add(new LoggingInInterceptor());
	                  
	         // change application/xml  to application/json get in json format
	         postClient = postClient.accept("application/xml").type("application/json").path("/customerservice/customer");
	      	
	         String postRequestURI = postClient.getCurrentURI().toString();
	         System.out.println("Client POST METHOD Request URI:  " + postRequestURI);
	         String postRequestHeaders = postClient.getHeaders().toString();
	         System.out.println("Client POST METHOD Request Headers:  " + postRequestHeaders);
	         CustomerRequest productRequest = new CustomerRequest();
	         productRequest.setCustomerID(11);
	         productRequest.setCustomerAddress("Park");
	         productRequest.setCustomerPhone(123);
	         
	         productRequest.setFirstname("shefali");
	         productRequest.setLastname("malhotra");
	         productRequest.setOrderid(111);
	         String responsePost =  postClient.post(productRequest, String.class);
	      	 System.out.println("POST MEDTHOD Response ........." + responsePost);
	         
	      	/*****************************************************************************************
	          * DELETE METHOD invoke
	         *****************************************************************************************/
	         System.out.println("DELETE METHOD .........................................................");
	         WebClient deleteClient = WebClient.create("http://localhost:8081", providers);
	         WebClient.getConfig(deleteClient).getOutInterceptors().add(new LoggingOutInterceptor());
	         WebClient.getConfig(deleteClient).getInInterceptors().add(new LoggingInInterceptor());
	         
	         // change application/xml  to application/json get in json format
	         deleteClient = deleteClient.accept("application/xml").type("application/json").path("/customerservice/customer/shefali");
	      	
	         String deleteRequestURI = deleteClient.getCurrentURI().toString();
	         System.out.println("Client DELETE METHOD Request URI:  " + deleteRequestURI);
	         String deleteRequestHeaders = deleteClient.getHeaders().toString();
	         System.out.println("Client DELETE METHOD Request Headers:  " + deleteRequestHeaders);
	         
	         deleteClient.delete();
	         System.out.println("DELETE MEDTHOD Response ......... OK");
	          
	         System.exit(0);
	    }

	}

	
	
	

