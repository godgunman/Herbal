package tw.edu.ntust.dt.herbal2.activity;

import tw.edu.ntust.dt.herbal2.R;

import com.facebook.Request;
import com.facebook.Session;
import com.facebook.model.GraphUser;
import com.facebook.*;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class CoverActivity extends Activity {

	private ProgressDialog progrss;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cover_parallax);

		progrss = new ProgressDialog(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/**
	 * onClick Login button
	 * 
	 * @param view
	 */
	public void clickLogin(View view) {

		progrss.show();
		Session.openActiveSession(this, true, new Session.StatusCallback() {

			// callback when session changes state
			@Override
			public void call(Session session, SessionState state,
					Exception exception) {
				if (session.isOpened()) {

					// make request to the /me API
					Request.executeMeRequestAsync(session,
							new Request.GraphUserCallback() {

								// callback after Graph API response with user
								// object
								@Override
								public void onCompleted(GraphUser user,
										Response response) {
									if (user != null) {
										SharedPreferences sp = getSharedPreferences(
												"fb", Context.MODE_PRIVATE);
										SharedPreferences.Editor editor = sp
												.edit();

										editor.putString("name", user.getName());
										editor.commit();

										progrss.dismiss();

										Intent intent = new Intent();
										intent.setClass(CoverActivity.this,
												AskActivity.class);
										startActivity(intent);
										finish();
									}
								}
							});
				}
			}
		});
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		Session.getActiveSession().onActivityResult(this, requestCode,
				resultCode, data);
	}

	@Override
	public void onBackPressed() {
		finish();
	}

}
