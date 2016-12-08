package com.web.client;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Response;


public final class PartnerServiceClient {

    private PartnerServiceClient() {
    } 

    public static void main(String args[]) throws Exception {

    	 List<Object> providers = new ArrayList<Object>();
         JacksonJsonProvider provider = new JacksonJsonProvider();
         provider.addUntouchable(Response.class);
         providers.add(provider);
         
         /*****************************************************************************************
          * GET METHOD invoke (---------------MISSING ON POST AND DELETE-------------)
          *****************************************************************************************/
         System.out.println("GET METHOD .........................................................");
         WebClient getClient = WebClient.create("http://localhost:8081", providers);
         
         WebClient.getConfig(getClient).getOutInterceptors().add(new LoggingOutInterceptor());
         WebClient.getConfig(getClient).getInInterceptors().add(new LoggingInInterceptor());
         
         getClient = getClient.accept("application/json").type("application/json").path("/partnerservice/partner/1");
         
         String getRequestURI = getClient.getCurrentURI().toString();
         System.out.println("Client GET METHOD Request URI:  " + getRequestURI);
         String getRequestHeaders = getClient.getHeaders().toString();
         System.out.println("Client GET METHOD Request Headers:  " + getRequestHeaders);
         
         String response = getClient.get(String.class);
         System.out.println("GET METHOD Response: ...." + response);
    }
}