package com.longg.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.longg.common.Storage;
import com.longg.dto.Customer;
import com.longg.dto.Shop;

public class CustomerService {
	
	private final String CUSTOMER_FILE_PATH = "src/com/longg/db/";
	public ArrayList<Customer> getCustomerByShop() {
		
		
		try {
		      File myObj = new File(CUSTOMER_FILE_PATH + Storage.shop.dbPath + "/customer.txt");
		      Scanner myReader = new Scanner(myObj);
		      ArrayList<Customer> customers = new ArrayList<>();
		      myReader.nextLine();
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        Customer c = readCustomerRow(data);
		        customers.add(c);
		      }
		      myReader.close();
		      
		      return customers;
		      
		      
		      
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
	    }
		
		return new ArrayList<Customer>();
	 }
	
	private Customer readCustomerRow(String line) {
		Scanner rowScanner = new Scanner(line);
		rowScanner.useDelimiter(",");
		String username = rowScanner.next();
		String password = rowScanner.next();
		rowScanner.close();
		return new Customer(username, password);
		
	}
	
}
