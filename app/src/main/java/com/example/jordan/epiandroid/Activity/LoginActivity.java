package com.example.jordan.epiandroid.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.jordan.epiandroid.APIIntra.APIRequests;
import com.example.jordan.epiandroid.APIModels.Token;
import com.example.jordan.epiandroid.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    public static String API_URL = "http://epitech-api.herokuapp.com";
    public static String sessionToken = null;

    private Context context;

    private EditText mLoginView;
    private EditText mPasswordView;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        context = this.getBaseContext();
        mLoginView = (EditText) findViewById(R.id.login);
        mPasswordView = (EditText) findViewById(R.id.password);

        mProgressBar = (ProgressBar) findViewById(R.id.login_progress);

        Button SignInButton = (Button) findViewById(R.id.sign_in_button);
        SignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
    }

    @Override
    protected void onResume(){
        super.onResume();
    }

    private boolean isEmailValid(String email) {
        return email.length() < 9;
    }

    private void attemptLogin() {
        mLoginView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String login = mLoginView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (password.isEmpty()) {
            mPasswordView.setError(getString(R.string.error_field_required));
            focusView = mPasswordView;
            cancel = true;
        }

        // Check for a valid email address.
        if (login.isEmpty()) {
            mLoginView.setError(getString(R.string.error_field_required));
            focusView = mLoginView;
            cancel = true;
        } else if (!isEmailValid(login)) {
            mLoginView.setError(getString(R.string.error_invalid_login));
            focusView = mLoginView;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        } else {
            mProgressBar.setVisibility(View.VISIBLE);
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            APIRequests requests = retrofit.create(APIRequests.class);
            Call<Token> call = requests.getToken(login, password);
            call.enqueue(new Callback<Token>() {

                @Override
                public void onResponse(retrofit2.Response<Token> response) {
                    mProgressBar.setVisibility(View.INVISIBLE);
                    Log.d("Token", "Resp: " + response.code());
                    if (response.code() == 200) {
                        Token t = response.body();
                        Log.d("Token", "Token: " + t.getToken());
                        sessionToken = t.getToken();
                        Intent intent = new Intent(context, MainActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(context, R.string.connection_error, Toast.LENGTH_SHORT).show();
                        Log.d("Token", "Wrong credentials");
                    }
                }

                @Override
                public void onFailure(Throwable throwable) {
                    mProgressBar.setVisibility(View.INVISIBLE);
                    Toast.makeText(context, R.string.network_error, Toast.LENGTH_SHORT).show();
                    Log.d("Token", "Can't access to network");
                }
            });
        }
    }
}