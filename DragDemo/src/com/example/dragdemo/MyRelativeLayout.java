package com.example.dragdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MyRelativeLayout extends RelativeLayout{

	private TextView txt;
	private LinearLayout linearLayout;
	private int screenWidth;
	private int screenHeight;
	private int lastX, lastY;
	private int left,right,top,bottom;
	private Bitmap bitmap;
	private Paint paint;
	private boolean flag;
	private boolean touchFlag;
	
	
	public MyRelativeLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		Log.d("sequence", "RelativeLayout()");
		
	}
	
	public void init()
	{
		Log.d("sequence", "init()");
		DisplayMetrics dm = getResources().getDisplayMetrics();
		screenWidth = dm.widthPixels;
		screenHeight = dm.heightPixels - 150;	
		paint=new Paint();
		paint.setColor(Color.RED);
		flag=false;
		touchFlag=false;
		bitmap=CreateBitmap.convertViewToBitmap(txt);
		txt.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				switch (event.getAction()) 
				{
				  case MotionEvent.ACTION_DOWN:
					  //记录当前按下的手指位置
					lastX = (int) event.getRawX();
					lastY = (int) event.getRawY();
					touchFlag=true;
					//txt.setVisibility(View.GONE);
					txt.setBackgroundColor(Color.GREEN);
					txt.setText("");
					break;
				  case MotionEvent.ACTION_MOVE:
					  //记录手指的偏移
					int dx = (int) event.getRawX() - lastX;
					int dy = (int) event.getRawY() - lastY;
					left = v.getLeft() + dx;
					top = v.getTop() + dy;
					right = v.getRight() + dx;
					bottom = v.getBottom() + dy;
					// 设置不能出界
					if (left < 0) {
						left = 0;
						right = left + v.getWidth();
					}
					if (right > screenWidth) {
						right = screenWidth;
						left = right - v.getWidth();
					}
					if (top < 0) {
						top = 0;
						bottom = top + v.getHeight();
					}
					if (bottom > screenHeight) {
						bottom = screenHeight;
						top = bottom - v.getHeight();
					}
					v.layout(left, top, right, bottom);
					lastX = (int) event.getRawX();
					lastY = (int) event.getRawY();
					break;
				  case MotionEvent.ACTION_UP:
					break;
				}
				return false;  //返回false则后续的事件都交给父ViewGroup执行
			}
		});
	}
	public void setTextView(TextView txt1)
	{
		Log.d("sequence", "setTextView()");
		this.txt=txt1;
	}
	public void setLinearLayout(LinearLayout linearLayout)
	{
		this.linearLayout=linearLayout;
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
	}

	@Override
	protected void dispatchDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		
		super.dispatchDraw(canvas);
		Log.d("sequence", "dispatchDraw()");
		
		if(flag==false)
		{
			int originX=linearLayout.getLeft();
			int originY=linearLayout.getTop();
			canvas.drawBitmap(bitmap, originX, originY, paint);
			Log.d("location","X:"+originX+",Y"+originY);
			flag=true;
		}else if(flag==true&&touchFlag==false){
			
		}
		else if(flag==true&&touchFlag==true)
		{
		  Log.d("location","X:"+lastX+",Y"+lastY);
          canvas.drawBitmap(bitmap, lastX, lastY, paint);
		}
	}
    
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		switch(ev.getAction())
		{
		  case MotionEvent.ACTION_DOWN:
		  {
			  break;
		  }
		  case MotionEvent.ACTION_MOVE:
		  {
			  break;
		  }
		  case MotionEvent.ACTION_UP:
		  {
			  break;
		  }
		  default:
			  break;
		}
		return super.dispatchTouchEvent(ev);
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		return super.onInterceptTouchEvent(ev);
		//return true;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		switch(event.getAction())
		{
		  case MotionEvent.ACTION_DOWN:
		  {
			//记录当前按下的手指位置
			lastX = (int) event.getRawX();
			lastY = (int) event.getRawY();
			Log.d("手指按下", "X:"+lastX+",Y:"+lastY);
			break;
		  }
		  
		  case MotionEvent.ACTION_MOVE:
		  {
			  int dx = (int) event.getRawX() - lastX;
			  int dy = (int) event.getRawY() - lastY;
			  Log.d("手指移动", "X:"+lastX+",Y:"+lastY);
				 left = txt.getLeft() + dx;
				 top = txt.getTop() + dy;
				 right = txt.getRight() + dx;
				 bottom = txt.getBottom() + dy;
				// 设置不能出界
				if (left < 0) {
					left = 0;
					right = left + txt.getWidth();
				}
				if (right > screenWidth) {
					right = screenWidth;
					left = right - txt.getWidth();
				}
				if (top < 0) {
					top = 0;
					bottom = top + txt.getHeight();
				}
				if (bottom > screenHeight) {
					bottom = screenHeight;
					top = bottom - txt.getHeight();
				}
				lastX = (int) event.getRawX();
				lastY = (int) event.getRawY();
				invalidate();
			    break;
		  }
		  case MotionEvent.ACTION_UP:
		  {
			  break;
		  }
		  default:
			  break;
		}
		return true;//预设如果去呼叫super.onTouchEvent()則很有可能super里面并没做任何事，并且回传false回來，
		//一旦回传false回來，很可能后面的event (例如：Action_Move、Action_Up) 都会收不到了
	}

}
