package com.springmvc.shopbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springmvc.shopbackend.dao.UserDAO;
import com.springmvc.shopbackend.dto.Address;
import com.springmvc.shopbackend.dto.Cart;
import com.springmvc.shopbackend.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Cart cart = null;
	private Address address = null;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.springmvc.shopbackend");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
	@Test
	public void testAdd() {
	
		user = new User();
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("1234554321");
		user.setRole("USER");
		user.setPassword("123456");
		
		// add the user
		assertEquals("Failed to add user!", true, userDAO.addUser(user));
		
		address = new Address();
		address.setAddressLineOne("101/B Jadoo Society Krissh Nagar");
		address.setAddressLineTwo("Near Kaabil Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("40001");
		address.setBilling(true);
		
		// link the user with the address using user id
		 address.setUserId(user.getId());
		
		//add the address
		assertEquals("Failed to add address!", true, userDAO.addAddress(address));
		
		if(user.getRole().equals("USER")) {
			
			//create a cart for this user
			cart = new Cart();
			cart.setUserId(user.getId());
			
			//add the cart
			assertEquals("Failed to add cart!", true, userDAO.addCart(cart));
			
			//add a shipping address for this user
			address = new Address();
			address.setAddressLineOne("201/B Jadoo Society Kishan Kanhaiya Nagar");
			address.setAddressLineTwo("Near Kudrat Store");
			address.setCity("Mumbai");
			address.setState("Maharashtra");
			address.setCountry("India");
			address.setPostalCode("40001");
			//set shipping to true
			address.setShipping(true);
			
			// link the user with the  user 
			address.setUserId(user.getId());
			
			//add the shipping address
			assertEquals("Failed to add shipping address!", true, userDAO.addAddress(address));
		}
		
	}
	
}
