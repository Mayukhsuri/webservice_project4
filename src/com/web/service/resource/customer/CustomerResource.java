package com.web.service.resource.customer;

import java.sql.SQLException;
import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.springframework.expression.spel.ast.Assign;

import com.sun.org.apache.xerces.internal.util.Status;
import com.web.model.customer.Customer;
import com.web.service.representation.customer.CustomerRepresentation;
import com.web.service.representation.customer.CustomerRequest;
import com.web.service.representation.product.ProductRepresentation;
import com.web.service.representation.product.ProductRequest;
import com.web.service.resource.product.ProductService;
import com.web.service.workflow.CustomerActivity;
import com.web.service.workflow.ProductActivity;
@CrossOriginResourceSharing(allowAllOrigins= true)
	
	@Path("/customerservice/")
	public class CustomerResource implements CustomerService  {
		@GET
		@Produces({"application/xml" , "application/json"})
		@Path("/customer/{customerid}")
		public CustomerRepresentation getCustomer(@PathParam("customerid")int id, @Context UriInfo uriInfo) throws SQLException {
			System.out.println("GET METHOD Request for all customers ............."+id);
			CustomerActivity proActivity = new CustomerActivity();
			 CustomerRepresentation cust= proActivity.getCustomer(id)	;
			 cust.addLink(getUriForSelf(uriInfo, cust), "self", "Get","application/jason");
			 cust.addLink(getUriForproduct(uriInfo,cust),"product", "POST", "application/json");
				cust.addLink(getUriForDelete(uriInfo,cust), "delete", "Delete", "application/json");
			return cust;

			 
			 
		}
		private String getUriForSelf (UriInfo uriinfo, CustomerRepresentation custrep ){
			String url= uriinfo.getBaseUriBuilder()
					.path(CustomerResource.class)
					.path("customer")
			.path(Integer.toString(custrep.getCustomerID()))
			.build()
			.toString();
			return url;
			
		}


	
		
		
		@POST
		@Produces({ "application/xml", "application/json" })
		@Path("/customer")
		public CustomerRepresentation insertCustomer( CustomerRequest customerRequest) throws SQLException {
			System.out.println("POST METHOD Request from Client with ............." +customerRequest.getCustomerID()+" "+ customerRequest.getCustomerAddress()+" "
		+customerRequest.getCustomerPhone()+" "+customerRequest.getFirstname()+" "+customerRequest.getLastname()+""+customerRequest.getOrderid()
					);
			CustomerActivity pdtActivity = new CustomerActivity();
			return pdtActivity.insertCustomer(customerRequest.getCustomerID(), customerRequest.getCustomerAddress(), customerRequest.getCustomerPhone(), customerRequest.getFirstname(), customerRequest.getLastname(), customerRequest.getOrderid());
		}
		
		
	
		@DELETE
		@Produces({ "application/xml", "application/json" })
		@Path("/customer/{firstname}")
		public Response deleteCustomer(@PathParam("firstname") String firstname) throws SQLException 
		{
			System.out.println("Delete METHOD Request from Client with ProductRequest String ............." + firstname);
			CustomerActivity pdtActivity = new CustomerActivity();
			String stat = pdtActivity.deleteCustomer(firstname);
			if (stat.equals("OK")) {
				return Response.status(javax.ws.rs.core.Response.Status.OK).build();		
				}
			return null;
		}


		private String getUriForproduct(UriInfo uriInfo,CustomerRepresentation custRep){
			String url = uriInfo.getBaseUriBuilder()
								.path(CustomerResource.class)
								.path("customer")
								.path("shefali")
								.build()
								.toString();
			return url;
			
		}
		private String getUriForDelete(UriInfo uriInfo,CustomerRepresentation custRep){
			String url = uriInfo.getBaseUriBuilder()
								.path(CustomerResource.class)
								.path("customer")
								.path(Integer.toString(custRep.getCustomerID()))
								.build()
								.toString();
			return url;
			
		}


		




		
	
	

	
	

}
