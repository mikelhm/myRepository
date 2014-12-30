package com.example.uidemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class progressActivity extends Activity {
	
	
	private ProgressBar horizontalP;
	private ProgressBar circleP;
	private Handler mh;
	private int mStatus;//记录进度
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.progresslayout);
		
		horizontalP=(ProgressBar) findViewById(R.id.progressHorizontal);
		circleP=(ProgressBar) findViewById(R.id.progressLarge);
		mh=new Handler(){

			@Override
			public void handleMessage(Message msg) {//重写方法处理子进程的消息;不能在主线程中执行耗时的操作，否则界面强制关闭
				// TODO Auto-generated method stub
				super.handleMessage(msg);
				if(msg.what==0x111)//表示还没有传送完毕
					horizontalP.setProgress(mStatus);
				else
				{
					Toast.makeText(progressActivity.this, "已经完成", 5).show();
					horizontalP.setVisibility(View.GONE);
					circleP.setVisibility(View.GONE);
				}
			}
		};//end handle
		
		
		Thread mythread=new Thread(new Runnable(){//创建一个子进程，使用Runnable来初始化

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				while(true)
				{
					mStatus=working();//调用耗时的操作，返回进度
					Message m=new Message();
					if(mStatus<100)//进度还不到100%
					{
						m.what=0x111;
						mh.sendMessage(m);//发送消息0x111
					}
					else
					{
						m.what=0x110;
					    mh.sendMessage(m);//进度已经到达100%，发送消息0x110
					    break;
					}
				}
			}

			private int working() {
				// TODO Auto-generated method stub
				mStatus+=Math.random()*10;
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//休眠200毫秒
				return mStatus;
			}});
		mythread.start();//启动子线程
		
	}
}
