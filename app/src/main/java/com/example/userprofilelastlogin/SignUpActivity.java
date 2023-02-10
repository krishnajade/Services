package com.example.userprofilelastlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //genderRadioGroup = findViewById(R.id.genderRadioGroup);
        //private RadioGroup genderRadioGroup;
        EditText usernameEditText = findViewById(R.id.usernameText);
        EditText emailEditText = findViewById(R.id.emailText);
        EditText contactNumberEditText = findViewById(R.id.contactNumberText);
        EditText passwordEditText = findViewById(R.id.passwordText);
        Button submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(view -> {
            Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
            startActivity(intent);
//            String username = usernameEditText.getText().toString();
//            String email = emailEditText.getText().toString();
//            String contactNumber = contactNumberEditText.getText().toString();
//            String password = passwordEditText.getText().toString();
            //int selectedGenderId = genderRadioGroup.getCheckedRadioButtonId();
           // RadioButton selectedGenderRadioButton = findViewById(selectedGenderId);
            //String gender = selectedGenderRadioButton.getText().toString();

          //  Intent intent = new Intent(SignUpActivity.this, ProfileActivity.class);
//            intent.putExtra("username", username);
//            intent.putExtra("email", email);
//            intent.putExtra("contactNumber", contactNumber);
//            intent.putExtra("password", password);
           // intent.putExtra("gender", gender);
        });
    }
}
