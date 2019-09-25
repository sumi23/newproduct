package dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Availability;
import model.Details;
import util.ConnectionUtil;

public class AvailabilityDao {
	Connection con = ConnectionUtil.getConnection();
	 PreparedStatement pst = null;
     Details water = new Details();
     Availability details = new Availability();

     public List<Availability> viewStock() throws Exception{
    	    
    	    Connection con =null;
    	    PreparedStatement pst = null;
    	    List<Availability> list = new ArrayList<Availability>();
    	    try {
    	        con = ConnectionUtil.getConnection();
    	        String sql = "select * from availability_List";
    	        pst = con.prepareStatement(sql);
    	        ResultSet rs = pst.executeQuery();
    	        while(rs.next()) {
    	            
    	        	Availability stock = new Availability();
    	            stock.setAvailability_List(rs.getInt("Availability_List"));
    	            Date date = rs.getDate("Date");
    	            stock.setDate(date.toLocalDate());
    	            list.add(stock);
    	        }
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	        throw new Exception("Unable to View Stock",e);
    	    }
    	    return list;
    	}
     
     public Availability getStock() throws Exception{
 	    
 	    Connection con =null;
 	    PreparedStatement pst = null;
 	    Availability availability = new Availability();
 	    try {
 	        con = ConnectionUtil.getConnection();
 	        String sql = "select * from availability_List";
 	        pst = con.prepareStatement(sql);
 	        ResultSet rs = pst.executeQuery();
 	        while(rs.next()) {
 	            
 	       
 	        	availability.setAvailability_List(rs.getInt("Availability_List"));
 	            Date date = rs.getDate("Date");
 	           availability.setDate(date.toLocalDate());
 	        
 	        }
 	    } catch (SQLException e) {
 	        e.printStackTrace();
 	        throw new Exception("Unable to View Stock",e);
 	    }
 	    return availability;
 	}
     
     public void admin1(int cans) {
 		try {
 			String sql = "update availability_List set Availability_List=? ";
 			PreparedStatement pst = con.prepareStatement(sql);
 			pst.setInt(1,cans);
 		  pst.executeUpdate();
 		} catch (SQLException e){
 			e.printStackTrace();
 		}
 	}
     
	public void admin(Availability details) {
		try {
			String sql = "insert into availability_List(Availability_List) values (?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setDouble(1, details.getAvailability_List());
			int rows = pst.executeUpdate();
			System.out.println("no of rows inserted:" + rows);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	
	 
}
