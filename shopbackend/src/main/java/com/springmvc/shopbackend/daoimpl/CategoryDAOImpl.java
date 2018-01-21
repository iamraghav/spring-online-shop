package com.springmvc.shopbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.shopbackend.dao.CategoryDAO;
import com.springmvc.shopbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired 
	private SessionFactory sessionFactory;
	
	

	@Override
	public List<Category> list() {

		String selectActiveCategory = "FROM Category WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		
		query.setParameter("active", true);
		
		return query.getResultList();
	}

	// Getting single category based on ID
	@Override
	public Category get(int id) {
		
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	// Methods for performing CRUD Operations
	
	//Add
	@Override
	public boolean add(Category category) {
		
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().persist(category);			
			return true;
			
		} 
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}

	// Update
	@Override
	public boolean update(Category category) {
		
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(category);			
			return true;
			
		} 
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}

	// Delete
	@Override
	public boolean delete(Category category) {
		
		category.setActive(false);
		
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(category);			
			return true;
			
		} 
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}

}
