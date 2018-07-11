package com.pacewer.custome.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class CustomeButton extends View{

	
	private static final String TAG = "CustomeButton";
	
	private Rect mBound;
    private Paint mPaint;
    private String mText;


	public CustomeButton(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		init();
	}

	public CustomeButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		init();
	}
	
	public CustomeButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		init();
	}
	
	private void init(){
		mText="hello world;";
		mPaint = new Paint();
		mBound = new Rect();
		mPaint.setColor(Color.RED);
		mPaint.getTextBounds(mText, 0, mText.length(), mBound);
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		
		int widthMode = MeasureSpec.getMode(widthMeasureSpec);
		int heightMode = MeasureSpec.getMode(heightMeasureSpec);
		
		int widthSize = MeasureSpec.getSize(widthMeasureSpec);
		int heightSize = MeasureSpec.getSize(heightMeasureSpec);
		
		Log.d(TAG, "widthMode:"+widthMode+",heightMode:"+heightMode);
		Log.d(TAG, "widthSize:"+widthSize+",heightSize:"+heightSize);
		
		int width;
	    int height ;
	    if (widthMode == MeasureSpec.EXACTLY) {
	        //如果match_parent或者具体的值，直接赋值
	        width = widthSize;
	    } else {
	        //如果是wrap_content，我们要得到控件需要多大的尺寸
//	        float textWidth = mBound.width();   //文本的宽度
	        //控件的宽度就是文本的宽度加上两边的内边距。内边距就是padding值，在构造方法执行完就被赋值
	        width = (int) (getPaddingLeft() + 100 + getPaddingRight());
	        Log.d(TAG, "控件的宽度："+width);
	    }
	    //高度跟宽度处理方式一样
	    if (heightMode == MeasureSpec.EXACTLY) {
	        height = heightSize;
	    } else {
	        float textHeight = 100;
	        height = (int) (getPaddingTop() + textHeight + getPaddingBottom());
	        Log.d(TAG, "文本的高度:"+textHeight + "控件的高度："+height);
	    }
	}
	
//	protected void onDraw(Canvas canvas) {
//        //绘制文字
//        for(int i = 0; i<mText.length(); i++){
//            mPaint.getTextBounds(mTextList.get(i), 0, mTextList.get(i).length(), mBound);
//            Log.v("openxu", "mBound.h:"+mBound.height());
//            Log.v("openxu", "在X:" + (getWidth() / 2 - mBound.width() / 2)+"  Y:"+(getPaddingTop() + (mBound.height() *i))+"  绘制："+mTextList.get(i));
//            canvas.drawText(mTextList.get(i), (getWidth() / 2 - mBound.width() / 2), (getPaddingTop() + (mBound.height() *i)), mPaint);
//        }
//    }
}
