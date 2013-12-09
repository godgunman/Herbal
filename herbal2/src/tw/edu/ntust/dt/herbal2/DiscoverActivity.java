package tw.edu.ntust.dt.herbal2;

import tw.edu.ntust.dt.herbal2.adapter.HerbalDiscoverAdapter;
import tw.edu.ntust.dt.herbal2.adapter.HerbalDiscoverAdapter.OnCategoryItemClickListener;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.View;

public class DiscoverActivity extends Activity {

	private ViewPager pager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_discover);

		HerbalDiscoverAdapter adapter = new HerbalDiscoverAdapter(this,
				new OnCategoryItemClickListener() {
					@Override
					public void onClick(View view, int categoryType,
							int targetIndex) {
						// TODO Auto-generated method stub
					}
				});

		int resId = getIntent().getIntExtra("result", -1);
		if (resId == -1) {
			resId = R.drawable.result_jian;
		}

		adapter.setCategoryType(resId);

		pager = (ViewPager) findViewById(R.id.herbal_list);
		pager.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void completeDiscover(View view) {
		Intent intent = new Intent();
		intent.setClass(this, UploadActivity.class);
		startActivity(intent);
	}
}
