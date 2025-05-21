package com.longg;

import java.util.ArrayList;
import java.util.Scanner;

import com.longg.common.Storage;
import com.longg.dto.Cart;
import com.longg.dto.CartItem;
import com.longg.dto.Product;
import com.longg.dto.Shop;
import com.longg.service.AuthenService;
import com.longg.service.ProductService;
import com.longg.service.ShopService;
import com.longg.service.ShoppingCartService;

public class Main {

	static Cart cart;
	static Shop shop;
//	static Customer customer;
	static Scanner scan = new Scanner(System.in);
	private static final int VIEW_CART_OPTION_ON_MENU = 0;
	private static final int BACK_TO_MENU = 1;
	private static final int CHECKOUT = 2;

	private static ShoppingCartService cartService = null;
	private static AuthenService authenService = null;

	public static void main(String[] args) {

		boolean isLoggedin;
		
		shop = selectShop();
		Storage.shop = shop;
		authenService = AuthenService.getAuthenService(shop);
		cartService = ShoppingCartService.getCartService(shop);
		
		do {
			isLoggedin = doLogin();
		} while (!isLoggedin);
		

		do {
			showMenu();

			System.out.print("Enter An Option: ");
			int option = scan.nextInt();
			scan.nextLine();

			if (option == VIEW_CART_OPTION_ON_MENU) {
				
				cartService.showCart(cart);
				System.out.println("1. Back to menu\n2. Checkout");
				System.out.print("Enter an option: ");
				int choice = scan.nextInt();
				scan.nextLine();
				
				if (choice == CHECKOUT) {
					checkOut();
				} 
				
				
					
				
			} else {
				doAddProductToCart(option);
			}

		} while (true);
	}
	
	
	
	private static void checkOut() {
		cartService.showCost(cart, shop, Storage.customer);				
		Storage.cost = cartService.calculateInitialCost(cart);
		cartService.checkOut(Storage.customer, cart);
		cartService.clearCart(cart);
		
	}
	

	
	
	private static Shop selectShop() {
		showShops();
		ShopService shopService = new ShopService();

		
		System.out.print("Enter An Option: ");
		int option = scan.nextInt();
		scan.nextLine();
		shop = shopService.getShops().get(option-1);
				
		System.out.println("-------- Welcome to shop " + shop.name + "----------");
		return shop;
		
		
		
	}
	
	
	private static void showShops() {
		ShopService shopService = new ShopService();

		System.out.println("============ Shops ==========");
		for (int i = 0; i < shopService.getShops().size(); i++) {
			System.out.println((i+1) + ". " + shopService.getShops().get(i).name);
		}
		
		System.out.println("=============================");
	}
	
	

	private static void showMenu() {
		System.out.println("=========== Menu ============ ");
		System.out.println("0. View Cart");
		
		ProductService productService = new ProductService();
		ArrayList<Product> products = productService.getProductsByShop();
		for (int i = 0; i < productService.getProductsByShop().size(); i++) {
			System.out.println(
					(i + 1) + ". " + products.get(i).name + " : " + products.get(i).price);
		}
	}

	private static boolean doLogin() {
		System.out.print("Enter ID: ");
		String userID = scan.nextLine();

		// Enter Password
		System.out.print("Enter Password: ");
		String userPassword = scan.nextLine();
		
		boolean isLoggedin = false;
		
		Storage.customer = authenService.login(userID, userPassword);
		if (Storage.customer != null) {
			cart = new Cart();
			cart.items = new ArrayList<CartItem>();
			isLoggedin = true;
			
		}
		return isLoggedin;
	}

	private static void doAddProductToCart(int productIndex) {
		ProductService productService = new ProductService();
		Product selectedProduct = productService.getProductsByShop().get(productIndex - 1);

		System.out.print("Enter quantity : ");
		int quantity = Integer.parseInt(scan.nextLine());

		cartService.addToCart(cart, selectedProduct, quantity);

		System.out.println("Added succesfully.");
	}

}
