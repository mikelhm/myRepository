package com.example.uidemo;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

public class galleryActivity extends Activity {

	private int[] imageId=new int[]{R.drawable.pic01,R.drawable.pic02,R.drawable.pic03,R.drawable.pic04,
			R.drawable.pic05,R.drawable.pic06};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gallerylayout);
		
		
		Gallery gallery=(Gallery) findViewById(R.id.gallery);//获取gallery组件
		BaseAdapter ada=new BaseAdapter(){

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return imageId.length;
			}

			@Override
			public Object getItem(int position) {
				// TODO Auto-generated method stub
				return position;
			}

			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return position;
			}

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				ImageView imageview;//声明了一个ImageView对象
				if(convertView==null)
				{
					imageview=new ImageView(galleryActivity.this);
					imageview.setScaleType(ImageView.ScaleType.FIT_XY);
					imageview.setLayoutParams(new Gallery.LayoutParams(180,135));
					TypedArray typeArray=obtainStyledAttributes(R.styleable.Gallery);//?
					imageview.setBackgroundResource(typeArray.getResourceId(R.styleable.Gallery_android_galleryItemBackground, 0));
					imageview.setPadding(5, 0, 5, 0);
				}else
				{
					imageview=(ImageView) convertView; 
				}
				imageview.setImageResource(imageId[position]);
				return imageview;
			}};
		gallery.setAdapter(ada);//设置适配器
		gallery.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Toast.makeText(galleryActivity.this, "你选择了第"+(position+1)+"张图片", 3).show();
			}});
	}
}
