package tw.edu.ntust.dt.herbal2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;

public class UploadActivity extends Activity {

	private static final int NORMAL = 0;
	private static final int PHOTO_DONE = 1;

	private int status = NORMAL;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_upload);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void clickNextButton(View view) {
		if (status == NORMAL) {
			status = PHOTO_DONE;
			((ImageButton) view)
					.setImageResource(R.drawable.upload_button_next);
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

							String uri = null;
							Intent shareIntent = new Intent();
							shareIntent.setAction(Intent.ACTION_SEND);
							shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
							shareIntent.setType("image/jpeg");
							startActivity(shareIntent);
						}
					});
			builder.create().show();
		}
	}
}
