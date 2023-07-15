package com.orizen.drinkiwater.ui.signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.orizen.drinkiwater.MainActivity;
import com.orizen.drinkiwater.databinding.FragmentSignupStatusBinding;

public class SignupStatusFragment extends Fragment {


    private FragmentSignupStatusBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSignupStatusBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonStart.setOnClickListener(view1 -> {
//                NavHostFragment.findNavController(SignupStatusFragment.this)
//                        .navigate(R.id.action_SecondFragment_to_FirstFragment);




        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}