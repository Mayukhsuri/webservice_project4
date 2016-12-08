package com.web.model.partner;

public class Partner {
	
	int partnerID;
	String partnerusername;
    String partneraddress;
    
    public Partner(){}
    
	public Partner(	int partnerID, String partnerusername, String partneraddress){
		this.partnerID = partnerID;
		this.partnerusername = partnerusername;
		this.partneraddress=partneraddress;
	}
	
	public int getpartnerID(){
		return partnerID;
	}
	
	public void setpartnerID(int partnerID) {
		this.partnerID = partnerID;
	}
	
	public String getpartnerusername(){
		return partnerusername;
	}
	
	public void setpartnerusername(String partnerusername) {
		this.partnerusername = partnerusername;
	}
	
	public String getpartneraddress(){
		return partneraddress;
	}
	
	public void setpartneraddress(String partneraddress) {
		this.partneraddress = partneraddress;
	}
    
}
