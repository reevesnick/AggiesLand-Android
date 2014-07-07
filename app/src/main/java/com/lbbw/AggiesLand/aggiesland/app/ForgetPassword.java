package com.lbbw.AggiesLand.aggiesland.app;

import android.app.Activity;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.RequestPasswordResetCallback;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by BTX17-1 on 6/24/2014.
 */
public class ForgetPassword extends Activity {

    EditText et_forgetpassword = null;
    Button btn_submitforgetpassword = null;
    String password = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.forgetview);

        et_forgetpassword = (EditText) findViewById(R.id.et_forgetpassword);
        btn_submitforgetpassword = (Button) findViewById(R.id.btn_submitforgetpassword);

        btn_submitforgetpassword.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                password = et_forgetpassword.getText().toString();
                checkEmailID();


            }
        });

    }

    protected void checkEmailID() {
        // TODO Auto-generated method stub
        if (TextUtils.isEmpty(password)) {
            et_forgetpassword.setError(getString(R.string.error_field_required));
        } else if (!password.contains("@")) {
            et_forgetpassword.setError(getString(R.string.error_invalid_email));
        }
        else
            forgotPassword(password);
    }

    public void forgotPassword(String email) {
        //postEvent(new UserForgotPasswordStartEvent());
        ParseUser.requestPasswordResetInBackground(email, new UserForgotPasswordCallback());
    }

    private class UserForgotPasswordCallback extends RequestPasswordResetCallback{
        public UserForgotPasswordCallback(){
            super();
        }

        @Override
        public void done(ParseException e) {
            if (e == null) {
                Toast.makeText(getApplicationContext(), "Successfully sent link to your email for reset Password", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Failed to sent link to your email for reset Password", Toast.LENGTH_LONG).show();

            }
        }
    }
}
