package com.web.dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.management.Query;

import com.web.model.partner.Partner;
import com.web.model.*;
import com.web.dbconn.*;

public class PartnerDB extends CommonDB{
	
	
	private static String dbUrl = "jdbc:mysql://localhost:3306/lastcart";
	private static String dbUsername = "Shefali";
	private static String dbPassword = "shefali123";
	private static Set<Partner> partner = new HashSet<Partner>();

	public PartnerDB() {
		// TODO Auto-generated constructor stub
	super();
	} 
	//private static Statement statement = null;

	public Set<Partner >searchPartner(String partner_name){
	partner.clear();
	String searchquery= "Select * from partner where Partner_name like '%"+partner_name+"%';";
	Connection connection = super.getConnection();
	Statement stm= null;
	
	
		
	
		try {
			
			stm = connection.createStatement();
			ResultSet result = stm.executeQuery(searchquery);
			
		   
			while(result.next())
			{
				Partner pd = new Partner();
				System.out.println("Inserting records into the table...");
				
				pd.setpartnerID(result.getInt(1));
				System.out.println("partner id is "+ pd.getpartnerID());
				pd.setpartnerusername(result.getString(2));
				System.out.println("name is "+pd.getpartnerusername());
				pd.setpartneraddress(result.getString(3));
				System.out.println("partner address  is "+ pd.getpartneraddress());	
							}
stm.close();result.close();

		} catch(SQLException e) {
			System.err.print(e.toString());
		} 
		super.closeConnection(connection);
		System.out.println("number of Partners is "+partner.size());	
		return partner;
	}
	
	public Partner addpartner(int partnerid, String partnerusername, String partneraddress)

	{

	Partner proo = new Partner();
	String sql3 = "INSERT INTO Partner  ('Partner_id','Partner_Username','Partner_Address')values(?,?,?);";
String select="Select * from Partner where Partner_id= ?";
	    Statement stm = null;
	    Connection connection= super.getConnection();
	try{
	stm = connection.createStatement();
	PreparedStatement psta = (PreparedStatement)connection.prepareStatement(sql3);
	psta.setInt(1, partnerid);
	psta.setString(2, partnerusername);
	psta.setString(3, partneraddress);
	
	psta.executeUpdate();
	PreparedStatement prr= (PreparedStatement)connection.prepareStatement(select);
	ResultSet rs1= psta.executeQuery();
	

	System.out.println("Inserting records into the table...");
	
	proo.setpartnerID(rs1.getInt(1));
	proo.setpartnerusername(rs1.getString(2));
	proo.setpartneraddress(rs1.getString(3));
	
	stm.close();
	}
    	catch (SQLException  ex) {
	   System.out.println("SQLException: " + ex.getMessage());
	}
	return proo;
	}	
	public Partner getPartner(int Partner_ID)    {
		Partner partner = new Partner();
		String query3 = "select Partner_id,Partner_address,Partner_username from partner where Partner_id="+Partner_ID ;
		Connection connection = super.getConnection();
		Statement stmt = null;
		try
		{
			stmt=connection.createStatement();
			ResultSet rs= stmt.executeQuery(query3);
		
		if(rs.next())
		{
			partner.setpartnerID(rs.getInt(1));
			System.out.println(" id is "+ rs.getInt(1));
			partner.setpartneraddress(rs.getString(2));

			partner.setpartnerusername(rs.getString(3));
			//partner.setDescription(rs.getString(4));
			//partner.setQty(rs.getInt(5));
		}
		stmt.close();
		rs.close();
		}
		catch (SQLException ex) {
			   System.out.println("SQLException: " + ex.getMessage());
			}
		return partner;

	}
}
	
	