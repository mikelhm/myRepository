/*
 * 该类的主要作用是开启一个新的线程来获取网络图片并且将图片显示到ImageView中
 */

package com.example.handlerdemo;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	private ImageView iv;//声明一个ImageView组件的对象
	private Button button;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		iv=(ImageView) findViewById(R.id.imageViewNet);
		button=(Button) findViewById(R.id.nextButton);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MainActivity.this, ColorActivity.class);
				startActivity(intent);
			}
		});
		
		//创建一个新的线程，在线程中完成获取网络图片的工作
		Thread thread=new Thread(new Runnable(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				final Bitmap bitmap=getNetPicture("http://csdnimg.cn/www/images/csdnindex_logo.gif");
				try {
					Thread.sleep(1000);          //让线程休眠1秒
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					Toast.makeText(MainActivity.this, "获取网络图片失败", 5).show();
					e.printStackTrace();
				}
				//上述的代码已经完成获取网络图片的工作；发送一个Runnable对象到消息队列，这个Runnable对象会在UI主线程中运行
				iv.post(new Runnable(){
					@Override
					public void run() {
						// TODO Auto-generated method stub
						iv.setImageBitmap(bitmap);
					}});
			}});
		thread.start();                          //开启线程
	}
    /**
     * 功能：根据网络地址获取图片
     * @param path
     * @return
     */
	public Bitmap getNetPicture(String path)
	{
		Bitmap bm=null;
		try {
			URL url=new URL(path);
			URLConnection conn=url.openConnection();//获取URL对象对应的连接
			conn.connect();                         //打开连接
			InputStream is=conn.getInputStream();   //获取输入流对象
			bm=BitmapFactory.decodeStream(is);      //根据输入流对象创建Bitmap对象
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bm;
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
