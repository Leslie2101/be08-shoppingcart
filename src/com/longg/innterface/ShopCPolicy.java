package com.longg.innterface;

import com.longg.common.Storage;
import com.longg.service.FileService;import java.time.LocalDateTime; 



public class ShopCPolicy extends ShopPolicy {
	
	private final String LOGIN_LOG_PATH = "src/com/longg/log/checkInLog.txt";
	private final String CHECKOUT_LOG_PATH = "src/com/longg/log/checkOutLog.txt";
	
	@Override
	public void afterLogin() {
		
		System.out.println("Write to file");

		FileService fileService = new FileService();
		
		if (!fileService.isFileExisted(LOGIN_LOG_PATH)) {
			fileService.createFile(LOGIN_LOG_PATH);
		}
		
		fileService.writeToFile(LOGIN_LOG_PATH, Storage.customer.id + "," + LocalDateTime.now());
		
		
		
		

	}

	@Override
	public void afterCheckout() {
		// TODO Auto-generated method stub
		System.out.println("Write to file");

		FileService fileService = new FileService();
		
		if (!fileService.isFileExisted(CHECKOUT_LOG_PATH)) {
			fileService.createFile(CHECKOUT_LOG_PATH);
		}
		
		fileService.writeToFile(CHECKOUT_LOG_PATH, Storage.customer.id + "," + Storage.cost + "," + LocalDateTime.now());
		

	}

}
