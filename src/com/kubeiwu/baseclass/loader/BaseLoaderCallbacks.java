package com.kubeiwu.baseclass.loader;

import android.os.Bundle;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;

public class BaseLoaderCallbacks<T> implements LoaderCallbacks<T> {

	@Override
	public Loader<T> onCreateLoader(int arg0, Bundle arg1) {
		return null;
	}
 

	@Override
	public void onLoaderReset(Loader<T> arg0) {
		
	}

	@Override
	public void onLoadFinished(Loader<T> arg0, T arg1) {
		
	}

}
