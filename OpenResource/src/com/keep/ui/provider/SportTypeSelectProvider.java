package com.keep.ui.provider;

import java.util.HashMap;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;


/**
 * Created by Administrator on 2018/3/27.
 */

public class SportTypeSelectProvider extends ContentProvider {
    private static HashMap<String, String> sporttypeMap;

    public static final String AUTHORITY = "com.keep.tws.sport.typeselect";
    private static final String CONTENT_RUNNING_TYPE = "com.keep.tws.sport.typeselect.running";

    private static final int SPORT_RUNNING = 1;

    private static final UriMatcher sUriMatcher;

    private LocalSQLiteOpenHelper mOpenHelper;

    @Override
    public boolean onCreate() {
        mOpenHelper = new LocalSQLiteOpenHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
                        String sortOrder) {
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        switch (sUriMatcher.match(uri)) { // 这里要对不同表的匹配结果做不同处理
            case SPORT_RUNNING:
                qb.setTables(DBConstants.TRACK_TABLE_NAME);
                break;
            	
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }

        switch (sUriMatcher.match(uri)) {
            case SPORT_RUNNING:
                qb.setProjectionMap(sporttypeMap);
                break;

            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }

        // Get the database and run the query
        SQLiteDatabase db = mOpenHelper.getReadableDatabase();
        Cursor c = qb.query(db, projection, selection, selectionArgs, null, null, sortOrder);

        // Tell the cursor what uri to watch, so it knows when its source data changes
        c.setNotificationUri(getContext().getContentResolver(), uri);
        return c;
    }

    @Override
    public String getType(Uri uri) {
        switch (sUriMatcher.match(uri)) { // 这里也要增加匹配项
            case SPORT_RUNNING:
                return CONTENT_RUNNING_TYPE;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues initialValues) {
        ContentValues values;
        if (initialValues != null) {
            values = new ContentValues(initialValues);
        } else {
            values = new ContentValues();
        }

        String tableName = "";
        switch (sUriMatcher.match(uri)) { // 这里要对不同表的匹配结果做不同处理
            case SPORT_RUNNING:
                tableName = DBConstants.TRACK_TABLE_NAME;
                break;
            default:
                // Validate the requested uri
                throw new IllegalArgumentException("Unknown URI " + uri);

        }

        SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        long rowId = db.insert(tableName, null, values);
        if (rowId > 0) {
            Uri noteUri = ContentUris.withAppendedId(uri, rowId);
            getContext().getContentResolver().notifyChange(noteUri, null);
            return noteUri;
        }

        throw new SQLException("Failed to insert row into " + uri);
    }

    @Override
    public int delete(Uri uri, String where, String[] whereArgs) {
        SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        int count;
        switch (sUriMatcher.match(uri)) { // 这里要对不同表的匹配结果做不同处理，注意下面用到的表名不要弄错了
            case SPORT_RUNNING:
                count = db.delete(DBConstants.TRACK_TABLE_NAME, where, whereArgs);
                break;

            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }

        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

    @Override
    public int update(Uri uri, ContentValues values, String where, String[] whereArgs) {
        SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        int count;
        switch (sUriMatcher.match(uri)) { // 这里要对不同表的匹配结果做不同处理，注意下面用到的表名不要弄错了
            case SPORT_RUNNING:
                count = db.update(DBConstants.TRACK_TABLE_NAME, values, where, whereArgs);
                break;

            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }

        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

    static {
        sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        sUriMatcher.addURI(AUTHORITY, "running", SPORT_RUNNING);

        // 保存所有表用到的字段
        sporttypeMap = new HashMap<String, String>();
    }
}
