package tw.edu.ntust.dt.herbal2.adapter;

import java.util.ArrayList;
import java.util.List;

import tw.edu.ntust.dt.herbal2.R;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

public class HerbalDiscoverAdapter extends PagerAdapter {

	public final static int CATEOGRY_TYPE_STICKER = 0;
	public final static int CATEOGRY_TYPE_FRAME = 1;

	public final static int[] HEADER_IDS = {
			R.drawable.herb_dog,
			R.drawable.herb_dragon,
			R.drawable.herb_fish, };

	private List<ImageView> mViews;
	private int currentCategoryType;

	private OnCategoryItemClickListener clickListener;

	public HerbalDiscoverAdapter(Context context) {
		mViews = new ArrayList<ImageView>();

		for (int i = 0; i < HEADER_IDS.length; i++) {
			ImageView view = new ImageView(context);
			view.setImageResource(HEADER_IDS[i]);
			mViews.add(view);
		}
	}

	public HerbalDiscoverAdapter(Context context,
			final OnCategoryItemClickListener clickListener) {

		this.clickListener = clickListener;
		mViews = new ArrayList<ImageView>();

		for (int i = 0; i < HEADER_IDS.length; i++) {
			ImageView view = new ImageView(context);
			view.setImageResource(HEADER_IDS[i]);
			mViews.add(view);
		}
	}

	public void setCategoryType(int categoryType) {
		currentCategoryType = categoryType;
	}

	@Override
	public int getCount() {
		return HEADER_IDS.length;
	}

	@Override
	public Object instantiateItem(ViewGroup container, final int position) {

		ImageView image = mViews.get(position);
		image.setImageResource(HEADER_IDS[position]);
		image.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				clickListener.onClick(v, currentCategoryType, position);
			}
		});

		container.addView(image);
		return image;
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(mViews.get(position));
	}

	/**
	 * To trigger notifyDataSetChanged. It's a workaround.
	 * http://stackoverflow.com
	 * /questions/7263291/viewpager-pageradapter-not-updating-the-view/7287121
	 */
	@Override
	public int getItemPosition(Object object) {
		return POSITION_NONE;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return "unknow";
	}

	@Override
	public float getPageWidth(int position) {
		return 0.6f;
	}

	public static interface OnCategoryItemClickListener {
		void onClick(View view, int categoryType, int targetIndex);
	}
}