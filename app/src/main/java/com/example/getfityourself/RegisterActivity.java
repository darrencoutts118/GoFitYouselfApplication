package com.example.getfityourself;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import API.*;

public class RegisterActivity extends MainActivity implements OnClickListener{
	EditText rFirstname, rLastname, rEmail, rPassword, rPasConfirm, rUsername;
	Button bRegister;

	public void onCreate (Bundle SavedInstanceState) {
		super.onCreate(SavedInstanceState);
		setContentView(R.layout.activity_register);
		
		initialise();
	}

	private void initialise() {
		// TODO Auto-generated method stub
		rUsername = (EditText) findViewById(R.id.rUsername);
		rFirstname = (EditText) findViewById(R.id.rFirstname);
		rLastname = (EditText) findViewById(R.id.rLastname);
		rEmail = (EditText) findViewById(R.id.rEmail);
		rPassword = (EditText) findViewById(R.id.rPassword);
		bRegister = (Button) findViewById(R.id.bRegister);
		bRegister.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		ServerMember member = new ServerMember();
        try {

            if(member.create(rUsername.getText().toString(), rFirstname.getText().toString() , rLastname.getText().toString(), rPassword.getText().toString(), rEmail.getText().toString())){
                SuccessPopup pup = new SuccessPopup();
                pup.show(getSupportFragmentManager(), "demo");
            } else {

                ErrorPopup err = new ErrorPopup();
                err.error(member.getError());
                err.show(getSupportFragmentManager(), "error");

            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
	}

    public class SuccessPopup extends DialogFragment {

        AlertDialog.Builder builder;

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the Builder class for convenient dialog construction
            builder = new AlertDialog.Builder(getActivity());
            builder.setMessage("New Account Created. You can now login with your new login information.").setTitle("Create Account")
                    .setPositiveButton("Login", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent);
                        }
                    });
            // Create the AlertDialog object and return it
            return builder.create();
        }
    }
}
