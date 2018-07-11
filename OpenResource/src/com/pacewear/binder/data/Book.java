package com.pacewear.binder.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author p_billylu
 * 定义需要传输的可序列化的数据
 */
public class Book implements Parcelable{
	
	private int price;
	private String nameString;

	@Override
	public int describeContents() {
		return 0;
	}
	
	public Book(){
		
	}
	
	public Book(Parcel parcel){
		this.price = parcel.readInt();
		this.nameString = parcel.readString();
	}
	
	public static final Creator<Book> CREATOR = new Creator<Book>() {

		@Override
		public Book createFromParcel(Parcel source) {
			return new Book(source);
		}

		@Override
		public Book[] newArray(int size) {
			return new Book[size];
		}
	};
	

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		 dest.writeInt(this.price);
	     dest.writeString(this.nameString);
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getNameString() {
		return nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

}
