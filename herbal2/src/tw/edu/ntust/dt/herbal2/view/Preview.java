package tw.edu.ntust.dt.herbal2.view;

/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.IOException;
import java.util.List;

import tw.edu.ntust.dt.herbal2.Utils;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.Size;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup.LayoutParams;

/**
 * A simple wrapper around a Camera and a SurfaceView that renders a centered
 * preview of the Camera to the surface. We need to center the SurfaceView
 * because not all devices have cameras that support preview sizes at the same
 * aspect ratio as the device's display.
 */
public class Preview extends SurfaceView implements SurfaceHolder.Callback {
	private final String TAG = "Preview";
	private SurfaceHolder mHolder;
	private Camera mCamera;
	private Context context;

	/**
	 * For custom view.
	 * 
	 * @see http://developer.android.com/training/custom-views/create-view.html
	 * @param context
	 * @param attrs
	 */
	public Preview(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public Preview(Context context) {
		super(context);
		init(context);
	}

	private void init(Context context) {
		// Install a SurfaceHolder.Callback so we get notified when the
		// underlying surface is created and destroyed.
		mHolder = getHolder();
		mHolder.addCallback(this);
		mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
		this.context = context;
	}

	/**
	 * TODO(ggm): layoutparams
	 */
	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// The Surface has been created, acquire the camera and tell it where
		// to draw. Should guarantee invoked before setCamera() .

		// TODO(ggm)
		if (mCamera != null) {
			try {
				mCamera.setPreviewDisplay(holder);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// Surface will be destroyed when we return, so stop the preview.
		// Because the CameraDevice object is not a shared resource, it's very
		// important to release it when the activity is paused.
		if (mCamera != null) {
			mCamera.stopPreview();
		}
		mCamera = null;
	}

	/**
	 * TODO(ggm): getSupportedPreviewSizes
	 */
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {
		// TODO(ggm)
		if (mCamera != null) {
			// Now that the size is known, set up the camera parameters and
			// begin
			// the preview.
			Camera.Parameters parameters = mCamera.getParameters();
			List<Size> sizes = parameters.getSupportedPreviewSizes();

			Point screenSize = Utils.getScreenSize(context);
			float ratio = (float) screenSize.y / screenSize.x;
			float minDiff = Float.MAX_VALUE;
			float bestR = -1;

			for (Size size : sizes) {

				float r2 = (float) size.width / size.height;
				if (Math.abs(ratio - r2) < minDiff) {
					minDiff = Math.abs(ratio - r2);
					bestR = r2;
					h = size.height;
					w = size.width;
					Log.d("preview", ratio + ", " + r2);
					Log.d("preview", "h=" + h + ", w=" + w);
				}
			}

			parameters.setPictureSize(w, h);
			parameters.setPreviewSize(w, h);

			mCamera.setParameters(parameters);
			mCamera.setDisplayOrientation(90);
			mCamera.startPreview();

			LayoutParams params = getLayoutParams();
			params.width = screenSize.x;
			params.height = (int) (screenSize.x * bestR);
			setLayoutParams(params);
		}
	}

	public void setCamera(Camera camera) {
		mCamera = camera;
	}

	public void switchCamera(Camera camera) {
		setCamera(camera);
		try {
			camera.setPreviewDisplay(mHolder);
		} catch (IOException exception) {
			Log.e(TAG, "IOException caused by setPreviewDisplay()", exception);
		}
		Camera.Parameters parameters = camera.getParameters();
		// parameters.setPreviewSize(mPreviewSize.width, mPreviewSize.height);
		requestLayout();

		camera.setParameters(parameters);
	}
}