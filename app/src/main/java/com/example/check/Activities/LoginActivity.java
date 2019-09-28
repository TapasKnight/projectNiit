package com.example.check.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.check.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class LoginActivity extends AppCompatActivity {

    private EditText userEmail, userPassword;
    private Button btnLogin;
    private ProgressBar barLogin;
    private FirebaseAuth mAuth;
    private Intent HomeActivity;
    private ImageView loginPhoto;
    Animation atg,btgone,btgtwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userEmail = (EditText) findViewById(R.id.login_name);
        userPassword = (EditText) findViewById(R.id.login_password);
        btnLogin = (Button) findViewById(R.id.login_button);
        barLogin = (ProgressBar) findViewById(R.id.login_progress);

        barLogin.setVisibility(View.INVISIBLE);
        mAuth = FirebaseAuth.getInstance();
        HomeActivity = new Intent(this, com.example.check.Activities.MainActivity.class);
        loginPhoto = (ImageView) findViewById(R.id.login_image);
        loginPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent registerActivity = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(registerActivity);
                finish();;


            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                barLogin.setVisibility(View.VISIBLE);
                btnLogin.setVisibility(View.INVISIBLE);

                final String mail = userEmail.getText().toString();
                final String password = userPassword.getText().toString();

                if (mail.isEmpty() || password.isEmpty()) {
                    barLogin.setVisibility(View.INVISIBLE);
                    btnLogin.setVisibility(View.VISIBLE);
                    showMessage("Please Verify all Fields ");
                }
                else
                {
                    signIN(mail,password);

                }
            }

        });


        // Load ANimation


        atg = AnimationUtils.loadAnimation(this,R.anim.atg);
        btgone = AnimationUtils.loadAnimation(this,R.anim.btgone);
        btgtwo = AnimationUtils.loadAnimation(this,R.anim.btgtwo);


        // Passing Animation


        loginPhoto.startAnimation(atg);
        userEmail.startAnimation(btgone);
        userPassword.startAnimation(btgone);
        btnLogin.startAnimation(btgtwo);


    }

    private void signIN(String mail, String password) {

        mAuth.signInWithEmailAndPassword(mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {


                if (task.isSuccessful()){
                    barLogin.setVisibility(View.INVISIBLE);
                    btnLogin.setVisibility(View.VISIBLE);
                    updateUI();

                }
                else{
                    barLogin.setVisibility(View.INVISIBLE);
                    btnLogin.setVisibility(View.VISIBLE);
                    showMessage(task.getException().getMessage());

                }


            }
        });


    }

    private void updateUI() {

        startActivity(HomeActivity);
        finish();


    }

    private void showMessage(String text){
        Toast.makeText(getApplicationContext(),text, Toast.LENGTH_SHORT).show();


    }

    @Override
    protected void onStart() {
        super.onStart();


        FirebaseUser user = mAuth.getCurrentUser();

        if(user != null){
            // If user is not logged out
            updateUI();;

        }

    }
}
