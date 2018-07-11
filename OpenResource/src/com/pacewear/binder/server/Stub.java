package com.pacewear.binder.server;

import java.util.List;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

import com.pacewear.binder.data.Book;
import com.pacewear.binder.proxy.Proxy;

public abstract class Stub extends Binder implements BookManager{
	
	private static final String DESCRIPTOR = "com.pacewear.binder.data.BookManager";
	
	public Stub(){
		this.attachInterface(this, DESCRIPTOR);
	}
	
	@Override
	public IBinder asBinder(){
		return this;
	}
	
	public static BookManager asInterface(IBinder binder){
		 if (binder == null){
			 return null;
		 }
		 
		 IInterface iInterface = binder.queryLocalInterface(DESCRIPTOR);
		 // 如果当前的对象是在同一个进程里面，那就直接使用本地对象
		 if(iInterface !=null && iInterface instanceof BookManager){
			 return (BookManager) iInterface;
		 }
		 
		 // 否则，需要使用远程对象作为代理
		 return new Proxy(binder);
	}
	
	@Override
	protected boolean onTransact(int code, Parcel data, Parcel reply, int flags)
			throws RemoteException {
		switch (code) {
		case INTERFACE_TRANSACTION:
			reply.writeString(DESCRIPTOR);
			
			return true;
			
		case TRANSAVTION_getBooks:
			data.enforceInterface(DESCRIPTOR);
			List<Book> books = this.getBooks();
			reply.writeNoException();
			reply.writeTypedList(books);
			
			return true;
			
		case TRANSAVTION_addBook:
			data.enforceInterface(DESCRIPTOR);
			 Book arg0 = null;
			 if(data.readInt() != 0){
				 arg0 = Book.CREATOR.createFromParcel(data);
			 }
			 this.add(arg0);                 // 这个步骤非常重要
			 reply.writeNoException();
			 
			return true;

		default:
			break;
		}
		
		return super.onTransact(code, data, reply, flags);
	}
	
	public static final int TRANSAVTION_getBooks = IBinder.FIRST_CALL_TRANSACTION;
	public static final int TRANSAVTION_addBook = IBinder.FIRST_CALL_TRANSACTION +1;
	
	
	
	

}
