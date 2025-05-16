package com.longg.service;

import java.util.ArrayList;

import com.longg.common.Storage;
import com.longg.db.Database;
import com.longg.dto.Customer;
import com.longg.dto.Shop;

// service class -> contain functions 
public class AuthenService {

	// login
	public Customer login(String id, String password) {
		CustomerService customerService = new CustomerService(); 
		for (Customer c : customerService.getCustomerByShop()) {
			if (c.id.equals(id) && c.password.equals(password)) {
				return c;
			}
		}
		return null;
	}

	// logout
}
