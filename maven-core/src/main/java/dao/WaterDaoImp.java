package dao;
import java.sql.SQLException;
import exception.DBException;
import model.Details;

public interface WaterDaoImp {

	public void quantity(Details water)throws  SQLException, DBException;

	void status(Details water)throws  SQLException, DBException;

	void reserve(Details water)throws  SQLException, DBException;

	void reserve1(Details water)throws  SQLException, DBException;

	void reserveu(Details water)throws  SQLException, DBException;

}