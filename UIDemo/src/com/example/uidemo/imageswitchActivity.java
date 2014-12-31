package com.example.uidemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar.LayoutParams;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;

public class imageswitchActivity extends Activity {

	private int[] imageId=new int[]{R.drawable.pic01,R.drawable.pic02,R.drawable.pic03,R.drawable.pic04,
			R.drawable.pic05,R.drawable.pic06,};
	private int cIndex=0;
	private ImageSwitcher imageswitch;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.imageswitch);
		
		
		Button prebut=(Button) findViewById(R.id.prebut);
		Button nextbut=(Button) findViewById(R.id.nextbut);
		prebut.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(cIndex>0)
					cIndex--;
				else
					cIndex=imageId.length-1;
			imageswitch.setImageResource(imageId[cIndex]);//设置当前显示的图片
			}
		});
		nextbut.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(cIndex<imageId.length-1)
					cIndex++;
				else
					cIndex=0;
				imageswitch.setImageResource(imageId[cIndex]);
			}
			
		});
		imageswitch=(ImageSwitcher) findViewById(R.id.imageswitch);
		imageswitch.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
		imageswitch.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));
		imageswitch.setFactory(new ViewFactory(){

			@Override
			public View makeView() {
				// TODO Auto-generated method stub
				ImageView imageview=new ImageView(imageswitchActivity.this);
				//通过代码来设置imageview
				imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
				imageview.setLayoutParams(new ImageSwitcher.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
				return imageview;
			}});
		imageswitch.setImageResource(imageId[cIndex]);//显示默认的图片
	}
	
	
	
}
