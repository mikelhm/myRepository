package com.example.toucheventdemo;

import android.support.v7.app.ActionBarActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		MyButton myButton=(MyButton) findViewById(R.id.myButton);
		MyLayout myLayout=(MyLayout) findViewById(R.id.myLayout);
		myLayout.setBackgroundColor(Color.RED);
		
		myLayout.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				switch(event.getAction())
				{
				 case MotionEvent.ACTION_DOWN:
				 {
					 Log.i("TouceEventDemo", "layout down--onTouch()");
					 break;
				 }
				 case MotionEvent.ACTION_UP:
				 {
					 Log.i("TouceEventDemo", "layout up--onTouch()");
					 break;
				 }
				 case MotionEvent.ACTION_MOVE:
				 {
					 Log.i("TouceEventDemo", "layout move--onTouch()");
					 break;
				 }
				 default:
					 break;
				}
				return false;
			}
		});
		
		myLayout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.i("TouceEventDemo", "layout click--onClick()");
			}
		});
		
		myButton.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				switch(event.getAction())
				{
				 case MotionEvent.ACTION_DOWN:
				 {
					 Log.i("TouceEventDemo", "button down--onTouch()");
					 break;
				 }
				 case MotionEvent.ACTION_UP:
				 {
					 Log.i("TouceEventDemo", "button up--onTouch()");
					 break;
				 }
				 case MotionEvent.ACTION_MOVE:
				 {
					 Log.i("TouceEventDemo", "button move--onTouch()");
					 break;
				 }
				 default:
					 break;
				}
				return false;
			}
		});
		
		myButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.i("TouceEventDemo", "button click--onClick()");
			}
		});
		
	}

	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		 switch (event.getAction()) {
         case MotionEvent.ACTION_DOWN:
        	 Log.e("TouceEventDemo", "ACTION_DOWN in onTouchEvent of MainActivity");
         case MotionEvent.ACTION_MOVE:
        	 Log.e("TouceEventDemo", "ACTION_MOVE in onTouchEvent of MainActivity");
             break;
         case MotionEvent.ACTION_UP:
        	 Log.e("TouceEventDemo", "ACTION_UP in onTouchEvent of MainActivity");
             break;
         case MotionEvent.ACTION_CANCEL:
        	 Log.e("TouceEventDemo", "ACTION_CANCEL in onTouchEvent of MainActivity");
             break;
         default:
        	 Log.e("TouceEventDemo", "others in onTouchEvent of MainActivity");
             break;
     }
		return super.onTouchEvent(event);
	}


	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		switch (ev.getAction()) {
        case MotionEvent.ACTION_DOWN:
            Log.e("TouceEventDemo", "ACTION_DOWN in dispatchTouchEvent of MainActivity");
            break;
        case MotionEvent.ACTION_MOVE:
       	 Log.e("TouceEventDemo", "ACTION_MOVE in dispatchTouchEvent of MainActivity");
            break;
        case MotionEvent.ACTION_UP:
       	 Log.e("TouceEventDemo", "ACTION_UP in dispatchTouchEvent of MainActivity");
            break;
        case MotionEvent.ACTION_CANCEL:
       	 Log.e("TouceEventDemo", "ACTION_CANCEL in dispatchTouchEvent of MainActivity");
            break;
        default:
       	 Log.e("TouceEventDemo", "others in dispatchTouchEvent of MainActivity");
            break;
    }
		return super.dispatchTouchEvent(ev);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
