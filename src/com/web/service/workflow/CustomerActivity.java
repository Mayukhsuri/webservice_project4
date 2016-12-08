package com.web.service.workflow;

import java.sql.SQLException;

import com.web.model.customer.Customer;
import com.web.model.customer.Customermanager;
import com.web.model.link.Link;
import com.web.service.representation.customer.CustomerRepresentation;


public class CustomerActivity {
	
	private static Customermanager cmm= new Customermanager();
	
	public CustomerRepresentation getCustomer(int id ) throws SQLException
	{
		Customer cs= cmm.getCustomer(id);
		
		CustomerRepresentation Repp=new CustomerRepresentation();
		Repp.setCustomerID(cs.getCustomerID());
		Repp.setCustomerAddress(cs.getCustomerAddress());
		Repp.setCustomerPhone(cs.getCustomerPhone());
		Repp.setFirstname(cs.getFirstName());
		Repp.setLastname(cs.getLastName());
		
		Repp.setOrderid(cs.getOrderid());
        //setLinks(Repp);
		return Repp;
		
	}
	
	public CustomerRepresentation insertCustomer(int customer_id, String customer_address, int customer_phone,String firstname,String lastname, int order_id) throws SQLException 
	{
		
		Customer cust= cmm.addcustomer(customer_id, customer_address, customer_phone, firstname, lastname, order_id);
		CustomerRepresentation custRepp=new CustomerRepresentation();
		
		
		
		custRepp.setCustomerID(cust.getCustomerID());
		custRepp.setCustomerAddress(cust.getCustomerAddress());
		custRepp.setCustomerPhone(cust.getCustomerPhone());
		custRepp.setFirstname(cust.getFirstName());
		custRepp.setLastname(cust.getLastName());
		custRepp.setCustomerAddress(cust.getCustomerAddress());
		custRepp.setOrderid(cust.getOrderid());





		return custRepp;
		
		
	}
public String deleteCustomer(String  firstname ) throws SQLException
{
	cmm.deletecustomerr(firstname);
	return "trashed";
}

}
