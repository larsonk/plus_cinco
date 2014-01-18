package com.example.plus5;

import android.os.Bundle;
import android.os.SystemClock;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.Menu;
import android.widget.Toast;

public class Alarm extends Activity {
	private int minutes;
	final static private long ONE_SECOND = 1000;
	final static private long ONE_MINUTE = ONE_SECOND * 60;
	PendingIntent pi;
	BroadcastReceiver br;
	AlarmManager am;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alarm);
		createAlarms();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.alarm, menu);
		return true;
	}
	
	public void createAlarms() {
		long final_min;
		Intent currIntent = getIntent();
		minutes = currIntent.getIntExtra("extraMinutes", 1);	
		final_min = (long)( minutes * ONE_MINUTE);
		br = new BroadcastReceiver() {
			@Override
			public void onReceive(Context context, Intent intent) {
				Toast.makeText(context, "Rise  & Shine!", Toast.LENGTH_LONG).show();
			}
		};
		
		registerReceiver(br, new IntentFilter("com.authorwjf.wakeywakey"));
		pi = PendingIntent.getBroadcast(this, 0, new Intent("com.authorwjf.wakeywakey"), 0);
		am = (AlarmManager)(this.getSystemService(Context.ALARM_SERVICE));
		
		am.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + final_min, pi);
		
		
	}
	
	protected void onDestroy() {
		am.cancel(pi);
		unregisterReceiver(br);
		super.onDestroy();
	}

}
