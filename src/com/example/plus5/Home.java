package com.example.plus5;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class Home extends Activity {

	private String destination, time, school;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		Intent intent = getIntent();
		String string_msg = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

		String [] message = string_msg.split("-");
		/*
		TextView textView = new TextView(this);
		textView.setTextSize(40);
		textView.setText(string_msg);

		// Set the text view as the activity layout
		setContentView(textView); */


		destination = message[0];
		time = message[1];
		school = message[2];	


		return true;
	}
	
	public void openAlarmTab(View view) {
		Intent intent = new Intent(this, Alarm.class);
		intent.putExtra("extraMinutes", time);
		startActivity(intent);
	}

}
