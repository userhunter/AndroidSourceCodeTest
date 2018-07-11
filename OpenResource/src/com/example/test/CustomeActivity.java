package com.example.test;

import com.example.myweixin.R;
import com.pacewer.custome.view.CircleMaskImage;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

public class CustomeActivity extends Activity implements Handler.Callback{
	
	private static final String TAG = "CustomeActivity";
	private TextView mTextView;
//	private Thread mThread;
	private Handler mHandler;
	
	private static final int MESSAGE_ONE = 1;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.custome_view);
		initViews();
	}
	
	private void sendMessage(int what){
		Message msg = Message.obtain();
		msg.what = what;
		mHandler.sendMessage(msg);
	}
	
	
	private void initViews(){
		mTextView = (TextView)findViewById(R.id.textview);
		CircleMaskImage image = (CircleMaskImage)findViewById(R.id.iamge_view);
		image.setBackgroundResource(R.drawable.ic_launcher);
	}


	@Override
	public boolean handleMessage(Message msg) {
		switch (msg.what) {
		case MESSAGE_ONE:
			mTextView.setText("niubility");
			break;

		default:
			break;
		}
		return false;
	}
}
