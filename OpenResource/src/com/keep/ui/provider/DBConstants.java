package com.keep.ui.provider;

import java.io.File;

import android.os.Environment;

/**
 * Created by hakimhuang on 2015/12/22.
 */
public class DBConstants {

	public static final String DATABASE_PATH = getSDCardPath() + File.separator
			+ "FTSports";
	public static final String DATABASE_NAME = DATABASE_PATH + File.separator
			+ "FTSport.db";
	
	public static final String LOCAL_DATABASE = "ftsports.db";
	public static final String COMMON_SDCARD_DATABASE = DATABASE_PATH + File.separator
			+ LOCAL_DATABASE;
	public static final int DATABASE_VERSION = 33;  // update walk and free/trainning
	
	public static final String KEY_ID = "_id"; // 字段id
	public static final String KEY_TRACK_ID = "trackId"; // 跑步记录id，唯一性
	public static final String KEY_USER_ID = "userId"; // 用户id，唯一性
	public static final String KEY_DEVICE_ID = "device_id";   // 设置device Id
	public static final String KEY_RUN_TYPE = "run_type";  // 运动类型

	public static final String TRACK_TABLE_NAME = "run_track"; // 跑步记录表-跑步记录页
	public static final String KEY_TRACK_YEAR = "year";      // 当前记录的年份
	public static final String KEY_TRACK_MONTH = "month"; // 当前记录月份
	public static final String KEY_TRACK_STARTTIME = "startTime"; // 当前记录开始时间
	public static final String KEY_TRACK_ENDTIME = "endTime"; // 当前记录结束时间
	public static final String KEY_TRACK_DISTANCE = "distance"; // 距离
	public static final String KEY_TRACK_DURATION = "duration"; // 时长
	public static final String KEY_TRACK_STEPS = "steps"; // 步数
	public static final String KEY_TRACK_CALORY = "calories"; // 卡路里
	public static final String KEY_TRACK_AVERAGESPEED = "averageSpeed"; // 平均配速
	public static final String KEY_TRACK_AVERAGEHEARTRATE = "averageHeartRate"; // 平均心率
	public static final String KEY_TRACK_AVERAGEALTITUDE = "averageAltitude"; // 平均海拔
	public static final String KEY_TRACK_INDOOR = "indoor"; // 室内外
	public static final String KEY_TRACK_LOCATIONCOUNT = "locationCount"; // 节点数
	public static final String KEY_TRACK_COMPRESS = "ifCompress"; // 是否经过压缩计算
	public static final String KEY_TRACK_MAXINSPEED = "max_inspeed"; // 当前最大的配速度
	public static final String KEY_TRACK_IS_DELETE = "isDelete";    // 是否删除
	public static final String KEY_TRACK_IS_HIDE = "isHide";    // 是否隐藏
	public static final String KEY_DELIVERY_STATUS = "deliver_status";
	public static final String KEY_MEDAL_COUNT = "medal_count";
	
	public static final String KEY_TARCK_MAX_HEARTRATE = "max_heartrate";
	public static final String KEY_TARCK_RANGE_HEARTRATE = "range_heartrate";
	public static final String KEY_TARCK_RUN_TYPE = "run_type";
	public static final String KEY_TARCK_RUN_INCHINA = "run_inchina";
	
	
	public static final String TRACK_TABLE_HIDE_NAME = "run_track_hide"; // 跑步记录表-跑步记录页

	
	/****** record start **********************************************************************/
	public static final String RECORD_TABLE_NAME = "run_record"; // 成就表-首页(每个userId只对应该表的一条记录)
	public static final String KEY_RECORD_COUNTS = "counts"; // 跑步总次数
	public static final String KEY_RECORD_TOTALCOSTTIME = "totalCostTime"; // 总时长
	public static final String KEY_RECORD_TOTALDISTANCE = "totalDistance"; // 总距离
	public static final String KEY_RECORD_MAXCALORY = "maxCalories";     // 单次最大消耗卡路里
	public static final String KEY_RECORD_MAXCALORY_TRACKID = "maxCaloriesTrackid";    
	public static final String KEY_RECORD_TOTALCALORY = "totalCalories"; // 总消耗卡路里
	public static final String KEY_RECORD_MAXDISTANCE = "maxDistance"; // 最大距离
	public static final String KEY_RECORD_MAXSPEED = "maxSpeed"; // 最大配速
	public static final String KEY_RECORD_LASTDISTACE = "last_distance";
	public static final String KEY_RECORD_MAXTIME = "max_time";
	public static final String KEY_RECORD_MAXTIME_TRACKID = "max_time_trackid";
	public static final String KEY_RECORD_MAXDISTANCE_TRACKID ="maxdistance_id";
	public static final String KEY_RECORD_MAXSPEED_TRACKID ="maxspeed_id";
	public static final String KEY_RECORD_LATEST_TRACKID = "latest_trackid";
	
	public static final String KEY_RECORD_DEL_RUN_COUNT = "del_run_count";
	public static final String KEY_RECORD_DEL_DURATION = "del_duration";
	public static final String KEY_RECORD_DEL_TOTAL_DISTANCE = "del_total_distance";
	public static final String KEY_RECORD_DEL_TOTAL_CALORY = "del_total_calories";
	
	/****** record end  **********************************************************************/
	
	
	public static final String WAYPOINT_TABLE_NAME = "run_waypoint"; // 轨迹节点表-记录详情页
	public static final String KEY_WAYPOINT_TIME = "time"; // 采集时间点
	public static final String KEY_WAYPOINT_LATITUDE = "latitude"; // 经度
	public static final String KEY_WAYPOINT_LONGITUDE = "longitude"; // 纬度
	public static final String KEY_WAYPOINT_ALTITUDE = "altitude"; // 海拔
	public static final String KEY_WAYPOINT_ACCURACY = "accuracy"; // 精确度
	public static final String KEY_WAYPOINT_BEARING = "bearing"; // 方位
	public static final String KEY_WAYPOINT_DISTANCE = "distance"; // 距离
	public static final String KEY_WAYPOINT_INSPEED = "inSpeed"; // 瞬时速度
	public static final String KEY_WAYPOINT_AVGSPEED = "avgSpeed"; // 平均速度
	public static final String KEY_WAYPOINT_HEARTRATE = "heartRate"; // 心率
	public static final String KEY_WAYPOINT_ISPAUSE = "ispause";  // 是否暂停

	public static final String COMPRESS_DATA_TABLE_NAME = "compress_data"; // 通过压缩之后的表
	public static final String KEY_COMPRESS_INDEX = "compress_index"; // 次数索引
	
	public static final String ORIGINAL_TABLE_NAME = "origin_sport_data";
	public static final String KEY_ORIGINAL_STARTTIME = "startTime";      // 开始时间
	public static final String KEY_ORIGINAL_STOPTTIME = "stopTime";       // 结束时间
	public static final String KEY_ORIGINAL_STEPCOUNT = "stepCount";      // 当前运行的步数
	public static final String KEY_ORIGINAL_INDOOR = "indoor";            // 室内还是室外
	public static final String KEY_ORIGINAL_LATITUDE = "latitude";        // 纬度
	public static final String KEY_ORIGINAL_LONGITUDE = "longitude";       // 经度
	public static final String KEY_ORIGINAL_ALTITUDE = "altitude";         // 高度
	public static final String KEY_ORIGINAL_SPEED = "speed";           // 瞬时速度
	public static final String KEY_ORIGINAL_TIME = "time";             // 当前的时间点
	public static final String KEY_ORIGINAL_HEARTCOUNT = "heartCount"; // 心率
	public static final String KEY_ORIGINAL_INSERT = "insert_success"; // 插入后台是否成功
	public static final String KEY_ORIGINAL_PAUSE = "insert_pause";    // 是否为停止
	
	public static final String KMSPEED_TABLE_NAME = "kmspeed_sport_data";
	public static final String KEY_INSPEED = "inspeed";
	public static final String KEY_INSPEED_PERKILOMETER = "perkilometer";

	//勋章表
	public static final String MEDAL_TABLE_NAME = "medal_data";  
	public static final String KEY_MEDAL_ID = "medal_id";
	public static final String KEY_MEDAL_STANDARD = "standard";
	public static final String KEY_MEDAL_CATEGORY = "category";
	public static final String KEY_MEDAL_THRESHOLD = "threshold";
	public static final String KEY_MEDAL_TEXT = "medalTxt";
	public static final String KEY_MEDAL_ICON = "medalIcon";
	public static final String KEY_MEDAL_SYNC = "isSync";
	public static final String KEY_MEDAL_GET = "isGet";
	public static final String KEY_MEDAL_TIME = "get_time";
	
	//勋章图片
	public static final String MEDAL_IMAGE_TABLE_NAME = "medal_image";
	public static final String KEY_MEDAL_IMAGE_FILENAME = "medal_image_filename";
	public static final String KEY_MEDAL_IMAGE_FOLDER = "medal_image_folder";
	public static final String KEY_MEDAL_IMAGE_URL = "medal_image_url";
	public static final String KEY_MEDAL_IMAGE_DOWNLOAD = "medal_download";
	public static final String KEY_MEDAL_IMAGE_MD5 = "medal_md5";
	
	//勋章视频
	public static final String MEDAL_VIDEO_TABLE_NAME = "medal_video";
	public static final String KEY_MEDAL_VIDEO_FILENAME = "medal_video_filename";
	public static final String KEY_MEDAL_VIDEO_FOLDER = "medal_video_folder";
	public static final String KEY_MEDAL_VIDEO_URL = "medal_video_url";
	public static final String KEY_MEDAL_VIDEO_DOWNLOAD = "medal_video_download";
	public static final String KEY_MEDAL_VIDEO_MD5 = "medal_video_md5";
	
	public static final String CLIENT_AND_SERVER = "client_server";
	public static final String KEY_SERVER_ID = "serverid";  // 当前的服务器ID
	public static final String KEY_TRACKID_NEED_DELETE = "isdelete";  // 当前的服务器ID
	public static final String KEY_SERVER_PULL_ITEM_DELETE = "server_delete"; // 从服务器端拉取下来的数据是否已经被删除

    public static final String INSPEED_TABLE_NAME = "inspeed_sport_data";
    private static final String DEFAULT_PATH = "/sdcard";
    
    public static final String FIT_HEARTRATE = "fit_heart_rate";
    public static final String FIT_HEARTRATE_TIME = "fit_heart_time";
    public static final String FIT_HEARTRATE_VALUE = "fit_heart_value";
    public static final String FIT_HEARTRATE_STATIC = "fit_heart_static";
    public static final String FIT_ACTION_TYPE = "fit_action_type";
    public static final String FIT_ACTION_VALUE = "fit_action_value";
    
    public static final String FIT_COUNT_DATA = "fit_count";
    public static final String FIT_ARRAY = "fit_array";
    public static final String FIT_NUMBER = "fit_number";
    
    public static final String FIT_RECORD = "fit_record";
	public static final String FIT_COUNTS = "fit_total_counts";  // 健身次数
    public static final String FIT_TOTAL_DURTIONS = "fit_total_time";  // 训练总时长
    public static final String FIT_SINGLE_MAX_TIME = "fit_single_max_value"; // 训练最长单次时长
    public static final String FIT_SINGLE_MAX_TIME_ID = "fit_single_max_value_id"; // 训练最长单次时长对应id
    public static final String FIT_LAST_TIME = "fit_last_time";  // 最近一次训练记录时长
    public static final String FIT_LAST_TIME_ID = "fit_last_time_id"; // 最近一条记录的trackid
    public static final String FIT_MAX_CALORIES = "fit_max_calories";  // 训练最大的一次卡路里值
    public static final String FIT_MAX_CALORIES_ID = "fit_max_calories_id"; // 训练最大的一次卡路里值对应id
    public static final String FIT_TOTAL_CALORIES = "fit_total_calories";  // 训练总的卡路里数
    public static final String DEL_TOTAL_CALORIES = "fit_delete_total_calories";  // 训练总的卡路里数
    public static final String DEL_TOTAL_DURATION = "fit_delete_duration";  // 训练总的卡路里数
    public static final String DEL_RECORD_COUNT = "fit_record_count";  // 训练总的卡路里数
    
    
    public static final String FIT_TRACK = "fit_track";
    public static final String FIT_TRACK_ACTION_NAME = "fit_track_action_name";  // 动作名称
    public static final String FIT_TRACK_ACTION_TYPE = "fit_track_action_type";  // 动作类型
    public static final String FIT_TRACK_START_TIME = "fit_track_start_time"; //开始时间
    public static final String FIT_TRACK_STOP_TIME = "fit_single_stop_time"; // 结束时间
    public static final String FIT_TRACK_WORK_TIME = "fit_work_time";  //训练时长
    
    public static final String FIT_TRACK_AVG_HEART = "fit_avg_heart"; // 平均心率
    public static final String FIT_TRACK_CALORIES = "fit_track_calories";   //卡路里calories
    public static final String FIT_TRACK_RECOVER = "fit_recover_time";     //恢复时间
    public static final String FIT_TRACK_DELETE = "fit_track_delete";      // 是否被删除了
    public static final String FIT_TRACK_DELIVER_NETWORK = "fit_track_network"; // 是否被传输到网上
    
//    public static final String BLE_CLIENT_SERVER_TABLE = "ble_client_server";
    
    public static final  int  ShotBitmapSize = 280;  // 压缩之后为280KB
    
	public static String getSDCardPath() {

		String currentPath = null;
		if (!Environment.MEDIA_MOUNTED.equals(Environment
				.getExternalStorageState())) {
			currentPath = DEFAULT_PATH;
		} else {
			currentPath = Environment.getExternalStorageDirectory()
					.getAbsolutePath();
		}

		return currentPath;
	}

}
