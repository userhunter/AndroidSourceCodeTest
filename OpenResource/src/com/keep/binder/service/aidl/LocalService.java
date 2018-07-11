package com.keep.binder.service.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class LocalService extends Service{
	
	public static final String FILTER = "com.pacewear.binder.service.LocalService";

	@Override
	public IBinder onBind(Intent intent) {
		return new LocalBinderService();
	}
	
	public void sayHello(){
		Toast.makeText(this, "yes", Toast.LENGTH_LONG).show();
	}
	
	
	public  class LocalBinderService extends Binder{
		
		public LocalService getService(){
			return LocalService.this;
		}
		
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
	}

}
