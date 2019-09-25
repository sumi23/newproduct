package service;
import dao.WaterDao;
import exception.DBException;
import java.sql.SQLException;
import dao.AvailabilityDao;
import model.Availability;
import model.Details;

public class CanService {
	WaterDao waterdao = new WaterDao();
	Availability stock = new Availability();
	AvailabilityDao dao = new AvailabilityDao();
	public void orderCan(Details details) throws SQLException, DBException {	
		 waterdao.quantity(details);
		 try {
			Availability availableStock=dao.getStock();
			int value=details.getQuantyList();
			int value1=availableStock.getAvailability_List()-value;
			dao.admin1(value1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 
  public void reserveCan(Details details) {
				waterdao.reserve(details);
  }
  }
