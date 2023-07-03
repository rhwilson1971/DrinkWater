package com.orizen.drinkiwater.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.orizen.drinkiwater.data.AppDatabase;
import 	android.graphics.Color;
import org.eazegraph.lib.models.PieModel;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<PieModel> pieModel;

    private final MutableLiveData<String> mText;

    public HomeViewModel() {
        pieModel = new MutableLiveData<>();
        setData();

        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<PieModel> getPieModel() {
        return pieModel;
    }

    private void setData() {

        pieModel.setValue(
            new PieModel(
                    "Water",
                    0,
                    Color.parseColor("#FFA726")));
    }
}