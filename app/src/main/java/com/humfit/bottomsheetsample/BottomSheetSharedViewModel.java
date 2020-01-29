package com.humfit.bottomsheetsample;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BottomSheetSharedViewModel extends ViewModel {

    private MutableLiveData<String> showBottomSheet = new MutableLiveData<>();

    public MutableLiveData<String> getShowBottomSheet() {
        return showBottomSheet;
    }

    public void setShowBottomSheet (String  value) {
        showBottomSheet.setValue(value);
    }
}
