package orderinfo;

import category.Subcategory;

public class OrderItem {
	public Subcategory item;
	public int quantity;
	
	
	public OrderItem(Subcategory item, int quantity) {
		super();
		this.item = item;
		this.quantity = quantity;
	}


	public Subcategory getItem() {
		return item;
	}


	public void setItem(Subcategory item) {
		this.item = item;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
