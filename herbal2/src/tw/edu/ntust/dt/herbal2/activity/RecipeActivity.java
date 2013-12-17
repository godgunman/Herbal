package tw.edu.ntust.dt.herbal2.activity;

import tw.edu.ntust.dt.herbal2.R;
import tw.edu.ntust.dt.herbal2.R.drawable;
import tw.edu.ntust.dt.herbal2.R.id;
import tw.edu.ntust.dt.herbal2.R.layout;
import tw.edu.ntust.dt.herbal2.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;
import android.view.Menu;

public class RecipeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recipe);

		int recipeResId = getSharedPreferences("herbal", Context.MODE_PRIVATE)
				.getInt("recipeResId", R.drawable.recipe_dragon);
		((ImageView) findViewById(R.id.recipe)).setImageResource(recipeResId);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
