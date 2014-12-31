package com.example.uidemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;

public class tabActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabhostlayout);
		
		TabHost tabhost=(TabHost) findViewById(android.R.id.tabhost);
		tabhost.setup();
		
		LayoutInflater inflater=LayoutInflater.from(this);
		inflater.inflate(R.layout.relativelayout, tabhost.getTabContentView());
		inflater.inflate(R.layout.framelayout, tabhost.getTabContentView());
		inflater.inflate(R.layout.tablelayout, tabhost.getTabContentView());
		
		tabhost.addTab(tabhost.newTabSpec("tab01").setIndicator("相对布局").setContent(R.id.relativelayout));
		tabhost.addTab(tabhost.newTabSpec("tab02").setIndicator("帧布局").setContent(R.id.framelayout));
		tabhost.addTab(tabhost.newTabSpec("tab03").setIndicator("表格布局").setContent(R.id.tablelayout));
		
	}
	
	
}
