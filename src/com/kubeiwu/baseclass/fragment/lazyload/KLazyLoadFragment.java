package com.kubeiwu.baseclass.fragment.lazyload;

import android.support.v4.app.Fragment;

public class KLazyLoadFragment extends Fragment {

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
