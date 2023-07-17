package com.orizen.drinkiwater.ui.login;

import android.util.Patterns;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.orizen.drinkiwater.R;
import com.orizen.drinkiwater.data.LoginRepository;
import com.orizen.drinkiwater.data.Result;
import com.orizen.drinkiwater.data.model.LoggedInUser;

public class SignupViewModel extends ViewModel {

    private final MutableLiveData<SignupFormState> signupFormState = new MutableLiveData<>();
    private final MutableLiveData<LoginResult> loginResult = new MutableLiveData<>();
    private final LoginRepository loginRepository;

    SignupViewModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public LiveData<SignupFormState> getSignupFormState() {
        return signupFormState;
    }

    public LiveData<LoginResult> getLoginResult() {
        return loginResult;
    }

    public void signup(String username, String password, String passwordConfirmed) {
        // can be launched in a separate asynchronous job
        Result<LoggedInUser> result = loginRepository.signup(username, password, passwordConfirmed);

        if (result instanceof Result.Success) {
            LoggedInUser data = ((Result.Success<LoggedInUser>) result).getData();
            loginResult.setValue(new LoginResult(new LoggedInUserView(data.getDbUser(), data.getDisplayName())));
        } else {
            loginResult.setValue(new LoginResult(R.string.login_failed));
        }
    }

    public void signupDataChanged(String username, String password, String confirmPassword) {
        if (!isUserNameValid(username)) {
            signupFormState.setValue(new SignupFormState(R.string.invalid_username, null));
        } else if (!isPasswordValid(password)) {
            signupFormState.setValue(new SignupFormState(null, R.string.invalid_password));
        } else if (password.compareTo(confirmPassword)!=0) {
            signupFormState.setValue(new SignupFormState(null, R.string.password_dont_match));
        } else {
            signupFormState.setValue(new SignupFormState(true));
        }
    }

    // A placeholder username validation check
    private boolean isUserNameValid(String username) {
        if (username == null) {
            return false;
        }
        if (username.contains("@")) {
            return Patterns.EMAIL_ADDRESS.matcher(username).matches();
        } else {
            return !username.trim().isEmpty();
        }
    }

    // A placeholder password validation check
    private boolean isPasswordValid(String password) {
        return password != null && password.trim().length() > 5;
    }
}
