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
		
	   //��ȡǰ��һ��activity���ݹ�������Ϣ
	   this.text1=(TextView) findViewById(R.id.textView1);
	   Intent tent=getIntent();
	   String message=tent.getStringExtra("message");
	   text1.setText(message);
	    //��ť��������Ϣ���ظ�ǰ���һ��activity
		Button button1=(Button) this.findViewById(R.id.button1);
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent tent=new Intent(fourActivity.this,thirdActivity.class);
				//tent.putExtra("result", "100");//���ݵ����ַ���
				tent.putExtra("result",100);//���ݵ���һ������
				setResult(1001,tent);//���ؽ����������
				finish();//������ǰ���Ӵ���
			}
		});
	}
}
