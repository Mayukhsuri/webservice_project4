package com.web.model.partner;

import com.web.dbconn.PartnerDB;
import com.web.dbconn.ProductDB;
import com.web.model.product.Product;

public class PartnerManagerfacade {
	
	PartnerDB db = new PartnerDB();
	public void addPartner(int partner_id,String username,String address)
	{
	
		 db.addpartner(partner_id,username,address);
		
		
	}
	public Partner getPartner (int id)
	{
		return db.getPartner(id);
		
	}
	
	

}
