package com.example.dragdemo;


import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		LinearLayout linearLayout=(LinearLayout) findViewById(R.id.linearLayout);
		linearLayout.setBackgroundColor(Color.GREEN);
		MyRelativeLayout myRelativeLayout=(MyRelativeLayout) findViewById(R.id.myRelativeLayout);
        TextView txt=(TextView) findViewById(R.id.textView);
        txt.setBackgroundColor(Color.YELLOW);
        //传递txt到自定义的layout中
        myRelativeLayout.setLinearLayout(linearLayout);
        myRelativeLayout.setTextView(txt);
        myRelativeLayout.init();
        myRelativeLayout.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				return false;
			}
		});
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
