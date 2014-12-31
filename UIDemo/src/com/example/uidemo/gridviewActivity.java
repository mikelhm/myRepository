package com.example.uidemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.SimpleAdapter;

public class gridviewActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gridviewlayout);
		
		GridView grdiview=(GridView) findViewById(R.id.gridview);
		
		int[] imageId=new int[]{R.drawable.pic01,R.drawable.pic02,R.drawable.pic03,R.drawable.pic04,R.drawable.pic05,R.drawable.pic06};
		String[] title=new String[]{"橙色花","沙漠","剑兰","水母","大海","菊花"};
		List<Map<String,Object>> listitems=new ArrayList<Map<String,Object>>();
		for(int i=0;i<imageId.length;i++)
		{
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("image", imageId[i]);
			map.put("title", title[i]);
			listitems.add(map);		
		}
		SimpleAdapter ada=new SimpleAdapter(this, listitems, R.layout.griditems, new String[]{"title","image"}, new int[]{R.id.gridtitle,R.id.gridimage});
		grdiview.setAdapter(ada);//不能缺少
	}
}
