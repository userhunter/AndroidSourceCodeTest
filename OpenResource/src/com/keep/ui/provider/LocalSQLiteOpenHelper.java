/**
 * 
 */

package com.keep.ui.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * @descrition
 * @author billylu@tencent.com
 * @data 2016-2-23 上午10:25:21 notice: LocalSQLiteOpenHelper数据保存在/data/data下面
 */
public class LocalSQLiteOpenHelper extends SQLiteOpenHelper {

    private static final String TAG = "LocalSQLiteOpenHelper"; 

    public static final String CREATE_TABLE_TRACK = String.format(
            "CREATE TABLE IF NOT EXISTS %s ("
                    + "%s INTEGER PRIMARY KEY,"
                    + "%s INTEGER NOT NULL,"
                    + "%s TEXT NOT NULL,"
                    + "%s INTEGER NOT NULL,"
                    + "%s INTEGER NOT NULL,"
                    + "%s TEXT ,"
                    + "%s LONG ,"
                    + "%s LONG ,"
                    + "%s FLOAT ,"
                    + "%s LONG ,"
                    + "%s INTEGER ,"
                    + "%s INTEGER ,"
                    + "%s FLOAT ,"
                    + "%s INTEGER ,"
                    + "%s INTEGER ,"
                    + "%s INTEGER ,"
                    + "%s INTEGER ,"
                    + "%s INTEGER ,"
                    + "%s FLOAT ,"
                    + "%s INTEGER ,"
                    + "%s TEXT ,"
                    + "%s INTEGER ,"
                    + "%s INTEGER ,"
                    + "%s INTEGER );",
            DBConstants.TRACK_TABLE_NAME,
            DBConstants.KEY_ID,
            DBConstants.KEY_TRACK_ID,
            DBConstants.KEY_USER_ID,
            DBConstants.KEY_TRACK_YEAR,
            DBConstants.KEY_TRACK_MONTH,
            DBConstants.KEY_DEVICE_ID,
            DBConstants.KEY_TRACK_STARTTIME,
            DBConstants.KEY_TRACK_ENDTIME,
            DBConstants.KEY_TRACK_DISTANCE,
            DBConstants.KEY_TRACK_DURATION,
            DBConstants.KEY_TRACK_STEPS,
            DBConstants.KEY_TRACK_CALORY,
            DBConstants.KEY_TRACK_AVERAGESPEED,
            DBConstants.KEY_TRACK_AVERAGEHEARTRATE,
            DBConstants.KEY_DELIVERY_STATUS,
            DBConstants.KEY_MEDAL_COUNT,
            DBConstants.KEY_TRACK_INDOOR,
            DBConstants.KEY_TRACK_LOCATIONCOUNT,
            DBConstants.KEY_TRACK_MAXINSPEED,
            DBConstants.KEY_TARCK_MAX_HEARTRATE,
            DBConstants.KEY_TARCK_RANGE_HEARTRATE,
            DBConstants.KEY_TARCK_RUN_TYPE,
            DBConstants.KEY_TRACK_IS_DELETE,
            DBConstants.KEY_TARCK_RUN_INCHINA);
    

    /**
     * @param context
     * @param name
     * @param factory
     * @param version
     */
    public LocalSQLiteOpenHelper(Context context) {
        super(context, DBConstants.LOCAL_DATABASE, null, DBConstants.DATABASE_VERSION);
    }
    
    /**
     * @param context
     * @param name
     * @param factory
     * @param version
     */
    public LocalSQLiteOpenHelper(Context context,String database) {
        super(context, database, null, DBConstants.DATABASE_VERSION);
    }

    /*
     * (non-Javadoc)
     * @see
     * android.database.sqlite.SQLiteOpenHelper#onCreate(android.database.sqlite.SQLiteDatabase)
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "db onCreate.");
        createRecordAndTrackDatabase(db);
    }
    
    
    private void createRecordAndTrackDatabase(SQLiteDatabase db){
        db.execSQL(CREATE_TABLE_TRACK);
    }

    /*
     * (non-Javadoc)
     * @see
     * android.database.sqlite.SQLiteOpenHelper#onUpgrade(android.database.sqlite.SQLiteDatabase,
     * int, int)
     */
    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
    }
    

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

}
