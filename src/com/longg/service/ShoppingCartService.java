package com.longg.service;

import com.longg.dto.Cart;
import com.longg.dto.CartItem;
import com.longg.dto.Customer;
import com.longg.dto.Product;
import com.longg.dto.Shop;

public class ShoppingCartService {

	public void addToCart(Cart cart, Product product, int quantity) {
		CartItem item = findProduct(cart, product);

		if (item != null) {
			item.quantity += quantity;
		} else {
			cart.items.add(new CartItem(product, quantity));
		}
	}
	
	public void clearCart(Cart cart) {
		cart.items.clear();
	}

	private CartItem findProduct(Cart cart, Product product) {
		for (CartItem item : cart.items) {
			if (item.name.equals(product.name)) {
				return item;
			}
		}
		return null;
	}

	public void showCart(Cart cart) {
		if (cart.items.size() == 0) {
			System.out.println("Your cart is empty");
			return;
		}
		for (CartItem i : cart.items) {
			System.out.println(i.name + " = " + i.price + ". quantity = " + i.quantity);
		}
	}
	
	
	public float calculateInitialCost(Cart cart) {
		float cost = 0;
		for (CartItem i : cart.items) {
			cost += (i.price * i.quantity);
		}
		
		return cost;
	}
	
	public float calculateShippingFee(Shop s, Customer c) {
		return 5;
	}
	
	public float calculateFinalCost(Cart cart, Shop s, Customer c) {
		float cost = calculateInitialCost(cart);
		float shippingFee = calculateShippingFee(s, c);
		
		// apply rank promo if possible
		if (c.rank == null) {
			return cost + shippingFee;
		}
		
		return c.rank.applyRankPromo(cost, shippingFee);
	}
	
	public void showCost(Cart cart, Shop s, Customer c) {
		System.out.println("Cost " + calculateInitialCost(cart));
		System.out.println("Shipping fee " + calculateShippingFee(s, c));
		
		if (c.rank != null) {
			System.out.println("Rank promo applied: " + c.rank.getDescription());
		}
		System.out.println("Total cost " +  calculateFinalCost(cart, s, c));
	}
}
