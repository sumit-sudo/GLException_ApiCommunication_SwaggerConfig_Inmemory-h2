package com.sumit.restapi.practice.service;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sumit.restapi.practice.customexception.ItemNotSaveException;
import com.sumit.restapi.practice.dao.ItemDaoRepo;
import com.sumit.restapi.practice.entity.Item;

@Service
public class ItemService implements ItemServiceInterface {

	@Autowired
	ItemDaoRepo repo;



	public List<Item> getItems() {
		List<Item> items=(List<Item>) repo.findAll();
		
		for(Item item:items)
		{
			item.setValue(item.getQuantity()*item.getPrice());
			//System.out.println(item.getValue());
		}
		return items;
	}

	@Override
	public Item getItem(int id) {
		
		String name=repo.findItemHavingEvenPrice("Item2");
		System.out.println("Item name by using custom query"+name);
		Item item=repo.findItemHavingPriceQunatityProductGreater();
		System.out.println(item.toString());
		return repo.findById(id).orElse(null);
	}

	@Override
	public Item saveItem(Item item)throws ItemNotSaveException{
		try {
			
		
		DateTimeFormatter format=null;
		String parsedate=null;
		System.out.println("HIi"+item.getDate().length());
		if(item.getDate().length()==11)
		{
			System.out.println("HIIIIIIIIIIII");
			parsedate=item.getDate();
		}
		else
		{
			LocalDate date=LocalDate.parse(item.getDate());
			 format=DateTimeFormatter.ofPattern("yyyy-MMM-dd");
			  parsedate = date.format(format);
		}
		
		
		item.setDate(parsedate);
		return repo.save(item);
		}
		catch(Exception e)
		{
			/*
			 * 1) An exception will be thrown if provided date is not correct.
			 * 	  eg. 2022-Feb-36
			 * 2) Above we have also converted date <->string.
			 */
			throw new ItemNotSaveException("Failed to save Item with error "+ e);
		}
		
	}
	
	

}
