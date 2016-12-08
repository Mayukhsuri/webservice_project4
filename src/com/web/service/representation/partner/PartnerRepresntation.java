package com.web.service.representation.partner;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Partner")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class PartnerRepresntation {

	int partnerID;
	String partnerusername;
    String partneraddress;
	public int getPartnerID() {
		return partnerID;
	}
	public void setPartnerID(int partnerID) {
		this.partnerID = partnerID;
	}
	public String getPartnerusername() {
		return partnerusername;
	}
	public void setPartnerusername(String partnerusername) {
		this.partnerusername = partnerusername;
	}
	public String getPartneraddress() {
		return partneraddress;
	}
	public void setPartneraddress(String partneraddress) {
		this.partneraddress = partneraddress;
	}
    
	
}
