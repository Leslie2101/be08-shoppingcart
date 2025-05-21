package com.longg.service;

import com.longg.dto.Customer;

public class ShopAAuthenService implements AuthenService {
	
	public void afterLogin(Customer c) {
		System.out.println("Shop A: Sent email for logging in successfully");
	} 

}
