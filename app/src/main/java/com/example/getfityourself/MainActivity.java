package com.example.getfityourself;

import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.R.layout;


public class MainActivity extends ActionBarActivity {
	Button button;
	Button button2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


        //startActivity(intent);



		button = (Button) findViewById(R.id.button);
		button2 = (Button)  findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {

           public void onClick(View v) {

               Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
               startActivity(intent);
        
       
           }
            });
        
        
        button2.setOnClickListener(new View.OnClickListener() {
        		
        	public void onClick(View v){
        		Intent intent2 = new Intent(MainActivity.this, RegisterActivity.class);
        		startActivity(intent2);
        	}
        });

      }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    // Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.menu_main, menu);
	    return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.action_bar:
	            openSearch();
	            return true;
	        case R.id.action_settings:
	            openSettings();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}

	private void openSearch() {
		// TODO Auto-generated method stub
		
	}

	private void openSettings() {
		// TODO Auto-generated method stub
		
	}
	
	}
