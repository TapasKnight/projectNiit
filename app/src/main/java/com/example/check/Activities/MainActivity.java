package com.example.check.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.check.Fragments.AboutFragment;
import com.example.check.Fragments.BookFragment;
import com.example.check.Fragments.ActivityFragment;
import com.example.check.Fragments.ProfileFragment;
import com.example.check.Fragments.TherapistFragment;
import com.example.check.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FirebaseUser currentUser;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        ///  *************Default Fragment

        FragmentTransaction tx =getSupportFragmentManager().beginTransaction();
        tx.replace(R.id.container, new ActivityFragment());
        tx.commit();


        // initialize
        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "You Application is up to date", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

         onNavigationItemSelected(navigationView.getMenu().findItem(R.id.nav_Activities));

        updateNavHeader();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        int id = item.getItemId();
        if (id == R.id.nav_Activities) {
            getSupportActionBar().setTitle("Activity");
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new ActivityFragment()).commit();
        } else if (id == R.id.nav_profile) {
            getSupportActionBar().setTitle("Profile");
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new ProfileFragment()).commit();

        }  else if (id == R.id.nav_logout) {

            FirebaseAuth.getInstance().signOut();
            Intent loginActivity = new Intent(this,LoginActivity.class);
            startActivity(loginActivity);
            finish();

        } else if (id == R.id.nav_aboutus){
            getSupportActionBar().setTitle("About Us");
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new AboutFragment()).commit();

        }
        else if(id == R.id.nav_books){
            getSupportActionBar().setTitle("Library");
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new BookFragment()).commit();

        }
        else if(id == R.id.nav_Therapist){
            getSupportActionBar().setTitle("Therapists");
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new TherapistFragment()).commit();



        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void updateNavHeader(){

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        TextView navUserName = headerView.findViewById(R.id.nav_user_name);
        TextView navUserEmail = headerView.findViewById(R.id.nav_user_mail);
        CircleImageView navUserPhoto = headerView.findViewById(R.id.nav_user_photo);


        navUserEmail.setText(currentUser.getEmail());
        navUserName.setText(currentUser.getDisplayName());
        navUserPhoto.setImageURI(currentUser.getPhotoUrl());


        //  use glide to load user Image
        //glide liabraries

        Glide.with(this).load(currentUser.getPhotoUrl()).into(navUserPhoto);




    }



}
