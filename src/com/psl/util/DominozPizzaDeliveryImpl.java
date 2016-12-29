package com.psl.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.psl.bean.Dish;
import com.psl.bean.Location;
import com.psl.bean.Order;


public class DominozPizzaDeliveryImpl implements DominozPizzaDelivery {


	@Override
	public void populateData(String dishFile, String locationFile,
			List<Dish> dishs, List<Location> locations) 
	{
		
		
		String locline;
		try
		{

			BufferedReader location= new BufferedReader(new FileReader(locationFile));
			String arr[];
			do {
				
				locline=location.readLine();
				/*if(locline.isEmpty())
				{
					break;
				}*/
				if(locline!=null)
				{
					arr=locline.split(",");
					locations.add(new Location(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Double.parseDouble(arr[2])));
				}

				}while(locline!=null); 
			
		}catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		///////////////////////////////// for reading Dish file/////////////////////////////////////////

		try 
		{
			BufferedReader dish= new BufferedReader(new FileReader(dishFile));
			
			String dishline;
			do
			{
				String arr[];
				dishline=dish.readLine();
				/*if(dishline.isEmpty())
				{
					break;
				}*/
				if(dishline!=null)
				{
					arr=dishline.split(",");
					dishs.add(new Dish(Integer.parseInt(arr[0]), arr[1], Double.parseDouble(arr[2]), Double.parseDouble(arr[3])));
				}
			}while(dishline!=null);
		}
		catch (FileNotFoundException e) 
		{
					e.printStackTrace();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		for(Dish d:dishs)
		{
			d.setList(locations);
		}
		
		
		System.out.println("\n\nDish file------------------");
		
		for(Dish d:dishs)
		{
			System.out.println(d);
		}
	}
			@Override
	public void calculateLocationForDistance(List<Dish> dishs,
			List<Location> locations)
	{
				List<Location>list=null;
	for(Dish d:dishs)
	{
		list= new ArrayList<Location>();
		for(Location l:locations)
		{
			if((d.getTimeToCook()+l.getLocationTime())<30)
			{
				list.add(l);
				d.setList(list);
			}
		}
	}
	
	for(Dish s:dishs)
	{
		System.out.println(s);
	}
	}
			

	@Override
	public List<Order> calculateOrder(String orderFile, List<Dish> dishs,
			List<Location> locations) {
		List<Order>list=new ArrayList<Order>();
		double price=1;										//Rs.1/km
		try 
		{

			BufferedReader buffer= new BufferedReader(new FileReader(orderFile));
			String line;
			do
			{
				line=buffer.readLine();
				if(line!=null)
				{
					String arr[]=line.split(",");
					list.add(new Order(Integer.parseInt(arr[0]), Integer.parseInt(arr[1])));
				}
			}while(line!=null);
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Order> temp = new ArrayList<Order>();		
		for(Dish d:dishs)
		{
			for(Order o:list)
			{
				if(o.getDishId()==d.getDishId())
				{
					for(Location l:locations)
					{
						if(o.getLocationCode()==l.getLocationCode())
						{
							if((d.getTimeToCook()+l.getLocationTime())<30) // time to cook + location time should be less than 30 min
							{
								o.setTotalCost(d.getCost()+l.getLocationDistance()*price);
							}
							else
							{
								temp.add(o);
							}
						}
					}
				}
			}
		}
		list.removeAll(temp);
		return list;
	}

	@Override
	public void freeDelivery(List<Order> orders, List<Dish> dishs,
			List<Location> locations) 
	{
		
		for(Order order:orders)
		{
			Dish tmpdish = dishs.get(dishs.indexOf(new Dish(order.getDishId())));
			Location tmploc = locations.get(locations.indexOf(new Location(order.getLocationCode())));
			if(tmploc.getLocationDistance() <10 && tmpdish.getCost() >200)
			{
				//order.setTotalCost(0);
				System.out.println("Free Delivery Order :" +order);
			}
		}
		
		/*int i=1;
		for(Order o: orders)
		{
			
			if(o.getTotalCost()==0)
			{
				System.out.println("Free Delivery Order"+i+" : "+o);
			}
			i++;
		}*/
	
	}
	
}
