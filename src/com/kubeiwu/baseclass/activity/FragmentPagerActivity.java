package com.kubeiwu.baseclass.activity;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;

import com.kubeiwu.baseclass.R;

public class FragmentPagerActivity extends FragmentActivity {
	//static final int NUM_ITEMS = 3;
	MyAdapter mAdapter;

	ViewPager mPager;

	private static String[] data;
	private int currentitem;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
//		setContentView(R.layout.fragment_pager);
		data = getIntent().getExtras().getStringArray("data");
		currentitem = getIntent().getIntExtra("currentitem", 0);
		mAdapter = new MyAdapter(getSupportFragmentManager());

		mPager = (ViewPager) findViewById(R.id.pager);
		mPager.setAdapter(mAdapter);
		mPager.setCurrentItem(currentitem);

	}

	public static class MyAdapter extends FragmentPagerAdapter {
		public MyAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public int getCount() {
			return data.length;
		}

		@Override
		public Fragment getItem(int position) {
			return ArrayListFragment.newInstance(position);
		}
	}

	public static class ArrayListFragment extends Fragment {
		int mNum;

		static ArrayListFragment newInstance(int num) {
			ArrayListFragment f = new ArrayListFragment();
			// Supply num input as an argument.
			Bundle args = new Bundle();
			args.putInt("num", num);
			f.setArguments(args);
			return f;
		}

		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			mNum = getArguments() != null ? getArguments().getInt("num") : 1;
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			ImageView imageView = new ImageView(getActivity());
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			imageView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
//			if (Util.checkImageLoading(getActivity(), PreferenceManager.getDefaultSharedPreferences(getActivity()).getInt(Assist.SET_PICTURE_BROWSING_MODE, 0)))
//			Assist.imageLoader.displayImage(data[mNum], imageView, Assist.screenshotoptions);
			return imageView;
		}
	}
}
