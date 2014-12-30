package com.example.uidemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

public class autotextviewActivity extends Activity {
	
	private static final String[] COUNTRIES=new String[]{"腾讯","腾讯科技","腾讯科技有限公司","腾讯QQ","腾讯计算机系统有限公司"
		
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.autotextview);
		
		final AutoCompleteTextView textview=(AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
		ArrayAdapter<String> adapter =new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,COUNTRIES);
		textview.setAdapter(adapter);
		
		Button searchbut=(Button) findViewById(R.id.searchbut);
		searchbut.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(autotextviewActivity.this, textview.getText().toString(), 5).show();
			}
		});
		
	}
}
