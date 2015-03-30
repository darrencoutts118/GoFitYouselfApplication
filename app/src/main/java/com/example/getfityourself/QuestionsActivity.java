package com.example.getfityourself;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.Toast;

public class QuestionsActivity extends MainActivity implements OnClickListener {
	
	private Spinner spinner1, spinner2, spinner3;
	private Button bSave;

    private Spinner sDay1, sDay2,sDay3,sDay4,sDay5,sDay6,sDay7;

    //Declare variables
	NumberPicker noPicker = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_questions);
	
		//Number Picker 1

		Log.e("Banana", "You should eat a banana" );
		
		generate();
	}
	
	
	private void generate() {
		bSave = (Button) findViewById(R.id.bSave);

        sDay1 = (Spinner) findViewById(R.id.day1);
        sDay2 = (Spinner) findViewById(R.id.day2);
        sDay3 = (Spinner) findViewById(R.id.day3);
        sDay4 = (Spinner) findViewById(R.id.day4);
        sDay5 = (Spinner) findViewById(R.id.day5);
        sDay6 = (Spinner) findViewById(R.id.day6);
        sDay7 = (Spinner) findViewById(R.id.day7);




        bSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                System.out.println("Saving....");
                System.out.println(sDay1.getSelectedItem().toString());
            }
        });
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.questions, menu);
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
		//Get Workout
		ServerWorkout workout = new ServerWorkout("UserAuth");
		int WorkoutID = (Integer) null; //!!!!!!!!no idea if this is actually working properly
		try {
			if(workout.workout(WorkoutID)){
				ArrayList<ServerWorkoutResponse> CurrentWorkout = workout.getWorkout();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/* public void onItemSelected(AdapterView<?> parent, View view, 
            int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
    
    public void setOnItemSelectedListener() {
    	Spinner spinner = (Spinner) findViewById(R.id.workouts_spinner);
    	spinner.setOnItemSelectedListener(this); 
    } */
    
}
