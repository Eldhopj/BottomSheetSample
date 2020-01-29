package com.humfit.bottomsheetsample;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.humfit.bottomsheetsample.databinding.ActivityMainBinding;

/**Create an layout for bottom sheet*/

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
    private BottomSheetSharedViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(BottomSheetSharedViewModel.class);

        binding.buttonOpenBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog dialog = new BottomSheetDialog();
                dialog.show(getSupportFragmentManager(),"BottomSheet");
            }
        });

        viewModel.getShowBottomSheet().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.textViewButtonClicked.setText(s);
            }
        });
    }
}
