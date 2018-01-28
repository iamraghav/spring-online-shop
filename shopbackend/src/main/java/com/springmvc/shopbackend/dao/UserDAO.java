package com.springmvc.shopbackend.dao;

import com.springmvc.shopbackend.dto.Address;
import com.springmvc.shopbackend.dto.Cart;
import com.springmvc.shopbackend.dto.User;

public interface UserDAO {

	// add new user
	boolean addUser(User user);
	User getByEmail(String email);
	
	// add an address
	boolean addAddress(Address address);
	
	// add a cart
	boolean updateCart(Cart cart);
	
}
