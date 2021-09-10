package com.example.appv6.ui.Sexta;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.appv6.R;

public class Sexta extends Fragment {

    private SextaViewModel SextaViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SextaViewModel =
                ViewModelProviders.of(this).get(SextaViewModel.class);
        View root = inflater.inflate(R.layout.sexta_fragment, container, false);
        SextaViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });
        return root;
    }
}