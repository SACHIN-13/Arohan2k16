package com.example.sachin.arohan;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivityActivity extends AppCompatActivity{
    public final static String EXTRA_MESSAGE = "com.example.sachin.arohan.app.MESSAGE";
    private Toolbar toolbar;
    private EditText inputFirstName, inputLastName, inputEmail, inputPassword;
    private TextInputLayout inputLayoutFirstName, inputLayoutLastName, inputLayoutEmail, inputLayoutPassword;
    private Button btnSignUp;
    public static String file="Hello shared preferences!";
    SharedPreferences prefs;
    public boolean logIn=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        inputLayoutFirstName = (TextInputLayout) findViewById(R.id.input_layout_first_name);
        inputLayoutLastName = (TextInputLayout) findViewById(R.id.input_layout_last_name);
        inputLayoutEmail = (TextInputLayout) findViewById(R.id.input_layout_email);
        inputLayoutPassword = (TextInputLayout) findViewById(R.id.input_layout_password);
        inputFirstName = (EditText) findViewById(R.id.input_first_name);
        inputLastName = (EditText) findViewById(R.id.input_last_name);
        inputEmail = (EditText) findViewById(R.id.input_email);
        inputPassword = (EditText) findViewById(R.id.input_password);
        btnSignUp = (Button) findViewById(R.id.btn_signup);
        inputLastName.addTextChangedListener(new MyTextWatcher(inputLastName));
        inputFirstName.addTextChangedListener(new MyTextWatcher(inputFirstName));
        inputEmail.addTextChangedListener(new MyTextWatcher(inputEmail));
        inputPassword.addTextChangedListener(new MyTextWatcher(inputPassword));

            prefs=getSharedPreferences(file,0);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                // TODO Auto-generated method stub

                /// Create Intent for SignUpActivity  abd Start The Activity
                String data=inputFirstName.getText().toString();
                SharedPreferences.Editor editor=prefs.edit();
                editor.putString("user name",data);
                editor.putBoolean("login status",true);
                editor.commit();

                Intent intentSignUP = new Intent(getApplicationContext(), SecondActivity.class);
                int x=1;
                x=submitForm();
                if(x==1)
                startActivity(intentSignUP);

            }

        });
    }




            private int submitForm() {
                if (!validateFirstName() ||!validateLastName()) {
                    return 0;
                }

                if (!validateEmail()) {
                    return 0;
                }

                if (!validatePassword()) {
                    return 0;
                }

                Toast.makeText(getApplicationContext(), "Thank You!", Toast.LENGTH_SHORT).show();
                return 1;
            }

            private boolean validateFirstName() {
                if (inputFirstName.getText().toString().trim().isEmpty()) {
                    inputLayoutFirstName.setError(getString(R.string.err_msg_name));
                    requestFocus(inputFirstName);
                    return false;
                }
                else {
                    inputLayoutFirstName.setErrorEnabled(false);
                }

                return true;
            }
              private boolean validateLastName() {
              if (inputLastName.getText().toString().trim().isEmpty()) {
                   inputLayoutLastName.setError(getString(R.string.err_msg_name));
                    requestFocus(inputLastName);
                    return false;
                }
               else {
                inputLayoutLastName.setErrorEnabled(false);
               }

        return true;
    }

            private boolean validateEmail() {
                String email = inputEmail.getText().toString().trim();

                if (email.isEmpty() || !isValidEmail(email)) {
                    inputLayoutEmail.setError(getString(R.string.err_msg_email));
                    requestFocus(inputEmail);
                    return false;
                } else {
                    inputLayoutEmail.setErrorEnabled(false);
                }

                return true;
            }

            private boolean validatePassword() {
                if (inputPassword.getText().toString().trim().isEmpty()||inputPassword.getText().toString().trim().length()<8) {
                    inputLayoutPassword.setError(getString(R.string.err_msg_password));
                    requestFocus(inputPassword);
                    return false;
                } else {
                    inputLayoutPassword.setErrorEnabled(false);
                }

                return true;
            }

            private boolean isValidEmail(String email) {
                return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
            }

            private void requestFocus(View view) {
                if (view.requestFocus()) {
                    getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                }
            }

            class MyTextWatcher implements TextWatcher {

                private View view;

                private MyTextWatcher(View view) {
                    this.view = view;
                }

                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                public void afterTextChanged(Editable editable) {
                    switch (view.getId()) {
                        case R.id.input_first_name:
                            validateFirstName();
                            break;
                        case R.id.input_last_name:
                            validateLastName();
                            break;
                        case R.id.input_email:
                            validateEmail();
                            break;
                        case R.id.input_password:
                            validatePassword();
                            break;
                    }
                }
            }

            @Override
            public boolean onCreateOptionsMenu(Menu menu) {
                // Inflate the menu; this adds items to the action bar if it is present.
                getMenuInflater().inflate(R.menu.menu_main, menu);
                return true;
            }

            @Override
            public boolean onOptionsItemSelected(MenuItem item) {
                // Handle action bar item clicks here. The action bar will
                // automatically handle clicks on the Home/Up button, so long
                // as you specify a parent activity in AndroidManifest.xml.
                int id = item.getItemId();

                //noinspection SimplifiableIfStatement
                if (id == R.id.action_settings) {
                    Toast.makeText(getApplicationContext(), "Settings!", Toast.LENGTH_SHORT).show();

                    return true;
                }
                if (id == R.id.contact_us) {
                    Toast.makeText(getApplicationContext(), "Contact Us!", Toast.LENGTH_SHORT).show();

                    return true;
                }
                return super.onOptionsItemSelected(item);
            }




    }
