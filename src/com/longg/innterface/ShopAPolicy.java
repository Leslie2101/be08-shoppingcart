package com.longg.innterface;

public class ShopAPolicy extends ShopPolicy{

	@Override
	public void afterLogin() {
		// send email 
		System.out.println("Send an email!");
		
	}

	@Override
	public void afterCheckout() {
		System.out.println("Send checkout email");
		
		
	}
	

}
