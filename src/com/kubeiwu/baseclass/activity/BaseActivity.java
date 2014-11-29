package com.kubeiwu.baseclass.activity;

import android.app.Activity;
import android.content.Intent;

import com.kubeiwu.baseclass.R;

public class BaseActivity extends Activity {
	@Override
	public void finish() {
		super.finish();
		overridePendingTransition(R.anim.pre_enter_anim, R.anim.pre_exist_anim);
		// activityStack.remove(getIntent());
		// if (activityStack.size() > 0) {
		// Intent intent = activityStack.lastElement();
		// if (intent != null) {
		// activityStack.remove(intent);
		// startActivity(intent);
		// }
		// }
	}

	// private static Stack<Intent> activityStack;
	@Override
	public void startActivity(Intent intent) {
		super.startActivity(intent);
		overridePendingTransition(R.anim.next_enter_anim, R.anim.next_exist_anim);

		// //自己管理activity'栈
		// if (activityStack == null) {
		// activityStack = new Stack<Intent>();
		// }
		// activityStack.add(getIntent());
	}
}
