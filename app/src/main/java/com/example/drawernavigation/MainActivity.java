package com.example.drawernavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.Toast;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity   {
    public DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    FrameLayout frameLayout;
    Fragment fragment = null;
    BottomNavigationView bottomNavigation;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    private MenuItem item;
    private FragmentManager fragmentManager;


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.nav_header);
        frameLayout = findViewById(R.id.frameLayout);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        bottomNavigation = findViewById(R.id.bottomNavigation);
//        bottomNavigation.setOnNavigationItemSelectedListener(this);
//        bottomNavigation.setSelectedItemId(R.id.product);

        fragmentManager = getSupportFragmentManager();

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.Profile:
                       // Toast.makeText(MainActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        fragment = new Profile();
                        if (fragment != null)
                        {
                            FragmentManager fragmentManager = getSupportFragmentManager();
                            fragmentManager.beginTransaction().replace(R.id.frameLayout, fragment).addToBackStack(null).commit();
                        }   break;
                    case R.id.Support:

                        drawerLayout.closeDrawer(GravityCompat.START);
                        fragment = new SupportScreen();
                        if (fragment != null)
                        {
                            FragmentManager fragmentManager = getSupportFragmentManager();
                            fragmentManager.beginTransaction().replace(R.id.frameLayout, fragment).addToBackStack(null).commit();
                        }
                        break;
                    case R.id.Contact:
                       // Toast.makeText(MainActivity.this, "Contact", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        fragment = new ContactUs();

                        if (fragment != null)
                        {
                            FragmentManager fragmentManager = getSupportFragmentManager();
                            fragmentManager.beginTransaction().replace(R.id.frameLayout, fragment).addToBackStack(null).commit();
                        }
                        break;
                    case R.id.Condition:
//                        Toast.makeText(MainActivity.this, "Condition", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        fragment = new TermNCondition();

                        if (fragment != null)
                        {
                            FragmentManager fragmentManager = getSupportFragmentManager();
                            fragmentManager.beginTransaction().replace(R.id.frameLayout, fragment).addToBackStack(null).commit();
                        }
                        break;
                    case R.id.About:

                        drawerLayout.closeDrawer(GravityCompat.START);
                        fragment = new AboutUsFragment();

                        if (fragment != null)
                        {
                            FragmentManager fragmentManager = getSupportFragmentManager();
                            fragmentManager.beginTransaction().replace(R.id.frameLayout, fragment).addToBackStack(null).commit();
                        }                        break;
                    case R.id.Sharing:
                        //Toast.makeText(MainActivity.this, "Sharing", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        fragment = new Sharing_Fragment();
                        if (fragment != null)
                        {
                            FragmentManager fragmentManager1 = getSupportFragmentManager();
                            fragmentManager1.beginTransaction().replace(R.id.frameLayout, fragment).commit();
                        }
                        break;
                    case R.id.wishList:
                        //Toast.makeText(MainActivity.this, "Sharing", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent = new Intent(getApplicationContext(),FavoriteList.class);
                        startActivity(intent);

                        break;
                    case R.id.Logout:

                        drawerLayout.closeDrawer(GravityCompat.START);
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage("Are you sure you want to logout this app ?");
                        builder.setCancelable(false);
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                dialogInterface.cancel();
                            }
                        }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();

                        break;


                }
                return false;
            }
        });


        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.product:
                        fragment  = new Product_Fragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).commit();
                        return true;

                    case R.id.fruit:
                        fragment = new Fruit_Fragment();
                         getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).commit();
                        return true;

                    case R.id.food:
                        fragment = new Food_Fragment();
                         getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).commit();
                        return true;

                    case R.id.vegetable:
                        fragment= new Vegetable_Fragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).commit();
                        return true;
                }
                return false;
            }
        });

    }



//    private void getDynamicLinkFromFirebase() {
//        FirebaseDynamicLinks.getInstance()
//                .getDynamicLink(getIntent())
//                .addOnSuccessListener(this, new OnSuccessListener<PendingDynamicLinkData>() {
//                    @Override
//                    public void onSuccess(PendingDynamicLinkData pendingDynamicLinkData) {
//                        // Get deep link from result (may be null if no link is found)
//                        Log.i("MainActivity","We have a dynamic link");
//                        Uri uri = Uri.parse("http://drawernavigation.com/link/id");
//                        String lastPathSegment = uri.getLastPathSegment();
//                        System.out.println(lastPathSegment);
//                        if (pendingDynamicLinkData != null) {
//                            uri = pendingDynamicLinkData.getLink();
//                        }
//                        if(uri!=null)
//                        {
//                            Log.i("MainActivity","Here the Dynamic link \n"+uri.toString());
////
////                            String email = uri.getQueryParameter("email");
////                            String password = uri.getQueryParameter("password");
//
//
//                        }
//
//                    }
//                })
//                .addOnFailureListener(this, new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//    }
//     int count =0;
//    @Override
//    public void onBackPressed() {
//
//
//        super.onBackPressed();
//    }

//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//        switch (item.getItemId()) {
//            case R.id.product:
//               fragment  = new Product_Fragment();
//               int Fragment1= getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).commit();
//                return true;
//
//            case R.id.fruit:
//                fragment = new Fruit_Fragment();
//                int Fragment2= getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).commit();
//                return true;
//
//            case R.id.food:
//                fragment = new Food_Fragment();
//                int Fragment3=  getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).commit();
//                return true;
//
//            case R.id.vegetable:
//                fragment= new Vegetable_Fragment();
//                int Fragment4 =getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).commit();
//                return true;
//        }
//        return false;
//    }

}