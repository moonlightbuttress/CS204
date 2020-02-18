package com.example.cognito_tutorial;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoDevice;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserAttributes;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserSession;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.AuthenticationContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.ChallengeContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.MultiFactorAuthenticationContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.GenericHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.SignUpHandler;
import com.amazonaws.services.cognitoidentityprovider.model.SignUpResult;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private EditText givenName;
    private EditText email;
    private EditText confirmationCode;

    private Button signUpButton;
    private Button signInButton;
    private Button confirmButton;

    private Context context;

    private String usernameText;
    private String passwordText;
    private String givenNameText;
    private String emailText;
    private String confirmationCodeText;

    private AppHelper appHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.usernameEditText);
        password = (EditText) findViewById(R.id.passwordEditText);
        givenName = (EditText) findViewById(R.id.givenNameEditText);
        email = (EditText) findViewById(R.id.emailEditText);
        confirmationCode = (EditText) findViewById(R.id.confirmCodeEditText);

        username.addTextChangedListener(textWatcher);
        password.addTextChangedListener(textWatcher);
        givenName.addTextChangedListener(textWatcher);
        email.addTextChangedListener(textWatcher);
        confirmationCode.addTextChangedListener(textWatcher);

        signUpButton = (Button) findViewById(R.id.signUpButton);
        signInButton = (Button) findViewById(R.id.signInButton);
        confirmButton = (Button) findViewById(R.id.confirmButton);

        appHelper = AppHelper.getInstance();
        appHelper.init(getApplicationContext());

        context = this;
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CognitoUserAttributes userAttributes = new CognitoUserAttributes();
                userAttributes.addAttribute("given_name", givenNameText);
                userAttributes.addAttribute("email", emailText);
                AppHelper.getInstance().getUserPool().signUpInBackground(usernameText, passwordText, userAttributes, null, signupCallback);

            }
        });

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppHelper.getInstance().getUserPool().getUser(usernameText).getSessionInBackground(authenticationHandler);

            }
        });

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean forcedAliasCreation = false;
                AppHelper.getInstance().getUserPool().getUser(usernameText).confirmSignUpInBackground(confirmationCodeText, forcedAliasCreation, confHandler);

            }
        });
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            usernameText = username.getText().toString();
            passwordText = password.getText().toString();
            givenNameText = givenName.getText().toString();
            emailText = email.getText().toString();
            confirmationCodeText = confirmationCode.getText().toString();
        }
    };

    public void startLoggedInActivity() {
        Intent intent = new Intent(this, LoggedInActivity.class);
        startActivity(intent);
    }

    SignUpHandler signupCallback = new SignUpHandler() {
        @Override
        public void onSuccess(CognitoUser user, SignUpResult signUpResult) {
            Context context = getApplicationContext();
            CharSequence text = "Success";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

        @Override
        public void onFailure(Exception exception) {
            Log.e("Exception", exception.toString());
            Context context = getApplicationContext();
            CharSequence text = "Failure";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    };

    GenericHandler confHandler = new GenericHandler() {
        @Override
        public void onSuccess() {
            Context context = getApplicationContext();
            CharSequence text = "Success";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            startLoggedInActivity();
        }

        @Override
        public void onFailure(Exception exception) {
            Context context = getApplicationContext();
            CharSequence text = "Failure";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    };

    AuthenticationHandler authenticationHandler = new AuthenticationHandler() {
        @Override
        public void onSuccess(CognitoUserSession userSession, CognitoDevice newDevice) {
            Context context = getApplicationContext();
            CharSequence text = "Success";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

        @Override
        public void getAuthenticationDetails(AuthenticationContinuation authenticationContinuation, String userId) {

        }

        @Override
        public void getMFACode(MultiFactorAuthenticationContinuation continuation) {

        }

        @Override
        public void authenticationChallenge(ChallengeContinuation continuation) {

        }

        @Override
        public void onFailure(Exception exception) {
            Context context = getApplicationContext();
            CharSequence text = "Failure";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    };
}