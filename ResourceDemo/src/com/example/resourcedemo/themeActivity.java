package com.example.resourcedemo;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class themeActivity extends Activity {

	private TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.theme);
		XmlResourceParser xrp=getResources().getXml(R.xml.customers);
		StringBuilder sb=new StringBuilder("");
	
		
			try {
				while(xrp.getEventType()!=XmlResourceParser.END_DOCUMENT)//当没有读取到文件的末尾
				{
					if(xrp.getEventType()==XmlResourceParser.START_TAG)//判断是否为开始标记
					{
					  String tagName=xrp.getName();//获取标记名
					  if(tagName.equals("customer"))
					  {
						sb.append("姓名:"+xrp.getAttributeValue(0)+" ");
						sb.append("电话:"+xrp.getAttributeValue(1)+" ");
						sb.append("邮件:"+xrp.getAttributeValue(2)+" ");
						sb.append("\n");
					   }
					}
					xrp.next();
				}
				TextView tv=(TextView) findViewById(R.id.showText);
				tv.setText(sb.toString());
				
			} catch (XmlPullParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			tv=(TextView) findViewById(R.id.showText);
			registerForContextMenu(tv);
	}

	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		MenuInflater inflater=new MenuInflater(this);
		inflater.inflate(R.menu.contextmenu, menu);//解析菜单文件
		menu.setHeaderIcon(R.drawable.ic_launcher);//为菜单头设置图标
		menu.setHeaderTitle("请选择");//为菜单头设置标题
		super.onCreateContextMenu(menu, v, menuInfo);
	}
	
	


	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		switch(item.getItemId()){
		case R.id.color1:
			tv.setTextColor(Color.rgb(255, 0, 0));
			break;
		case R.id.color2:
			tv.setTextColor(Color.rgb(0, 255, 0));
			break;
		case R.id.color3:
			tv.setTextColor(Color.rgb(0, 0, 255));
			break;
		case R.id.color4:
			tv.setTextColor(Color.rgb(255, 180, 0));
			break;
		default:
			tv.setTextColor(Color.rgb(0,0,0));
			break;
		}
		return true;
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater=new MenuInflater(this);
		inflater.inflate(R.menu.menus, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if(item.getGroupId()==R.id.setting)
		{
			if(item.isChecked())//点击 如果没选那么设置选中；如果选了则设置不选中
			{
				item.setChecked(false);
			}else
			{
				item.setChecked(true);
			}
		}
		if(item.getItemId()!=R.id.subitem)//弹出选中的菜单项的标题，除了选中“设置”菜单项外
		{
		    Toast.makeText(themeActivity.this, item.getTitle(), 3).show();
		}
		return true;
	}
	
}
