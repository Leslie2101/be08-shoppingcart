package com.longg.service;

import com.longg.dto.Cart;
import com.longg.dto.Customer;

public class ShopAShoppingCartService implements ShoppingCartService{
	
	@Override
	public void checkOut(Customer c, Cart cart) {
		System.out.println("Send checkout email");
	}
	
}
