package com.example.userprofilelastlogin.ui.Registration;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.userprofilelastlogin.R;

public class GalleryFragment extends Fragment {

    private static final int PICK_AADHAR_IMAGE_REQUEST = 1;
    private static final int PICK_PAN_IMAGE_REQUEST = 2;
    private static final int PICK_CERTIFICATE_IMAGE_REQUEST = 3;

    private ImageView aadharimageView;
    private ImageView panCardImageView;
    private ImageView certificateImageView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        //Addhar card logic
//        aadharimageView = view.findViewById(R.id.aadhar_image_view);
        view.findViewById(R.id.upload_aadhar_button).setOnClickListener(v -> showFileChooser(PICK_AADHAR_IMAGE_REQUEST));

        //pancard logic
//        panCardImageView=view.findViewById(R.id.pancard_image_view);
        view.findViewById(R.id.upload_pancard_button).setOnClickListener(v ->showFileChooser(PICK_PAN_IMAGE_REQUEST));

        //Education certificate logic
//        certificateImageView=view.findViewById(R.id.certificate_image_view);
        view.findViewById(R.id.upload_certificate_button).setOnClickListener(v ->showFileChooser(PICK_CERTIFICATE_IMAGE_REQUEST));



        return view;
    }

    private void showFileChooser(int requestCode) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), requestCode);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null && data.getData() != null) {
            Uri uri = data.getData();
            if(requestCode==PICK_AADHAR_IMAGE_REQUEST){try {
                aadharimageView.setImageURI(uri);
            } catch (Exception e) {
                Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
            }}
            else if (requestCode==PICK_PAN_IMAGE_REQUEST) {try {
                panCardImageView.setImageURI(uri);
            } catch (Exception e) {
                Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
            }}
            else if (requestCode==PICK_CERTIFICATE_IMAGE_REQUEST) {try {
                certificateImageView.setImageURI(uri);
            } catch (Exception e) {
                Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
            }}





        }
    }
}




//Qualification code
//        Spinner spinnerQualification = view.findViewById(R.id.spinner_qualification);
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
//                R.array.qualification_array, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinnerQualification.setAdapter(adapter);
//        spinnerQualification.setSelection(0);