package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.UserDetails;
import util.ConnectionUtil;
import exception.DBException;

public class UserDao implements UserDaoImp {
	Connection con = ConnectionUtil.getConnection();
	 PreparedStatement pst = null;	
	
	public void register(UserDetails user) throws  SQLException, DBException {
		
		try {
			
			String sql = "insert into user_Info(Name,Mobile_Number,Set_Password) values (?,?,?)";
			Long mobile=Long.parseLong(user.getMobileNumber());
			 pst = con.prepareStatement(sql);
			pst.setString(1, user.getName());
			pst.setLong(2, mobile);
			pst.setString(3, user.getSetPassword());
			int rows = pst.executeUpdate();
			System.out.println("no of rows inserted:" + rows);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("This account is already existing!!!...Please enter a valid details...");
		}
		finally
		{
		pst.close();	
		}
	}

	public  UserDetails login(String phone_number, String setPassword) throws  SQLException, DBException {
		
		UserDetails details = null;
		try {
			
			String sql = "select * from user_Info where Mobile_Number = ? and Set_Password = ?";
			 pst = con.prepareStatement(sql);
			pst.setString(1, phone_number);
			pst.setString(2, setPassword);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				details = new UserDetails();
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

	
	

	
	public UserDetails findByID(int id) throws SQLException, DBException {
		UserDetails userid = null;
		try {
			
			String sql = "select ID, Name, Mobile_Number,Set_Password from quantity_List where ID = ?";
			 pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs1 = pst.executeQuery();

			if (rs1.next()) {
				userid = new UserDetails();
				userid = toRow(rs1);
			}

		} catch (Exception e) {
			throw new DBException("Unable to give reference ID...",e);

		}
		finally
		{
		pst.close();	
		}
		
		return userid;
	}

	

	private UserDetails toRow(ResultSet rs1) throws SQLException {
		int id = rs1.getInt("ID");
		String name = rs1.getString("Name");
		String phone_number = rs1.getString("Mobile_Number");
		String setPassword = rs1.getString("Set_Password");
		UserDetails user = new UserDetails();
		user.setID(id);
		user.setName(name);
		user.setMobileNumber(phone_number);
		user.setSetPassword(setPassword);
		return user;
	}

	

}