package com.pacewear.tws.sharepreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SharePreferenceUtils {
	
	private static final String PREFERENCE_NAME = "ok_https";
	
	private static final String KEY_DISTANCE = "distance";
	
	// ble free_train define
	private static final String KEY_FREE_TRAIN_PULL_SIZE = "ble_free_train_pull_size";
	private static final String KEY_FREE_TRAIN_PULL_POS = "ble_free_train_pull_pos";
	
	
	public static void clearAll(Context context){
		SharedPreferences preferences = context.getSharedPreferences(
				PREFERENCE_NAME, Context.MODE_PRIVATE);
		Editor editor = preferences.edit();
		editor.clear();
		editor.commit();
	}
	
	public static void setCurrentDistance(Context context, String distance) {
		SharedPreferences preferences = context.getSharedPreferences(
				PREFERENCE_NAME, Context.MODE_PRIVATE);
		Editor editor = preferences.edit();
		editor.putString(KEY_DISTANCE, distance);
		editor.commit();
	}

	public static String getCurrentDistance(Context context) {
		SharedPreferences preferences = context.getSharedPreferences(
				PREFERENCE_NAME, Context.MODE_PRIVATE);
		return preferences.getString(KEY_DISTANCE, "");
	}
	
	// 记录下当前的size,1表示还可以拉取
	public static void setFreeTrainTrackLeftSize(Context context,int hasMore) {
		SharedPreferences preferences = context.getSharedPreferences(
				PREFERENCE_NAME, Context.MODE_PRIVATE);
		Editor editor = preferences.edit();
		editor.putInt(KEY_FREE_TRAIN_PULL_SIZE, hasMore);
		editor.commit();
	}

	public static int getFreeTrainningTrackLeftSize(Context context) {
		SharedPreferences preferences = context.getSharedPreferences(
				PREFERENCE_NAME, Context.MODE_PRIVATE);
		return preferences.getInt(KEY_FREE_TRAIN_PULL_SIZE,0);
	}
	
	public static void setFreeTrainLeftPos(Context context,String postion) {
		SharedPreferences preferences = context.getSharedPreferences(
				PREFERENCE_NAME, Context.MODE_PRIVATE);
		Editor editor = preferences.edit();
		editor.putString(KEY_FREE_TRAIN_PULL_POS, postion);
		editor.commit();
	}

	public static String getFreeTrainLeftPos(Context context) {
		SharedPreferences preferences = context.getSharedPreferences(
				PREFERENCE_NAME, Context.MODE_PRIVATE);
		return preferences.getString(KEY_FREE_TRAIN_PULL_POS, "");
	}

}
