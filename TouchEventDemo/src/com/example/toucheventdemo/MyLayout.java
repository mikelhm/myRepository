package com.example.toucheventdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class MyLayout extends LinearLayout{

	public MyLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		
		switch (ev.getAction()) {
        case MotionEvent.ACTION_DOWN:
            Log.e("TouceEventDemo", "ACTION_DOWN in dispatchTouchEvent of MyLayout");
            break;
        case MotionEvent.ACTION_MOVE:
       	 Log.e("TouceEventDemo", "ACTION_MOVE in dispatchTouchEvent of MyLayout");
            break;
        case MotionEvent.ACTION_UP:
       	 Log.e("TouceEventDemo", "ACTION_UP in dispatchTouchEvent of MyLayout");
            break;
        case MotionEvent.ACTION_CANCEL:
       	 Log.e("TouceEventDemo", "ACTION_CANCEL in dispatchTouchEvent of MyLayout");
            break;
        default:
       	 Log.e("TouceEventDemo", "others in dispatchTouchEvent of MyLayout");
            break;
    }
		// TODO Auto-generated method stub
		return super.dispatchTouchEvent(ev);
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		switch (ev.getAction()) {
        case MotionEvent.ACTION_DOWN:
       	 Log.e("TouceEventDemo", "ACTION_DOWN in onIntercept of MyLayout");
        case MotionEvent.ACTION_MOVE:
        	Log.e("TouceEventDemo", "ACTION_MOVE in onIntercept of MyLayout");
            break;
        case MotionEvent.ACTION_UP:
        	Log.e("TouceEventDemo", "ACTION_UP in onIntercept of MyLayout");
            break;
        case MotionEvent.ACTION_CANCEL:
        	Log.e("TouceEventDemo", "ACTION_CANCEL in onIntercept of MyLayout");
            break;
        default:
       	 Log.e("TouceEventDemo", "others in onTouchEvent of MyLayout");
            break;
    }
		return super.onInterceptTouchEvent(ev);
		//return true;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN:
       	 Log.e("TouceEventDemo", "ACTION_DOWN in onTouchEvent of MyLayout");
        case MotionEvent.ACTION_MOVE:
       	 Log.e("TouceEventDemo", "ACTION_MOVE in onTouchEvent of MyLayout");
            break;
        case MotionEvent.ACTION_UP:
       	 Log.e("TouceEventDemo", "ACTION_UP in onTouchEvent of MyLayout");
            break;
        case MotionEvent.ACTION_CANCEL:
       	 Log.e("TouceEventDemo", "ACTION_CANCEL in onTouchEvent of MyLayout");
            break;
        default:
       	 Log.e("TouceEventDemo", "others in onTouchEvent of MyLayout");
            break;
    }
		return super.onTouchEvent(event);
		//return true;
	}
      
	
	
}
