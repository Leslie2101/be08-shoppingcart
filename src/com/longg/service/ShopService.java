package com.longg.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.longg.dto.Customer;
import com.longg.dto.Shop;
import com.longg.innterface.ShopPolicy;

public class ShopService {
	private final String SHOP_PATH = "src/com/longg/db/shop/shop.txt";
	
	public ArrayList<Shop> getShops() {
			
		
		try {
		      File myObj = new File(SHOP_PATH);
		      Scanner myReader = new Scanner(myObj);
		      ArrayList<Shop> shops = new ArrayList<>();
		      myReader.nextLine();
		      while (myReader.hasNextLine()) {
		        String line = myReader.nextLine();
		        Shop s = readShopRow(line);
		        shops.add(s);
		      }
		      myReader.close();
		      
		      return shops;
		      
		      
		      
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
	    }
			
		return new ArrayList<Shop>();
	}
	
	private Shop readShopRow(String line) {
		Scanner rowScanner = new Scanner(line);
		rowScanner.useDelimiter(",");
		String id = rowScanner.next();
		String name = rowScanner.next();
		String dbPath = rowScanner.next();
		String policy = rowScanner.next();
		rowScanner.close();
		return new Shop(Integer.parseInt(id), name, dbPath, getShopPolicy(policy));
		
	}
	
	
	public ShopPolicy getShopPolicy(String shopPolicyName) {
		try {
			Class cls = Class.forName("com.longg.innterface." + shopPolicyName);//com.longg.innterface.ShopAPolicy
			ShopPolicy shopPolicy = (ShopPolicy) cls.getDeclaredConstructor().newInstance();
			return shopPolicy;
			
		} catch (ReflectiveOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}

}
