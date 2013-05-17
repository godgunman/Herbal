package tw.edu.ntust.dt.herbal;

import java.util.Random;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
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

	private ProgressDialog progress;

	private int bmpValue;
	private int status;
	private int lastStatus;

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
			if (lastStatus == 0)
				return;
			leaf.setImageResource(R.drawable.result_leaf3);
			lastStatus = 0;
		} else if (newBmpValue < 100) {
			if (lastStatus == 1)
				return;
			leaf.setImageResource(R.drawable.result_leaf2);
			lastStatus = 1;
		} else if (newBmpValue < 150) {
			if (lastStatus == 2)
				return;
			leaf.setImageResource(R.drawable.result_leaf1);
			lastStatus = 2;
		}
	}

	private void findViews() {
		buttonBackground = (ImageView) findViewById(R.id.result_button_background);
		leaf = (ImageView) findViewById(R.id.leaf);

		bmpTextView = (TextView) findViewById(R.id.bmp);

		normalButton = (Button) findViewById(R.id.result_button_normal);
		mealButton = (Button) findViewById(R.id.result_button_meal);
		sportButton = (Button) findViewById(R.id.result_button_sport);

		progress = new ProgressDialog(this);
	}

	private void setContent() {
		bmpTextView.setText(String.valueOf(bmpValue));
		updateLeafColor();
	}

	private void setListeners() {
		normalButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d("debug", "normal");
				if (ResultActivity.this.status == 0) {
					return;
				}
				new ImageLoadTask().execute(R.drawable.result_head_button_normal, 0);
			}
		});

		mealButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d("debug", "meal");
				if (ResultActivity.this.status == 1) {
					return;
				}
				new ImageLoadTask().execute(R.drawable.result_head_button_meal, 1);
			}
		});

		sportButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.d("debug", "sport");
				if (ResultActivity.this.status == 2) {
					return;
				}
				new ImageLoadTask().execute(R.drawable.result_head_button_sport, 2);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.result, menu);
		return true;
	}

	class ImageLoadTask extends AsyncTask<Integer, Void, Void> {

		@Override
		protected void onPreExecute() {
			progress.setTitle("讀取中");
			progress.show();
		}

		@Override
		protected Void doInBackground(Integer... params) {
			// TODO Auto-generated method stub
			final int rid = params[0];
			final int status = params[1];
			ResultActivity.this.runOnUiThread(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					ResultActivity.this.buttonBackground.setImageResource(rid);
					ResultActivity.this.status = status;
					updateLeafColor();
				}
			});
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			progress.dismiss();
		}
	};

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
