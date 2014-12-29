package com.example.uidemo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PatternMatcher;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class edittextActivity extends Activity {
    
	EditText nametext;
	EditText pswtext;
	EditText pswtext2;
	EditText emailText;
	EditText passportText;
	RadioGroup sexR;
	CheckBox sportbox;
	CheckBox enterbox;
	CheckBox musicbox;
	CheckBox sciencebox;
	Spinner spinner;
	public edittextActivity() {
		// TODO Auto-generated constructor stub
		
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edittext);
		
		nametext=(EditText) findViewById(R.id.nameEdit);
		pswtext=(EditText) findViewById(R.id.pswEdit);
		pswtext2=(EditText) findViewById(R.id.conpswEdit);
		emailText=(EditText) findViewById(R.id.emailEdit);
		passportText=(EditText) findViewById(R.id.passportEdit);
		
		sexR=(RadioGroup) findViewById(R.id.sexGroup);
		sportbox=(CheckBox) findViewById(R.id.sportBox);
		enterbox=(CheckBox) findViewById(R.id.enterBox);
		musicbox=(CheckBox) findViewById(R.id.musicBox);
		sciencebox=(CheckBox) findViewById(R.id.scienceBox);
		spinner=(Spinner) findViewById(R.id.spinner1);
		
		Button button1=(Button) this.findViewById(R.id.commitButton);
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String passLabel=spinner.getSelectedItem().toString();
				String name=nametext.getText().toString();
				String psw=pswtext.getText().toString();
				String email=emailText.getText().toString();
				String psw2=pswtext2.getText().toString();
				String sex="";//初始化
				String passportnumber=passportText.getText().toString();
				
				for(int i=0;i<sexR.getChildCount();i++)
				{
					RadioButton r=(RadioButton) sexR.getChildAt(i);
					if(r.isChecked())
					{
						sex=r.getText().toString();
						break;
					}
				}
				String hobby="";
				if(sportbox.isChecked())
					hobby+=sportbox.getText().toString()+" ";
				if(enterbox.isChecked())
					hobby+=enterbox.getText().toString()+" ";
				if(musicbox.isChecked())
					hobby+=musicbox.getText().toString()+" ";
				if(sciencebox.isChecked())
					hobby+=sciencebox.getText().toString()+" ";
				//上面代码实现获取组件的值
				if("".equals(name))
					Toast.makeText(edittextActivity.this, "用户名不能为空", 5).show();
				if("".equals(psw))
					Toast.makeText(edittextActivity.this, "密码不能为空", 5).show();
				if(!psw.equals(psw2))
					Toast.makeText(edittextActivity.this, "两次密码不相同", 5).show();
				if("".equals(email))
					Toast.makeText(edittextActivity.this, "邮件不能为空", 5).show();
				Pattern pattern = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
				Matcher matcher = pattern.matcher(email);
				if(!matcher.matches())
					Toast.makeText(edittextActivity.this, "邮箱格式不正确", 5).show();
				else{
				String result="用户: "+name+"\n密码: "+psw+"\n邮件: "+email+"\n"+passLabel+":"
						+ passportnumber+"\n性别 "+sex
						+"\n爱好："+hobby;
				Toast.makeText(edittextActivity.this, result, 5).show();
				}
			}
		});
		
		Button button2=(Button) this.findViewById(R.id.cleanButton);
		button2.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				
				// TODO Auto-generated method stub
				EditText nametext=(EditText) findViewById(R.id.nameEdit);
				EditText pswtext=(EditText) findViewById(R.id.pswEdit);
				EditText emailText=(EditText) findViewById(R.id.emailEdit);
				EditText passportText=(EditText) findViewById(R.id.passportEdit);
				EditText conpsw=(EditText) findViewById(R.id.conpswEdit);
				RadioGroup sexR=(RadioGroup) findViewById(R.id.sexGroup);
//			   
//			    
			    CheckBox sportbox=(CheckBox) findViewById(R.id.sportBox);
			    CheckBox enterbox=(CheckBox) findViewById(R.id.enterBox);
			    CheckBox musicbox=(CheckBox) findViewById(R.id.musicBox);
			    CheckBox sciencebox=(CheckBox) findViewById(R.id.scienceBox);
			    
//			    sexR.getChildAt(0).setSelected(true);
//			    sportbox.setSelected(false);
//			    enterbox.setSelected(false);
//			    musicbox.setSelected(false);
//			    sciencebox.setSelected(false);
				RadioButton maleRadio=(RadioButton) findViewById(R.id.male);
				maleRadio.setChecked(true);
			    sportbox.setChecked(false);
			    enterbox.setChecked(false);
			    musicbox.setChecked(false);
			    sciencebox.setChecked(false);
			    
				nametext.setText("");
				pswtext.setText("");
				emailText.setText("");
				conpsw.setText("");
				passportText.setText("");
			}
			
		});
	}
}
