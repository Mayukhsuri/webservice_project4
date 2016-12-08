package com.web.service.workflow;

import com.web.model.partner.Partner;
import com.web.model.partner.PartnerManagerfacade;
import com.web.model.product.Product;
import com.web.model.product.ProductManagerfacade;
import com.web.service.representation.partner.PartnerRepresntation;
import com.web.service.representation.product.ProductRepresentation;

public class PartnerActivity {
	private static PartnerManagerfacade pm = new PartnerManagerfacade();

	public PartnerRepresntation getPartner(int id)  {

		Partner pdt = pm.getPartner(id);

		PartnerRepresntation pdtRep = new PartnerRepresntation();
		pdtRep.setPartnerID(pdt.getpartnerID());
		pdtRep.setPartnerusername(pdt.getpartnerusername());

		pdtRep.setPartneraddress(pdt.getpartneraddress());
		//pdtRep.setProductID(pdt.getProductID());
		

				
		// Add the links
		//setLinks(pdtRep);
		
		return pdtRep;
		
		
		
	}
	
	public PartnerRepresntation addPartner(int id,String username,String address)  
             {

pm.addPartner(id, username, address);
return null;

}


	
}
