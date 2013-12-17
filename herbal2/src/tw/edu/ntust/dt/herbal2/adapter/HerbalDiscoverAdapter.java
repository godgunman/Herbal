package tw.edu.ntust.dt.herbal2.adapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import tw.edu.ntust.dt.herbal2.R;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

public class HerbalDiscoverAdapter extends PagerAdapter {

	public static SparseArray<List<Integer>> data;
	public static SparseArray<List<Integer>> discoverData;
	public static SparseIntArray herbalToFaceLayout;
	public static SparseIntArray resIdToFaceText;
	public static SparseIntArray herbalToRecipe;
	public static SparseIntArray herbalToCook;

	
	public final static int CATEOGRY_TYPE_STICKER = 0;
	public final static int CATEOGRY_TYPE_FRAME = 1;

	static {
		data = new SparseArray<List<Integer>>();

		data.put(R.drawable.result_jian,
				Arrays.asList(R.drawable.herb_hsian, R.drawable.herb_mint));
		data.put(R.drawable.result_jie, Arrays.asList(R.drawable.herb_shell,
				R.drawable.herb_gochi, R.drawable.herb_white));
		data.put(R.drawable.result_nee, Arrays.asList(R.drawable.herb_flower,
				R.drawable.herb_dog, R.drawable.herb_jinin,
				R.drawable.herb_fish));
		data.put(R.drawable.result_ya, Arrays.asList(R.drawable.herb_shell,
				R.drawable.herb_lu, R.drawable.herb_jinin, R.drawable.herb_shy));
		data.put(R.drawable.result_yen, Arrays.asList(R.drawable.herb_lu,
				R.drawable.herb_grape, R.drawable.herb_jinin,
				R.drawable.herb_fish));
		data.put(R.drawable.result_yenyen, Arrays.asList(
				R.drawable.herb_dragon, R.drawable.herb_flower,
				R.drawable.herb_one, R.drawable.herb_fish));

		discoverData = new SparseArray<List<Integer>>();
		discoverData.put(R.drawable.result_jian, Arrays.asList(
				R.drawable.discover_fish, R.drawable.discover_mint));
		discoverData.put(R.drawable.result_jie, Arrays.asList(
				R.drawable.discover_shell, R.drawable.discover_white));
		discoverData.put(R.drawable.result_nee, Arrays.asList(
				R.drawable.discover_flower, R.drawable.discover_jinin,
				R.drawable.discover_fish));
		discoverData.put(R.drawable.result_ya, Arrays.asList(
				R.drawable.discover_shell, R.drawable.discover_lu,
				R.drawable.discover_jinin, R.drawable.discover_shy));
		discoverData.put(R.drawable.result_yenyen, Arrays.asList(
				R.drawable.discover_flower, R.drawable.discover_one,
				R.drawable.discover_fish));

		/*
		 * if_jian__hsian+mint if_jie__shell+gochi+mao+white
		 * if_nee__flower+dog+jinin+fish if_ya__shell+lu+jinin+shy
		 * if_yen__lu+grape+jinin+fish if_yenyen__dragon+flower+one+fish
		 */

		herbalToFaceLayout = new SparseIntArray();
		herbalToFaceLayout.put(R.drawable.herb_dragon, R.layout.face_dragon_ear);
		herbalToFaceLayout.put(R.drawable.herb_flower, R.layout.face_flowe_ribbon);
		herbalToFaceLayout.put(R.drawable.herb_gochi, R.layout.face_gochi_cheek);
		herbalToFaceLayout.put(R.drawable.herb_grape, R.layout.face_grape_eyes);
		herbalToFaceLayout.put(R.drawable.herb_hsian, R.layout.face_hsian_glasses);
		herbalToFaceLayout.put(R.drawable.herb_jinin, R.layout.face_jinin_bite);
		herbalToFaceLayout.put(R.drawable.herb_lu, R.layout.face_lu_eyebrow);
		herbalToFaceLayout.put(R.drawable.herb_mint, R.layout.face_mint_eyebrow);
		herbalToFaceLayout.put(R.drawable.herb_one, R.layout.face_one_head);
		herbalToFaceLayout.put(R.drawable.herb_shell, R.layout.face_shell_nose);
		herbalToFaceLayout.put(R.drawable.herb_shy, R.layout.face_shy_glasses);
		herbalToFaceLayout.put(R.drawable.herb_white, R.layout.face_white_mouth);

		resIdToFaceText = new SparseIntArray();
		resIdToFaceText.put(R.drawable.result_jian, R.drawable.upload_jian);
		resIdToFaceText.put(R.drawable.result_jie, R.drawable.upload_jie);
		resIdToFaceText.put(R.drawable.result_nee, R.drawable.upload_nee);
		resIdToFaceText.put(R.drawable.result_ya, R.drawable.upload_ya);
		resIdToFaceText.put(R.drawable.result_yen, R.drawable.upload_yen);
		resIdToFaceText.put(R.drawable.result_yenyen, R.drawable.upload_yenyen);
	
		herbalToRecipe = new SparseIntArray();
//		herbalToRecipe.put(R.drawable.herb_dog, R.drawable.recipe_);
		herbalToRecipe.put(R.drawable.herb_dragon, R.drawable.recipe_dragon);
		herbalToRecipe.put(R.drawable.herb_fish, R.drawable.recipe_fish);
		herbalToRecipe.put(R.drawable.herb_flower, R.drawable.recipe_flower);
		herbalToRecipe.put(R.drawable.herb_gochi, R.drawable.recipe_gochi);
		herbalToRecipe.put(R.drawable.herb_grape, R.drawable.recipe_grape);
		herbalToRecipe.put(R.drawable.herb_hsian, R.drawable.recipe_hsian);
		herbalToRecipe.put(R.drawable.herb_jinin, R.drawable.recipe_jinin);
		herbalToRecipe.put(R.drawable.herb_lu, R.drawable.recipe_lu);
		herbalToRecipe.put(R.drawable.herb_mint, R.drawable.recipe_mint);
		herbalToRecipe.put(R.drawable.herb_one, R.drawable.recipe_one);
		herbalToRecipe.put(R.drawable.herb_shell, R.drawable.recipe_shell);
		herbalToRecipe.put(R.drawable.herb_shy, R.drawable.recipe_shy);
		herbalToRecipe.put(R.drawable.herb_white, R.drawable.recipe_white);
		
		herbalToCook = new SparseIntArray();
		herbalToCook.put(R.drawable.herb_dragon, R.drawable.all_button_tea_normal);
		herbalToCook.put(R.drawable.herb_fish, R.drawable.all_button_tea_normal);
		herbalToCook.put(R.drawable.herb_flower, R.drawable.all_button_tea_normal);
		herbalToCook.put(R.drawable.herb_gochi, R.drawable.all_button_tea_normal);
		herbalToCook.put(R.drawable.herb_grape, R.drawable.all_button_cook_normal);
		herbalToCook.put(R.drawable.herb_hsian, R.drawable.all_button_cook_normal);
		herbalToCook.put(R.drawable.herb_jinin, R.drawable.all_button_tea_normal);
		herbalToCook.put(R.drawable.herb_lu, R.drawable.all_button_tea_normal);
		herbalToCook.put(R.drawable.herb_mint, R.drawable.all_button_tea_normal);
		herbalToCook.put(R.drawable.herb_one, R.drawable.all_button_tea_normal);
		herbalToCook.put(R.drawable.herb_shell, R.drawable.all_button_cook_normal);
		herbalToCook.put(R.drawable.herb_shy, R.drawable.all_button_tea_normal);
		herbalToCook.put(R.drawable.herb_white, R.drawable.all_button_cook_normal);
		
	}

	private List<ImageView> mViews;
	private int currentCategoryType;

	private OnCategoryItemClickListener clickListener;

	public HerbalDiscoverAdapter(Context context,
			final OnCategoryItemClickListener clickListener) {

		this.clickListener = clickListener;
		mViews = new ArrayList<ImageView>();

		for (int i = 0; i < 5; i++) {
			ImageView view = new ImageView(context);
			mViews.add(view);
		}
	}

	public void setCategoryType(int categoryType) {
		currentCategoryType = categoryType;
	}

	@Override
	public int getCount() {
		return data.get(currentCategoryType).size();
	}

	@Override
	public Object instantiateItem(ViewGroup container, final int position) {

		ImageView image = mViews.get(position);
		image.setImageResource(data.get(currentCategoryType).get(position));
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