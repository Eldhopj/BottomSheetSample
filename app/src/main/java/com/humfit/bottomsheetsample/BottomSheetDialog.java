package com.humfit.bottomsheetsample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.humfit.bottomsheetsample.databinding.BottomSheetLayoutBinding;


/**In mainActivity we use BottomSheetDialog instance to show bottom sheet */
public class BottomSheetDialog extends BottomSheetDialogFragment {

    private BottomSheetLayoutBinding binding;
    private BottomSheetSharedViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       binding = BottomSheetLayoutBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(getActivity()).get(BottomSheetSharedViewModel.class);
        clicks();
    }

    private void clicks() {
        binding.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.setShowBottomSheet("Button One clicked");
                dismiss();
            }
        });
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.setShowBottomSheet("Button two clicked");
                dismiss();
            }
        });
    }
}
