package com.example.handlerdemo;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

public class ColorActivity extends Activity {
	
	private Handler handler;       //创建一个Handler对象
	int[] backgroundColor;
	private TextView[] tvs;
	private int currentColorIndex=0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_color);
		backgroundColor=new int[]{R.color.color1,R.color.color2,R.color.color3,R.color.color4,
                R.color.color5,R.color.color6,R.color.color7};
		tvs=new TextView[]{(TextView) findViewById(R.id.textView1),(TextView) findViewById(R.id.textView2),
                (TextView) findViewById(R.id.textView3),(TextView) findViewById(R.id.textView4),
                (TextView) findViewById(R.id.textView5),(TextView) findViewById(R.id.textView6),
                (TextView) findViewById(R.id.textView7)};
		
		//在主线程中更新UI
		handler=new Handler(){
			@Override
			public void handleMessage(Message msg) {
				// TODO Auto-generated method stub
				int temp=0;            //临时变量
				if(msg.what==0x101)
				{
					for(int i=0;i<tvs.length;i++)
					{
						temp=new Random().nextInt(backgroundColor.length);// 随机生成数
						if(currentColorIndex==temp)  //如果新生成的颜色和前面一个颜色重复
						{
							temp++;
							if(temp==backgroundColor.length)
								temp=0;
						}
						currentColorIndex=temp;
						tvs[i].setBackgroundColor(getResources().getColor(backgroundColor[currentColorIndex]));
					}
				}
				super.handleMessage(msg);
			}
		};
		
		//创建一个子线程
		Thread thread=new Thread(new Runnable(){

			@Override
			public void run() {
			while(!Thread.currentThread().isInterrupted())
			{
				// TODO Auto-generated method stub
				Message message=handler.obtainMessage();
				message.what=0x101;
				handler.sendMessage(message);
				try {
					Thread.sleep(1000);             //子线程休眠1秒
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			}});
		
		thread.start();
	}
	
}
