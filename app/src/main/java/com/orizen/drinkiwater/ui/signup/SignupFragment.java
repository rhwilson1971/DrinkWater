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

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();

                user.name = fullNameText.getText().toString();
                user.email = emailEditText.getText().toString();
                user.password = passwordEditText.getText().toString();

                User found =
                DrinkAppRepository.getInstance().userDao().findByUser(user.name, user.email, user.password).getValue();

                if(found == null) {
                    DrinkAppRepository.getInstance().userDao().insertUser(user);

                    if(user.userId > 0){
                        // success go back to
                    }
                }
            }
        });

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSaveUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                NavHostFragment.findNavController(SignupFragment.this)
//                        .navigate(R.id.action_FirstFragment_to_SecondFragment);



                //binding.errorMessagesView
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}