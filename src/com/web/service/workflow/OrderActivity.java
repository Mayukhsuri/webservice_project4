package com.web.service.workflow;





import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.web.model.order.*;
import com.web.service.representation.order.*;

public class OrderActivity {
private static Ordermanagerfacade omf = new Ordermanagerfacade();
	
	public Set<OrderRepresentation> getAllOrders()    {
		
		Set<Order> orders = new HashSet<Order>();
		Set<OrderRepresentation> orderRepresentations = new HashSet<OrderRepresentation>();
		try {
			orders = omf.getAllOrderss();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Iterator<Order> it = orders.iterator();
		while(it.hasNext()) {
          Order order = (Order)it.next();
          OrderRepresentation orderRepresentation = new OrderRepresentation();
                   
          orderRepresentation.setorderID(order.getOrderID());
          orderRepresentation.setCustomerid(order.getCustomerid());
          orderRepresentation.setStatus(order.getOrderStatus());
          
          //now add this representation in the list
          orderRepresentations.add(orderRepresentation);
        }
		return orderRepresentations;
	}
	
public OrderRepresentation getOrder(int orderID) {
		
		Order order = omf.getOrder(orderID);
		
		OrderRepresentation orderRepresentation = new OrderRepresentation();
		orderRepresentation.setorderID(order.getOrderID());
        orderRepresentation.setCustomerid(order.getCustomerid());
        orderRepresentation.setStatus(order.getOrderStatus());
        
		
		return orderRepresentation;

	}
public OrderRepresentation insertOrder(int cid,  int id,String status) {	
	Order order = omf.addOrder(id, status, cid);
	
	OrderRepresentation orderRepresentation = new OrderRepresentation();
	orderRepresentation.setorderID(order.getOrderID());
    orderRepresentation.setCustomerid(order.getCustomerid());
    orderRepresentation.setStatus(order.getOrderStatus());
    
	
	return orderRepresentation;


}

public OrderRepresentation getstatus(int id )
{
	
	Order order = omf.getOrder(id);
	
	OrderRepresentation orderRepresentation = new OrderRepresentation();
	orderRepresentation.setorderID(order.getOrderID());
    //orderRepresentation.setCustomerid(order.getCustomerid());
    //orderRepresentation.setStatus(order.getOrderStatus());
    
	
	return orderRepresentation;
	
	
	//return omf.getorderstatus(id);
}
public OrderRepresentation cancelord(int id )
{
	
Order order = omf.getOrder(id);
	
	OrderRepresentation orderRepresentation = new OrderRepresentation();
	orderRepresentation.setorderID(order.getOrderID());
	System.out.println("successfully deleted"+id);

	return orderRepresentation;
}
/*
public OrderRepresentation searchorder(String orderID) {
	
	Order order = omf.searchorder(orderID);
	
	OrderRepresentation orderRepresentation = new OrderRepresentation();
	orderRepresentation.setorderID(order.getOrderID());
    orderRepresentation.setCustomerid(order.getCustomerid());
    orderRepresentation.setStatus(order.getOrderStatus());
    
	
	return orderRepresentation;

}
*/


	
}
