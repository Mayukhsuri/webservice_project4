package com.web.service.resource.order;


import java.util.Set;

import javax.jws.WebService;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import com.web.service.representation.order.OrderRepresentation;
import com.web.service.representation.order.OrderRequest;
@WebService
public interface OrderService {
	public Set<OrderRepresentation> getAllOrders();
	public OrderRepresentation getOrder(int orderId,@Context UriInfo uriInfo);
	public OrderRepresentation createOrder(OrderRequest orderRequest);
	public OrderRepresentation cancelOrder(int orderId,@Context UriInfo uriInfo);
	public OrderRepresentation getStatus(int orderId,@Context UriInfo uriInfo);
   
}
