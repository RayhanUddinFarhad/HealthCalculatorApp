package com.rayhanuddinfarhad.healthcalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
NavigationView navigationView;

    CardView c_bmi, c_BMR, c_waterintake, c_bloodvolume, c_bodyframe, c_bodyfat, c_waisttohip, c_waistToHeight, c_leanbody;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        navigationView = findViewById(R.id.navigation_view);



        c_bmi = findViewById(R.id.BMI_Calculator);
        c_BMR = findViewById(R.id.card_Bmr_cal);
        c_waterintake = findViewById(R.id.card_waterintake);
        c_bloodvolume = findViewById(R.id.Card_bloodvolume);
        c_bodyframe = findViewById(R.id.Card_bodyframe);
        c_bodyfat = findViewById(R.id.Card_bodyfat);
        c_waisttohip = findViewById(R.id.Card_waistTohip);
        c_waistToHeight = findViewById(R.id.Card_waistToHeight);
        c_leanbody = findViewById(R.id.Card_leanbody);



        c_leanbody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LeamBodyMass.class));
            }
        });



        c_waistToHeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, WistToHeight.class));
            }
        });

        c_waisttohip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, WaistToHip.class));
            }
        });


        c_bodyfat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BodyFat.class));
            }
        });


        c_bodyframe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BodyFrame.class));
            }
        });


        c_bloodvolume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BloodVolume.class));
            }
        });



        c_waterintake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Water_intake.class));
            }
        });


        c_BMR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BMR_calculate.class));
            }
        });


        c_bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Bmi_Calculator.class));
            }
        });


        // drawer layout instance to toggle the menu icon to open
        // drawer and back button to close drawer
        drawerLayout = findViewById(R.id.mydrawer_layout);
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


                int id = item.getItemId();





                if (id==R.id.ShareApp) {

                    Intent sharingIntent = new Intent(Intent.ACTION_SEND);

                    // type of the content to be shared
                    sharingIntent.setType("text/plain");

                    // Body of the content
                    String shareBody = "https://play.google.com/store/apps/details?id=com.rayhanuddinfarhad.healthcalculator";

                    // subject of the content. you can share anything
                    String shareSubject = "Share to your friends";

                    // passing body of the content
                    sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);

                    // passing subject of the content
                    sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
                    startActivity(Intent.createChooser(sharingIntent, "Share using"));

                }

                else if (id==R.id.MoreApp) {

                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=Rayhan+Uddin+Farhad")));


                }







                else if (id==R.id.RateMe) {

                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.rayhanuddinfarhad.healthcalculator")));


                }



                else if (id==R.id.privicy) {

                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://sites.google.com/view/healthcalculatorbd/home")));




                }















                drawerLayout.closeDrawer(GravityCompat.START);








                return true;
            }
        });


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.info, menu);

        // first parameter is the file for icon and second one is menu







        return super.onCreateOptionsMenu(menu);
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


            switch (item.getItemId()) {



                case  R.id.info:


                    Dialog dialog = new Dialog(MainActivity.this);
                    dialog.setContentView(R.layout.info);
                    TextView title = dialog.findViewById(R.id.tv_title);
                    TextView dis = dialog.findViewById(R.id.tv_Dis);
                    Button btnback = dialog.findViewById(R.id.btn_back2);


                    title.setText("Health Calculators");
                    dis.setText("Welcome To Health Calculator App! \n \n   Whether you are a doctor, a medical student or a patient, you will find answers to your medical questions here, as well as receive a lot of scientifically proven information. \n  You can Calculate accurately BMI , BMR, Body Frame Size,Body Fat Calculator. You can also know your Blood Volume here. \n  It will be update and will be add a lot of new features.  \n These are just a few examples of what you can learn! CURB-65 and MELD Score sound strange to you? Health Calculator App will explain these terms and help you determine your own result! Don’t hesitate, solve your medical issues with us!");
dialog.show();

btnback.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        dialog.dismiss();
    }
});

            }


        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }





}
