package com.pacewear.binder.service.aidl;

import com.pacewear.binder.service.aidl.IMyAidlInterface;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class RemoteService extends Service{

	private static final String TAG = "RemoteService";
	public static final String INTENT = "com.pacewear.binder.service.RemoteService";
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		Log.d(TAG, "onCreate");
	}
	
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.d(TAG, "onStartCommand");
		return START_NOT_STICKY;
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		return (IBinder) mBInder;
	}
	
	
	private  IMyAidlInterface mBInder = new IMyAidlInterface.Stub() {
		
		@Override
		public int getPid() throws RemoteException {
			return 1000;
		}
		
		@Override
		public int add(int a, int b) throws RemoteException {
			return a+b;
		}
	};
	
	
	
	
	

}
