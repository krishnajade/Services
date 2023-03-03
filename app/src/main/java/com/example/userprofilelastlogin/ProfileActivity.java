package com.example.userprofilelastlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView usernameTextView = findViewById(R.id.usernameValue);
        TextView emailTextView = findViewById(R.id.emailValue);
        TextView genderTextView = findViewById(R.id.genderValue);
        TextView passwordTextView = findViewById(R.id.passwordValue);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            usernameTextView.setText(extras.getString("username"));
            emailTextView.setText(extras.getString("email"));
            genderTextView.setText(extras.getString("gender"));
            passwordTextView.setText(extras.getString("password"));
        }
    }
}
