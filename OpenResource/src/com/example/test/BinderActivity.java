package com.example.test;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.example.myweixin.R;
import com.keep.binder.data.Book;
import com.keep.binder.server.BookManager;
import com.keep.binder.server.RemoteBInderService;
import com.keep.binder.server.Stub;
import com.keep.binder.service.aidl.IMyAidlInterface;
import com.keep.binder.service.aidl.RemoteService;

public class BinderActivity extends Activity{

	private static final String TAG = "BinderActivity";
	private IMyAidlInterface mBinder;  
	
	private BookManager mBookManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.binder_service);
		
//		binderService();
		binderPersonalService();
	}
	
	
	private void binderService(){
		Intent intent = new Intent(RemoteService.INTENT);  
        boolean result =  bindService(intent, conn, Context.BIND_AUTO_CREATE);  
        Log.d(TAG, "binder service:"+result);
	}
	
	private void binderPersonalService(){
		Intent intent = new Intent(RemoteBInderService.INTENT);  
		boolean result =  bindService(intent, bindConnection, Context.BIND_AUTO_CREATE);  
        Log.d(TAG, "binder service:"+result);
	}
	
	
	private ServiceConnection bindConnection = new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			mBookManager = Stub.asInterface(service);
			Book book = new Book();
			book.setNameString("nick");
			book.setPrice(21);
			  try {
					Log.d(TAG, "get Books:"+mBookManager.getBooks().size());
					mBookManager.add(book);
					Log.d(TAG, "get Books:"+mBookManager.getBooks().size());
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	};
	
	
	private  ServiceConnection conn = new ServiceConnection() {  
        @Override  
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {  
            mBinder = IMyAidlInterface.Stub.asInterface(iBinder);  
            try {
				Log.d(TAG, "interface :"+mBinder.add(5, 6)+",get pid:"+mBinder.getPid());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }  
  
        @Override  
        public void onServiceDisconnected(ComponentName componentName) {  
  
        }  
    };  
	
	
	
}
