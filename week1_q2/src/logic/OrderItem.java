package logic;

public class OrderItem {
	private Item item;
	private int itemAmount;
	
	public OrderItem( Item item, int itemAmount ) {
		setItem(item);
		setItemAmount(itemAmount);
	}
	
	public void increaseItemAmount( int amount ) {
		if ( amount > 0 ) this.itemAmount += amount;
	}
	
	public int calculateTotalPrice() {
		return this.item.getPricePerPiece() * this.getItemAmount();
	}
	
	public void setItem( Item item ) {
		this.item = item;
	}
	
	public void setItemAmount( int itemAmount ) {
		if ( itemAmount < 0 ) this.itemAmount = 0;
		else this.itemAmount = itemAmount;
	}
	
	public Item getItem() {
		return this.item;
	}
	
	public int getItemAmount() {
		return this.itemAmount;
	}
}
