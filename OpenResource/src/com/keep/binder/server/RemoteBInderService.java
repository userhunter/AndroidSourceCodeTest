package com.keep.binder.server;

import java.util.ArrayList;
import java.util.List;

import com.keep.binder.data.Book;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.widget.ArrayAdapter;

public class RemoteBInderService extends Service{

	private static final String TAG = "RemoteBInderService";
	public static final String INTENT = "com.pacewear.binder.server.RemoteBInderService";
	
	private List<Book> arrayList = new ArrayList<Book>();
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		Log.d(TAG, "onCreate");
		Book book = new Book();
		book.setNameString("zhang san");
		book.setPrice(15);
		
		arrayList.add(book);
	}
	
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.d(TAG, "onStartCommand");
		return START_NOT_STICKY;
	}
	
	
	public Stub bookManagerStub = new Stub() {
		
		@Override
		public List<Book> getBooks() throws RemoteException {
			return arrayList;
		}
		
		@Override
		public void add(Book book) throws RemoteException {
			
			if(book != null){
				Log.d(TAG, "add the book");
				book.setPrice(book.getPrice() * 10);
				arrayList.add(book);
			}
		}
	};
	
	@Override
	public IBinder onBind(Intent intent) {
		return bookManagerStub;
	}
	
	
}
