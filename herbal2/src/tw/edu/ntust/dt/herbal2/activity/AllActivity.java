package tw.edu.ntust.dt.herbal2.activity;

import java.util.List;

import tw.edu.ntust.dt.herbal2.DataHelper;
import tw.edu.ntust.dt.herbal2.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class AllActivity extends Activity {

	private ImageView resultImage;
	private LinearLayout root;

	private SharedPreferences sp;
	private SharedPreferences.Editor editor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_all);

		sp = getSharedPreferences("herbal", Context.MODE_PRIVATE);
		editor = sp.edit();
		int resId = sp.getInt("resId", R.drawable.result_jian);

		root = (LinearLayout) findViewById(R.id.root);

		resultImage = (ImageView) findViewById(R.id.result_image);
		resultImage.setImageResource(getAnotherResultId(resId));

		List<Integer> herbals = DataHelper.resIdToHerbals.get(resId);
		LayoutInflater layoutInflater = getLayoutInflater();

		for (final Integer herbal : herbals) {

			final int recipe = DataHelper.herbalToRecipe.get(herbal);
			OnClickListener onClickListener = new OnClickListener() {
				@Override
				public void onClick(View v) {
					editor.putInt("recipeResId", recipe);
					editor.commit();
					goToRecipeActivity(v);
				}
			};

			View view = layoutInflater
					.inflate(R.layout.activity_all_item, null);

			ImageView img = ((ImageView) view.findViewById(R.id.herbal));
			img.setImageResource(herbal);
			img.setOnClickListener(onClickListener);

			view.findViewById(R.id.herbal_method).setOnClickListener(
					onClickListener);

			root.addView(view);
		}
	}

	private int getAnotherResultId(int resId) {
		switch (resId) {
		case R.drawable.result_jian:
			return R.drawable.all_jian;
		case R.drawable.result_jie:
			return R.drawable.all_jie;
		case R.drawable.result_nee:
			return R.drawable.all_nee;
		case R.drawable.result_ya:
			return R.drawable.all_ya;
		case R.drawable.result_yen:
			return R.drawable.all_yen;
		case R.drawable.result_yenyen:
			return R.drawable.all_yenyen;
		default:
			return -1;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void goToRecipeActivity(View view) {
		startActivity(new Intent(this, RecipeActivity.class));
	}

}
