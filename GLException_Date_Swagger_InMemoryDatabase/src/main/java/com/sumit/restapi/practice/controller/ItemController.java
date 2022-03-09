package com.sumit.restapi.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sumit.restapi.practice.customexception.ItemCutsomException;
import com.sumit.restapi.practice.customexception.ItemNotFoundException;
import com.sumit.restapi.practice.customexception.ItemNotSaveException;
import com.sumit.restapi.practice.entity.Item;
import com.sumit.restapi.practice.service.ItemServiceInterface;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api")
public class ItemController {

	@Autowired
	ItemServiceInterface service;
	
	@ApiOperation(value="This Api will give list of  all item")
	@GetMapping(path="/get_items"
			//consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, 
			//produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
			)
	public List<Item> getItemsFromDatabase() throws ItemCutsomException
	{
		
		List<Item> items = service.getItems();
		if(items.size()==0)
		{
			throw new ItemCutsomException("Item List sumit  is empty");
		}
		return items;
	}
	@ApiOperation("This API will return Item corresponding to passed itemid")
	@GetMapping("/{itemid}")
	public Item getOneItem(@ApiParam(value="enter id of item you want to search ",required=true,example = "100")@PathVariable("itemid") int  itemid) throws ItemNotFoundException
	{
		Item item = service.getItem(itemid);
		if(item==null)
		{
			throw new ItemNotFoundException("The Item for corresponding itemid not available"+itemid);
		}
		return item;
	}
	
	@ApiOperation(value="This API will save the Item")
	@PostMapping("/save")
	public Item saveItem(@ApiParam(value="Enter new Item",required = true,example = "1")@RequestBody Item item) throws ItemNotSaveException
	{
		Item saveItem = service.saveItem(item);
		
		
		if(saveItem==null)
		{
			throw new ItemNotSaveException("Something went wrong, Item details didn't save");
		}
		return saveItem;
	}
	@ApiOperation("This API will update Item Entity by taking Item object as an input parameter")
	@PutMapping("/updateItemById/{id}")
	public Item updateItemByObject(@ApiParam(value="Id of item", required = true,example = "1")@PathVariable("id") int id,
				@ApiParam(value="Enter new values of Item",required = true,example = "1")@RequestBody Item item) throws ItemNotSaveException
	{
		
	/*		This is the best approach to perform Put Mapping
			two input parameter , one is It and another one is Item object
			and then follow below steps
			 Employee employee = employeeRepository.findById(employeeId)
				        .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
			employee.setEmailId(employeeDetails.getEmailId());
			employee.setLastName(employeeDetails.getLastName());
			employee.setFirstName(employeeDetails.getFirstName());
		    Employee updatedEmployee = employeeRepository.save(employee);*/
		
		Item saveItem = service.saveItem(item);
		if(saveItem==null)
		{
			throw new ItemNotSaveException("Item was not upadted "+ item);
		}
		return saveItem;
	}
	
	@ApiOperation("This API will update Item Entity by taking id as pathvariable and values as an parameter")
	@PutMapping("/{id}")
	public Item updateItemById(@ApiParam(value="enter id of item you want to update ",required = true,example = "1")@PathVariable(value="id") int id,@ApiParam(value="Enter new Item name",required = true,defaultValue = "Item0",example = "1")@RequestParam String name,@ApiParam(value="Enter new Item price",required = true,example = "1")@RequestParam(defaultValue = "1") int price) throws ItemNotFoundException, ItemNotSaveException
	{
		Item item=service.getItem(id);
		if(item==null)
		{
			throw new ItemNotFoundException(" Item for the given id is not found" + id );
		}
		item.setName(name);
		item.setPrice(price);
		Item saveItem = service.saveItem(item);
		if(saveItem==null)
		{
			throw new ItemNotSaveException("Item was not upadted "+ item);
		}
		return saveItem;
		
	}
	
	
	
	
	
	
}
