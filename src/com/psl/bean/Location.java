package com.psl.bean;

public class Location {

	private int locationCode;
	private int locationDistance;
	private double locationTime;
	


	public Location(int locationCode, int locationDistance, double locationTime) {
		super();
		this.locationCode = locationCode;
		this.locationDistance = locationDistance;
		this.locationTime = locationTime;
	}
	public Location(int loc)
	{
		// TODO Auto-generated constructor stub
		this.locationCode = loc;
	}
	public int getLocationCode() {
		return locationCode;
	}
	public void setLocationCode(int locationCode) {
		this.locationCode = locationCode;
	}
	public int getLocationDistance() {
		return locationDistance;
	}
	public void setLocationDistance(int locationDistance) {
		this.locationDistance = locationDistance;
	}
	public double getLocationTime() {
		return locationTime;
	}
	public void setLocationTime(double locationTime) {
		this.locationTime = locationTime;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + locationCode;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (locationCode != other.locationCode)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Location [locationCode=" + locationCode + ", locationDistance="
				+ locationDistance + ", locationTime=" + locationTime + "]\n";
	}
}
