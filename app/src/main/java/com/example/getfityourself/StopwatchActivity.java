package com.example.getfityourself;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Chronometer;
import android.app.Activity;


public class StopwatchActivity extends MainActivity implements OnClickListener {
	private Button start;
	private Button stop;
	private Button reset;
	
	private Chronometer myChronometer;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stopwatch);

        PreferencesHelper store = new PreferencesHelper(getApplicationContext());
        System.out.println("User is " + store.GetPreferences("User"));


        uI();
	}
	
	public void uI() {
		start = (Button) findViewById(R.id.btstart);
		start.setOnClickListener(this);
		stop = (Button) findViewById(R.id.btstop);
		stop.setOnClickListener(this);
		reset = (Button) findViewById(R.id.btreset);
		reset.setOnClickListener(this);
		myChronometer = (Chronometer) findViewById(R.id.myChronometer);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.stopwatch, menu);
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

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v == start ) {
			myChronometer.start();	
		}else if (v == stop) {
			myChronometer.stop();
		}else if (v == reset ) {
			myChronometer.setBase(SystemClock.elapsedRealtime());
		}
		
	}
}
