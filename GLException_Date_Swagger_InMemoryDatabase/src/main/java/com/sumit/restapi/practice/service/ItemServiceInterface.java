package com.sumit.restapi.practice.service;

import java.util.List;

import com.sumit.restapi.practice.customexception.ItemNotSaveException;
import com.sumit.restapi.practice.entity.Item;

public interface ItemServiceInterface {

	//public Item getItem();
	public List<Item> getItems();
	public Item getItem(int id);
	public Item saveItem(Item item) throws ItemNotSaveException;
	
	
}
