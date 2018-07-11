package com.pacewear.binder.server;

import java.util.List;

import com.pacewear.binder.data.Book;

import android.os.IInterface;
import android.os.RemoteException;

/**
 * @author p_billylu
 * 这个类用来定义服务端 RemoteService 具备什么样的能力
 */
public interface BookManager extends IInterface{
	
	List<Book> getBooks() throws RemoteException;
	
	void add(Book book) throws RemoteException;
}
