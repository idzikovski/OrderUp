package com.orderup;

import orderinfo.Order;
import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import category.SubcategoryDialog;
import category.Subcategorylist;

public class SubcategoryActivity extends Activity {

	ListView list2;
	String[] txtChosed;
	Integer[] imgChosed;
	Button btnSend;
	Button btnCheck;
	Button btnCancel;
	public SubcategoryDialog dialog;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.subcategorylist);

		Button btnSend = (Button) findViewById(R.id.btnSendOrderS);
		Button btnCheck = (Button) findViewById(R.id.btnCheckOrderS);
		Button btnCancel = (Button) findViewById(R.id.btnCancelOrderS);
		Resources res = getResources();
		String[] txtCoffee = res.getStringArray(R.array.coffee);
		String[] txtBeer = res.getStringArray(R.array.beer);
		String[] txtWine = res.getStringArray(R.array.wine);
		String[] txtSoftDrinks = res.getStringArray(R.array.softDrinks);
		String[] txtCocktails = res.getStringArray(R.array.cocktails);
		
		Integer[] imgSoftDrink = {R.drawable.coca_cola, R.drawable.sprite, R.drawable.prigat};
		Integer[] imgCoffee = {R.drawable.nescafe, R.drawable.macchiato, R.drawable.cappuchino};
		Integer[] imgBeer = { R.drawable.heineken, R.drawable.zlatendab };
		Integer[] imgWine = { R.drawable.vrnec, R.drawable.alexandria };
		Integer[] imgCocktails = {R.drawable.mojito, R.drawable.sex_big, R.drawable.margarita_big};
		
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		int chosedCategory = bundle.getInt("position");
		list2 = (ListView) findViewById(R.id.listSubCategory);
		if (bundle != null) {
			if (chosedCategory == 0) {
				loadDataForAdapter(txtCoffee,imgCoffee,txtCoffee.length);
			}
			else if (chosedCategory == 1) {
				loadDataForAdapter(txtSoftDrinks,imgSoftDrink,txtSoftDrinks.length);
			}
			else if (chosedCategory == 2) {
				loadDataForAdapter(txtBeer,imgBeer,txtBeer.length);
			} 
			else if (chosedCategory == 4) {
				loadDataForAdapter(txtWine,imgWine,txtWine.length);
			} 
			else if (chosedCategory == 5) {
				loadDataForAdapter(txtCocktails,imgCocktails,txtCocktails.length);
			} 
			else {
				loadDataForAdapter(txtWine,imgWine,txtWine.length);
			}
		} 
		Subcategorylist adapter = new Subcategorylist(SubcategoryActivity.this,
				txtChosed, imgChosed);
		list2.setAdapter(adapter);
		list2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
					dialog = new SubcategoryDialog(SubcategoryActivity.this, txtChosed[position],100,imgChosed[position]);
					dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
					dialog.show();
			}
		});
		btnSend.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		btnCheck.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.d("btn", "asdasd");
				Intent intent=new Intent(SubcategoryActivity.this, OrderShow.class);
				startActivity(intent);
				Log.d("btn", "posle start activitia");
			}
		});
		btnCancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Order.clear();
				Toast.makeText(SubcategoryActivity.this, "Order canceled!", Toast.LENGTH_LONG).show();
			}
		});
	}
	public void loadDataForAdapter(String[] txt,Integer[] img,int size) 
	{
		txtChosed = new String[size];
		imgChosed= new Integer[size];
		txtChosed = txt;
		imgChosed = img;
	}
	
	
}
