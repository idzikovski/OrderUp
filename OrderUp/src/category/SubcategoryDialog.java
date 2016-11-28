package category;


import orderinfo.Order;
import orderinfo.OrderItem;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.orderup.R;
import com.orderup.SubcategoryActivity;


public class SubcategoryDialog extends Dialog implements NumberPicker.OnValueChangeListener{

	public static final String TAGG = "is";
	String name; 
	int price;
	Integer imgId;
	Button ok;
	Context context;
	ImageView imgProduct;
	TextView txtPrice;
	NumberPicker np;
	int sum;
	public SubcategoryDialog(Context context, String name,int price, Integer img) {
		super(context);
		this.context=context;
		this.name = name;
		this.price = price;
		this.imgId = img;
	}

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sub_dialog);
		setCancelable(true);
		
		TextView txtName = (TextView) findViewById(R.id.nazivSubDialog);
		txtPrice= (TextView) findViewById(R.id.txtPrice);
		imgProduct= (ImageView) findViewById(R.id.imgProduct);
		imgProduct.setImageResource(imgId);
		txtName.setText(name);
		
		np = (NumberPicker) findViewById(R.id.np);
		String[] nums = new String[20];
		for(int i=0; i<20; i++) {
			nums[i] =  Integer.toString(i+1);
		}
		np.setMinValue(1);
		np.setMaxValue(20);
		np.setWrapSelectorWheel(false);
		np.setDisplayedValues(nums);
		np.setValue(1);
		np.setOnValueChangedListener(this);
		
		sum = np.getValue() * price;
		txtPrice.setText(Integer.toString(sum));
		ok = (Button) findViewById(R.id.btnAddItem);
		ok.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Subcategory subcategory = new Subcategory(name, price);
				OrderItem orderItem = new OrderItem(subcategory, np.getValue());
				Order.addOrder(orderItem);
				
				Toast.makeText(context, "Item added to list!", Toast.LENGTH_LONG).show();
				SubcategoryActivity activity=(SubcategoryActivity) context;
				activity.dialog.dismiss();
				
			}
		});
	}

	@Override
	public void onValueChange(NumberPicker picker, int oldValue, int newValue) {
		// TODO Auto-generated method stub
		sum = newValue * price;
		txtPrice.setText(Integer.toString(sum));
	}
}
