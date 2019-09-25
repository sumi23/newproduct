package dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dao.WaterDaoImp;
import model.Availability;
import model.Details;
import util.ConnectionUtil;

public class WaterDao implements WaterDaoImp {
	Connection con = ConnectionUtil.getConnection();
	 PreparedStatement pst = null;
     Details water = new Details();
     
     public  int findavailability(){
    	    int availableStock = 0;
    	        Connection con = ConnectionUtil.getConnection();
    	        String sql = "select * from availability_List";
    	        PreparedStatement pst = null;
    	        Availability stock=null;
    	        try {
    	            pst = con.prepareStatement(sql);
    	            ResultSet rs = pst.executeQuery();
    	            while(rs.next()) {
    	                
    	            	stock = new Availability();
    	                availableStock=rs.getInt("cans_avail");
    	                Date date = rs.getDate("date");
    	                stock.setDate(date.toLocalDate());
    	            }
    	        } catch (SQLException e) {
    	            e.printStackTrace();
    	        }
    	        return availableStock;
    	    }
     
	 public void quantity(Details water) {
		try {
			String sql = "insert into quantity_List(Quantity_List,Mobile_Number) values(?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setDouble(1, water.getQuantyList());
			pst.setLong(2, water.getNumber());
			 pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void reserve(Details water) {
		try {
			String sql = "insert quantity_List(Reserved_List,Mobile_Number) values (?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setDouble(1, water.getReservedList());
			pst.setDouble(1, water.getNumber());
			int rows = pst.executeUpdate();
			System.out.println("no of rows inserted:" + rows);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void reserveu(Details water) {
		try {
			String sql = "update quantity_List set Reserved_List=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setDouble(1, water.getReservedList());
			int rows = pst.executeUpdate();
			System.out.println("no of rows inserted:" + rows);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public void reserve1(Details water) {
		try {
			String sql = "update quantity_List set Reserved_Order=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setDouble(1, water.getReservedOrder());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void status(Details water) {
		try {
			String sql = "update quantity_List set STATUS=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, water.getStatus());
			int rows = pst.executeUpdate();
			System.out.println("no of rows inserted:" + rows);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	

	
	
}