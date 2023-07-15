package com.orizen.drinkiwater.ui.signup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;


import com.orizen.drinkiwater.data.DrinkAppRepository;
import com.orizen.drinkiwater.data.entities.User;
import com.orizen.drinkiwater.databinding.FragmentSignupBinding;
import com.orizen.drinkiwater.ui.login.LoginViewModelFactory;
import com.orizen.drinkiwater.ui.login.SignupViewModel;

public class SignupFragment extends Fragment {

    private FragmentSignupBinding binding;

    SignupViewModel signupViewModel;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSignupBinding.inflate(inflater, container, false);

        signupViewModel = new  ViewModelProvider(this, new LoginViewModelFactory())
                .get(SignupViewModel.class);

        final EditText fullNameText= binding.editTextFullName;
        final EditText emailEditText = binding.editTextEmailAddress;
        final EditText passwordEditText = binding.editTextPassword;
        final EditText confirmPasswordEditText = binding.editTextConfirmPassword;
        final Button saveButton = binding.buttonSaveUser;

        saveButton.setOnClickListener(view -> {
            User user = new User();

            user.name = fullNameText.getText().toString();
            user.email = emailEditText.getText().toString();
            user.password = passwordEditText.getText().toString();


        });

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSaveUser.setOnClickListener(view1 -> signupUser());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void signupUser() {

        User user = new User();

        user.email = binding.editTextEmailAddress.toString();
        user.name = binding.editTextFullName.toString();
        user.password = binding.editTextPassword.toString();
        user.password = binding.editTextConfirmPassword.toString();
        user.displayName = user.name;

        User found =
                DrinkAppRepository.getInstance().userDao().findByUser(user.name, user.email, user.password).getValue();

        if(found == null) {
            DrinkAppRepository.getInstance().userDao().insertUser(user);

            if(user.userId > 0){
                NavDirections action =
                    SignupFragmentDirections.actionSignupFragmentToSignupStatusFragment(user);
                NavHostFragment.findNavController(SignupFragment.this).navigate(action);
            }
        }
    }
}