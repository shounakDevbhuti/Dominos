package com.psl.bean;

import java.util.ArrayList;
import java.util.List;

public class Dish {

	private int dishId;
	private String dishName;
	private double cost;
	private double timeToCook;
	private List<Location> list;

	

	public Dish(int dishId, String dishName, double cost, double timeToCook) {
		super();
		this.dishId = dishId;
		this.dishName = dishName;
		this.cost = cost;
		this.timeToCook = timeToCook;
		this.list = new ArrayList<Location>();
		
	}

	

	public Dish() {
		// TODO Auto-generated constructor stub
	}



	public Dish(int dishno) 
	{
		// TODO Auto-generated constructor stub
		this.dishId = dishno;
	}



	@Override
	public String toString() {
		return "Dish [dishId=" + dishId + ", dishName=" + dishName + ", cost="
				+ cost + ", timeToCook=" + timeToCook + ", list=" + list + "]";
	}

	public int getDishId() {
		return dishId;
	}
	public void setDishId(int dishId) {
		this.dishId = dishId;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getTimeToCook() {
		return timeToCook;
	}
	public void setTimeToCook(double timeToCook) {
		this.timeToCook = timeToCook;
	}
	public List<Location> getList() {
		return list;
	}
	public void setList(List<Location> list) {
		this.list = list;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dishId;
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
		Dish other = (Dish) obj;
		if (dishId != other.dishId)
			return false;
		return true;
	}
	
	
	
}
