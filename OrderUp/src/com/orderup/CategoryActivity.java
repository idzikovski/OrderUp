package com.orderup;

import orderinfo.Order;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import category.CategoryList;

public class CategoryActivity extends Activity {

	public static final String TAG = "send";
	ListView list;
	Button btnSend;
	Button btnCheck;
	Button btnCancel;
	String txtSendArray;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.category);

		Resources res = getResources();
		String[] txtCategories = res.getStringArray(R.array.categories);
		Integer[] imgCategory = { R.drawable.arrow_orange,
				R.drawable.arrow_green, R.drawable.arrow_orange,
				R.drawable.arrow_green, R.drawable.arrow_orange,
				R.drawable.arrow_green };

		Button btnSend = (Button) findViewById(R.id.btnSendOrderC);
		Button btnCheck = (Button) findViewById(R.id.btnCheckOrderC);
		Button btnCancel = (Button) findViewById(R.id.btnCancelOrderC);

		list = (ListView) findViewById(R.id.listCategory);
		CategoryList adapter = new CategoryList(CategoryActivity.this,
				txtCategories, imgCategory);
		list.setAdapter(adapter);
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				Intent i = new Intent(CategoryActivity.this,
						SubcategoryActivity.class);
				Bundle b = new Bundle();
				b.putInt("position", position);
				i.putExtras(b);
				startActivity(i);
			}
		});

		btnSend.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				txtSendArray = new String();
				txtSendArray = Order.getConvertedHashMapToString();
				Log.d(TAG, "poruka:"+txtSendArray);
			}
		});
		btnCheck.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.d("btn", "asdasd");
				Intent intent = new Intent(CategoryActivity.this,
						OrderShow.class);
				startActivity(intent);
				Log.d("btn", "posle start activitia");
			}
		});
		btnCancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Order.clear();
				Toast.makeText(CategoryActivity.this, "Order canceled!",
						Toast.LENGTH_LONG).show();
			}
		});
	}

	public void btnSendOrderClicked(View view) {

	}

	public void btnCheckOrderClicked(View view) {
		Log.d("btn", "asdasd");
		Intent intent = new Intent(this, OrderShow.class);
		startActivity(intent);
		Log.d("btn", "after");
	}

	public void btnCancelOrderClicked(View view) {
		Order.clear();
		Toast.makeText(this, "Order canceled!", Toast.LENGTH_LONG).show();
	}

}
