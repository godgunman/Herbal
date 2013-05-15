package tw.edu.ntust.dt.herbal;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import com.sileria.android.Kit;

public class ShopActivity extends Activity {
	
	
	private ImageView mHeadButtonBackground;
	private Button mShop1Button;
	private Button mShop2Button;
	private Button mShop3Button;
	private Button mShop4Button;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Kit.init(this); 
		setContentView(R.layout.shop);
		
		mHeadButtonBackground = (ImageView) findViewById(R.id.shop_head_button_background);
		
		mShop1Button = (Button) findViewById(R.id.shop_button_1);
		mShop2Button = (Button) findViewById(R.id.shop_button_2);
		mShop3Button = (Button) findViewById(R.id.shop_button_3);
		mShop4Button = (Button) findViewById(R.id.shop_button_4);
		
		mShop1Button.setOnClickListener(mButtonClickListener);
		mShop2Button.setOnClickListener(mButtonClickListener);
		mShop3Button.setOnClickListener(mButtonClickListener);
		mShop4Button.setOnClickListener(mButtonClickListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.shop, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_logout:
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
	private OnClickListener mButtonClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch(v.getId()){
			case R.id.shop_button_1:
				mHeadButtonBackground.setImageResource(R.drawable.shop_button_1);
				break;
			case R.id.shop_button_2:
				mHeadButtonBackground.setImageResource(R.drawable.shop_button_2);
				break;
			case R.id.shop_button_3:
				mHeadButtonBackground.setImageResource(R.drawable.shop_button_3);
				break;
			case R.id.shop_button_4:
				mHeadButtonBackground.setImageResource(R.drawable.shop_button_4);
				break;
			}
			
		}
	};
	
}
