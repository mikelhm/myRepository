package com.example.intentdemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class secondActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.secondlayout);
		TextView name=(TextView) findViewById(R.id.usertext);
		TextView psw=(TextView) findViewById(R.id.pswtext);
		Intent intent=getIntent();
		String username=intent.getStringExtra("username");
		String password=intent.getStringExtra("psw");
		name.setText("”√ªß√˚:"+username);
		psw.setText("√‹¬Î:"+password);
		
		Button homebut=(Button) findViewById(R.id.homebut);
		homebut.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setAction(Intent.ACTION_MAIN);
				intent.addCategory(Intent.CATEGORY_HOME);
				startActivity(intent);
			}
		});
		
		EditText phoneedit=(EditText) findViewById(R.id.phoneedit);
		final String number=phoneedit.getText().toString();
		Button phonebut=(Button) findViewById(R.id.phonebut);
		phonebut.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setAction(Intent.ACTION_CALL);
				intent.setData(Uri.parse("tel:"+number));
				startActivity(intent);
			}
		});
		
		Button openbut=(Button) findViewById(R.id.openbut);
		openbut.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setAction(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("http://www.baidu.com"));
				startActivity(intent);
			}
		});
	}
}
