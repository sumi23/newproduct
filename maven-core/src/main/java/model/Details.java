package model;

import java.time.LocalDate;

public class Details {
	
	
	private LocalDate date;
	private  int quantyList;
	private int reservedList;
	private int reservedOrder;
	private int quanty;
	private String status;
    private long number;
	

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getQuantyList() {
		return quantyList;
	}

	public  int setQuantyList(int quantyList) {
		return this.quantyList = quantyList;
	}

	public  double getReservedList() {
		return reservedList;
	}

	public void setReservedList(int reservedList) {
		this.reservedList = reservedList;
	}

	public double getReservedOrder() {
		return reservedOrder;
	}

	public void setReservedOrder(int reservedOrder) {
		this.reservedOrder = reservedOrder;
	}

	public  int getQuanty() {
		return quanty;
	}

	public void setQuanty(int quanty) {
		this.quanty = quanty;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number2) {
		this.number = number2;
	}

}
