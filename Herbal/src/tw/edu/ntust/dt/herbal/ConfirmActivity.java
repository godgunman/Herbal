package tw.edu.ntust.dt.herbal;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ConfirmActivity extends Activity {

	String cart[];
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.confirm);
		
		cart = getIntent().getExtras().getStringArray("cart");
		generateCartList();
	}
	
	private void generateCartList(){
		LinearLayout parent = (LinearLayout) findViewById(R.id.herbal_carts);
		parent.removeAllViews();
		for(String item: cart){
			ImageView image = new ImageView(this);
			
		}
	}
	
}
