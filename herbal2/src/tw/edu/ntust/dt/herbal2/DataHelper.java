package tw.edu.ntust.dt.herbal2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.util.SparseArray;
import android.util.SparseIntArray;

public class DataHelper {
	public static SparseArray<List<Integer>> resIdToHerbals;
	public static SparseArray<List<Integer>> discoverData;
	public static SparseIntArray herbalToFaceLayout;
	public static SparseIntArray resIdToFaceText;
	public static SparseIntArray herbalToRecipe;
	public static SparseIntArray herbalToCook;
	public static SparseArray<String> herbalDiscoverResIdToName;
	public static Map<String, String> herbalDiscoverResIdToChineseName;

	public final static int CATEOGRY_TYPE_STICKER = 0;
	public final static int CATEOGRY_TYPE_FRAME = 1;

	static {
		resIdToHerbals = new SparseArray<List<Integer>>();

		resIdToHerbals.put(R.drawable.result_jian,
				Arrays.asList(R.drawable.herb_hsian, R.drawable.herb_mint));

		resIdToHerbals.put(R.drawable.result_jie, Arrays.asList(
				R.drawable.herb_gochi, R.drawable.herb_shilianhua,
				R.drawable.herb_wuzhuajinying, R.drawable.herb_grape,
				R.drawable.herb_jinyinhua, R.drawable.herb_cheqiancao,
				R.drawable.herb_jinqiancao, R.drawable.herb_huoxiang));

		resIdToHerbals.put(R.drawable.result_nee, Arrays.asList(
				R.drawable.herb_flower, R.drawable.herb_jinin,
				R.drawable.herb_fish, R.drawable.herb_lu,
				R.drawable.herb_gouweicao, R.drawable.herb_zhufanhuatou,
				R.drawable.herb_jianghuang));

		resIdToHerbals.put(R.drawable.result_ya, Arrays.asList(
				R.drawable.herb_shell, R.drawable.herb_lu,
				R.drawable.herb_jinin, R.drawable.herb_shy,
				R.drawable.herb_sanqihua, R.drawable.herb_flower));

		resIdToHerbals.put(R.drawable.result_yen, Arrays.asList(
				R.drawable.herb_lu, R.drawable.herb_grape,
				R.drawable.herb_jinin, R.drawable.herb_fish,
				R.drawable.herb_heye, R.drawable.herb_sangye,
				R.drawable.herb_jili, R.drawable.herb_qianliguang,
				R.drawable.herb_xianfengcao, R.drawable.herb_baihelingzhi,
				R.drawable.herb_fenteng, R.drawable.herb_lujiaotieshu));

		resIdToHerbals.put(R.drawable.result_yenyen, Arrays.asList(
				R.drawable.herb_flower, R.drawable.herb_fish,
				R.drawable.herb_chuanxinlian, R.drawable.herb_baguacao,
				R.drawable.herb_hsian, R.drawable.herb_hongtianwu,
				R.drawable.herb_kuteng, R.drawable.herb_jianghuang));

		discoverData = new SparseArray<List<Integer>>();
		discoverData.put(R.drawable.result_jian, Arrays.asList(
				R.drawable.discover_fish, R.drawable.discover_mint));
		discoverData.put(R.drawable.result_jie, Arrays.asList(
				R.drawable.discover_shell, R.drawable.discover_gouweicao,
				R.drawable.discover_wuzhuajinying, R.drawable.discover_grape,
				R.drawable.discover_jinyinhua, R.drawable.discover_cheqiancao,
				R.drawable.discover_jinqiancao, R.drawable.discover_huoxiang));
		discoverData.put(R.drawable.result_nee, Arrays
				.asList(R.drawable.discover_flower, R.drawable.discover_jinin,
						R.drawable.discover_fish, R.drawable.discover_lu,
						R.drawable.discover_gouweicao,
						R.drawable.discover_zhufanhuatou,
						R.drawable.discover_jinyinhua));
		discoverData.put(R.drawable.result_ya, Arrays.asList(
				R.drawable.discover_shell, R.drawable.discover_lu,
				R.drawable.discover_jinin, R.drawable.discover_shy,
				R.drawable.discover_sanqihua, R.drawable.discover_flower));
		discoverData.put(R.drawable.result_yenyen, Arrays.asList(
				R.drawable.discover_flower, R.drawable.discover_one,
				R.drawable.discover_fish, R.drawable.discover_heye,
				R.drawable.discover_sangye, R.drawable.discover_jili,
				R.drawable.discover_qianliguang,
				R.drawable.discover_xianfengcao,
				R.drawable.discover_baihelingzhi, R.drawable.discover_fenteng,
				R.drawable.discover_lujiaotieshu));
		discoverData.put(R.drawable.result_yen, Arrays.asList(
				R.drawable.discover_lu, R.drawable.discover_grape,
				R.drawable.discover_jinin, R.drawable.discover_fish,
				R.drawable.discover_chuanxinlian, R.drawable.discover_baguacao,
				R.drawable.discover_hsian, R.drawable.discover_hongtianwu,
				R.drawable.discover_kuteng, R.drawable.discover_jianghuang));

		/*
		 * if_jian__hsian+mint if_jie__shell+gochi+mao+white
		 * if_nee__flower+dog+jinin+fish if_ya__shell+lu+jinin+shy
		 * if_yen__lu+grape+jinin+fish if_yenyen__dragon+flower+one+fish
		 */

		herbalToFaceLayout = new SparseIntArray();
		herbalToFaceLayout.put(R.drawable.discover_flower,
				R.layout.face_flowe_ribbon);
		herbalToFaceLayout.put(R.drawable.discover_grape,
				R.layout.face_grape_eyes);
		herbalToFaceLayout.put(R.drawable.discover_hsian,
				R.layout.face_hsian_glasses);
		herbalToFaceLayout.put(R.drawable.discover_jinin,
				R.layout.face_jinin_bite);
		herbalToFaceLayout
				.put(R.drawable.discover_lu, R.layout.face_lu_eyebrow);
		herbalToFaceLayout.put(R.drawable.discover_mint,
				R.layout.face_mint_eyebrow);
		herbalToFaceLayout.put(R.drawable.discover_one, R.layout.face_one_head);
		herbalToFaceLayout.put(R.drawable.discover_shell,
				R.layout.face_shell_nose);
		herbalToFaceLayout.put(R.drawable.discover_shy,
				R.layout.face_shy_glasses);
		herbalToFaceLayout.put(R.drawable.discover_fish,
				R.layout.face_fish_mouth);
		// fixme(ggm)

		resIdToFaceText = new SparseIntArray();
		resIdToFaceText.put(R.drawable.result_jian, R.drawable.upload_jian);
		resIdToFaceText.put(R.drawable.result_jie, R.drawable.upload_jie);
		resIdToFaceText.put(R.drawable.result_nee, R.drawable.upload_nee);
		resIdToFaceText.put(R.drawable.result_ya, R.drawable.upload_ya);
		resIdToFaceText.put(R.drawable.result_yen, R.drawable.upload_yen);
		resIdToFaceText.put(R.drawable.result_yenyen, R.drawable.upload_yenyen);

		herbalToRecipe = new SparseIntArray();
		// herbalToRecipe.put(R.drawable.herb_dog, R.drawable.recipe_);
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

		herbalToRecipe
				.put(R.drawable.herb_baguacao, R.drawable.recipe_baguacao);
		herbalToRecipe.put(R.drawable.herb_baihelingzhi,
				R.drawable.recipe_baihelingzhi);
		herbalToRecipe.put(R.drawable.herb_cheqiancao,
				R.drawable.recipe_cheqiancao);
		herbalToRecipe.put(R.drawable.herb_chuanxinlian,
				R.drawable.recipe_chuanxinlian);
		herbalToRecipe.put(R.drawable.herb_fenteng, R.drawable.recipe_fenteng);
		herbalToRecipe.put(R.drawable.herb_gouweicao,
				R.drawable.recipe_gouweicao);
		herbalToRecipe.put(R.drawable.herb_heye, R.drawable.recipe_heye);
		herbalToRecipe.put(R.drawable.herb_hongtianwu,
				R.drawable.recipe_hongtianwu);
		herbalToRecipe
				.put(R.drawable.herb_huoxiang, R.drawable.recipe_huoxiang);
		herbalToRecipe.put(R.drawable.herb_jianghuang,
				R.drawable.recipe_jianghuang);
		herbalToRecipe.put(R.drawable.herb_jili, R.drawable.recipe_jili);
		herbalToRecipe.put(R.drawable.herb_jinqiancao,
				R.drawable.recipe_jinqiancao);
		herbalToRecipe.put(R.drawable.herb_jinyinhua,
				R.drawable.recipe_jinyinhua);
		herbalToRecipe.put(R.drawable.herb_kuteng, R.drawable.recipe_kuteng);
		herbalToRecipe.put(R.drawable.herb_lujiaotieshu,
				R.drawable.recipe_lujiaotieshu);
		herbalToRecipe.put(R.drawable.herb_qianliguang,
				R.drawable.recipe_qianliguang);
		herbalToRecipe.put(R.drawable.herb_sangye, R.drawable.recipe_sangye);
		herbalToRecipe
				.put(R.drawable.herb_sanqihua, R.drawable.recipe_sanqihua);
		herbalToRecipe.put(R.drawable.herb_shilianhua,
				R.drawable.recipe_shilianhua);
		herbalToRecipe.put(R.drawable.herb_wuzhuajinying,
				R.drawable.recipe_wuzhuajinying);
		herbalToRecipe.put(R.drawable.herb_xianfengcao,
				R.drawable.recipe_xianfengcao);
		herbalToRecipe.put(R.drawable.herb_zhufanhuatou,
				R.drawable.recipe_zhufanhuatou);

		herbalToCook = new SparseIntArray();
		herbalToCook.put(R.drawable.herb_dragon,
				R.drawable.all_button_tea_normal);
		herbalToCook
				.put(R.drawable.herb_fish, R.drawable.all_button_tea_normal);
		herbalToCook.put(R.drawable.herb_flower,
				R.drawable.all_button_tea_normal);
		herbalToCook.put(R.drawable.herb_gochi,
				R.drawable.all_button_tea_normal);
		herbalToCook.put(R.drawable.herb_grape,
				R.drawable.all_button_cook_normal);
		herbalToCook.put(R.drawable.herb_hsian,
				R.drawable.all_button_cook_normal);
		herbalToCook.put(R.drawable.herb_jinin,
				R.drawable.all_button_tea_normal);
		herbalToCook.put(R.drawable.herb_lu, R.drawable.all_button_tea_normal);
		herbalToCook
				.put(R.drawable.herb_mint, R.drawable.all_button_tea_normal);
		herbalToCook.put(R.drawable.herb_one, R.drawable.all_button_tea_normal);
		herbalToCook.put(R.drawable.herb_shell,
				R.drawable.all_button_cook_normal);
		herbalToCook.put(R.drawable.herb_shy, R.drawable.all_button_tea_normal);

		herbalDiscoverResIdToName = new SparseArray<String>();
		herbalDiscoverResIdToName.put(R.drawable.discover_fish, "single_fish");
		herbalDiscoverResIdToName.put(R.drawable.discover_flower,
				"single_flower");
		herbalDiscoverResIdToName
				.put(R.drawable.discover_grape, "single_grape");
		herbalDiscoverResIdToName
				.put(R.drawable.discover_hsian, "single_hsian");
		herbalDiscoverResIdToName
				.put(R.drawable.discover_jinin, "single_jinin");
		herbalDiscoverResIdToName.put(R.drawable.discover_lu, "single_lu");
		herbalDiscoverResIdToName.put(R.drawable.discover_mint, "single_mint");
		herbalDiscoverResIdToName.put(R.drawable.discover_one, "single_one");
		herbalDiscoverResIdToName
				.put(R.drawable.discover_shell, "single_shell");
		herbalDiscoverResIdToName.put(R.drawable.discover_shy, "single_shy");

		herbalDiscoverResIdToChineseName = new HashMap<String, String>();
		herbalDiscoverResIdToChineseName.put("single_fish", "魚腥草");
		herbalDiscoverResIdToChineseName.put("single_flower", "洛神花");
		herbalDiscoverResIdToChineseName.put("single_grape", "小山本葡萄");
		herbalDiscoverResIdToChineseName.put("single_hsian", "仙草");
		herbalDiscoverResIdToChineseName.put("single_jinin", "小金英");
		herbalDiscoverResIdToChineseName.put("single_lu", "蘆薈");
		herbalDiscoverResIdToChineseName.put("single_mint", "薄荷");
		herbalDiscoverResIdToChineseName.put("single_one", "一葉草");
		herbalDiscoverResIdToChineseName.put("single_shell", "含殼草");
		herbalDiscoverResIdToChineseName.put("single_shy", "含羞草");
	}
}
