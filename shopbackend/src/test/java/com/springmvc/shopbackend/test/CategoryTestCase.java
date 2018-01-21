package com.springmvc.shopbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springmvc.shopbackend.dao.CategoryDAO;
import com.springmvc.shopbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.springmvc.shopbackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	/*
	 * @Test public void testAddCategory() {
	 * 
	 * category = new Category(); category.setName("Laptop");
	 * category.setDescription("This is some description for laptop");
	 * category.setImageURL("CAT_3.png");
	 * 
	 * assertEquals("Successfully added a category inside the table!", true,
	 * categoryDAO.add(category));
	 * 
	 * }
	 */

	/*
	 * @Test public void testGetCategory() {
	 * 
	 * category = categoryDAO.get(3);
	 * 
	 * assertEquals("Successfully fetched a single category from the table!"
	 * ,"Television", category.getName()); }
	 */

	/*
	 * @Test public void testUpdateCategory() {
	 * 
	 * category = categoryDAO.get(3);
	 * 
	 * category.setName("TV");
	 * 
	 * assertEquals("Successfully updated a single category in the table!", true,
	 * categoryDAO.update(category)); }
	 */

	/*
	 * @Test public void testDeleteCategory() {
	 * 
	 * category = categoryDAO.get(3);
	 * 
	 * assertEquals("Successfully deleted a single category in the table!", true,
	 * categoryDAO.delete(category)); }
	 */

	/*
	 * @Test public void testListCategory() {
	 * 
	 * assertEquals("Successfully fetched the list of categories from the table!",
	 * 3, categoryDAO.list().size()); }
	 */

	@Test
	public void testCRUOCategory() {

		// Add operation
		category = new Category();
		category.setName("Laptop");
		category.setDescription("This is some description for laptop");
		category.setImageURL("CAT_1.png");
		assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));

		category = new Category();
		category.setName("Television");
		category.setDescription("This is some description for television");
		category.setImageURL("CAT_2.png");
		assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));

		category = new Category();
		category.setName("Mobile");
		category.setDescription("This is some description for mobile");
		category.setImageURL("CAT_3.png");
		assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));

		// Update operation
		category = categoryDAO.get(2);
		category.setName("TV");
		assertEquals("Successfully updated a single category in the table!", true, categoryDAO.update(category));
		
		// Delete Operation
		assertEquals("Successfully deleted a single category in the table!", true, categoryDAO.delete(category)); 
		
		// Fetching the active list
		assertEquals("Successfully fetched the list of categories from the table!", 2, categoryDAO.list().size());
	}
}


