package com.example.uidemo;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class tableActivity extends Activity {

	public tableActivity() {
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tablelayout);
		
		Button namebut=(Button) findViewById(R.id.namebutton);
		Button pswbut=(Button) findViewById(R.id.pswbutton);
		
		namebut.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EditText editname=(EditText) findViewById(R.id.editText1);
				EditText editpsw=(EditText) findViewById(R.id.editText2);
				String name=editname.getText().toString();
				String psw=editpsw.getText().toString();
				if("mike".equals(name)&&"123456".equals(psw))
				{
					Intent intent=new Intent(tableActivity.this,edittextActivity.class);
					startActivity(intent);
				}
				else
				{
					Toast.makeText(tableActivity.this, "用户名或者密码错误", 6).show();
				}
				
				
			}
		});
		
		pswbut.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(tableActivity.this,MainActivity.class);
				startActivity(intent);
			}
		});
		
		
	}

}
