package com.example.getfityourself;

import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ProfilePageActivity extends MainActivity implements OnItemClickListener {

	private DrawerLayout drawerLayout;
	private ListView listView;
	@SuppressWarnings("deprecation")
	private ActionBarDrawerToggle drawerListener;

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		Button button = null;
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile_page);
		button = (Button)  findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {

           public void onClick(View v) {

               Intent intent = new Intent(ProfilePageActivity.this, QuestionsActivity.class);
               startActivity(intent);
        
       
           }
            });
		listView=(ListView) findViewById(R.id.drawerList);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.profile_page, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (drawerListener.onOptionsItemSelected(item)) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
		drawerListener.onConfigurationChanged(newConfig);
	}
	
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onPostCreate(savedInstanceState);
		drawerListener.syncState();
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		selectItem(position);
	}

	public void selectItem(int position) {
		listView.setItemChecked(position, true);
	}

	public void setTitle(String title) {
		getSupportActionBar().setTitle(title);
	}

}