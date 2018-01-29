package com.springmvc.onlineshop.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springmvc.onlineshop.model.RegisterModel;
import com.springmvc.shopbackend.dao.UserDAO;
import com.springmvc.shopbackend.dto.Address;
import com.springmvc.shopbackend.dto.Cart;
import com.springmvc.shopbackend.dto.User;

@Component
public class RegisterHandler {
	
	@Autowired
	private UserDAO userDAO;

	public RegisterModel init() {
		
		return new RegisterModel();
		
	}
	
	public void addUser(RegisterModel registerModel, User user) {
		
		registerModel.setUser(user);
		
	}
	
public void addBilling(RegisterModel registerModel, Address billing) {
		
		registerModel.setBilling(billing);
		
	}

public String saveAll(RegisterModel model) {
	
	String transitionValue="success";
	
	//fetch the user
	User user = model.getUser();
	
	if(user.getRole().equals("USER")) {
		Cart cart = new Cart();
		cart.setUser(user);
		user.setCart(cart);
	}
	
	//save the user
	userDAO.addUser(user);
	
	//get the address
	Address billing = model.getBilling();
	billing.setUser(user);
	billing.setBilling(true);
	
	//save the address
	userDAO.addAddress(billing);
	
	
	return transitionValue;
	
}
	
}
