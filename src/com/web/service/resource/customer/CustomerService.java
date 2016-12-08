package com.web.service.resource.customer;

import java.sql.SQLException;
import java.util.Set;

import javax.jws.WebService;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.web.service.representation.customer.CustomerRepresentation;
import com.web.service.representation.customer.CustomerRequest;

@WebService
public interface CustomerService {
	public CustomerRepresentation getCustomer(int id,@Context UriInfo uriInfo) throws SQLException;

	public CustomerRepresentation insertCustomer(CustomerRequest customerrequest) throws SQLException;

	public Response deleteCustomer(String firstname) throws SQLException;
	
	
	
}
