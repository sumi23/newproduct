package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import exception.DBException;
import model.AdminDetails;
import util.ConnectionUtil;

public class AdminDao {
	Connection con = ConnectionUtil.getConnection();
	 PreparedStatement pst = null;	
public  AdminDetails adminLogin(String name,String password) throws  SQLException, DBException {
	
	AdminDetails details = null;
		try {
			String sql = "select * from admin where Name = ? and Password = ?";
			 pst = con.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				details = toRow(rs);
			}

		} catch (Exception e) {
			throw new DBException("Invalid Credentials...!!!",e);
		}
		finally
		{
		pst.close();	
		}
		return details;
	}


private AdminDetails toRow(ResultSet rs) throws SQLException {
	String name = rs.getString("Name");
	String setPassword = rs.getString("Set_Password");
	AdminDetails info = new AdminDetails();
	
	info.setName(name);
	info.setPassword(setPassword);
	return info;
}
}
