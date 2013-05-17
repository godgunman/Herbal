package tw.edu.ntust.dt.herbal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ImageView;

public class HerbalDetailActivity extends Activity {

	public static final String EXTRA_PRAM_HERBAL_DETAIL_ID = "EXTRA_PRAM_HERBAL_DETAIL_ID";

	private ImageView herbalDetail;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.herbal_detail);
		
		
		herbalDetail = (ImageView) findViewById(R.id.herbal_detail);

		int num = getIntent().getIntExtra(EXTRA_PRAM_HERBAL_DETAIL_ID, -1);
		if (num != -1) {
			herbalDetail.setImageResource(num);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.symptom, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_next:
			Intent intent = new Intent(this, ShopActivity.class);
			startActivity(intent);
			return true;
		case R.id.menu_logout:
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
