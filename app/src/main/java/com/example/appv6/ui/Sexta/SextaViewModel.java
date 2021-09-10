package com.example.appv6.ui.Sexta;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SextaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SextaViewModel () {
        mText = new MutableLiveData<>();
        mText.setValue("This is sexta fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}