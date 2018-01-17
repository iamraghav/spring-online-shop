package com.springmvc.shopbackend.dao;

import java.util.List;

import com.springmvc.shopbackend.dto.Category;

public interface CategoryDAO {

	
	List<Category> list();
	Category get(int id);
	
}
