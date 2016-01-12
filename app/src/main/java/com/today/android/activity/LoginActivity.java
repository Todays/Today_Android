package com.today.android.activity;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.today.android.R;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements OnClickListener
{

    /**
     * Id to identity READ_CONTACTS permission request.
     */


    private TextInputLayout emailInputLayout,passwordInputlayout;


    // UI references.
    private View mProgressView;
    private View mLoginFormView;
    private static final int REQUEST_READ_CONTACTS = 0;
    private  Button signUpButton,skipButton,loginButton;
    private  String emailPattern = "[A-Za-z.\0-9_]+@[0-9A-Za-z]+\\.+[a-z]+";
    private EditText emailEditText,passwordEditText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();


    }

    private void init() {
        mProgressView = findViewById(R.id.login_progress);
        emailEditText = (EditText) findViewById(R.id.email);
        passwordEditText = (EditText)findViewById(R.id.password);
        loginButton = (Button)findViewById(R.id.loginButton);
        loginButton.setOnClickListener(this);
        signUpButton = (Button)findViewById(R.id.signupButton);
        signUpButton.setOnClickListener(this);

        emailInputLayout = (TextInputLayout)findViewById(R.id.emailinputlayout);
        passwordInputlayout = (TextInputLayout)findViewById(R.id.passwordinputlayout);

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.signupButton) {
            Intent intent = new Intent(this,SignUpActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out);
        }else if (v.getId() == R.id.loginButton) {
            Intent intent = new Intent(this,HomeActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
    }
}