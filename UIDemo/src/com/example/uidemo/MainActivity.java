package com.example.uidemo;



import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button button1=(Button) this.findViewById(R.id.button1);
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(MainActivity.this,edittextActivity.class);
				startActivity(intent);
			}
		});
		Button button2=(Button) this.findViewById(R.id.button2);
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(MainActivity.this,frameActivity.class);
				startActivity(intent);
			}
		});
		
		Button button3=(Button) this.findViewById(R.id.button3);
		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(MainActivity.this,relativeActivity.class);
				startActivity(intent);
			}
		});
		
		Button button4=(Button) this.findViewById(R.id.button4);
		button4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(MainActivity.this,complexActivity.class);
				startActivity(intent);
			}
		});
		
		Button button5=(Button) this.findViewById(R.id.button5);
		button5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(MainActivity.this,textviewActivity.class);
				startActivity(intent);
			}
		});
		Button button6=(Button) this.findViewById(R.id.button6);
		button6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(MainActivity.this,tableActivity.class);
				startActivity(intent);
			}
		});
		
		Button listButton=(Button) this.findViewById(R.id.listviewbutton);
		listButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(MainActivity.this,listviewActivity.class);
				startActivity(intent);
			}
		});
		
		Button timeButton=(Button) this.findViewById(R.id.timeButton);
		timeButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(MainActivity.this,dateandtimeActivity.class);
				startActivity(intent);
			}
		});
		Button imagelistviewButton=(Button) this.findViewById(R.id.imageviewButton);
		imagelistviewButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(MainActivity.this,imagelistviewActivity.class);
				startActivity(intent);
			}
		});
		
		Button searchbut=(Button) this.findViewById(R.id.autotext);
		searchbut.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(MainActivity.this,autotextviewActivity.class);
				startActivity(intent);
			}
		});
		
		Button progressbut=(Button) this.findViewById(R.id.progressbut);
		progressbut.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(MainActivity.this,progressActivity.class);
				startActivity(intent);
			}
		});
		
		Button seekbut=(Button) this.findViewById(R.id.seekbut);
		seekbut.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(MainActivity.this,seekbarActivity.class);
				startActivity(intent);
			}
		});
		Button ratingbut=(Button) this.findViewById(R.id.ratingbut);
		ratingbut.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(MainActivity.this,ratingActivity.class);
				startActivity(intent);
			}
		});
		
		Button tabbut=(Button) this.findViewById(R.id.tabbut);
		tabbut.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(MainActivity.this,tabActivity.class);
				startActivity(intent);
			}
		});
		
		Button imagesbut=(Button) this.findViewById(R.id.imageswitchbut);
	    imagesbut.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(MainActivity.this,imageswitchActivity.class);
				startActivity(intent);
			}
		});
	    
	    Button gridbut=(Button) this.findViewById(R.id.gridbut);
	    gridbut.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(MainActivity.this,gridviewActivity.class);
				startActivity(intent);
			}
		});
	    
	    Button gallerybut=(Button) this.findViewById(R.id.gallerybut);
	    gallerybut.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(MainActivity.this,galleryActivity.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
