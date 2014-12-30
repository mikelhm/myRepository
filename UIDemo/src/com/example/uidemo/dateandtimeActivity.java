package com.example.uidemo;

import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.TimePicker.OnTimeChangedListener;


public class dateandtimeActivity extends Activity {

	public dateandtimeActivity() {
		// TODO Auto-generated constructor stub
	}
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dateandtime);
		
	  CalendarView calendarView= (CalendarView) findViewById(R.id.calendarView1);
	  calendarView.setOnDateChangeListener(new OnDateChangeListener(){

		@Override
		public void onSelectedDayChange(CalendarView view, int year, int month,
				int dayOfMonth) {
			// TODO Auto-generated method stub
			String date = year + "Äê" + (month+1 )+ "ÔÂ" + dayOfMonth + "ÈÕ";
            Toast.makeText(getApplicationContext(), date, 3).show();
		}});

	  
		TimePicker tp=(TimePicker) findViewById(R.id.timePicker1);
		tp.setIs24HourView(true);
		tp.setOnTimeChangedListener(new OnTimeChangedListener(){
			@Override
			public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
				// TODO Auto-generated method stub
				String result=hourOfDay+":"+minute;
				Toast.makeText(dateandtimeActivity.this, result,3).show();
			}
			
		});
		
	}
	
	
	
}
