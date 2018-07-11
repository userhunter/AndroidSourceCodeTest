package com.pacewear.glide.test;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.request.animation.GlideAnimation.ViewAdapter;
import com.example.myweixin.R;
import com.example.test.MainActivity;

public class OkHttpActivity extends Activity implements OnClickListener{
	
	private String Path = "http://g.hiphotos.baidu.com/zhidao/pic/item/1e30e924b899a901da2aece318950a7b0308f5cc.jpg";  
    private static final int SUCCESS = 1;  
    private static final int FALL = 2; 
    private ImageView mImageView;
    private Button mButton;
    
    Handler handler = new Handler(){  
        @Override  
        public void handleMessage(Message msg) {  
            switch (msg.what){  
                //加载网络成功进行UI的更新,处理得到的图片资源  
                case SUCCESS:  
                    //通过message，拿到字节数组  
                    byte[] Picture = (byte[]) msg.obj;  
                    //使用BitmapFactory工厂，把字节数组转化为bitmap  
                    Bitmap bitmap = BitmapFactory.decodeByteArray(Picture, 0, Picture.length);  
                    //通过imageview，设置图片  
                    mImageView.setImageBitmap(bitmap);  
  
                    break;  
                //当加载网络失败执行的逻辑代码  
                case FALL:  
                    Toast.makeText(OkHttpActivity.this, "网络出现了问题", Toast.LENGTH_SHORT).show();  
                    break;  
            }  
        }  
    };  
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.okhttp_layout);
		
		initViews();
	}
	
	private void initViews(){
		mImageView = (ImageView)findViewById(R.id.image_okhttp);
		mButton = (Button)findViewById(R.id.button_view);
		mButton.setOnClickListener(this);
	}
	
	
	private void invokeNetworkData(){
		//1.创建一个okhttpclient对象  
        OkHttpClient okHttpClient = new OkHttpClient();  
        //2.创建Request.Builder对象，设置参数，请求方式如果是Get，就不用设置，默认就是Get  
        Request request = new Request.Builder()
        					.url(Path)
        					.build();
        // 3.创建一个Call对象，参数是request对象
        Call call = okHttpClient.newCall(request);
        
        // 4. 异步请求，请求加入调度
        call.enqueue(new Callback() {
			
			@Override
			public void onResponse(Call call, Response response) throws IOException {
				//得到从网上获取资源，转换成我们想要的类型  
                byte[] Picture_bt = response.body().bytes();  
                
                //通过handler更新UI  
                Message message = handler.obtainMessage();  
                message.obj = Picture_bt;  
                message.what = SUCCESS;  
                handler.sendMessage(message);  
			}
			
			@Override
			public void onFailure(Call arg0, IOException arg1) {
				
			}
		});
	}
	
	

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button_view:
			invokeNetworkData();
			break;

		default:
			break;
		}
		
	}

}
