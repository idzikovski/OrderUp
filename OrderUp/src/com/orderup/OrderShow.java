package com.orderup;

import orderinfo.Order;
import orderinfo.OrderItem;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ListView;
import android.widget.Toast;
import category.OrderShowList;

public class OrderShow extends Activity {
	
	ListView listOrder;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		Log.d("btn", "u on cReatu sam za order show");
		setContentView(R.layout.order_show);
		Log.d("btn", "lista");
		listOrder = (ListView) findViewById(R.id.listOrder);
		Log.d("btn", "pre velicine");
		int mapSize= orderinfo.Order.getSize();
		Log.d("btn", "pre fora za hash");
		String[] name=new String[mapSize];
		String[] quantity=new String[mapSize];
		int i=0;
		for (OrderItem value : Order.items.values()) {
		    name[i]=value.item.getName();
		    quantity[i]=Integer.toString(value.quantity);
		    i++;
		}
		Log.d("btn", "posle fora za hash");
		
		OrderShowList adapter =new OrderShowList(this, name, quantity); 
		listOrder.setAdapter(adapter);
		
	}
	
public void btnSendOrderClicked(View view){
		
	}
	public void btnCheckOrderClicked(View view){
		Intent intent=new Intent(this, OrderShow.class);
		startActivity(intent);
	}
	public void btnCancelOrderClicked(View view){
		Order.clear();
		Toast.makeText(this, "Order canceled!", Toast.LENGTH_LONG).show();
	}
	
}
