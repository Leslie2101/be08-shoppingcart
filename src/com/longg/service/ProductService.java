package com.longg.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.longg.common.Storage;
import com.longg.dto.Product;
import com.longg.dto.Shop;

public class ProductService {
	private final String PRODUCT_FILE_PATH = "src/com/longg/db/";
	public ArrayList<Product> getProductsByShop() {
		
		try {
		      File myObj = new File(PRODUCT_FILE_PATH + Storage.shop.dbPath + "/products.txt");
		      Scanner myReader = new Scanner(myObj);
		      ArrayList<Product> products = new ArrayList<>();
		      myReader.nextLine();
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        Product p = readProductRow(data);
		        products.add(p);
		      }
		      myReader.close();
		      
		      return products;
		      
		      
		      
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
	    }
		
		return new ArrayList<Product>();
	 }
	
	private Product readProductRow(String line) {
		Scanner rowScanner = new Scanner(line);
		rowScanner.useDelimiter(",");
		String name = rowScanner.next();
		String price = rowScanner.next();
		rowScanner.close();
		return new Product(name, Integer.parseInt(price));
		
	}
}
