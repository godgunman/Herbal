package tw.edu.ntust.dt.herbal2.activity;

import tw.edu.ntust.dt.herbal2.R;
import tw.edu.ntust.dt.herbal2.R.anim;
import tw.edu.ntust.dt.herbal2.R.drawable;
import tw.edu.ntust.dt.herbal2.R.id;
import tw.edu.ntust.dt.herbal2.R.layout;
import tw.edu.ntust.dt.herbal2.R.menu;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);

		int resId = getSharedPreferences("herbal", Context.MODE_PRIVATE).getInt(
				"resId", R.drawable.result_jian);
		String name = getSharedPreferences("fb", Context.MODE_PRIVATE)
				.getString("name", "unknown");

		((ImageView) findViewById(R.id.result_image)).setImageResource(resId);
		((TextView) findViewById(R.id.name)).setText(name);

		new AsyncTask<Void, Void, Void>() {

			@Override
			protected Void doInBackground(Void... voids) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return null;
			}

			protected void onPostExecute(Void result) {
				findViewById(R.id.progressBar).setVisibility(View.GONE);

				Animation animationFadeIn = AnimationUtils.loadAnimation(
						ResultActivity.this, R.anim.fadein);

				View afterLoading = findViewById(R.id.after_lading);
				afterLoading.setVisibility(View.VISIBLE);
				afterLoading.startAnimation(animationFadeIn);
			};
		}.execute();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/**
	 * onClick for search_button
	 * 
	 * @param view
	 */
	public void clickSearchButton(View view) {
		Intent intent = new Intent();
		intent.setClass(this, DiscoverActivity.class);
		startActivity(intent);
	}
}