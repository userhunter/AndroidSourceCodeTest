package com.example.test;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.example.myweixin.R;

public class AnimationActivity extends Activity{
	
	private static final String TAG = "AnimationActivity";
//	private Button mButton;
	private ImageView mImageView;
	private ImageView mImageView2;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.animation);
		initViews();
		startScaleAnimation();
//		startPropertyAnimation();
		
		startValueAnimation();
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.d(TAG, "onPause data.");
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.d(TAG, "onStop data.");
	}
	
	@Override
		protected void onDestroy() {
			// TODO Auto-generated method stub
			super.onDestroy();
			Log.d(TAG, "onDestroy data.");
		}
	
	private void initViews(){
		mImageView = (ImageView)findViewById(R.id.image_item);
		mImageView2 = (ImageView)findViewById(R.id.image_item_2);
		
		Button button = (Button)findViewById(R.id.button);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				AnimationActivity.this.finish();
			}
		});
	}
	
	private void startScaleAnimation(){
		TranslateAnimation scaleAnimation = new TranslateAnimation(0, 500, 0,0);
		scaleAnimation.setDuration(500);
		scaleAnimation.setFillAfter(true);
		mImageView.startAnimation(scaleAnimation);
	}
	
	private void startPropertyAnimation(){
		ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mImageView2, "translationX", 0f, 100f);
	    objectAnimator.setDuration(500);
	    objectAnimator.setRepeatCount(1);
	    objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
	    objectAnimator.start();
	}
	
	private void startValueAnimation(){
		ValueAnimator valueAnimator = ValueAnimator.ofFloat(0,0.5f);
		valueAnimator.addUpdateListener(new AnimatorUpdateListener() {
			
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				    float animatorValue = (Float) animation.getAnimatedValue();  
				    mImageView2.setPivotX(mImageView2.getWidth()/2);
				    mImageView2.setPivotY(mImageView2.getHeight()/2);
				    mImageView2.setScaleX(animatorValue);
				    mImageView2.setScaleY(animatorValue);
			}
		});
		valueAnimator.setDuration(2000);
		valueAnimator.start();
	}

}
