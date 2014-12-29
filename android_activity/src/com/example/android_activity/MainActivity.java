package com.example.android_activity;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button button1=(Button) this.findViewById(R.id.button1);
		button1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent tent=new Intent(MainActivity.this,secondActivity.class);
				
				//使用bundle来传送数据
//				Bundle bundle=new Bundle();
//				bundle.putCharSequence("bundle1", "hello world");
//				bundle.putCharSequence("bundle2", "你好");
//				bundle.putCharSequence("bundle3", "welcome");
//				//tent.putExtra("bundle", bundle); //错误用法
//				tent.putExtras(bundle);
				
				tent.putExtra("name", "peter");
				tent.putExtra("age", 24);
				tent.putExtra("adress", "深圳");
				tent.putExtra("gpa", 3.50);
				
				//使用bundle在activity之间传递数据
				Bundle myBundle=new Bundle(); 
				myBundle.putString("ENGLISH","china"); 
				myBundle.putString("CHINA","中国"); 
				tent.putExtras(myBundle); 
				
				startActivity(tent);
				
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
