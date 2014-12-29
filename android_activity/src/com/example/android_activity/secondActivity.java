package com.example.android_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class secondActivity extends Activity {

	public secondActivity() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		
		//现场数据的保存恢复
		  if (savedInstanceState != null) {  
			  String name=savedInstanceState.getString("name");
		      Toast.makeText(secondActivity.this, ">>"+name, 1).show();
	        }  
		  
        //利用intent获取从mainActivity 中得到的数据
		Intent tent=getIntent();
		String name=tent.getStringExtra("name");
		System.out.println("--name "+name);
		int age=tent.getIntExtra("age", 0);
		System.out.println("--age "+age);
		String adress=tent.getStringExtra("adress");
		System.out.println("--adress "+adress);
		String adress2=tent.getStringExtra("adress");
		System.out.println("--adress "+adress);
		double gpa=tent.getDoubleExtra("gpa", 3.5);
		System.out.println("--gpa "+gpa);
		
		//利用bundle来获取从mainActivity中得到的数据
		Bundle myBundle=this.getIntent().getExtras(); 
		String aname=myBundle.getString("CHINA"); 
		String bname=myBundle.getString("ENGLISH");
		TextView textView=(TextView) findViewById(R.id.textView1);
		textView.setText(aname+" "+bname);
		

		Button button1=(Button) this.findViewById(R.id.button1);
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent tent=new Intent(secondActivity.this,thirdActivity.class);
				startActivity(tent);
			}
		});
		
		Button button2=(Button) this.findViewById(R.id.button2);
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent tent=new Intent(secondActivity.this,MainActivity.class);
				startActivity(tent);
			}
		});
	}


	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		outState.putString("name", "hello");
		
	}
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(savedInstanceState);
	} 
}
