package com.longg.service;

import java.time.LocalDateTime;

import com.longg.common.Storage;
import com.longg.dto.Customer;

public class ShopCAuthenService implements AuthenService {
	
	private final String LOGIN_LOG_PATH = "src/com/longg/log/checkInLog.txt";

	@Override
	public void afterLogin(Customer c) {
		// TODO Auto-generated method stub
		System.out.println("Write to file");

		FileService fileService = new FileService();
		
		if (!fileService.isFileExisted(LOGIN_LOG_PATH)) {
			fileService.createFile(LOGIN_LOG_PATH);
		}
		
		fileService.writeToFile(LOGIN_LOG_PATH, c.id + "," + LocalDateTime.now());
		

	}

}
