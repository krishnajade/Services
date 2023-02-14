package com.example.userprofilelastlogin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;

import android.content.Intent;
import android.content.SharedPreferences;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText mUsernameEditText;
    private EditText mPasswordEditText;

    public boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }
    private void enableLocation() {
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Location services not enabled");
            builder.setMessage("Please enable location services");
            builder.setPositiveButton("OK", (dialogInterface, i) -> {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }).setNegativeButton("No Thanks", (dialogInterface, i) -> dialogInterface.cancel());
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUsernameEditText = findViewById(R.id.username);
        mPasswordEditText = findViewById(R.id.password);

        enableLocation();

        //Logic to see if checkbox is checked
        CheckBox checkBox = findViewById(R.id.checkbox_terms);
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                // The check box is checked
                // Add your logic here
                //Login button functionality
                Button loginButton = findViewById(R.id.login_button);
                loginButton.setOnClickListener(view -> {
                    // retrieve the username and password from the text fields

                    String username="user";
                    String password="password";
                    boolean condition1 = mUsernameEditText.getText().toString().equals(username);
                    boolean condition2 =  mPasswordEditText.getText().toString().equals(password);
                    boolean condition3= isNetworkConnected();
                    if(condition3 ){
                            if ( condition1 && condition2 ) {
                                Intent intent=new Intent(getApplicationContext(),UserProfileActivity.class);
                                startActivity(intent);
                                finish();
                            }
                            else {
                                String toastMessage = "Wrong Username or Password ";
                                Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
                            }
                    }
                    else{
                        String toastMessage = "You are not connected to network ";
                        Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
                    }
                    SharedPreferences sharedPref = getSharedPreferences("user_prefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();

                    // Store the current time as the last login time
                    long currentTime = System.currentTimeMillis();
                    editor.putLong("last_login", currentTime);
                    editor.apply();
                });
            } else {
                // The check box is not checked
                // Add your logic here
                Toast.makeText(LoginActivity.this, "Please accept terms and conditions before proceeding", Toast.LENGTH_SHORT).show();
            }
    }
    );
        TextView signup = findViewById(R.id.dont_have_account);
        signup.setOnClickListener(view->{
            Intent intent=new Intent(getApplicationContext(),SignUpActivity.class);
            startActivity(intent);
            finish();
        });
    }
    public void onCheckboxClicked(View view) {
    }
}
