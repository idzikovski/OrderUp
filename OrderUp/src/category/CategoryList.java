package category;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.orderup.R;




public class CategoryList extends ArrayAdapter<String> {

	public static final String TAG = "ispis";
	private final Activity context;
	private final String[] name;
	private final Integer[] imageId;

	public CategoryList(Activity context,  String[] name,
			Integer[] imageId) {
		super(context, R.layout.single_category,name);
		this.context = context;
		this.name = name;
		this.imageId = imageId;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		Log.d(TAG, "usao u get view");
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView = inflater.inflate(R.layout.single_category, null, true);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
		TextView txtName = (TextView) rowView.findViewById(R.id.name);

		txtName.setText(name[position]);
		imageView.setImageResource(imageId[position]);
		
		Log.d(TAG, "ime: "+position+" position "+position);
		return rowView;
	}

}
