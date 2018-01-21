package com.springmvc.shopbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springmvc.shopbackend.dao.ProductDAO;
import com.springmvc.shopbackend.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;

	private static ProductDAO productDAO;

	private Product product;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.springmvc.shopbackend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
	}

	/* @Test
	 public void testCRUDProduct() {
	
	 // Create operation
	 product = new Product();
	
	 product.setName("Oppo Selfie S53");
	 product.setBrand("Oppo");
	 product.setDescription("This is some description for oppo mobile phones!");
	 product.setUnitPrice(25000);
	 product.setActive(true);
	 product.setCategory_id(3);
	 product.setSupplierId(3);
	
	 assertEquals("Something went wrong while inserting a new product!", true,
	 productDAO.add(product));
	
	 // reading and updating the category
	 product = productDAO.get(2);
	 product.setName("Samsung Galaxy S7");
	 assertEquals("Something went wrong while updating the exixting record!",
	 true, productDAO.update(product));
	
	 assertEquals("Something went wrong while deleting the exixting record!",
	 true, productDAO.delete(product));
	
	 // list
	 assertEquals("Something went wrong while fetching the list of products!", 4,
	 productDAO.list().size());
	
	 }
	*/
	
	@Test
	public void testListOfActiveProducts(){
		assertEquals("Something went wrong while fetching active records",4,productDAO.listActiveProducts().size());
	}
	@Test
	public void testListOfActiveProductsByCategory(){
		assertEquals("Something went wrong while fetching active records",4,productDAO.listActiveProductsByCategory(3).size());
	}
	
	@Test
	public void testGetLatestActiveProducts(){
		assertEquals("Something went wrong while fetching latest active records",3,productDAO.getLatestActiveProducts(3).size());
}

}
