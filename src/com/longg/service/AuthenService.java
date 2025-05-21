package com.longg.service;

import com.longg.dto.Customer;
import com.longg.dto.Shop;
import com.longg.service.CustomerService;


// service class -> contain functions 
public interface AuthenService {
	

	// login
	default public Customer login(String id, String password) {
		CustomerService customerService = new CustomerService();
		for (Customer c : customerService.getCustomerByShop()) {
			if (c.id.equals(id) && c.password.equals(password)) {
				afterLogin(c);
				return c;
			}
		}
		return null;
	}
	
	
	void afterLogin(Customer c);
	
	
	
	static AuthenService getAuthenService(Shop shop) {
		
		AuthenService service;
		
		switch (shop.id) {
			case 1:
				service = new ShopAAuthenService();
				break;
			case 2:
				service = new ShopBAuthenService();
				break;
			default:
				service = new ShopCAuthenService();
				break;
		}
		return service;
	}

	// logout
}
