package com.example.lanchmodedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends Activity{
	
	private static final String Tag="LanchModeDemo";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_third);
		Button buttonPre=(Button) findViewById(R.id.buttonPre);
		buttonPre.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(ThirdActivity.this,SecondActivity.class);
				startActivity(intent);
			}
		});
		
		Button buttonSelf=(Button) findViewById(R.id.buttonSelf);
		buttonSelf.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(ThirdActivity.this,ThirdActivity.class);
				startActivity(intent);
			}
		});
		
		Button buttonFirst=(Button) findViewById(R.id.buttonFirst);
		buttonFirst.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(ThirdActivity.this,MainActivity.class);
				startActivity(intent);
			}
		});
	}
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.d(Tag, this.getTaskId()+"--"+this.toString());
	}
}
