package category;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.orderup.R;




public class Subcategorylist extends ArrayAdapter<String> {

	public static final String TAG = "ispis";
	private final Activity context;
	private final String[] name;
	private final Integer[] imageId;

	public Subcategorylist(Activity context,  String[] name,
			Integer[] imageId) {
		super(context, R.layout.subcategory,name);
		this.context = context;
		this.name = name;
		this.imageId = imageId;
		Log.d(TAG, "konstruktor");
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		Log.d(TAG, "usao u get view");
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView = inflater.inflate(R.layout.subcategory, null, true);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.imgSub);
		TextView txtName = (TextView) rowView.findViewById(R.id.nazivSub);

		txtName.setText(name[position]);
		
		imageView.setImageResource(imageId[position]);
		
	
		return rowView;
	}

}