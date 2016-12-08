package com.web.service.resource.partner;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.web.model.partner.Partner;
import com.web.service.representation.partner.PartnerRepresntation;
import com.web.service.representation.partner.PartnerRequest;
import com.web.service.workflow.PartnerActivity;
import com.web.service.workflow.ProductActivity;

public class PartnerResource implements PartnerService{

	@GET
	@Produces({ "application/xml", "application/json" })
	@Path("/partner/{partnerid}")
	public PartnerRepresntation getPartner(@PathParam("productid")  int partnerid) {
		// TODO Auto-generated method stub
		System.out.println("GET METHOD Request from Client with ProductRequest String ............." + partnerid);
		PartnerActivity pdtActivity = new PartnerActivity();
		return pdtActivity.getPartner(partnerid);
	}

	@POST
	@Produces({ "application/xml", "application/json" })
	@Path("/partner")
	public PartnerRepresntation addPartner(PartnerRequest partnerRequest) {
		System.out.println("POST METHOD Request from Client with ............." +partnerRequest.getPartnerID()+" "+ partnerRequest.getPartnerusername()+" "+partnerRequest.getPartnerusername());
		PartnerActivity pdtActivity = new PartnerActivity();
		return pdtActivity.addPartner(partnerRequest.getPartnerID(), partnerRequest.getPartnerusername(), partnerRequest.getPartnerusername()); 
	}

}
