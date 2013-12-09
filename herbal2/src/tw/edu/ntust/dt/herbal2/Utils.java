package tw.edu.ntust.dt.herbal2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

public class Utils {

	public static Point getScreenSize(Context context) {
		WindowManager wm = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		Point size = new Point();
		Display display = wm.getDefaultDisplay();
		display.getSize(size);
		Log.d("getScreenSize", "screen=" + size.x + "x" + size.y);
		return size;
	}

	public static Uri getTempUri() {
		return Uri.fromFile(getTempFile());
	}

	public static File getTempFile() {

		final String TEMP_PHOTO_FILE = "TEMP_" + System.currentTimeMillis()
				+ ".jpg";

		if (isSDCARDMounted()) {

			File file = new File(Environment.getExternalStorageDirectory(),
					TEMP_PHOTO_FILE);
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return file;
		} else {
			return null;
		}
	}

	public static File saveFileFromURL(String urlStr) {
		try {
			// The sdcard directory e.g. '/sdcard' can be used directly, or
			// more safely abstracted with getExternalStorageDirectory()
			URL url = new URL(urlStr);
			InputStream input = url.openStream();

			File tempFile = getTempFile();
			OutputStream output = new FileOutputStream(tempFile);
			byte[] buffer = new byte[1024];
			int bytesRead = 0;
			while ((bytesRead = input.read(buffer, 0, buffer.length)) >= 0) {
				output.write(buffer, 0, bytesRead);
			}
			output.close();
			input.close();
			return tempFile;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void saveFileFromURL(final String urlStr,
			final SaveFileCallback callback) {
		AsyncTask<Void, Void, File> task = new AsyncTask<Void, Void, File>() {

			@Override
			protected File doInBackground(Void... params) {
				return Utils.saveFileFromURL(urlStr);
			}

			@Override
			protected void onPostExecute(File result) {
				callback.done(result);
			}
		};
		task.execute();
	}

	public static boolean removeTempFile() {
		File tmpFile = new File(
				Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
						+ "/herbalapp", "tmp_save.jpg");
		return tmpFile.delete();
	}

	private static boolean isSDCARDMounted() {
		String status = Environment.getExternalStorageState();
		if (status.equals(Environment.MEDIA_MOUNTED))
			return true;
		return false;
	}

	public interface SaveFileCallback {
		public void done(File file);
	}
}