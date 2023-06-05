package com.orizen.drinkiwater.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NewDrinkViewModel extends ViewModel {
    private final MutableLiveData<String> mDrinkName;
    private final MutableLiveData<String> mDrinkAmount;

    public NewDrinkViewModel() {
        mDrinkName = new MutableLiveData<>();
        mDrinkAmount = new MutableLiveData<>();
    }

    public LiveData<String> getDrinkName() {
        return mDrinkName;
    }

    public LiveData<String> getDrinkAmount(){
        return mDrinkAmount;
    }
}
