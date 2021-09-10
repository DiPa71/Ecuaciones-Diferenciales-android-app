package com.example.appv6.ui.Quinta;

        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.fragment.app.Fragment;
        import androidx.lifecycle.Observer;
        import androidx.lifecycle.ViewModelProviders;

        import com.example.appv6.R;
        import com.example.appv6.ui.home.HomeViewModel;

public class quintaFragment extends Fragment {

    private quintaViewModel quintaViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        quintaViewModel =
                ViewModelProviders.of(this).get(quintaViewModel.class);
        View root = inflater.inflate(R.layout.fragment_quinta, container, false);
        quintaViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });
        return root;
    }
}