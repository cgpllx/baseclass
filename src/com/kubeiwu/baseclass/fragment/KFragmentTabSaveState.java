package com.kubeiwu.baseclass.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kubeiwu.baseclass.R;

/**
 * Tab+Fragment
 * 
 * @author 耳东
 *
 */
public abstract class KFragmentTabSaveState extends KFragmentBase {
	protected  KFragmentTabHostSaveState  mFragmentTabHost;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		TabConfig tabConfig = getTabConfig();

		if (tabConfig == null) {
			tabConfig = TabConfig.getSimpleInstance();
		}
		View view = ViewFactory.getKFragmentTabHostSaveStateView(inflater.getContext(), tabConfig.getTabGravity());
		mFragmentTabHost = (KFragmentTabHostSaveState) view.findViewById(android.R.id.tabhost);
		mFragmentTabHost.setup(view.getContext(), getChildFragmentManager(), R.id.realtabcontent);
		initTab(mFragmentTabHost);
		int tabcount = mFragmentTabHost.getTabWidget().getChildCount();
		if (tabcount == 0) {
			throw new IllegalArgumentException("Please in the initTab method to add Tab Fragment");
		}
		mFragmentTabHost.getTabWidget().setBackgroundResource(tabConfig.getWidgetBackgroundResource());
		return view;
	}

	/**
	 * eg:mTabHost.addTab(mTabHost.newTabSpec("simple").setIndicator( getTabItemView(0)), IndexFragment.class, null);
	 */
	protected abstract void initTab(KFragmentTabHostSaveState mTabHost);
}
