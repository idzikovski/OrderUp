package orderinfo;

import java.util.ArrayList;
import java.util.HashMap;

import android.util.Log;

public class Order {
	
	public static final String delimiter = ";"; 
	public static HashMap<String, OrderItem> items=new HashMap<>();

	public Order(HashMap<String, OrderItem> items) {
		super();
		this.items = items;
	}
	
	public static void addOrder(OrderItem oi) {
		items.put(oi.getItem().getName(), oi);
		Log.d("Order class", items.get(oi.getItem().getName()).getItem().getName());
	}
	
	public static void clear(){
		items.clear();
	}
	
	public static int getSize() {
		return items.size();
	}

	public static String getConvertedHashMapToString() {
		String str = new String();
		for (OrderItem value : Order.items.values()) {
		    str+=value.item.getName();
		    str+=delimiter;
		    str+=Integer.toString(value.quantity);
		    str+=delimiter;
		}
		return str;
	}
}
