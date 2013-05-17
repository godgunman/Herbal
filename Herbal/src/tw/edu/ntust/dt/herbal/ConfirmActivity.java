package tw.edu.ntust.dt.herbal;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class ConfirmActivity extends Activity {

	String cart[];
	
	private TextView mPriceTextView;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.confirm);
		
		cart = getIntent().getExtras().getStringArray("cart");
		generateCartList();
		
		mPriceTextView = (TextView) findViewById(R.id.price);
		mPriceTextView.setText(""+cart.length*150);
	}
	
	private void generateCartList(){
		LinearLayout parent = (LinearLayout) findViewById(R.id.herbal_carts);
		parent.removeAllViews();
		for(String item: cart){
			ImageView image = new ImageView(this);
			int resourceId = Constants.herbalToConfirmDrawableId.get(item);
			image.setImageResource(resourceId);
			image.setAdjustViewBounds(true);
			
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0,
					LayoutParams.WRAP_CONTENT, 1);
			parent.addView(image, params);
		}
	}
	
	
}
