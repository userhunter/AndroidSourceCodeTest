package com.pacewear.binder.proxy;

import java.util.List;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

import com.pacewear.binder.data.Book;
import com.pacewear.binder.server.BookManager;
import com.pacewear.binder.server.Stub;

public class Proxy implements BookManager{
	
	private static final String DESCRIPTOR = "com.pacewear.binder.data.BookManager";

	private IBinder remote;
	
	public String getInterfaceDescriptor() {
		return DESCRIPTOR;
	}
	
	public Proxy(IBinder binder){
		remote = binder;
	}
	
	@Override
	public IBinder asBinder() {
		return remote;
	}

	@Override
	public List<Book> getBooks() throws RemoteException {
		 Parcel data = Parcel.obtain();
	     Parcel reply = Parcel.obtain();
	     List<Book> result;
	     
	     data.writeInterfaceToken(DESCRIPTOR);
	     remote.transact(Stub.TRANSAVTION_getBooks, data, reply, 0);
	     reply.readException();
	     result = reply.createTypedArrayList(Book.CREATOR);
		return result;
	}

	@Override
	public void add(Book book) throws RemoteException {
		 Parcel data = Parcel.obtain();
	     Parcel reply = Parcel.obtain();
	     
	     try {
	    	 data.writeInterfaceToken(DESCRIPTOR);
		     if(book != null){
		    	 data.writeInt(1);
		    	 book.writeToParcel(data, 0);
		     }else{
		    	 data.writeInt(0);
		     }
		     
		     remote.transact(Stub.TRANSAVTION_addBook, data, reply, 0);
		     data.readException();
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			reply.recycle();
			data.recycle();
		}
	     
	}

}
