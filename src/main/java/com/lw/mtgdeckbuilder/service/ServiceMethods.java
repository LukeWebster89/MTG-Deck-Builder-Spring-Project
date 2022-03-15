package com.lw.mtgdeckbuilder.service;

import java.util.List;

public interface ServiceMethods <T>{
	
	//create
	T create(T card);
	
	//readAll
	List<T> readAll();
	
	//readById
	T readById(long id);
	
	//update
	T update(long id, T card);
	
	//delete
	boolean delete(long id);
	
	

}
