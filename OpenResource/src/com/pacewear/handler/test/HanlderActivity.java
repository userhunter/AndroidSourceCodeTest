package com.pacewear.handler.test;

import com.example.myweixin.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HanlderActivity extends Activity implements OnClickListener{
	
	private static final String TAG = "HanlderActivity";
	
	private Handler mMaHandler = null;
	private Handler workHander = null;   // 子线程handler
	
	private Handler thridHandler = null;
	private HandlerThread thread = null;
	
	private static final int MSG_MAIN = 1;
	private static final int MSG_THREAD = 2;
	private static final int MSG_THIRD= 3;
	
	private void initButton(){
		Button mainButton = (Button)findViewById(R.id.button_main);
		mainButton.setOnClickListener(this);
		
		Button thradButton = (Button)findViewById(R.id.button_thread);
		thradButton.setOnClickListener(this);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.empty);
		
		initHander();
		
		initButton();
		
	}
	
	private void initHander(){
		mMaHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() {
			
			@Override
			public boolean handleMessage(Message msg) {
				switch (msg.what) {
				case MSG_MAIN:
					boolean isMainLooper = Looper.myLooper() == Looper.getMainLooper();
					Log.d(TAG, "MSG_MAIN :"+Thread.currentThread()+",isMainLooper:"+isMainLooper);
					break;

				default:
					break;
				}
				return false;
			}
		});
		
		thread = new HandlerThread("deal_with");
		thread.start();
		workHander = new Handler(thread.getLooper(),new Handler.Callback() {
			
			@Override
			public boolean handleMessage(Message msg) {
				switch (msg.what) {
				case MSG_THREAD:
					
					boolean isMainLooper = Looper.myLooper() == Looper.getMainLooper();
					Log.d(TAG, "MSG_THREAD :"+Thread.currentThread()+",isMainLooper:"+isMainLooper);
					
					thridHandler = new Handler(new Handler.Callback() {
						
						@Override
						public boolean handleMessage(Message msg) {
							switch (msg.what) {
							case MSG_THIRD:
								Log.d(TAG, "MSG_THIRD :"+Thread.currentThread());
								
								break;

							default:
								break;
							}
							return false;
						}
					});
					break;

				default:
					break;
				}
				
				return false;
			}
		});
	}
	
	private void mainHandlerSendMessage(){
		mMaHandler.sendEmptyMessage(MSG_MAIN);
	}
	
	private void thirdHandlerSendMessage(){
		if(thridHandler != null){
			thridHandler.sendEmptyMessage(MSG_THIRD);
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button_main:
//			mMaHandler.sendEmptyMessage(MSG_MAIN);
			thirdHandlerSendMessage();
			break;
			
		case R.id.button_thread:
			workHander.sendEmptyMessage(MSG_THREAD);
			break;

		default:
			break;
		}
	}

}
