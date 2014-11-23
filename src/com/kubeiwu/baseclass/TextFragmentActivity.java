package com.kubeiwu.baseclass;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;
import com.kubeiwu.baseclass.demo.Fragment1;
import com.kubeiwu.baseclass.demo.Fragment2;
import com.kubeiwu.baseclass.demo.Fragment3;
import com.kubeiwu.baseclass.fragment.KFragmentTab;
import com.kubeiwu.baseclass.fragment.KFragmentTabsPager;

public class TextFragmentActivity extends FragmentActivity {
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		// getSupportFragmentManager().beginTransaction().replace(android.R.id.content,
		// new MyTabFragment()).commit();
		getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new MyTabPagerFragment()).commit();
	}

}

class MyTabPagerFragment extends KFragmentTabsPager {
	@SuppressLint("InflateParams")
	@Override
	protected void initTab(TabsPagerAdapter mTabsAdapter, TabHost mTabHost) {
		TextView textView1 = new TextView(getActivity());
		textView1.setHeight(60);
		textView1.setText("测试");
		TextView textView2 = new TextView(getActivity());
		textView2.setText("测试");
		textView2.setHeight(60);
		TextView textView3 = new TextView(getActivity());
		textView3.setText("测试");
		textView3.setHeight(60);
		View view=LayoutInflater.from(getActivity()).inflate(R.layout.tab_item, null);
		View view1=LayoutInflater.from(getActivity()).inflate(R.layout.tab_item, null);
		View view2=LayoutInflater.from(getActivity()).inflate(R.layout.tab_item, null);
		mTabsAdapter.addTab(mTabHost.newTabSpec("simple1").setIndicator(view), Fragment1.class, null);
		mTabsAdapter.addTab(mTabHost.newTabSpec("simple2").setIndicator(view1), Fragment2.class, null);
		mTabsAdapter.addTab(mTabHost.newTabSpec("simple3").setIndicator(view2), Fragment3.class, null);
		// Fragment3.class, null);
		// CharSequence args = "dd";
		// mTabsAdapter.addTab(mTabHost.newTabSpec("dd").setIndicator(args,
		// null), Fragment3.class, null);
	}
}

class MyTabFragment extends KFragmentTab {
	@Override
	protected void initTab(FragmentTabHost mTabHost) {
		TextView textView1 = new TextView(getActivity());
		textView1.setHeight(60);
		textView1.setText("测试");
		TextView textView2 = new TextView(getActivity());
		textView2.setText("测试");
		textView2.setHeight(60);
		TextView textView3 = new TextView(getActivity());
		textView3.setText("测试");
		textView3.setHeight(60);
//		tab_item.xml
		View view=LayoutInflater.from(getActivity()).inflate(R.layout.tab_item, null);
		mTabHost.addTab(mTabHost.newTabSpec("simple1").setIndicator(view), Fragment1.class, null);
		mTabHost.addTab(mTabHost.newTabSpec("simple2").setIndicator(view), Fragment2.class, null);
		mTabHost.addTab(mTabHost.newTabSpec("simple3").setIndicator(view), Fragment3.class, null);
	}
}