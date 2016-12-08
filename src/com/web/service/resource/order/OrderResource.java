package com.web.service.resource.order;



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
import javax.ws.rs.core.Response.Status;

import com.web.service.representation.order.OrderRepresentation;
import com.web.service.representation.order.OrderRequest;
import com.web.service.representation.product.ProductRepresentation;
import com.web.service.resource.customer.CustomerResource;
import com.web.service.resource.product.ProductResource;
import com.web.service.workflow.OrderActivity;

import javax.ws.rs.core.UriInfo;
@Path("/orderservice/")
public class OrderResource implements OrderService {

	
	
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/order")
	//@Cacheable(cc="public, maxAge=3600") example for caching
	public Set<OrderRepresentation> getAllOrders()  {
		System.out.println("GET METHOD Request for all orders .............");
		OrderActivity orderActivity = new OrderActivity();
		return orderActivity.getAllOrders();
	}
	
	
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/order/{orderID}")
	public OrderRepresentation getOrder(@PathParam("orderID")int orderId,  @Context UriInfo uriInfo) {
		// TODO Auto-generated method stub
		System.out.println("GET METHOD Request for all orders ............."+orderId);
OrderActivity ord = new OrderActivity();
		OrderRepresentation ordRep= ord.getOrder(orderId);
		ordRep.addLink(getUriForSelf(uriInfo,ordRep), "self", "Get", "application/json");
		ordRep.addLink(getUritopost(uriInfo,ordRep),"add", "POST", "application/json");
		ordRep.addLink(getUriForOrderStatus(uriInfo, ordRep), "delivered", "GET", "application/json");

		ordRep.addLink(getUriForCancel(uriInfo,ordRep), "cancel", "GET", "application/json");
		ordRep.addLink(getUriForproduct(uriInfo,ordRep),"product", "Get", "application/json");
		return ordRep;		
	}
	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/order")
	@Override
	public OrderRepresentation createOrder(OrderRequest orderRequest) {
		// TODO Auto-generated method stub
		System.out.println("GET METHOD Request for all orders .............");
		OrderActivity ord = new OrderActivity();
				return ord.insertOrder(orderRequest.getCustomerid(), orderRequest.getorderID(),orderRequest.getStatus());
	}
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/order/status/{orderId}")
	public OrderRepresentation getStatus(@PathParam("orderId") int id,@Context UriInfo uriInfo) {
		System.out.println("GET METHOD Request for all orders ............."+id);

		OrderActivity ordActivity = new OrderActivity();
		OrderRepresentation ordRep= ordActivity.getstatus(id);
	ordRep.addLink(getUriForOrderStatus(uriInfo,ordRep),"orderstatus", "Get", "application/json");
	return ordRep;
	}
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/order/delete/{orderId}")
	public OrderRepresentation cancelOrder(@PathParam("orderId") int id,@Context UriInfo uriInfo) {
		System.out.println("GET METHOD Request for all orders ............."+id);

		OrderActivity ordActivity = new OrderActivity();
		OrderRepresentation ordRep= ordActivity.cancelord(id);
		ordRep.addLink(getUriForCancel(uriInfo,ordRep), "cancel", "GET", "application/json");


		return ordRep;
	//ordRep.addLink(getUriForOrderStatus(uriInfo,ordRep),"orderstatus", "Get", "application/json");

	}
	
	
	/*Method to generate link for itself*/
	private String getUriForSelf(UriInfo uriInfo,OrderRepresentation ordRep){
		String url = uriInfo.getBaseUriBuilder()
							.path(OrderResource.class)
							.path("order")
							.path("OrderID" +ordRep.getorderID())
							.build()
							.toString();
		return url;
		
	}
	private String getUriForproduct(UriInfo uriInfo,OrderRepresentation ordrep){
		String url = uriInfo.getBaseUriBuilder()
							.path(ProductResource.class)
							.path("product/" +ordrep.getorderID())
							.build()
							.toString();
		return url;
		
	}
	/*Method to generate link to add order*/
	private String getUritopost(UriInfo uriInfo, OrderRepresentation ordRep) {
		String url = uriInfo.getBaseUriBuilder()
				.path(OrderResource.class)
				.path("order")
				.build()
				.toString();
		return url;
	}
	/*Method to generate link to cancel order*/
	private String getUriForCancel(UriInfo uriInfo, OrderRepresentation ordRep) {
		String url = uriInfo.getBaseUriBuilder()
				.path(OrderResource.class)
				.path("order")
				.path("cancel")
				.path(Integer.toString(ordRep.getorderID()))
				.build()
				.toString();
		return url;
	}
	/*Method to generate link to order status*/
	private String getUriForOrderStatus(UriInfo uriInfo, OrderRepresentation ordRep) {
		String url = uriInfo.getBaseUriBuilder()
				.path(OrderResource.class)
				.path("order")
				.path("status")
				.path(Integer.toString(ordRep.getorderID()))
				.build()
				.toString();
		return url;
	}
	/*Method to generate link to customer*/
	private String getUriForCustomer(UriInfo uriInfo, OrderRepresentation ordRep) {
		String url = uriInfo.getBaseUriBuilder()
				.path(CustomerResource.class)
				.path("customer")
				.path(Integer.toString(ordRep.getorderID()))
				.build()
				.toString();
		return url;
	}	

	
}
