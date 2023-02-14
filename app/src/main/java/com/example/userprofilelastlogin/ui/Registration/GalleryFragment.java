package com.example.userprofilelastlogin.ui.Registration;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.userprofilelastlogin.R;
import com.example.userprofilelastlogin.ServiceEngineerInfoActivity;

public class GalleryFragment extends Fragment {
    private static final int PICK_AADHAR_IMAGE_REQUEST = 1;
    private static final int PICK_PAN_IMAGE_REQUEST = 2;
    private static final int PICK_CERTIFICATE_IMAGE_REQUEST = 3;
    private TextView aadharEditText;
    private TextView panCardEditText;
    private TextView certificateEditText;
    String qualification;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        EditText mResidentialAddress = view.findViewById(R.id.residential_address);
        EditText mPermanentAddress=view.findViewById(R.id.permanent_address);
        EditText mCity=view.findViewById(R.id.city);
        EditText mState=view.findViewById(R.id.state);
        EditText mAadhar=view.findViewById(R.id.aadhar);
        EditText mPan=view.findViewById(R.id.pan);
        Spinner mCertificate=view.findViewById(R.id.spinner_qualification);

        // Find the "Submit" button in the layout
        Button submitButton = view.findViewById(R.id.submit_button);
        // Set an OnClickListener on the "Submit" button
        submitButton.setOnClickListener(v -> {
            // Check if any required fields are empty
            if (mResidentialAddress.getText().toString().isEmpty() ||
                    mPermanentAddress.getText().toString().isEmpty() ||
                    mCity.getText().toString().isEmpty() ||
                    mState.getText().toString().isEmpty() ||
                    mAadhar.getText().toString().isEmpty() ||
                    mPan.getText().toString().isEmpty() ||
                    mCertificate.getSelectedItem().toString().isEmpty()) {
                // If any field is empty, show an error message and don't submit the form
                Toast.makeText(getContext(), "Please fill in all required fields", Toast.LENGTH_SHORT).show();
            } else {
                // If all fields are filled, create an Intent to start the ServiceEngineerInfoActivity
                Intent intent = new Intent(getContext(), ServiceEngineerInfoActivity.class);

                // Add the residential address as an extra to the Intent
                String address = mResidentialAddress.getText().toString();
                intent.putExtra("RESIDENTIAL_ADDRESS", address);
                //
                String permaddress=mPermanentAddress.getText().toString();
                intent.putExtra("PERMANENT_ADDRESS",permaddress);
                //
                String city=mCity.getText().toString();
                intent.putExtra("CITY",city);
                //
                String state=mState.getText().toString();
                intent.putExtra("STATE",state);
                //
                String aadhar=mAadhar.getText().toString();
                intent.putExtra("AADHAR",aadhar);
                //
                String pan=mPan.getText().toString();
                intent.putExtra("PAN",pan);
                //
                qualification=mCertificate.getSelectedItem().toString();
                intent.putExtra("QUALIFICATION",qualification);

                // Start the ServiceEngineerInfoActivity with the Intent
                startActivity(intent);
            }
        });






        //Addhar card logic
//        aadharimageView = view.findViewById(R.id.aadhar_image_view);
        aadharEditText = view.findViewById(R.id.aadhar_edit_text);
        view.findViewById(R.id.upload_aadhar_button).setOnClickListener(v -> showFileChooser(PICK_AADHAR_IMAGE_REQUEST));

        //pancard logic
//        panCardImageView=view.findViewById(R.id.pancard_image_view);
        panCardEditText = view.findViewById(R.id.pancard_edit_text);
        view.findViewById(R.id.upload_pancard_button).setOnClickListener(v ->showFileChooser(PICK_PAN_IMAGE_REQUEST));

        //Education certificate logic
//        certificateImageView=view.findViewById(R.id.certificate_image_view);
        certificateEditText = view.findViewById(R.id.certificate_edit_text);
        view.findViewById(R.id.upload_certificate_button).setOnClickListener(v ->showFileChooser(PICK_CERTIFICATE_IMAGE_REQUEST));

        //Spinner Logic
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.qualifications_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mCertificate.setAdapter(adapter);

        EditText otherEditText = view.findViewById(R.id.edit_text_other_qualification);
        otherEditText.setVisibility(View.GONE);

        mCertificate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedQualification = parent.getItemAtPosition(position).toString();

                if (selectedQualification.equals("Other")) {
                    otherEditText.setVisibility(View.VISIBLE);
                    qualification = otherEditText.getText().toString();
                } else {
                    otherEditText.setVisibility(View.GONE);
                    qualification=mCertificate.getSelectedItem().toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });


        return view;
    }
private void showFileChooser(int requestCode) {
    Intent intent = new Intent();
    intent.setType("*/*");
    intent.setAction(Intent.ACTION_GET_CONTENT);
    startActivityForResult(Intent.createChooser(intent, "Select File"), requestCode);
}
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null && data.getData() != null) {
            Uri uri = data.getData();

            if(requestCode==PICK_AADHAR_IMAGE_REQUEST){try {
               // aadharimageView.setImageURI(uri);
                //aadharEditText.setText(uri.toString());
                aadharEditText.setText("File chosen");

            } catch (Exception e) {
                Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
            }}
            else if (requestCode==PICK_PAN_IMAGE_REQUEST) {try {
               // panCardImageView.setImageURI(uri);
//                panCardEditText.setText(uri.toString());
                panCardEditText.setText("File chosen");
            } catch (Exception e) {
                Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
            }}
            else if (requestCode==PICK_CERTIFICATE_IMAGE_REQUEST) {try {
               // certificateImageView.setImageURI(uri);
               // certificateEditText.setText(uri.toString());
                certificateEditText.setText("File chosen");
            } catch (Exception e) {
                Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
            }}
        }
    }
}
