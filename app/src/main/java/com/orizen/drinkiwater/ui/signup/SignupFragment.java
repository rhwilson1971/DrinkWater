package com.orizen.drinkiwater.ui.signup;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;


import com.orizen.drinkiwater.data.DrinkAppRepository;
import com.orizen.drinkiwater.data.entities.User;
import com.orizen.drinkiwater.databinding.FragmentSignupBinding;
import com.orizen.drinkiwater.ui.login.LoginViewModelFactory;
import com.orizen.drinkiwater.ui.login.SignupViewModel;

import java.util.List;

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

        signupViewModel.getSignupFormState().observe(getViewLifecycleOwner(), signupFormState -> {
            if (signupFormState == null) {
                return;
            }

            saveButton.setEnabled(signupFormState.isDataValid());

            if (signupFormState.getUsernameError() != null) {
                fullNameText.setError(getString(signupFormState.getUsernameError()));
            }

            if (signupFormState.getPasswordError() != null) {
                passwordEditText.setError(getString(signupFormState.getPasswordError()));
            }


        });

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                signupViewModel.signupDataChanged(emailEditText.getText().toString(),
                        passwordEditText.getText().toString(),
                        confirmPasswordEditText.getText().toString());
            }
        };

        emailEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.addTextChangedListener(afterTextChangedListener);
        confirmPasswordEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    signupViewModel.signup(emailEditText.getText().toString(),
                            passwordEditText.getText().toString(),
                            confirmPasswordEditText.getText().toString());
                }
                return false;
            }
        });



        saveButton.setOnClickListener(view -> {
            signupUser();
        });
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // binding.buttonSaveUser.setOnClickListener(view1 -> signupUser());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void signupUser() {

        String password = binding.editTextPassword.getText().toString();
        String confirmPassword = binding.editTextConfirmPassword.getText().toString();

        if(password.isEmpty()) return ;
        if(password.length() < 5) return ;
        if(password.compareTo(confirmPassword) !=0) return;

        User user = new User(binding.editTextFullName.getText().toString(),
                binding.editTextEmailAddress.getText().toString(),
                binding.editTextPassword.getText().toString()
                );

        User found =
                DrinkAppRepository.getInstance().userDao().findByUser(user.name, user.email, user.password).getValue();

        if(found == null) {

            try {
                DrinkAppRepository.getInstance().userDao().insertUser(user);

                LiveData<User> savedUser=
                DrinkAppRepository.getInstance().userDao().findByUserAndPassword(user.email, user.password);

                List<User> allUsers=
                DrinkAppRepository.getInstance().userDao().getAll();

                if(allUsers == null) {
                    Log.d("signup", "got no users");
                } else {
                    Log.d("signup", "got all users");
                }

                if(savedUser.getValue() != null){
                    NavDirections action =
                            SignupFragmentDirections.actionSignupFragmentToSignupStatusFragment(user);
                    NavHostFragment.findNavController(SignupFragment.this).navigate(action);
                }
            }
            catch(Exception e) {
                Log.d("signup", e.getLocalizedMessage());
            }
        }
    }
}
