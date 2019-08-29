package com.revature.bankapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.bankapp.util.ConnectionUtil;

public class UserDAO {
	 public boolean login(String email, String password) {
	        boolean isValidLogin = false;
	        try {
	            Connection con=ConnectionUtil.getConnection();

	            String sql="select * from users where email=? and password=?";
	            PreparedStatement pst=con.prepareStatement(sql);
	            pst.setString(1, email);
	           pst.setString(2, password); 
	           
	           ResultSet rs= pst.executeQuery();
	            if(rs.next())
	            {
	            isValidLogin=true;
	            }
	            }
	            catch (SQLException e) {
	           	e.printStackTrace();
	           }
	        return isValidLogin;
	    }
}
