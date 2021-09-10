package com.example.appv6.ui.Quinta;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class quintaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public quintaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is quinta fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}