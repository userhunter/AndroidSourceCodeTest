package com.example.test;

import com.example.myweixin.R;

import android.app.Activity;
import android.os.Bundle;

public class ActivityTransfer extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.animation);
	}
	
	
	@Override
	public void finish() {
		super.finish();
		overridePendingTransition(0, R.anim.slide_out_from_bottom);
	}

}
