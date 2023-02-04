package com.example.userprofilelastlogin.ui.slideshow;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SlideshowViewModel extends ViewModel {

    public SlideshowViewModel() {
        MutableLiveData<String> mText = new MutableLiveData<>();
        mText.setValue("This is Contact us fragment");
    }

}