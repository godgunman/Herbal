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
	private final int[] BUBBLE_IMAGE_LIST = new int[] { R.drawable.bubble1,
			R.drawable.bubble2, R.drawable.bubble3 };
	private final int[] BUBBLE_IMAGE_WIDTH = new int[] { 122, 199, 287 };

	
	private final static int IMG_SIZE = 50;
	private final static int CIRCLE_R = 350 / 2;
	private final static int EPS = 0;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.measure);

		removeMock();
//		makeBubbleAndMoving(20000, 50);

	}

	@SuppressLint("NewApi")
	private void makeCunterAndRun() {

		
		ValueAnimator va = ValueAnimator.ofInt(1, 360).setDuration(10000);
		va.addUpdateListener(new AnimatorUpdateListener() {
			private boolean first = true;
			private int[] location = new int[] { 0, 0 };
			private ImageView countDownCunter;
			
			
			private void init() {
				countDownCunter = (ImageView) findViewById(R.id.measureCountdownCounter);
				countDownCunter.setVisibility(View.VISIBLE);
			}
			
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				if(first) { init(); first = false; }
				/*
				 * http://stackoverflow.com/questions/3591784/android-get-width-
				 * returns-0 You are calling getWidth() too early. The UI has
				 * not been sized and laid out on the screen yet.
				 */

				View view = findViewById(R.id.space);
				view.getLocationInWindow(location);

				if (location[0] + location[1] == 0) {
					return;
				}

//				Log.d("debug", "x=" + location[0] + "y=" + location[1]);

				Integer degrees = (Integer) animation.getAnimatedValue();
				double radians = Math.toRadians(degrees);

				RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) countDownCunter
						.getLayoutParams();
				int offsetX = -EPS + -IMG_SIZE / 2 + location[0]
						+ (int) (CIRCLE_R * Math.cos(radians));
				int offsetY = -EPS + -IMG_SIZE / 2
						+ -getStatusNotificationBar() + location[1]
						+ (int) (CIRCLE_R * Math.sin(radians));

				params.leftMargin = offsetX;
				params.topMargin = offsetY;

				countDownCunter.setLayoutParams(params);
			}
		});
		va.start();

	}

	private void removeMock() {
		LinearLayout container = (LinearLayout) findViewById(R.id.measureBubbleContainer);
		container.removeAllViews();
		ImageView countDownCunter = (ImageView) findViewById(R.id.measureCountdownCounter);
		countDownCunter.setVisibility(View.GONE);
	}

	private ImageView addBubbleToContainer(int index, int leftMargin) {
		LinearLayout container = (LinearLayout) findViewById(R.id.measureBubbleContainer);
		ImageView bubble = new ImageView(this);
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		params.gravity = Gravity.CENTER_VERTICAL;
		params.leftMargin = leftMargin;
		bubble.setImageResource(BUBBLE_IMAGE_LIST[index]);
		bubble.setLayoutParams(params);
		container.addView(bubble);
		return bubble;
	}

	@SuppressLint("NewApi")
	private void makeBubbleAndMoving(int value, int numsOfBubble) {
		LinearLayout container = (LinearLayout) findViewById(R.id.measureBubbleContainer);
		container.removeAllViews();
		
		int firstIndex = new Random().nextInt(3);
		ImageView firstBubble = addBubbleToContainer(firstIndex, 0);

		int left = -BUBBLE_IMAGE_WIDTH[firstIndex];
		while (numsOfBubble-- > 0) {
			int index = new Random().nextInt(3);
			int tmpLeft = -10 + new Random().nextInt(50)*-1;
			addBubbleToContainer(index, tmpLeft);
			Log.d(TAG, "left="+left+","+BUBBLE_IMAGE_WIDTH[index]+","+tmpLeft);
			left += (-BUBBLE_IMAGE_WIDTH[index] - tmpLeft);
		}

		LayoutParams parmas = ((LinearLayout.LayoutParams)firstBubble.getLayoutParams());
		parmas.leftMargin = left;
		firstBubble.setLayoutParams(parmas);
		
		ValueAnimator va = ValueAnimator.ofInt(1, 1000);
		va.addUpdateListener(new bubbleAnimationUpdate(firstBubble, left));
		va.setDuration(value);
		va.start();
	}

	@SuppressLint("NewApi")
	public class bubbleAnimationUpdate implements AnimatorUpdateListener {
		private ImageView firstBubbleImage;
		private int start;
		private int end = 1000;

		public bubbleAnimationUpdate(ImageView bubbleImage, int start) {
			this.firstBubbleImage = bubbleImage;
			this.start = start;
		}

		@Override
		public void onAnimationUpdate(ValueAnimator animation) {

			LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) firstBubbleImage
					.getLayoutParams();
			double percent = (double) (Integer) animation.getAnimatedValue() / 1000;
			params.leftMargin = (int) (start + (end - start) * percent);
			firstBubbleImage.setLayoutParams(params);
		}
	}

	/**
	 * For calculating absolute position.
	 * 
	 * @return
	 */

	private int getStatusNotificationBar() {
		Rect rectgle = new Rect();
		Window window = getWindow();
		window.getDecorView().getWindowVisibleDisplayFrame(rectgle);
		int StatusBarHeight = rectgle.top;
		int contentViewTop = window.findViewById(Window.ID_ANDROID_CONTENT)
				.getTop();
		int TitleBarHeight = contentViewTop - StatusBarHeight;

		// Log.i("debug", "StatusBar Height= " + StatusBarHeight
		// + " , TitleBar Height = " + TitleBarHeight);
		return StatusBarHeight + TitleBarHeight;
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
			
			this.startService(intent);
			makeBubbleAndMoving(10000, 50);
			makeCunterAndRun();
			return true;
		case R.id.menu_logout:
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
