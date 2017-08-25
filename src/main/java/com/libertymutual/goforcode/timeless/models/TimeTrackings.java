package com.libertymutual.goforcode.timeless.models;

public class TimeTrackings {

	private String date;
	private double mondayTime;
	private double tuesdayTime;
	private double wednesdayTime;
	private double thursdayTime;
	private double fridayTime;
	
	public double getMondayTime() {
		return mondayTime;
	}
		
	public void setMondayTime(double mondayTime) {
		this.mondayTime = mondayTime;
	}

	public double getTuesdayTime() {
		return tuesdayTime;
	}

	public void setTuesdayTime(Double tuesdayTime) {
		if (tuesdayTime != null) {
			this.tuesdayTime = tuesdayTime;
		}
	}

	public double getWednesdayTime() {
		return wednesdayTime;
	}


	public void setWednesdayTime(Double wednesdayTime) {
		if (wednesdayTime != null) {
			this.wednesdayTime = wednesdayTime;
		}
	}

	public double getThursdayTime() {
		return thursdayTime;
	}

	public void setThursdayTime(Double thursdayTime) {
		if (thursdayTime != null) {
			this.thursdayTime = thursdayTime;
		}
	}

	public double getFridayTime() {
		return fridayTime;
	}

	public void setFridayTime(Double fridayTime) {
		if (fridayTime != null) {
			this.fridayTime = fridayTime;
		}
	}

	public double getTotal() {
		double total = (mondayTime + tuesdayTime + wednesdayTime + thursdayTime + fridayTime);
		return total;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
