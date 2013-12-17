package tw.edu.ntust.dt.herbal2.activity;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;

public class ImageProcess {

	public static Bitmap roate90(Bitmap bitmap) {
		Log.d("ImageProcess", bitmap.getHeight() + "," + bitmap.getWidth());
		Matrix matrix = new Matrix();

		matrix.postRotate(90);
		// Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmapOrg, height,
		// width, true);

		Bitmap rotatedBitmap = Bitmap.createBitmap(bitmap, 0, 0,
				bitmap.getWidth(), bitmap.getHeight(), matrix, true);
		return rotatedBitmap;
	}

	public static Bitmap cropByFrame(Bitmap bitmap, int startX, int startY) {
		Log.d("ImageProcess", bitmap.getHeight() + "," + bitmap.getWidth());
		int edge = bitmap.getWidth();
		return Bitmap.createBitmap(bitmap, startX, startY, edge, edge);
	}

	public static Bitmap scaleBitmap(Bitmap bitmap, int w, int h) {
		return Bitmap.createScaledBitmap(bitmap, w, h, false);

	}

	public static boolean saveToFile(Bitmap bitmap, File file) {
		try {
			BufferedOutputStream bos = new BufferedOutputStream(
					new FileOutputStream(file));
			bitmap.compress(CompressFormat.JPEG, 100, bos);
			return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static File saveToFile(Bitmap bitmap) {
		File imageDir = Environment
				.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES
						+ "/herbalapp");

		if (imageDir.exists() == false) {
			if (imageDir.mkdirs() == false) {
				Log.d("debug", "create false");
			}
		}

		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd_HH-mm-ss_SSS_Z");
		File file = new File(imageDir, "IMG_" + dateFormat.format(new Date())
				+ ".jpg");

		if (ImageProcess.saveToFile(bitmap, file)) {
			return file;
		} else {
			return null;
		}
	}

	public static Bitmap combineImages(Bitmap buttomBitmap, Bitmap topBitmap) {
		Bitmap bmOverlay = Bitmap.createBitmap(buttomBitmap.getWidth(),
				buttomBitmap.getHeight(), buttomBitmap.getConfig());
		Canvas canvas = new Canvas(bmOverlay);
		canvas.drawBitmap(buttomBitmap, new Matrix(), null);
		canvas.drawBitmap(topBitmap, 0, 0, null);
		return bmOverlay;
	}

	public static void scanMedia(Context context, File file) {
		Uri uri = Uri.fromFile(file);
		Intent scanFileIntent = new Intent(
				Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, uri);
		context.sendBroadcast(scanFileIntent);
	}

	public static void scanMedia(Context context) {
		File imageDir = Environment
				.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES
						+ "/BananaCamera");
		if (imageDir.exists() == false) {
			if (imageDir.mkdirs() == false) {
				Log.d("debug", "create false");
			}
		}

		ImageProcess.scanMedia(context, imageDir);
	}
}