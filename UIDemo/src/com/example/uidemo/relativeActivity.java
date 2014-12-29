package com.example.uidemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class relativeActivity extends Activity {

	public relativeActivity() {
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.relativelayout);
		Button backbut=(Button) findViewById(R.id.button1);
		backbut.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(relativeActivity.this,MainActivity.class);
				startActivity(intent);
			}
		});
	}
}
