package com.example.resourcedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class textcolorActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		
		
		Button themeBut=(Button) findViewById(R.id.themeBut);
		themeBut.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(textcolorActivity.this,themeActivity.class);
				startActivity(intent);
			}
		});
		
		int [] ID=new int[]{R.id.str1,R.id.str2,R.id.str3,R.id.str4,R.id.str5,R.id.str6,R.id.str7,R.id.str8};
		int [] Color=new int[]{R.color.color1,R.color.color2,R.color.color3,R.color.color4,R.color.color5,R.color.color6,R.color.color7,R.color.color8};
		for(int i=0;i<8;i++)
		{
			TextView tv=(TextView) findViewById(ID[i]);
			tv.setGravity(Gravity.CENTER);
			tv.setBackgroundColor(getResources().getColor(Color[i]));
			tv.setHeight((int) (getResources().getDimension(R.dimen.basic)*(i+2)/2));
		}
	}
}
