package tw.edu.ntust.dt.herbal2;

import java.util.List;

import tw.edu.ntust.dt.herbal2.adapter.HerbalDiscoverAdapter;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class AllActivity extends Activity {

	private ImageView resultImage;
	private LinearLayout root;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_all);

		int resId = getSharedPreferences("herbal", Context.MODE_PRIVATE)
				.getInt("resId", R.drawable.result_jian);

		root = (LinearLayout) findViewById(R.id.root);

		resultImage = (ImageView) findViewById(R.id.result_image);
		resultImage.setImageResource(getAnotherResultId(resId));

		List<Integer> herbals = HerbalDiscoverAdapter.data.get(resId);
		LayoutInflater layoutInflater = getLayoutInflater();

		for (Integer herbal : herbals) {
			View view = layoutInflater
					.inflate(R.layout.activity_all_item, null);
			((ImageView) view.findViewById(R.id.herbal))
					.setImageResource(herbal);
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

}
