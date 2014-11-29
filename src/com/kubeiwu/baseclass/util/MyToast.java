package com.kubeiwu.baseclass.util;

import android.content.Context;
import android.os.Looper;
import android.widget.Toast;

public class MyToast {
	public static void show(Context context, String text, int duration) {
		if (Looper.myLooper() != Looper.getMainLooper()) {
			Looper.prepare();
			deliverToast(context, text, duration);
			Looper.loop();
			return;
		}else{
			deliverToast(context, text, duration);
		}

	}
	private static void deliverToast(Context context, String text, int duration){
		if (context != null) {
			Toast.makeText(context, text, duration).show();
		}
	}

	@SuppressWarnings("unused")
	private void throwIfNotOnMainThread() {
		if (Looper.myLooper() != Looper.getMainLooper()) {
			throw new IllegalStateException("Toast must be invoked from the main thread.");
		}
	}
}
