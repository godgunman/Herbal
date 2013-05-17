package tw.edu.ntust.dt.herbal;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends Activity {

	public static final String EXTRA_PRAM_BMP = "EXTRA_PRAM_BMP";

	private ImageView buttonBackground;
	private ImageView leaf;

	private TextView bmpTextView;
	private Button normalButton;
	private Button mealButton;
	private Button sportButton;

	private int bmpValue;
	private int status;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);
		findViews();
		setListeners();

		bmpValue = getIntent().getIntExtra(EXTRA_PRAM_BMP, -1);
		if (bmpValue == -1) {
			bmpValue = new Random().nextInt(60) + 60;
		}

		status = 0;
		setContent();
	}

	private void updateLeafColor() {
		int newBmpValue = bmpValue - status * 15;
		if (newBmpValue < 80) {
			leaf.setImageResource(R.drawable.result_leaf3);
		} else if (newBmpValue < 100) {
			leaf.setImageResource(R.drawable.result_leaf2);
		} else if (newBmpValue < 150) {
			leaf.setImageResource(R.drawable.result_leaf1);
		}
	}

	private void findViews() {
		buttonBackground = (ImageView) findViewById(R.id.result_button_background);
		leaf = (ImageView) findViewById(R.id.leaf);

		bmpTextView = (TextView) findViewById(R.id.bmp);

		normalButton = (Button) findViewById(R.id.result_button_normal);
		mealButton = (Button) findViewById(R.id.result_button_meal);
		sportButton = (Button) findViewById(R.id.result_button_sport);
	}

	private void setContent() {
		bmpTextView.setText(String.valueOf(bmpValue));
		updateLeafColor();
	}

	private void setListeners() {
		normalButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				buttonBackground
						.setImageResource(R.drawable.result_head_button_normal);
				ResultActivity.this.status = 0;
				updateLeafColor();
				Log.d("debug", "normal");
			}
		});

		mealButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				buttonBackground
						.setImageResource(R.drawable.result_head_button_meal);
				ResultActivity.this.status = 1;
				updateLeafColor();
				Log.d("debug", "meal");
			}
		});

		sportButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				buttonBackground
						.setImageResource(R.drawable.result_head_button_sport);
				ResultActivity.this.status = 2;
				updateLeafColor();
				Log.d("debug", "sport");
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
