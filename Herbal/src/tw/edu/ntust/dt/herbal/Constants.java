package tw.edu.ntust.dt.herbal;

import android.annotation.SuppressLint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressLint("UseSparseArrays")
public class Constants {

	/*
	 * 明日葉 菊苣 薄荷 烏梅 松葉 竹葉 桑葉 紅骨九層塔 荷葉 車前草 紫蘇葉 蒲公英 金銀花 生甘草 菊花
	 */

	public static final String[] herbals = new String[] { "Ashitaba",
			"Chicory", "Mint", "Ebony", "Matsuba", "BambooLeaves",
			"MulberryLeaves", "RedBoneBasil", "LotusLeaf", "Plantain",
			"Perilla", "Dandelion", "Honeysuckle", "Licorice", "Chrysanthemum", };

	public static Map<Integer, List<String>> perscriptionToHerbal;
	public static final int[] perscriptionToDrawableId = new int[] {
			R.drawable.perscription_01, R.drawable.perscription_02,
			R.drawable.perscription_03, R.drawable.perscription_04,
			R.drawable.perscription_05, R.drawable.perscription_06,
			R.drawable.perscription_07, R.drawable.perscription_08,
			R.drawable.perscription_09, R.drawable.perscription_10,
			R.drawable.perscription_11, R.drawable.perscription_12 };

	public static Map<String, Integer> herbalDrawable;

	static {

		perscriptionToHerbal = new HashMap<Integer, List<String>>();

		perscriptionToHerbal.put(0, new ArrayList<String>());
		perscriptionToHerbal.get(0).addAll(
				Arrays.asList("Ashitaba", "Chicory", "Mint"));

		perscriptionToHerbal.put(1, new ArrayList<String>());
		perscriptionToHerbal.get(1).addAll(Arrays.asList("Ebony", "Mint"));

		perscriptionToHerbal.put(2, new ArrayList<String>());
		perscriptionToHerbal.get(2).addAll(
				Arrays.asList("BambooLeaves", "Matsuba"));

		perscriptionToHerbal.put(3, new ArrayList<String>());
		perscriptionToHerbal.get(3).addAll(Arrays.asList("MulberryLeaves"));

		perscriptionToHerbal.put(4, new ArrayList<String>());
		perscriptionToHerbal.get(4).addAll(Arrays.asList("RedBoneBasil"));

		perscriptionToHerbal.put(5, new ArrayList<String>());
		perscriptionToHerbal.get(5).addAll(Arrays.asList("LotusLeaf"));

		perscriptionToHerbal.put(6, new ArrayList<String>());
		perscriptionToHerbal.get(6).addAll(Arrays.asList("Plantain"));

		perscriptionToHerbal.put(7, new ArrayList<String>());
		perscriptionToHerbal.get(7).addAll(Arrays.asList("Perilla"));

		perscriptionToHerbal.put(8, new ArrayList<String>());
		perscriptionToHerbal.get(8).addAll(Arrays.asList("Dandelion"));

		perscriptionToHerbal.put(9, new ArrayList<String>());
		perscriptionToHerbal.get(9).addAll(Arrays.asList("Honeysuckle"));

		perscriptionToHerbal.put(10, new ArrayList<String>());
		perscriptionToHerbal.get(10).addAll(Arrays.asList("Chrysanthemum"));

		perscriptionToHerbal.put(11, new ArrayList<String>());
		perscriptionToHerbal.get(11).addAll(Arrays.asList("Licorice"));

		// TODO wait drawable available
		herbalDrawable = new HashMap<String, Integer>();
		herbalDrawable.put(herbals[0], 0);
		herbalDrawable.put(herbals[1], 0);
		herbalDrawable.put(herbals[2], 0);
		herbalDrawable.put(herbals[3], 0);
		herbalDrawable.put(herbals[4], 0);
		herbalDrawable.put(herbals[5], 0);
		herbalDrawable.put(herbals[6], 0);
		herbalDrawable.put(herbals[7], 0);
		herbalDrawable.put(herbals[8], 0);
		herbalDrawable.put(herbals[9], 0);
		herbalDrawable.put(herbals[10], 0);
		herbalDrawable.put(herbals[11], 0);
		herbalDrawable.put(herbals[12], 0);
		herbalDrawable.put(herbals[13], 0);
		herbalDrawable.put(herbals[14], 0);
	}
}
