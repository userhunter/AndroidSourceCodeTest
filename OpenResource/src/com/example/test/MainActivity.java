package com.example.test;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TabHost;

import com.example.myweixin.R;
import com.pacewear.binder.service.aidl.IMyAidlInterface;
import com.pacewear.binder.service.aidl.IMyAidlInterface.Stub;
import com.pacewear.binder.service.aidl.LocalService;
import com.pacewear.binder.service.aidl.LocalService.LocalBinderService;
import com.pacewear.binder.service.aidl.RemoteService;
import com.pacewear.glide.test.GlideActivity;
import com.pacewear.glide.test.OkHttpActivity;
import com.pacewear.handler.test.HanlderActivity;
import com.pacewear.tws.sharepreference.SharePreferenceUtils;
import com.pacewear.ui.provider.SportTypeSelectProvider;

public class MainActivity extends Activity implements OnTouchListener,OnClickListener{
	
	private static final String TAG = "MainActivity";
	
	private TabHost tabhost;
	private LinearLayout mLayout;
    private Button mButton;
    private static final String usr = "https://watcheditor.cdn.pacewear.com/qrcode_5d1bf54793ca2d80d31cab802fb63899.json";
	
    Uri uri = Uri.parse("content://"+SportTypeSelectProvider.AUTHORITY+"/");  
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_test);
        
//        tabhost =(TabHost) findViewById(R.id.mytab);
//        tabhost.setup();
//        updateTab(tabhost);
//        TabWidget widget = tabhost.getTabWidget();
//        widget.setBackgroundColor(Color.BLACK);
//        widget.setLeftStripDrawable(getResources().getDrawable(R.drawable.tab_bar_bg_light));
//        widget.setRightStripDrawable(getResources().getDrawable(R.drawable.tab_bar_bg_light));
//        
//        tabhost.addTab(tabhost.newTabSpec("one").setIndicator("nihao").setContent(R.id.widget_layout_red));
//        tabhost.addTab(tabhost.newTabSpec("two").setIndicator("name").setContent(R.id.widget_layout_yellow));
        initViews();
        
//        test(usr);
        testSharePreference();
        registerUpdateObserver();
    }
    
    private void registerUpdateObserver(){
    	
    	ContentObserver observer = new ContentObserver(new Handler()) {
    	     
        	@SuppressLint("NewApi") @Override
        	public void onChange(boolean selfChange, Uri uri) {
        		super.onChange(selfChange, uri);
        		Log.d(TAG, "DB Chang " + uri.toString());
        	}
         
        	@Override
        	public void onChange(boolean selfChange) {
        		Log.i(TAG, "DB Chang");
        		super.onChange(selfChange);
        	}	
        };
    	getContentResolver().registerContentObserver(uri, false, observer);
    }
    
    public void testSharePreference(){
    	SharePreferenceUtils.setCurrentDistance(this, "abd");
    	SharePreferenceUtils.setFreeTrainTrackLeftSize(this, 12);
    }
    
    @Override
    protected void onDestroy() {
    	// TODO Auto-generated method stub
    	super.onDestroy();
    	SharePreferenceUtils.clearAll(this);
    }
    
    
    private void test(final String url){
    	
    	new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				HttpClient httpClient = new DefaultHttpClient();
				SSLSocketFactory.getSocketFactory().setHostnameVerifier(new AllowAllHostnameVerifier());  
//				if(!url.startsWith("http://") && !url.startsWith("https://")){
//					url = "http://"+url;
//				}
				HttpGet httpGet = new HttpGet(url);

				Header[] headers = httpGet.getAllHeaders();
				for(int i=0;i<headers.length;i++){
					Log.d(TAG,"type:"+i+",name:"+headers[i]);
				}

				Log.d(TAG, "get content type:"+httpGet.getHeaders("Content-Type"));
				httpGet.addHeader("Content-Type", "application/json");

				Log.w(TAG,"parse url = "+url);

				Log.d(TAG, "start to get the HttpResponse");
				HttpResponse httpResponse;
				try {
					httpResponse = httpClient.execute(httpGet);
					if(httpResponse.getStatusLine().getStatusCode() == 200){
						HttpEntity entity = httpResponse.getEntity();
						String reJson = EntityUtils.toString(entity,"utf-8");
					}
				}catch (IOException e) {
					// TODO Auto-generated catch block
					Log.w(TAG,"IOException: "+e);
					e.printStackTrace();
				}
			}
		}).start();
    	
		
    }
    
    private void initViews(){
    	  mLayout = (LinearLayout) this.findViewById(R.id.myRoot);
          mButton = (Button) this.findViewById(R.id.my_btn);
          
          Button ok = (Button)this.findViewById(R.id.okhttp);
          ok.setOnClickListener(this);
          
          Button binderActivity = (Button)this.findViewById(R.id.binderServer);
          binderActivity.setOnClickListener(this);
          
          Button localService = (Button)findViewById(R.id.binderlocalservice);
          localService.setOnClickListener(this);
          
          Button useAIDL = (Button)findViewById(R.id.useraidlbinderservice);
          useAIDL.setOnClickListener(this);
          
          Button button = (Button)findViewById(R.id.custome_view);
          button.setOnClickListener(this);
          
          Button animatiButton = (Button)findViewById(R.id.animation_view);
          animatiButton.setOnClickListener(this);
          
          Button customeView = (Button)findViewById(R.id.customeActivity);
          customeView.setOnClickListener(this);
          
          Button providerButton = (Button)findViewById(R.id.provider);
          providerButton.setOnClickListener(this);
          
          Button anmationButton = (Button)findViewById(R.id.animation_activity);
          anmationButton.setOnClickListener(this);
          
          Button handlerButton = (Button)findViewById(R.id.handler_test);
          handlerButton.setOnClickListener(this);

//          mLayout.setOnTouchListener(this);
//          mButton.setOnTouchListener(this);

          mLayout.setOnClickListener(this);
          mButton.setOnClickListener(this);
          
          
    }

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.my_btn:
			startAssignActivity(GlideActivity.class);
			break;
			
		case R.id.okhttp:
			startAssignActivity(OkHttpActivity.class);
			break;
			
		case R.id.binderServer:
			startAssignActivity(BinderActivity.class);
			break;
			
		case R.id.binderlocalservice:
			binderLocalService();
			break;
			
		case R.id.useraidlbinderservice:
			bindRemoteService();
			break;
			
		case R.id.custome_view:
			startAssignActivity(CustomeActivity.class);
			break;
			
		case R.id.animation_view:
			startAssignActivity(AnimationActivity.class);
			break;
			
		case R.id.provider:
			getContentResolver().notifyChange(uri, null);
			break;
			
		case R.id.animation_activity:
			startAssignActivity(ActivityTransfer.class);
			overridePendingTransition(R.anim.slide_in_from_bottom, 0);
			break;
			
		case R.id.handler_test:
			startAssignActivity(HanlderActivity.class);
			break;
			
			
		default:
			break;
		}
	}
	
	private  void bindRemoteService(){
		Intent intent = new Intent(RemoteService.INTENT);
		boolean binderSuccess = bindService(intent, remoteConnection, Context.BIND_AUTO_CREATE);
		Log.d(TAG, "bindRemoteService:"+binderSuccess);
	}
	
	
	
	private void binderLocalService(){
		Intent intent = new Intent(MainActivity.this,LocalService.class);
		boolean binderSuccess = bindService(intent, connection, Context.BIND_AUTO_CREATE);
		Log.d(TAG, "binderSuccess:"+binderSuccess);
	}
	
	
	ServiceConnection connection = new ServiceConnection(){

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			Log.d(TAG, "onServiceConnected:");
			LocalService localService = ((LocalBinderService)service).getService();
			localService.sayHello();
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			
		}
		
	};
	
	ServiceConnection remoteConnection = new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			Log.d(TAG, "onServiceConnected remote service:");
			IMyAidlInterface data = Stub.asInterface(service);
			try {
				data.add(5, 6);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	};
	
	private void startAssignActivity(Class<?> object){
		Intent intent = new Intent(MainActivity.this,object);
		startActivity(intent);
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		Log.i(TAG, "OnTouchListener--onTouch-- action="+event.getAction()+" --"+v);
		return false;
	}
    
    
    /**
     * 更新Tab标签的颜色，和字体的颜色
     * @param tabHost
     */ 
//    private void updateTab(final TabHost tabHost) { 
//        for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++) { 
//            View view = tabHost.getTabWidget().getChildAt(i); 
//            TextView tv = (TextView) tabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title); 
//            tv.setTextSize(16); 
//            tv.setTypeface(Typeface.SERIF, 2); // 设置字体和风格  
//            if (tabHost.getCurrentTab() == i) {//选中  
//                view.setBackgroundColor(Color.RED);//选中后的背景  
//                tv.setTextColor(this.getResources().getColorStateList( 
//                        android.R.color.black)); 
//            } else {//不选中  
//            	view.setBackgroundColor(Color.YELLOW);//非选择的背景  
//                tv.setTextColor(this.getResources().getColorStateList( 
//                        android.R.color.holo_red_dark)); 
//            } 
//        } 
//    } 


}
