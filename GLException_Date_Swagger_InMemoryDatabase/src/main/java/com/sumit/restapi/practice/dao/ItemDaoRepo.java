package com.sumit.restapi.practice.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sumit.restapi.practice.entity.Item;




@Repository
public interface ItemDaoRepo extends CrudRepository<Item, Integer> {

	//Implementing Hibernate query using field from entity class
	@Query("Select name from Item where name=:param1")
	String findItemHavingEvenPrice(@Param("param1") String str);

	//Implementing SQL and comparison operator
	@Query(value="select * from Item where price*quantity > 100",nativeQuery = true)
	Item findItemHavingPriceQunatityProductGreater();

}
