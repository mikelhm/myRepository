package com.example.toucheventdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

public class MyButton extends Button{

	public MyButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN:
       	 Log.e("TouceEventDemo", "ACTION_DOWN in onTouchEvent of MyButton");
        case MotionEvent.ACTION_MOVE:
       	 Log.e("TouceEventDemo", "ACTION_MOVE in onTouchEvent of MyButton");
            break;
        case MotionEvent.ACTION_UP:
       	 Log.e("TouceEventDemo", "ACTION_UP in onTouchEvent of MyButton");
            break;
        case MotionEvent.ACTION_CANCEL:
       	 Log.e("TouceEventDemo", "ACTION_CANCEL in onTouchEvent of MyButton");
            break;
        default:
       	 Log.e("TouceEventDemo", "others in onTouchEvent of MyButton");
            break;
    }
		return super.onTouchEvent(event);
		//return true;
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN:
            Log.e("TouceEventDemo", "ACTION_DOWN in dispatchTouchEvent of MyButton");
            break;
        case MotionEvent.ACTION_MOVE:
       	 Log.e("TouceEventDemo", "ACTION_MOVE in dispatchTouchEvent of MyButton");
            break;
        case MotionEvent.ACTION_UP:
       	 Log.e("TouceEventDemo", "ACTION_UP in dispatchTouchEvent of MyButton");
            break;
        case MotionEvent.ACTION_CANCEL:
       	 Log.e("TouceEventDemo", "ACTION_CANCEL in dispatchTouchEvent of MyButton");
            break;
        default:
       	 Log.e("TouceEventDemo", "others in dispatchTouchEvent of MyButton");
            break;
    }
		return super.dispatchTouchEvent(event);
	}
}
