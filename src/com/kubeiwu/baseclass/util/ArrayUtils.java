package com.kubeiwu.baseclass.util;

import java.util.List;

public class ArrayUtils {

	public static <T> boolean isEmpty(List<T> array) {
		if (array == null || array.size() == 0)
			return true;
		else
			return false;
	}
}
