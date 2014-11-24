package com.kubeiwu.baseclass.activity;

import android.app.Activity;
import android.content.Intent;

import com.kubeiwu.baseclass.R;

public class BaseFragmentActivity extends Activity {
	@Override
	public void finish() {
		super.finish();
		overridePendingTransition(R.anim.pre_enter_anim, R.anim.pre_exist_anim);
	}

	@Override
	public void startActivity(Intent intent) {
		super.startActivity(intent);
		overridePendingTransition(R.anim.next_enter_anim, R.anim.next_exist_anim);
	}
}
