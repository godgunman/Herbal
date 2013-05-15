package tw.edu.ntust.dt.herbal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class SymptomActivity extends Activity {

	public static final String EXTRA_PRAM_PERSCRIPTION_NUM = "EXTRA_PRAM_PERSCRIPTION_NUM";

	private ImageView perscription;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.symptom);
		perscription = (ImageView) findViewById(R.id.perscription);

		int num = getIntent().getIntExtra(EXTRA_PRAM_PERSCRIPTION_NUM, -1);
		if (num != -1) {
			perscription
					.setImageResource(Constants.perscriptionToDrawableId[num]);
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
