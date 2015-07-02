package com.kubeiwu.baseclass.loader;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;

public abstract class BaseLoaderCallbacksFragment<T> extends Fragment implements LoaderCallbacks<T> {

	@Override
	public Loader<T> onCreateLoader(int arg0, Bundle arg1) {
		return null;
	}

	@Override
	public void onLoadFinished(Loader<T> arg0, T arg1) {
		// ChannelChildFragment
	}

	@Override
	public void onLoaderReset(Loader<T> arg0) {

	}

	protected boolean isVisible;

	@Override
	public void setUserVisibleHint(boolean isVisibleToUser) {
		super.setUserVisibleHint(isVisibleToUser);
		if (isVisibleToUser) {
			isVisible = true;
			onVisible();
		} else {
			isVisible = false;
		}
	}

	protected void onVisible() {
		if (!loaded) {
			loaded = true;
			lazyLoad();
		}
	}

	private boolean loaded = false;

	protected void lazyLoad() {
	};

}
