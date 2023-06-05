package com.orizen.drinkiwater.ui.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.orizen.drinkiwater.R;
import com.orizen.drinkiwater.data.DrinkAppRepository;
import com.orizen.drinkiwater.data.entities.DrinkItem;

import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewDrinkFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewDrinkFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_DRINK_NAME = "Param_Drink_Name";
    private static final String ARG_DRINK_AMOUNT = "Param_Drink_Amount";

    // TODO: Rename and change types of parameters
    private String mDrinkName;
    private Float mDrinkAmount;

    public NewDrinkFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewDrinkBlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewDrinkFragment newInstance(String param1, float param2) {
        NewDrinkFragment fragment = new NewDrinkFragment();
        Bundle args = new Bundle();
        args.putString(ARG_DRINK_NAME, param1);
        args.putFloat(ARG_DRINK_AMOUNT, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mDrinkName = getArguments().getString(ARG_DRINK_NAME);
            mDrinkAmount = getArguments().getFloat(ARG_DRINK_AMOUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        NewDrinkViewModel newDrinkViewModel =
                new ViewModelProvider(this).get(NewDrinkViewModel.class);

        Log.d("NewDrink", "onCreateView in is called!");
        View root = inflater.inflate(R.layout.fragment_new_drink, container, false);

        final TextView drinkName = root.findViewById(R.id.editTextTextDrinkName);
        final TextView drinkAmount = root.findViewById(R.id.editTextNumberSignedAmount);

        newDrinkViewModel.getDrinkName().observe(getViewLifecycleOwner(), drinkName::setText);
        newDrinkViewModel.getDrinkAmount().observe(getViewLifecycleOwner(), drinkAmount::setText);

        Button button = (Button)root.findViewById(R.id.buttonAdd);

        button.setOnClickListener(v -> {
            String amount = newDrinkViewModel.getDrinkAmount().getValue();
            String name = newDrinkViewModel.getDrinkName().getValue();

            if(amount == null || name == null)
                return;

            DrinkItem newDrink = new DrinkItem();

            newDrink.Amount = Float.parseFloat(amount);
            newDrink.Name = name;
            newDrink.dateAdded = new Date();

            DrinkAppRepository.getInstance(container.getContext()).drinkItemDao().insert(newDrink);

        });

        return root;
    }
}