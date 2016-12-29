package com.psl.main;

import java.util.ArrayList;
import java.util.List;

import com.psl.bean.Dish;
import com.psl.bean.Location;
import com.psl.bean.Order;
import com.psl.util.DominozPizzaDeliveryImpl;

public class Client {

	public static void main(String[] args) {
		DominozPizzaDeliveryImpl obj=new DominozPizzaDeliveryImpl();
		
		List<Dish> dishList=new ArrayList<Dish>();
		List<Location> locationList=new ArrayList<Location>();
		
		obj.populateData("dish.txt", "location.txt", dishList, locationList);
		
		System.out.println("For Delivery time less than 30");
		obj.calculateLocationForDistance(dishList, locationList);
		
		List<Order>list= new ArrayList<Order>();
		list=obj.calculateOrder("order.txt", dishList, locationList);
		
		for(Order i:list)
		{
			System.out.println(i+"  ");
		}
		System.out.println("Free Delivery ");
		obj.freeDelivery(list, dishList, locationList);
	}
	

}
