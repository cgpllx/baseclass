package com.kubeiwu.baseclass.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Locale;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.Toast;

public class Util {
	/**
	 * RGB颜色 转 HEX颜色 *
	 * 
	 * @param red
	 * @param green
	 * @param blue
	 * @return
	 */
	public static String toHEX(int red, int green, int blue) {
		if (red < 0 || red > 255 || green < 0 || green > 255 || blue < 0 || blue > 255) {
			return "";
		}
		String redStr = Integer.toHexString(red);
		String greenStr = Integer.toHexString(green);
		String blueStr = Integer.toHexString(blue);
		return ("#" + redStr + greenStr + blueStr).toUpperCase(Locale.US);
	}
	 /** Print an on-screen message to alert the user */
    public static void toaster(Context context, int stringId) {
        Toast.makeText(context, stringId, Toast.LENGTH_SHORT).show();
    }

    public static int convertPxToDp(int px) {
        DisplayMetrics metrics = VLCApplication.getAppResources().getDisplayMetrics();
        float logicalDensity = metrics.density;
        int dp = Math.round(px / logicalDensity);
        return dp;
    }

    public static int convertDpToPx(int dp) {
        return Math.round(
                TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                        VLCApplication.getAppResources().getDisplayMetrics())
                );
    }

    public static String readAsset(String assetName, String defaultS) {
        try {
            InputStream is = VLCApplication.getAppResources().getAssets().open(assetName);
            BufferedReader r = new BufferedReader(new InputStreamReader(is, "UTF8"));
            StringBuilder sb = new StringBuilder();
            String line = r.readLine();
            if(line != null) {
                sb.append(line);
                line = r.readLine();
                while(line != null) {
                    sb.append('\n');
                    sb.append(line);
                    line = r.readLine();
                }
            }
            return sb.toString();
        } catch (IOException e) {
            return defaultS;
        }
    }

    /**
     * Get a resource id from an attribute id.
     * @param context
     * @param attrId
     * @return the resource id
     */
    public static int getResourceFromAttribute(Context context, int attrId) {
        TypedArray a = context.getTheme().obtainStyledAttributes(new int[] {attrId});
        int resId = a.getResourceId(0, 0);
        a.recycle();
        return resId;
    }
}
