package com.example.uidemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;

public class ratingActivity extends Activity {
   
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ratingbarlayout);
		
		RatingBar ratingbar=(RatingBar) findViewById(R.id.ratingBar);
		ratingbar.setOnRatingBarChangeListener(new OnRatingBarChangeListener(){

			@Override
			public void onRatingChanged(RatingBar ratingBar, float rating,
					boolean fromUser) {
				// TODO Auto-generated method stub
				TextView result=(TextView) findViewById(R.id.ratingresult);
				result.setText(rating+"");
				
				
			}});
		
		
	}
}
