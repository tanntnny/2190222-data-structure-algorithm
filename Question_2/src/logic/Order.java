package logic;

import java.util.ArrayList;

public class Order {
	private ArrayList<OrderItem> orderItemList;
	private static int totalOrderCount = 0;
	private int orderNumber;
	
	public Order() {
		this.orderItemList = new ArrayList<OrderItem>();
		this.orderNumber = totalOrderCount;
		totalOrderCount += 1;
	}

	public OrderItem addItem(Item item, int amount) {
		for (OrderItem orderedItem : orderItemList ) {
			if ( orderedItem.getItem().getName().equals(item.getName()) ) {
				orderedItem.increaseItemAmount(amount);
				return orderedItem;
			}
		}
		OrderItem orderItem = new OrderItem(item, amount);
		orderItemList.add(orderItem);
		return orderItem;
	}

	public int calculateOrderTotalPrice() {
		int totalPrice = 0;
		for (OrderItem orderedItem : orderItemList) {
			totalPrice += orderedItem.calculateTotalPrice();
		}
		return totalPrice;
	}

	public static int getTotalOrderCount() {
		return totalOrderCount;
	}
	
	public static void resetTotalOrderCount() {
		totalOrderCount = 0;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public ArrayList<OrderItem> getOrderItemList() {
		return orderItemList;
	}
	
	
}
