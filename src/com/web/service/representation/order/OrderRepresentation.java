package com.web.service.representation.order;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.web.model.link.Link;

@XmlRootElement(name = "Order")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")

public class OrderRepresentation {
int orderid;
String status;
int customerid;


private List <Link> links = new ArrayList<>();

public int getorderID(){
	return orderid;
}


public void setorderID(int orderID){
	this.orderid = orderID;
}


public String getStatus() {
	return status;
}


public void setStatus(String status) {
	this.status = status;
}


public int getCustomerid() {
	return customerid;
}


public void setCustomerid(int customerid) {
	this.customerid = customerid;
}
	
	
public List<Link> getLinks() {
	return links;
}
public void setLinks(List<Link> links) {
	this.links = links;
}
public void addLink(String url, String rel,String method, String mediaType)
{
	Link link = new Link();
	link.setAction(rel);
	link.setUrl(url);
	
	links.add(link);
}
	
	
}
