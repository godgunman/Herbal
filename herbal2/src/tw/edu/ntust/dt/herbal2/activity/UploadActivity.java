package tw.edu.ntust.dt.herbal2.activity;

import java.io.File;
import java.util.List;

import tw.edu.ntust.dt.herbal2.R;
import tw.edu.ntust.dt.herbal2.Utils;
import tw.edu.ntust.dt.herbal2.R.drawable;
import tw.edu.ntust.dt.herbal2.R.id;
import tw.edu.ntust.dt.herbal2.R.menu;
import tw.edu.ntust.dt.herbal2.adapter.HerbalDiscoverAdapter;
import tw.edu.ntust.dt.herbal2.view.Preview;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.ShutterCallback;
import android.hardware.Camera.Size;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class UploadActivity extends Activity {

	private static final int NORMAL = 0;
	private static final int PHOTO_DONE = 1;

	private int status = NORMAL;
	private RelativeLayout root;
	private Preview mPreview;
	private TextView nameTextView;
	private ImageView resultImage;
	private ImageView faceTextImage;
	private ImageButton nextButton;

	private int numberOfCameras;
	private int defaultCameraId;
	private Camera mCamera;
	private int cameraCurrentlyLocked;

	private File resultFile;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		SharedPreferences sp = getSharedPreferences("herbal", Context.MODE_PRIVATE);
		int discoverHerbalId = sp.getInt("discoverHerbalId", R.drawable.discover_fish);
		int resId = sp.getInt("resId", R.drawable.result_jian);
		
		int faceLayoutId = HerbalDiscoverAdapter.herbalToFaceLayout.get(discoverHerbalId);
		int faceText = HerbalDiscoverAdapter.resIdToFaceText.get(resId);
		
		String name = getSharedPreferences("fb", Context.MODE_PRIVATE)
				.getString("name", "unknown");

		setContentView(faceLayoutId);

		mPreview = (Preview) findViewById(R.id.preview);
		resultImage = (ImageView) findViewById(R.id.result_image);
		faceTextImage = (ImageView) findViewById(R.id.face_text);
		root = (RelativeLayout) findViewById(R.id.root);
		nextButton = (ImageButton) findViewById(R.id.next_button);
		nameTextView = (TextView) findViewById(R.id.name);

		nameTextView.setText(name);
		faceTextImage.setImageResource(faceText);
		
		// Find the total number of cameras available
		numberOfCameras = Camera.getNumberOfCameras();

		// Find the ID of the default camera
		CameraInfo cameraInfo = new CameraInfo();
		for (int i = 0; i < numberOfCameras; i++) {
			Camera.getCameraInfo(i, cameraInfo);
			if (cameraInfo.facing == CameraInfo.CAMERA_FACING_BACK) {
				defaultCameraId = i;
			}
		}
	}

	@Override
	protected void onResume() {
		super.onResume();

		if (mCamera == null) {
			mCamera = Camera.open();
		}
		Camera.Parameters parameters = mCamera.getParameters();
		List<Size> sizes = parameters.getSupportedPictureSizes();

		Point p = Utils.getScreenSize(this);
		float r = (float) p.y / p.x;
		float minDiff = Float.MAX_VALUE;
		int h = 0, w = 0;

		for (Size size : sizes) {

			float r2 = (float) size.width / size.height;
			if (Math.abs(r - r2) < minDiff) {
				minDiff = Math.abs(r - r2);
				h = size.height;
				w = size.width;
				Log.d("debug", r + ", " + r2);
				Log.d("debug", "h=" + h + ", w=" + w);

			}
		}
		parameters.setPictureSize(w, h);
		mCamera.setParameters(parameters);

		cameraCurrentlyLocked = defaultCameraId;
		mPreview.setCamera(mCamera);
		mPreview.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					mCamera.autoFocus(myAutoFocusCallback);
				}
				return false;
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private AutoFocusCallback myAutoFocusCallback = new AutoFocusCallback() {

		@Override
		public void onAutoFocus(boolean success, Camera camera) {
			// TODO Auto-generated method stub
			if (success) {
				camera.cancelAutoFocus();
			}
		}
	};

	private ShutterCallback shutterCallback = new ShutterCallback() {

		@Override
		public void onShutter() {
			// TODO Auto-generated method stub

		}
	};

	private PictureCallback rawPictureCallback = new PictureCallback() {

		@Override
		public void onPictureTaken(byte[] data, Camera camera) {
			// TODO Auto-generated method stub
		}
	};

	private PictureCallback jpegPictureCallback = new PictureCallback() {

		@Override
		public void onPictureTaken(byte[] data, Camera camera) {
			// TODO Auto-generated method stub

			Bitmap bitmapPicture = BitmapFactory.decodeByteArray(data, 0,
					data.length);
			bitmapPicture = ImageProcess.roate90(bitmapPicture);

			bitmapPicture = ImageProcess.scaleBitmap(bitmapPicture,
					mPreview.getWidth(), mPreview.getHeight());

			File file = ImageProcess.saveToFile(bitmapPicture);
			ImageProcess.scanMedia(getApplicationContext(), file);

			resultImage.setImageBitmap(bitmapPicture);
			mPreview.setVisibility(View.INVISIBLE);
			nextButton.setVisibility(View.INVISIBLE);

			new AsyncTask<Void, Void, Void>() {

				private ProgressDialog progress;

				protected void onPreExecute() {
					progress = new ProgressDialog(UploadActivity.this);
					progress.show();
				};

				@Override
				protected Void doInBackground(Void... params) {
					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					root.buildDrawingCache();
					resultFile = ImageProcess
							.saveToFile(root.getDrawingCache());
					ImageProcess.scanMedia(getApplicationContext(), resultFile);
					return null;
				}

				protected void onPostExecute(Void result) {
					progress.dismiss();
					nextButton.setVisibility(View.VISIBLE);
				};
			}.execute();

		}
	};

	/**
	 * OnClick method for btn_takeshot
	 * 
	 * @param view
	 */
	public void onClickTakeshot(View view) {

		try {
			mCamera.takePicture(shutterCallback, rawPictureCallback,
					jpegPictureCallback);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * OnClick method for next_button
	 * 
	 * @param view
	 */
	public void clickNextButton(View view) {
		if (status == NORMAL) {
			status = PHOTO_DONE;
			((ImageButton) view)
					.setImageResource(R.drawable.upload_button_next);
			onClickTakeshot(view);
		} else if (status == PHOTO_DONE) {
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			// builder.setTitle("上傳你的青草人生");
			builder.setMessage("上傳你的青草人生吧！");
			builder.setPositiveButton("繼續",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							Intent intent = new Intent();
							intent.setClass(UploadActivity.this,
									AllActivity.class);
							startActivity(intent);
						}
					});
			builder.setNegativeButton("分享",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {

							Intent shareIntent = new Intent();
							shareIntent.setAction(Intent.ACTION_SEND);
							shareIntent.putExtra(Intent.EXTRA_STREAM,
									Uri.fromFile(resultFile));
							shareIntent.setType("image/jpeg");
							// shareIntent.setComponent(ComponentName
							// .unflattenFromString("com.facebook.katana/.activity.composer.ComposerActivity"));
							shareIntent.setPackage("com.facebook.katana");
							startActivity(shareIntent);
						}
					});
			builder.create().show();
		}
	}

}
