package com.longg.innterface;

public class ShopBPolicy extends ShopPolicy {

	@Override
	public void afterLogin() {
		// TODO Auto-generated method stub
		System.out.println("You have logged in successfully ^^");

	}

	@Override
	public void afterCheckout() {
		// TODO Auto-generated method stub
		System.out.println("total");

	}

}
