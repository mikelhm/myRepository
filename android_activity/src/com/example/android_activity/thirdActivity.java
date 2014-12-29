package com.example.android_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class thirdActivity extends Activity {


	public TextView text1;
	public TextView text2;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.third);
		
	  text1=(TextView) this.findViewById(R.id.textView1);
	  text2=(TextView) this.findViewById(R.id.textView2);
		
		Button button1=(Button) this.findViewById(R.id.button1);
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent tent=new Intent(thirdActivity.this,fourActivity.class);
				String a=text1.getText().toString().trim();
				String b=text2.getText().toString().trim();
				tent.putExtra("message", a+b);
				startActivityForResult(tent,1000);
				
			}
		});
		
		Button button2=(Button) this.findViewById(R.id.button2);
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent tent=new Intent(thirdActivity.this,secondActivity.class);
				startActivity(tent);
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==1000&&resultCode==1001)
		{
			//从子窗口中返回结果
			//String data_value=data.getStringExtra("result");//获取字符串
		    int data_value=data.getIntExtra("result",0);//获取数值
		    String value=Integer.toString(data_value);
			text2.setText(value);
		}
	}
}
