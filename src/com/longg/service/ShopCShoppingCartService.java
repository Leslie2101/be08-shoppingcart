package com.longg.service;

import java.time.LocalDateTime;

import com.longg.common.Storage;
import com.longg.dto.Cart;
import com.longg.dto.Customer;

public class ShopCShoppingCartService implements ShoppingCartService {

	private final String CHECKOUT_LOG_PATH = "src/com/longg/log/checkOutLog.txt";

	@Override
	public void checkOut(Customer c, Cart cart) {
		// TODO Auto-generated method stub
		System.out.println("Write to file");

		FileService fileService = new FileService();
		
		if (!fileService.isFileExisted(CHECKOUT_LOG_PATH)) {
			fileService.createFile(CHECKOUT_LOG_PATH);
		}
		
		fileService.writeToFile(CHECKOUT_LOG_PATH, c.id + "," + this.calculateInitialCost(cart) + "," + LocalDateTime.now());
		
	}

}
