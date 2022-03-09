package com.sumit.restapi.practice.controlleradvice;

import java.time.LocalTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sumit.restapi.practice.customexception.ItemCutsomException;
import com.sumit.restapi.practice.customexception.ItemNotFoundException;
import com.sumit.restapi.practice.customexception.ItemNotSaveException;
import com.sumit.restapi.practice.entity.ItemErrorMessage;

@RestControllerAdvice
public class ControllerAdvice {

	@ExceptionHandler(ItemCutsomException.class)
	public ResponseEntity<ItemErrorMessage> EmptyItemException(ItemCutsomException exe)
	{
		ItemErrorMessage obj=new ItemErrorMessage(HttpStatus.BAD_REQUEST.value(),exe.getMessage(),LocalTime.now());
		return new ResponseEntity<>(obj,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ItemNotFoundException.class)
	public ResponseEntity<ItemErrorMessage> ItemNotFoundException(ItemNotFoundException exe)
	{
		ItemErrorMessage obj=new ItemErrorMessage(HttpStatus.NOT_FOUND.value(),exe.getMessage(),LocalTime.now());
		return new ResponseEntity<>(obj,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ItemNotSaveException.class)
	public ResponseEntity<ItemErrorMessage> ItemNotFoundException(ItemNotSaveException exe)
	{
		ItemErrorMessage obj=new ItemErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(),exe.getMessage(),LocalTime.now());
		return new ResponseEntity<>(obj,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}


