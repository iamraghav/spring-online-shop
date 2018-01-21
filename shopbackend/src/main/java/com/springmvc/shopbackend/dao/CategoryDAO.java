package com.springmvc.shopbackend.dao;

import java.util.List;

import com.springmvc.shopbackend.dto.Category;

public interface CategoryDAO {

	
	Category get(int id);
	List<Category> list();

	// All Methods for CRUD Operations
	
	// Add
	boolean add(Category category);
	
	// Update
	boolean update(Category category);
	
	// Delete
	boolean delete(Category category);
	
	//
	//boolean add(Category category);
	
}
