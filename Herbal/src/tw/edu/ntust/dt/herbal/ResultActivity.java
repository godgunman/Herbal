package tw.edu.ntust.dt.herbal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class ResultActivity extends Activity {

	private ImageView buttonBackground;
	private Button normalButton;
	private Button mealButton;
	private Button sportButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);
		findViews();
		setListeners();

	}

	private void findViews() {
		buttonBackground = (ImageView) findViewById(R.id.result_button_background);
		normalButton = (Button) findViewById(R.id.result_button_normal);
		mealButton = (Button) findViewById(R.id.result_button_meal);
		sportButton = (Button) findViewById(R.id.result_button_sport);

	}

	private void setListeners() {
		normalButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				buttonBackground
						.setImageResource(R.drawable.result_head_button_normal);
			}
		});

		mealButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				buttonBackground
						.setImageResource(R.drawable.result_head_button_meal);
			}
		});

		sportButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				buttonBackground
						.setImageResource(R.drawable.result_head_button_sport);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.result, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_next:
			Intent intent = new Intent(this, HistoryActivity.class);
			startActivity(intent);
			return true;
		case R.id.menu_logout:
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
