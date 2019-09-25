package model;

import java.time.LocalDate;

public class Availability {
	private int availability_List;
	private LocalDate date;

	public int getAvailability_List() {
		return availability_List;
	}

	public void setAvailability_List(int availability_List) {
		this.availability_List = availability_List;
	}
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	}
