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
			"MulberryLeaves", "Basil", "LotusLeaf", "Plantain",
			"Perilla", "Dandelion", "Honeysuckle", "Licorice", "Chrysanthemum", };

	public static Map<Integer, List<String>> perscriptionToHerbal;
	public static final int[] perscriptionToDrawableId = new int[] {
			R.drawable.perscription01, R.drawable.perscription02,
			R.drawable.perscription03, R.drawable.perscription04,
			R.drawable.perscription05, R.drawable.perscription06,
			R.drawable.perscription07, R.drawable.perscription08,
			R.drawable.perscription09, R.drawable.perscription10,
			R.drawable.perscription11, R.drawable.perscription12 };

	public static Map<String, Integer> herbalToPressedDrawableId;
	public static Map<String, Integer> herbalToNormalDrawableId;
	
	public static Map<Integer, Integer> herbalDrawableIdToDetailId;

	public static Map<String, Integer> herbalToConfirmDrawableId;
	
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
		perscriptionToHerbal.get(4).addAll(Arrays.asList("Basil"));

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
		herbalToPressedDrawableId = new HashMap<String, Integer>();
		herbalToPressedDrawableId.put("Ashitaba", R.drawable.herbal_ashitaba1);
		herbalToPressedDrawableId.put("Chicory", R.drawable.herbal_chicory1);
		herbalToPressedDrawableId.put("Mint", R.drawable.herbal_mint1);
		herbalToPressedDrawableId.put("Ebony", R.drawable.herbal_ebony1);
		herbalToPressedDrawableId.put("BambooLeaves", R.drawable.herbal_bamboo_leaves1);
		herbalToPressedDrawableId.put("Matsuba", R.drawable.herbal_matsuba1);
		herbalToPressedDrawableId.put("MulberryLeaves", R.drawable.herbal_mulberry_leaves1);
		herbalToPressedDrawableId.put("Basil", R.drawable.herbal_basil1);
		herbalToPressedDrawableId.put("LotusLeaf", R.drawable.herbal_lotus_leaf1);
		herbalToPressedDrawableId.put("Plantain", R.drawable.herbal_plantain1);
		herbalToPressedDrawableId.put("Perilla", R.drawable.herbal_perilla1);
		herbalToPressedDrawableId.put("Dandelion", R.drawable.herbal_dandelion1);
		herbalToPressedDrawableId.put("Honeysuckle", R.drawable.herbal_honeysuckle1);
		herbalToPressedDrawableId.put("Chrysanthemum", R.drawable.herbal_chrysanthemum1);
		herbalToPressedDrawableId.put("Licorice", R.drawable.herbal_licorice1);
		
		herbalToNormalDrawableId = new HashMap<String, Integer>();
		herbalToNormalDrawableId.put("Ashitaba", R.drawable.herbal_ashitaba2);
		herbalToNormalDrawableId.put("Chicory", R.drawable.herbal_chicory2);
		herbalToNormalDrawableId.put("Mint", R.drawable.herbal_mint2);
		herbalToNormalDrawableId.put("Ebony", R.drawable.herbal_ebony2);
		herbalToNormalDrawableId.put("BambooLeaves", R.drawable.herbal_bamboo_leaves2);
		herbalToNormalDrawableId.put("Matsuba", R.drawable.herbal_matsuba2);
		herbalToNormalDrawableId.put("MulberryLeaves", R.drawable.herbal_mulberry_leaves2);
		herbalToNormalDrawableId.put("Basil", R.drawable.herbal_basil2);
		herbalToNormalDrawableId.put("LotusLeaf", R.drawable.herbal_lotus_leaf2);
		herbalToNormalDrawableId.put("Plantain", R.drawable.herbal_plantain2);
		herbalToNormalDrawableId.put("Perilla", R.drawable.herbal_perilla2);
		herbalToNormalDrawableId.put("Dandelion", R.drawable.herbal_dandelion2);
		herbalToNormalDrawableId.put("Honeysuckle", R.drawable.herbal_honeysuckle2);
		herbalToNormalDrawableId.put("Chrysanthemum", R.drawable.herbal_chrysanthemum2);
		herbalToNormalDrawableId.put("Licorice", R.drawable.herbal_licorice2);
	
		herbalToConfirmDrawableId = new HashMap<String, Integer>();
		herbalToConfirmDrawableId.put("Ashitaba", R.drawable.confirm_herbal_ashitaba);
		herbalToConfirmDrawableId.put("Chicory", R.drawable.confirm_herbal_chicory);
		herbalToConfirmDrawableId.put("Mint", R.drawable.confirm_herbal_mint);
		herbalToConfirmDrawableId.put("Ebony", R.drawable.confirm_herbal_ebony);
		herbalToConfirmDrawableId.put("BambooLeaves", R.drawable.confirm_herbal_bamboo);
		herbalToConfirmDrawableId.put("Matsuba", R.drawable.confirm_herbal_matsuba);
		herbalToConfirmDrawableId.put("MulberryLeaves", R.drawable.confirm_herbal_mulberry_leaves);
		herbalToConfirmDrawableId.put("Basil", R.drawable.confirm_herbal_basil);
		herbalToConfirmDrawableId.put("LotusLeaf", R.drawable.confirm_herbal_lotus_leaf);
		herbalToConfirmDrawableId.put("Plantain", R.drawable.confirm_herbal_plantain);
		herbalToConfirmDrawableId.put("Perilla", R.drawable.confirm_herbal_perilla);
		herbalToConfirmDrawableId.put("Dandelion", R.drawable.confirm_herbal_dandelion);
		herbalToConfirmDrawableId.put("Honeysuckle", R.drawable.confirm_herbal_honeysuckle);
		herbalToConfirmDrawableId.put("Chrysanthemum", R.drawable.confirm_herbal_chrysanthemum);
		herbalToConfirmDrawableId.put("Licorice", R.drawable.confirm_herbal_licorice);
		
		
		
		herbalDrawableIdToDetailId = new HashMap<Integer, Integer>();
		
		herbalDrawableIdToDetailId.put(R.drawable.herbal_ashitaba1, R.drawable.herbal_ashitaba_detail);
		herbalDrawableIdToDetailId.put(R.drawable.herbal_ashitaba2, R.drawable.herbal_ashitaba_detail);
		
		herbalDrawableIdToDetailId.put(R.drawable.herbal_bamboo_leaves1, R.drawable.herbal_bamboo_leaves_detail);
		herbalDrawableIdToDetailId.put(R.drawable.herbal_bamboo_leaves2, R.drawable.herbal_bamboo_leaves_detail);
		
		herbalDrawableIdToDetailId.put(R.drawable.herbal_basil1, R.drawable.herbal_basil_detail);
		herbalDrawableIdToDetailId.put(R.drawable.herbal_basil2, R.drawable.herbal_basil_detail);

		herbalDrawableIdToDetailId.put(R.drawable.herbal_chicory1, R.drawable.herbal_chicory_detail);
		herbalDrawableIdToDetailId.put(R.drawable.herbal_chicory2, R.drawable.herbal_chicory_detail);
		
		herbalDrawableIdToDetailId.put(R.drawable.herbal_chrysanthemum1, R.drawable.herbal_chrysanthemum_detail);
		herbalDrawableIdToDetailId.put(R.drawable.herbal_chrysanthemum2, R.drawable.herbal_chrysanthemum_detail);
		
		herbalDrawableIdToDetailId.put(R.drawable.herbal_dandelion1, R.drawable.herbal_dandelion_detail);
		herbalDrawableIdToDetailId.put(R.drawable.herbal_dandelion2, R.drawable.herbal_dandelion_detail);
		
		herbalDrawableIdToDetailId.put(R.drawable.herbal_ebony1, R.drawable.herbal_ebony_detail);
		herbalDrawableIdToDetailId.put(R.drawable.herbal_ebony2, R.drawable.herbal_ebony_detail);
		
		herbalDrawableIdToDetailId.put(R.drawable.herbal_honeysuckle1, R.drawable.herbal_honeysuckle_detail);
		herbalDrawableIdToDetailId.put(R.drawable.herbal_honeysuckle2, R.drawable.herbal_honeysuckle_detail);
		
		herbalDrawableIdToDetailId.put(R.drawable.herbal_licorice1, R.drawable.herbal_licorice_detail);
		herbalDrawableIdToDetailId.put(R.drawable.herbal_licorice2, R.drawable.herbal_licorice_detail);
		
		herbalDrawableIdToDetailId.put(R.drawable.herbal_lotus_leaf1, R.drawable.herbal_lotus_leaf_detail);
		herbalDrawableIdToDetailId.put(R.drawable.herbal_lotus_leaf2, R.drawable.herbal_lotus_leaf_detail);
		
		herbalDrawableIdToDetailId.put(R.drawable.herbal_matsuba1, R.drawable.herbal_matsuba_detail);
		herbalDrawableIdToDetailId.put(R.drawable.herbal_matsuba2, R.drawable.herbal_matsuba_detail);
		
		herbalDrawableIdToDetailId.put(R.drawable.herbal_mint1, R.drawable.herbal_mint_detail);
		herbalDrawableIdToDetailId.put(R.drawable.herbal_mint2, R.drawable.herbal_mint_detail);
		
		herbalDrawableIdToDetailId.put(R.drawable.herbal_mulberry_leaves1, R.drawable.herbal_mulberry_leaves_detail);
		herbalDrawableIdToDetailId.put(R.drawable.herbal_mulberry_leaves2, R.drawable.herbal_mulberry_leaves_detail);
		
		herbalDrawableIdToDetailId.put(R.drawable.herbal_perilla1, R.drawable.herbal_perilla_detail);
		herbalDrawableIdToDetailId.put(R.drawable.herbal_perilla2, R.drawable.herbal_perilla_detail);
		
		herbalDrawableIdToDetailId.put(R.drawable.herbal_plantain1, R.drawable.herbal_plantain_detail);
		herbalDrawableIdToDetailId.put(R.drawable.herbal_plantain2, R.drawable.herbal_plantain_detail);
		
		
		
	}
}
