package com.example.android_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class fourActivity extends Activity {
 
    public TextView text1;
	public fourActivity() {
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.four);
		
	   //获取前面一个activity传递过来的信息
	   this.text1=(TextView) findViewById(R.id.textView1);
	   Intent tent=getIntent();
	   String message=tent.getStringExtra("message");
	   text1.setText(message);
	    //按钮触发将信息返回给前面的一个activity
		Button button1=(Button) this.findViewById(R.id.button1);
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent tent=new Intent(fourActivity.this,thirdActivity.class);
				//tent.putExtra("result", "100");//传递的是字符串
				tent.putExtra("result",100);//传递的是一个整型
				setResult(1001,tent);//返回结果到父窗口
				finish();//结束当前的子窗口
			}
		});
	}
}
