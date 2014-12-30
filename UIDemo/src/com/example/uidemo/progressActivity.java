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
	private int mStatus;//��¼����
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.progresslayout);
		
		horizontalP=(ProgressBar) findViewById(R.id.progressHorizontal);
		circleP=(ProgressBar) findViewById(R.id.progressLarge);
		mh=new Handler(){

			@Override
			public void handleMessage(Message msg) {//��д���������ӽ��̵���Ϣ;���������߳���ִ�к�ʱ�Ĳ������������ǿ�ƹر�
				// TODO Auto-generated method stub
				super.handleMessage(msg);
				if(msg.what==0x111)//��ʾ��û�д������
					horizontalP.setProgress(mStatus);
				else
				{
					Toast.makeText(progressActivity.this, "�Ѿ����", 5).show();
					horizontalP.setVisibility(View.GONE);
					circleP.setVisibility(View.GONE);
				}
			}
		};//end handle
		
		
		Thread mythread=new Thread(new Runnable(){//����һ���ӽ��̣�ʹ��Runnable����ʼ��

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				while(true)
				{
					mStatus=working();//���ú�ʱ�Ĳ��������ؽ���
					Message m=new Message();
					if(mStatus<100)//���Ȼ�����100%
					{
						m.what=0x111;
						mh.sendMessage(m);//������Ϣ0x111
					}
					else
					{
						m.what=0x110;
					    mh.sendMessage(m);//�����Ѿ�����100%��������Ϣ0x110
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
				}//����200����
				return mStatus;
			}});
		mythread.start();//�������߳�
		
	}
}
