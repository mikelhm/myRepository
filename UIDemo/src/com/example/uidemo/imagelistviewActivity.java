package com.example.uidemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class imagelistviewActivity extends Activity {

	public imagelistviewActivity() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.imagelistview);
		ListView listview=(ListView) findViewById(R.id.imagelistview);
		
		int image[]=new int[]{R.drawable.left, R.drawable.right,R.drawable.in,R.drawable.bottom,R.drawable.topp};
		String title[]=new String[]{"我的文档","系统设置","我的音乐","导航","上网"};
		
		List<Map<String, Object>> listitems=new ArrayList<Map<String,Object>>();
		for(int i=0;i<image.length;i++)
		{
			Map<String,Object>map=new HashMap<String,Object>();
			map.put("image",image[i]);
			map.put("title",title[i]);
			listitems.add(map);
		}
		
		SimpleAdapter ada=new SimpleAdapter(this, listitems, R.layout.items, new String[]{"image","title"}, new int[]{R.id.image,R.id.title});
		listview.setAdapter(ada);
		
	}
	

}
