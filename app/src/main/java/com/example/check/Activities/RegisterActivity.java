package com.example.check.Activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.check.Activities.LoginActivity;
import com.example.check.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import de.hdodenhof.circleimageview.CircleImageView;

public class RegisterActivity extends AppCompatActivity {

    CircleImageView userPhoto;
    static int PReqCode = 1;
    static int REQUESCODE = 1;
    Uri pickedImage;
    private EditText userEmail,userPassword,userPAssword2,userName;
    private Button regButton;
    private FirebaseAuth mAuth;
    private ProgressBar barLogin;
    Animation atg,btgone,btgtwo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // load animation

        atg = AnimationUtils.loadAnimation(this,R.anim.atg);
        btgone = AnimationUtils.loadAnimation(this,R.anim.btgone);
        btgtwo = AnimationUtils.loadAnimation(this,R.anim.btgtwo);


        userName = findViewById(R.id.user_name);
        userEmail = findViewById(R.id.user_email);
        userPassword = findViewById(R.id.user_password);
        userPAssword2 = findViewById(R.id.user_conf);
        mAuth =FirebaseAuth.getInstance();
        barLogin = findViewById(R.id.register_progress);
        barLogin.setVisibility(View.INVISIBLE);




        // Register Button
        regButton = findViewById(R.id.btn_register);
        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                barLogin.setVisibility(View.VISIBLE);
                regButton.setVisibility(View.INVISIBLE);

                final String email = userEmail.getText().toString();
                final String name = userName.getText().toString();
                final String password = userPassword.getText().toString();
                final String password2 = userPAssword2.getText().toString();
                if(email.isEmpty() || name.isEmpty() || password.isEmpty()
                        || !password.equals(password2)){

                    showMessage("Please Verify All Fields ");
                    regButton.setVisibility(View.VISIBLE);
                     barLogin.setVisibility(View.INVISIBLE);
                }
                else{

                    CreateUserAccount(email,name,password);
                }

            }
        });

        /// Registerd User Image
        userPhoto = (CircleImageView) findViewById(R.id.user_image);

        userPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= 22){

                    checkAndRequestForPermission();
                }
                else{

                    openAlbums();

                }
            }
        });

        userName.startAnimation(btgone);
        userEmail.startAnimation(btgone);
        userPassword.startAnimation(btgone);
        userPAssword2.startAnimation(btgone);
        userPhoto.startAnimation(atg);
        regButton.startAnimation(btgtwo);
    }

    private void CreateUserAccount(final String email, final String name, String password) {
        // Create USer Account using Details

        mAuth.createUserWithEmailAndPassword(email,password).
                addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            barLogin.setVisibility(View.VISIBLE);
                            regButton.setVisibility(View.VISIBLE);
                            showMessage("Accounted Created");
                            updateUserInfo( name,email, pickedImage,mAuth.getCurrentUser());

                        }
                        else{

                            showMessage("account  creation Failed" + task.getException().getMessage());
                            regButton.setVisibility(View.VISIBLE);
                        }
                    }
                });

    }





    //  *************************        Update Information of the current User
    private void updateUserInfo(final String name,final String email, final Uri pickedImage, final FirebaseUser currentUser) {

        StorageReference mStorage = FirebaseStorage.getInstance().getReference().child("user_photos");
        final StorageReference imageFilePath = mStorage.child(pickedImage.getLastPathSegment());
        imageFilePath.putFile(pickedImage).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                imageFilePath.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {

                        UserProfileChangeRequest profileUpdate = new UserProfileChangeRequest.Builder()
                                .setDisplayName(email)
                                .setDisplayName(name)
                                .setPhotoUri(uri)
                                .build();

                        currentUser.updateProfile(profileUpdate).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    showMessage("Register Complete");
                                    updateUI();

                                }
                                else{

                                }

                            }
                        });


                    }
                });

            }
        });

    }

    private void updateUI() {

        Intent loginActivity = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(loginActivity);
        finish();


    }

    // Toast for incomplete Fields
    private void showMessage(String message) {

        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();

    }



    private void checkAndRequestForPermission() {
        if(ContextCompat.checkSelfPermission(RegisterActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(RegisterActivity.this,Manifest.permission.READ_EXTERNAL_STORAGE))
            {
                Toast.makeText(RegisterActivity.this, "Please except the Required Permission", Toast.LENGTH_SHORT).show();
            }

            else
            {
                ActivityCompat.requestPermissions(RegisterActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},PReqCode);

            }
        }
        else
            openAlbums();
    }

    private void openAlbums() {
        // Wait For user to select Image
        Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent,REQUESCODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == REQUESCODE && data != null){

            // imported Image

            pickedImage = data.getData();
            userPhoto.setImageURI(pickedImage);


        }
    }
}

