package com.keep.user.intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class UserIntentService  extends IntentService{
	
	private static final String TAG = "UserIntentService";
	public static final String INTENT_CONTENT = "com.keep.user.intent";
	
	public UserIntentService(){
		this("user");
	}
	
	public UserIntentService(String name) {
		super(name);
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		
		String action = intent.getAction();
		if(INTENT_CONTENT.equals(action)){
			// 
			
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			Log.d(TAG, "onHandleIntent data.");
		}
		
	}
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		Log.d(TAG, "UserIntentService onCreate.");
	}
	
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.d(TAG, "UserIntentService onDestroy.");
	}
	
	

}
