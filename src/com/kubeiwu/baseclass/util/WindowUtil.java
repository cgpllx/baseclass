package com.kubeiwu.baseclass.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public class WindowUtil {
	/**
	 * 屏幕的宽高 dm.widthPixel dm.heightPixels
	 * 
	 * @param context
	 * @return
	 */
	public static DisplayMetrics getDisplayMetrics(Context context) {
		WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics dm = new DisplayMetrics();
		windowManager.getDefaultDisplay().getMetrics(dm);
		return dm;
	}
}
