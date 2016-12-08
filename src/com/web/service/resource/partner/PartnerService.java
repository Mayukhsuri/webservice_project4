package com.web.service.resource.partner;

import javax.jws.WebService;

import com.web.service.representation.partner.PartnerRepresntation;
import com.web.service.representation.partner.PartnerRequest;

@WebService
public interface PartnerService {
	public PartnerRepresntation getPartner(int partnerid);

	public PartnerRepresntation addPartner(PartnerRequest partnerRequest);

}


