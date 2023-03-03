package com.example.userprofilelastlogin;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import com.example.userprofilelastlogin.models.SignupResponse;
import com.example.userprofilelastlogin.services.SignupApi;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignupActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private EditText emailEditText;
    private RadioGroup genderRadioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        usernameEditText = findViewById(R.id.username_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        emailEditText = findViewById(R.id.email_edit_text);
        genderRadioGroup = findViewById(R.id.gender_radio_group);

        Button signupButton = findViewById(R.id.signup_button);
        signupButton.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();
            String email = emailEditText.getText().toString();
            String gender = "";
            int selectedId = genderRadioGroup.getCheckedRadioButtonId();
            if (selectedId != -1) {
                RadioButton selectedRadioButton = findViewById(selectedId);
                gender = selectedRadioButton.getText().toString();
            }
            signup(username, password, email, gender);
        });
    }
    private void signup(String username, String password, String email, String gender) {
        final String BASE_URL = "https://trifrnd.com/TestServer/API/Second/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
            SignupApi signupApi = retrofit.create(SignupApi.class);
            Call<SignupResponse> call = signupApi.signup( username, password, email, gender);
            call.enqueue(new Callback<SignupResponse>() {
                @Override
                public void onResponse(Call<SignupResponse> call, Response<SignupResponse> response) {
                    if (response.isSuccessful()) {
                        SignupResponse signupResponse = response.body();
                        String message = signupResponse.getMessage();
                        Toast.makeText(SignupActivity.this, message, Toast.LENGTH_SHORT).show();
                        // Handle successful signup
                    } else {
                        // Handle unsuccessful signup
                    }
                }
                @Override
                public void onFailure(Call<SignupResponse> call, Throwable t) {
                    // Handle failure
                }
            });
        }
    }
