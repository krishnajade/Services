package com.example.userprofilelastlogin;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class ServiceEngineerInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_engineer_info);

        setTitle("Service Engineer Info");

        // Retrieve the value passed from the previous activity
        String residentialAddress = getIntent().getStringExtra("RESIDENTIAL_ADDRESS");
        String permanentAddress = getIntent().getStringExtra("PERMANENT_ADDRESS");
        String city = getIntent().getStringExtra("CITY");
        String state = getIntent().getStringExtra("STATE");
        String aadhar = getIntent().getStringExtra("AADHAR");
        String pan = getIntent().getStringExtra("PAN");
        String qualification=getIntent().getStringExtra("QUALIFICATION");

        // Get the TextView and set its text to the address value
        TextView textView1 = findViewById(R.id.residential_address_display);
        textView1.setText(residentialAddress);
        TextView textView2 = findViewById(R.id.permanent_address_display);
        textView2.setText(permanentAddress);
        TextView textView3 = findViewById(R.id.city_display);
        textView3.setText(city);
        TextView textView4 = findViewById(R.id.state_display);
        textView4.setText(state);
        TextView textView5 = findViewById(R.id.aadhar_display);
        textView5.setText(aadhar);
        TextView textView6 = findViewById(R.id.pan_display);
        textView6.setText(pan);
        TextView textView7 = findViewById(R.id.qualification_display);
        textView7.setText(qualification);


        //
        Button submitButton = findViewById(R.id.submit_button);
        submitButton.setOnClickListener(view -> {

            // Launch the Login activity
            Intent intent = new Intent(ServiceEngineerInfoActivity.this, LoginActivity.class);
            startActivity(intent);
        });
        //


    }
}