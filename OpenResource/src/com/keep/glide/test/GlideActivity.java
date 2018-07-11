package com.keep.glide.test;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.myweixin.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class GlideActivity extends Activity{
	
	private ImageView mImageView;
	private final String ImageUrl = "http://pic5.bbzhi.com/dongwubizhi/chaokeaideyixiaomaobizhi/chaokeaideyixiaomaobizhi_438977_2.jpg";
	private final String gifUrl = "https://p1.pstatp.com/large/166200019850062839d3";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.glide_demo);
		
		initViews();
	}
	
	private void initViews(){
		mImageView = (ImageView)findViewById(R.id.image_view);
		loadImage();
	}
	
	public void loadImage() {
        String url = gifUrl;
        Glide.with(this)
        .load(url)
        .error(R.drawable.picture2)
        .placeholder(R.drawable.ic_launcher)
        .diskCacheStrategy(DiskCacheStrategy.NONE)
        .into(mImageView);
    }

}
