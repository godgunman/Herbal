package tw.edu.ntust.dt.herbal;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class ConfirmActivity extends Activity {

	String cart[];

	private TextView mPriceTextView;
	private EditText mInputPeople;
	private EditText mInputPhone;
	private EditText mInputSerial;
	private ImageView mConfirmButton;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.confirm);
		if(getIntent().getExtras()!= null){
			cart = getIntent().getExtras().getStringArray("cart");
		}else{
			cart = new String[0];
		}
		generateCartList();
		mPriceTextView = (TextView) findViewById(R.id.price);
		mPriceTextView.setText("$"+cart.length*150);
		
		mInputPeople = (EditText) findViewById(R.id.input_people);
		mInputPeople = (EditText) findViewById(R.id.input_phone);
		mInputPeople = (EditText) findViewById(R.id.input_serial);
		
		mConfirmButton = (ImageView) findViewById(R.id.button_confirm);
		mConfirmButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				AlertDialog.Builder builder = new Builder(ConfirmActivity.this);
				builder.setMessage("訂單已送出");
				builder.create().show();
				
			}
		});
	}

	private void generateCartList() {
		LinearLayout parent = (LinearLayout) findViewById(R.id.herbal_carts);
		parent.removeAllViews();
		for (String item : cart) {
			ImageView image = new ImageView(this);
			int resourceId = Constants.herbalToConfirmDrawableId.get(item);
			image.setImageResource(resourceId);
			image.setScaleType(ScaleType.CENTER_CROP);
			image.setAdjustViewBounds(true);

			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0,
					LayoutParams.WRAP_CONTENT, 1);
			parent.addView(image, params);
		}
	}

}
