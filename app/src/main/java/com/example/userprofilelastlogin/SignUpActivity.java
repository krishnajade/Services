package com.example.userprofilelastlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class SignUpActivity extends AppCompatActivity {
    private RadioGroup genderRadioGroup;
    private EditText usernameEditText;
    private EditText emailEditText;
    private EditText contactNumberEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        genderRadioGroup = findViewById(R.id.genderRadioGroup);
        usernameEditText = findViewById(R.id.usernameText);
        emailEditText = findViewById(R.id.emailText);
        contactNumberEditText = findViewById(R.id.contactNumberText);
        passwordEditText = findViewById(R.id.passwordText);
        Button submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(view -> {
            String username = usernameEditText.getText().toString();
            String email = emailEditText.getText().toString();
            String contactNumber = contactNumberEditText.getText().toString();
            String password = passwordEditText.getText().toString();
            int selectedGenderId = genderRadioGroup.getCheckedRadioButtonId();
            RadioButton selectedGenderRadioButton = findViewById(selectedGenderId);
            String gender = selectedGenderRadioButton.getText().toString();

            Intent intent = new Intent(SignUpActivity.this, ProfileActivity.class);
            intent.putExtra("username", username);
            intent.putExtra("email", email);
            intent.putExtra("contactNumber", contactNumber);
            intent.putExtra("password", password);
            intent.putExtra("gender", gender);
            startActivity(intent);
        });
    }
}
