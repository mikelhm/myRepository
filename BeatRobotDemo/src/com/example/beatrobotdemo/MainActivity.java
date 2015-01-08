package com.example.beatrobotdemo;

import java.util.Random;




import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	private int count=0;  //记录打的机器人的个数
	private ImageView robot;
	private ImageView robot2;
	private TextView tv;
	private Handler handler;
	//表示机器人位置的二维数组
	public int[][] position=new int[][]{{231,325},{424,349},{521,256},{543,296},{719,245},{832,292},{772,358}};
	public int[][] position2=new int[][]{{125,200},{300,221},{400,105},{355,69},{70,427},{80,110},{650,118}};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		robot=(ImageView) findViewById(R.id.imageRobot);
		robot2=(ImageView) findViewById(R.id.imageRobot2);
		tv=(TextView) findViewById(R.id.textView);
		
		robot.setOnTouchListener(new OnTouchListener(){
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				v.setVisibility(View.INVISIBLE);//设置不可见
				count++;
				//Toast.makeText(MainActivity.this, "打到第["+count+"]个机器人!", Toast.LENGTH_SHORT).show();
				tv.setText("总共打的机器人个数:"+count);
				return false;
			}});
		
		robot2.setOnTouchListener(new OnTouchListener(){
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				v.setVisibility(View.INVISIBLE);//设置不可见
				count++;
				//Toast.makeText(MainActivity.this, "打到第["+count+"]个机器人!", Toast.LENGTH_SHORT).show();
				tv.setText("总共打的机器人个数:"+count);
				return false;
			}});
		
		handler=new Handler(){
			@Override
			public void handleMessage(Message msg) {
				// TODO Auto-generated method stub
				int index=0;
				int index2=0;
				if(msg.what==0x101)
				{
					index=msg.arg1;
					index2=msg.arg2;
					robot.setX(position[index][0]);
					robot.setY(position[index][1]);
					robot.setVisibility(View.VISIBLE);
					robot2.setX(position2[index2][0]);
					robot2.setY(position2[index2][1]);
					robot2.setVisibility(View.VISIBLE);
				}
				super.handleMessage(msg);
			}};
			Thread thread=new Thread(new Runnable(){
				@Override
				public void run() {
					// TODO Auto-generated method stub
					int index=0;
					int index2=0;
					while(!Thread.currentThread().isInterrupted())
					{
						index=new Random().nextInt(position.length);//在二维数组的长度范围内产生一个随机数
						index2=new Random().nextInt(position2.length);
						Message message=handler.obtainMessage();
						message.arg1=index;
						message.arg2=index2;
						message.what=0x101;
						handler.sendMessage(message);
						try {
							Thread.sleep(300);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}});
			thread.start();
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
