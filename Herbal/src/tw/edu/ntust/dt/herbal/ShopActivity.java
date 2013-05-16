package tw.edu.ntust.dt.herbal;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import com.sileria.android.Kit;
import com.sileria.android.Tools;
import com.sileria.android.view.SlidingTray;
import com.sileria.util.Side;

public class ShopActivity extends Activity {

	public static final String EXTRA_PRAM_PERSCRIPTION_NUM = "EXTRA_PRAM_PERSCRIPTION_NUM";

	private LinearLayout herbalList;

	private ImageView mHeadButtonBackground;
	private Button mShop1Button;
	private Button mShop2Button;
	private Button mShop3Button;
	private Button mShop4Button;

	private ImageView mTrayContent;
	private SlidingTray mSlidingTray;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Kit.init(getApplicationContext());
		setContentView(R.layout.shop);

		mHeadButtonBackground = (ImageView) findViewById(R.id.shop_head_button_background);
		herbalList = (LinearLayout) findViewById(R.id.shop_herbal_list);

		mShop1Button = (Button) findViewById(R.id.shop_button_1);
		mShop2Button = (Button) findViewById(R.id.shop_button_2);
		mShop3Button = (Button) findViewById(R.id.shop_button_3);
		mShop4Button = (Button) findViewById(R.id.shop_button_4);

		mShop1Button.setOnClickListener(mButtonClickListener);
		mShop2Button.setOnClickListener(mButtonClickListener);
		mShop3Button.setOnClickListener(mButtonClickListener);
		mShop4Button.setOnClickListener(mButtonClickListener);

		createSlidingTray();
		createHerbalListFromPerscription();
	}

	private void createHerbalListFromPerscription() {
		herbalList.removeAllViews();
		int num = getIntent().getIntExtra(EXTRA_PRAM_PERSCRIPTION_NUM, 0);
		List<String> herbals = Constants.perscriptionToHerbal.get(num);
		for (String herbal : herbals) {
			ImageView imageView = new ImageView(this);
			int drawableId = Constants.herbalToNormalDrawableId.get(herbal);
			imageView.setImageResource(drawableId);
			imageView.setTag(Pair.create(herbal, 0));
			imageView.setOnLongClickListener(triggerHerbalDetail);
			imageView.setOnClickListener(toggleHerbalSelected);

			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0,
					LayoutParams.WRAP_CONTENT, 1);
			herbalList.addView(imageView, params);
		}

	}

	private void createSlidingTray() {
		mTrayContent = new Tools(this).newImage(R.drawable.shop_store_info1);
		mTrayContent.setAdjustViewBounds(true);
		mTrayContent.setScaleType(ImageView.ScaleType.CENTER_CROP);
		ImageView handler = new Tools(this).newImage(R.drawable.handle);
		handler.setAdjustViewBounds(true);
		handler.setScaleType(ImageView.ScaleType.CENTER_CROP);
		mSlidingTray = new SlidingTray(this, handler, mTrayContent,
				SlidingTray.TOP);
		RelativeLayout parent = (RelativeLayout) this
				.findViewById(R.id.tray_parent);
		mSlidingTray.setHandlePosition(Side.TOP);
		parent.addView(mSlidingTray, new RelativeLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.shop, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_logout:
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private OnClickListener mButtonClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.shop_button_1:
				mHeadButtonBackground
						.setImageResource(R.drawable.shop_button_1);
				break;
			case R.id.shop_button_2:
				mHeadButtonBackground
						.setImageResource(R.drawable.shop_button_2);
				break;
			case R.id.shop_button_3:
				mHeadButtonBackground
						.setImageResource(R.drawable.shop_button_3);
				break;
			case R.id.shop_button_4:
				mHeadButtonBackground
						.setImageResource(R.drawable.shop_button_4);
				break;
			}

		}
	};

	private OnLongClickListener triggerHerbalDetail = new OnLongClickListener() {

		@Override
		public boolean onLongClick(View v) {

			/* name and status */
			@SuppressWarnings("unchecked")
			Pair<String, Integer> pair = (Pair<String, Integer>) v.getTag();
			if (pair != null) {
				int drawableId = Constants.herbalToNormalDrawableId
						.get(pair.first);
				int detailId = Constants.herbalDrawableIdToDetailId
						.get(drawableId);
				Intent intent = new Intent(ShopActivity.this,
						HerbalDetailActivity.class);
				intent.putExtra(
						HerbalDetailActivity.EXTRA_PRAM_HERBAL_DETAIL_ID,
						detailId);
				ShopActivity.this.startActivity(intent);
			}
			return false;
		}
	};

	private OnClickListener toggleHerbalSelected = new OnClickListener() {

		@Override
		public void onClick(View v) {
			@SuppressWarnings("unchecked")
			Pair<String, Integer> pair = (Pair<String, Integer>) v.getTag();
			if (pair != null) {
				String herbal = pair.first;
				int status = pair.second;

				int changeId = -1;
				switch (status) {
				case 0:
					changeId = Constants.herbalToPressedDrawableId.get(herbal);
					break;
				case 1:
					changeId = Constants.herbalToNormalDrawableId.get(herbal);
					break;
				}
				if (changeId != -1) {
					((ImageView) v).setImageResource(changeId);
					v.setTag(Pair.create(herbal, 1 - status));
				}
			}
		}
	};

}
