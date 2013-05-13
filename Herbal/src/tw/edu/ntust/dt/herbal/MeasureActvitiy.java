package tw.edu.ntust.dt.herbal;

import java.util.Random;

import android.os.Bundle;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;

public class MeasureActvitiy extends Activity {

	private final static String TAG = MeasureActvitiy.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.measure);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.measure, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) {
		case R.id.menu_start:
			/* http://teslacoilsw.com/teslaled/ */
			Intent intent = new Intent("com.teslacoilsw.intent.FLASHLIGHT");
			intent.putExtra("toggle", true);
			
			return true;
		case R.id.menu_logout:
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
