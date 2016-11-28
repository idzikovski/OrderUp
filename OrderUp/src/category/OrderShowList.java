package category;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.orderup.R;




public class OrderShowList extends ArrayAdapter<String> {
	public static final String TAG = "ispis";
	String[] name;
	String[] quantity; 
	private final Activity context;
	private TextView txtProductName, txtQuantity;
	public OrderShowList(Activity context, String[] name, String[] quantity) {
		super(context, R.layout.single_order_show,name);
		this.context = context;
		this.name = name;
		this.quantity=quantity;
	}

	
	@Override
	public View getView(int position, View view, ViewGroup parent) {
		Log.d(TAG, "usao u get view");
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView = inflater.inflate(R.layout.single_order_show, null, true);
		txtProductName=(TextView) rowView.findViewById(R.id.txtProductName);
		txtQuantity=(TextView) rowView.findViewById(R.id.txtQuantity);
		
		txtProductName.setText(name[position]);
		txtQuantity.setText(quantity[position]);
		
		Log.d(TAG, "ime: "+position+" position "+position);
		return rowView;
	}

}