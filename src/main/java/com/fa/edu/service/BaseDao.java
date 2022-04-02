package com.fa.edu.service;

import java.util.List;

public interface BaseDao<T, K> {
	
	List<T> getAll();
	
	T createObj(T obj);
	
	T updateObj(T obj);
	
	T getById(K key);
	
	boolean deleteById(K key);
}
