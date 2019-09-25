package service;
import java.util.List;
import dao.AvailabilityDao;
import exception.DBException;
import model.Availability;
import validator.AdminValidator;

public class AvailabilityService {
	AdminValidator validator = new AdminValidator();
	AvailabilityDao availabilitydao = new AvailabilityDao();
	
	public List<Availability> stockView() throws Exception {
        List<Availability> list = null;
        try {
            list = availabilitydao.viewStock();
        } catch (DBException e) {
            e.printStackTrace();
        }
        System.out.println();
        return list;
    }

	public void setCan(int cans) {
	   try {
		availabilitydao.admin1(cans);
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}