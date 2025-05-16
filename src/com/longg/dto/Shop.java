package com.longg.dto;

import java.util.ArrayList;

import com.longg.innterface.ShopPolicy;

public class Shop {
	
	public int id;
	public String name;
	public String dbPath;
	public ShopPolicy shopPolicy;
	
	
	
	public Shop(int id, String name, String dbPath, ShopPolicy shopPolicy) {
		this.id = id;
		this.name = name;
		this.dbPath = dbPath;
		this.shopPolicy = shopPolicy;
		
	}
	


	
}
