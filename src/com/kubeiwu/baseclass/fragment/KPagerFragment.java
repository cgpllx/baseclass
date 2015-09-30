package com.kubeiwu.baseclass.fragment;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class KPagerFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return super.onCreateView(inflater, container, savedInstanceState);
	}

	public class MyAdapter extends FragmentPagerAdapter {
		List<Fragment> fragmengs;

		public MyAdapter(FragmentManager fm) {
			super(fm);
		}

		public MyAdapter(FragmentManager fm, List<Fragment> fragmengs) {
			super(fm);
			this.fragmengs = fragmengs;
		}

		@Override
		public int getCount() {
			return fragmengs.size();
		}

		@Override
		public Fragment getItem(int position) {
			return fragmengs.get(position);
		}
	}
}
