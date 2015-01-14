package com.example.lanchmodedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends Activity{

	private static final String Tag="LanchModeDemo";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		Button buttonPre=(Button) findViewById(R.id.buttonPre);
		buttonPre.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(SecondActivity.this,MainActivity.class);
				startActivity(intent);
			}
		});
		Button buttonNext=(Button) findViewById(R.id.buttonNext);
		buttonNext.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(SecondActivity.this,ThirdActivity.class);
				startActivity(intent);
			}
		});
		
		Button buttonSelf=(Button) findViewById(R.id.buttonSelf);
		buttonSelf.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(SecondActivity.this,SecondActivity.class);
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


