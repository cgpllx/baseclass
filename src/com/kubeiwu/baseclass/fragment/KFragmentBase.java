//2014-8-20
package com.kubeiwu.baseclass.fragment;

import android.support.v4.app.Fragment;

/**
 * @author cgpllx1@qq.com (www.kubeiwu.com)
 * @date 2014-8-20
 */
abstract class KFragmentBase extends Fragment {

	public TabConfig getTabConfig() {
		return null;
	};

	public static class TabConfig {
		interface TabGravity {
			int BOTTOM = 0, TOP = 1;
		}

		private int widgetBackgroundResource = android.R.color.white;
		private int tabGravity = TabGravity.BOTTOM;

		public int getTabGravity() {
			return tabGravity;
		}

		public static TabConfig getSimpleInstance() {
			return new TabConfig();
		}

		public void setGravity(int tabGravity) {
			this.tabGravity = tabGravity;
		}

		public int getWidgetBackgroundResource() {
			return widgetBackgroundResource;
		}

		public TabConfig setWidgetBackgroundResource(int mWidgetBackgroundResource) {
			this.widgetBackgroundResource = mWidgetBackgroundResource;
			return this;
		}
	}
}
