package com.example.getfityourself;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

	
public class LoginActivity extends MainActivity implements OnClickListener {
	EditText etEmail, etPassword;
	Button bLogin;
	/** Called when the activity is first created */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		initialise();
	}

	private void initialise() {
		// TODO Auto-generated method stub
		etEmail = (EditText) findViewById(R.id.etEmail);
		etPassword = (EditText) findViewById(R.id.etPassword);
		bLogin = (Button) findViewById(R.id.bSubmit);
		//Now set an OnClickListener
		bLogin.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Toast.makeText(getApplicationContext(), "Logging in",Toast.LENGTH_LONG).show();
		String email1 = etEmail.getText().toString();
		String password1 = etPassword.getText().toString();
		ServerAuthentication auth = new ServerAuthentication();
	try {
		if(auth.login(email1,password1)){

            System.out.println("We have now logged in...");

			System.out.println(auth.AuthorizationKey);

            PreferencesHelper store = new PreferencesHelper(getApplicationContext());
            store.SavePreferences("User",auth.AuthorizationKey);

            System.out.println(store.GetPreferences("User"));

            Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
            startActivity(intent);

		}else{

            ErrorPopup error = new ErrorPopup();
            error.error(auth.getError());
            error.show(getSupportFragmentManager(), "login");
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
		
	}

	
	
	
	
	
	
}