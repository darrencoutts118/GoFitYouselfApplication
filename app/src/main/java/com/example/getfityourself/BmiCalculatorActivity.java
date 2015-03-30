package com.example.getfityourself;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BmiCalculatorActivity extends ActionBarActivity {
	
	public static EditText heightIn;
	public static EditText weightIn;
	private Button btnCalcBMI;
	private TextView bmiOut;
	private double weight = 0;
	private double height = 0;
	private TextView bmiStatus;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bmi_calculator);
		initializeApp();
	}
	
	private void initializeApp() {
		    weightIn = (EditText)findViewById( R.id.weightInput );
		    heightIn = (EditText)findViewById( R.id.heightInput );
		    btnCalcBMI = (Button)findViewById( R.id.btnCalcBMI );
		    bmiOut = (TextView)findViewById( R.id.bmiOut );
		    bmiStatus = (TextView) findViewById(R.id.bmiStatus);
		/*btnCalcBMI.setOnClickListener( new View.OnClickListener () {
		
				@Override
		public void onClick(View v) {
			calculateBMI();
		}
			
		}); */
	}
	
	public void calculateBMI( View v) {
		String status = null;
		weight = Double.parseDouble(weightIn.getText().toString() );
		height = Double.parseDouble(heightIn.getText().toString() );
		double bmi = ( weight / ( height * height ) ) * 703.0;
	    String result = String.format( "%.2f", bmi );
	    Log.d( "BMI", result );
	    bmiOut.setText( result, TextView.BufferType.NORMAL );
	    
	    if(bmi > 16.0) {
	    	status = "Seriously Underweight";
	    } else if (bmi >= 16.0 && bmi < 18.0) {
	    	status = "Underweight";
	    }else if (bmi >= 18.0 && bmi < 24.0) {
	    	status = "Normal";
	    }else if (bmi >= 24.0 && bmi < 35) {
	    	status = "Big Fatty";
	    }
	    
	    
	    bmiStatus.setText(status);
	}
	
	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bmi_calculator, menu);
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
	} */
}
