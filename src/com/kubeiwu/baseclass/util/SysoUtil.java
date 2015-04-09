package com.kubeiwu.baseclass.util;

public class SysoUtil {
	public static boolean DEBUG = false;


	public static void print(Object object) {
		if (DEBUG) {
			System.out.println(object);
		}
	}
}
