package com.longg.service;

import com.longg.dto.Customer;

public class ShopBAuthenService implements AuthenService{

	@Override
	public void afterLogin(Customer c) {
		// TODO Auto-generated method stub
		System.out.println("You have logged in successfully ^^");

		
	}

}
