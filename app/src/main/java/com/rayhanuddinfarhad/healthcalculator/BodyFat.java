package com.rayhanuddinfarhad.healthcalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class BodyFat extends AppCompatActivity {

    EditText ed_age, ed_feet, ed_inch, ed_weight;
    Button btn_calculate, btn_reset;

    RadioGroup radioGroup;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_fat);



        ed_age = findViewById(R.id.ed_bodyfatAge);
        ed_feet = findViewById(R.id.ed_bodyfatfeet);
        ed_inch = findViewById(R.id.ed_bodyfatinch);
        ed_weight = findViewById(R.id.ed_bodyfatkg);
        btn_calculate = findViewById(R.id.btn_bodyfat_Calculate);
        btn_reset = findViewById(R.id.btn_bodyfat_Reset);
        radioGroup = findViewById(R.id.RadioGroupFat);


        // calling the action bar
        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);

        actionBar.setTitle("Body Fat Calculator");


        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ed_age.getText().clear();
                ed_feet.getText().clear();
                ed_inch.getText().clear();
                ed_weight.getText().clear();


            }
        });

        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {





                String Sage = ed_age.getText().toString();
                String ssfeet = ed_feet.getText().toString();
                String ssinch = ed_inch.getText().toString();
                String ssweight = ed_weight.getText().toString();


                if (ssweight.length() >0 && ssfeet.length()>0 && ssinch.length()>0 ) {





                    Dialog dialog = new Dialog(BodyFat.this);
                    dialog.setContentView(R.layout.dia_result);

                    TextView dialouge_score = dialog.findViewById(R.id.di_score);
                    TextView dialouge_result = dialog.findViewById(R.id.dia_result);
                    TextView dialouge_position = dialog.findViewById(R.id.dia_position);
                    TextView dialouge_tips = dialog.findViewById(R.id.dia_tips);
                    Button btn_back = dialog.findViewById(R.id.btn_back);
                    int selecteditemid = radioGroup.getCheckedRadioButtonId();
                    dialouge_score.setText("Your Average Body Fat Is ");
                    dialouge_tips.setText("This calculator's results are based on the BMI - they may be inaccurate if you're pregnant or if you have high muscle mass.");



                    float fage = Float.parseFloat(Sage);


                    float fweight = Float.parseFloat(ssweight);
                    float ffeet = Float.parseFloat(ssfeet);
                    float finch = Float.parseFloat(ssinch);

                    float resultheight = (float) (ffeet*0.3048 + finch*0.0254);

                    float BMI = fweight/ (resultheight*resultheight);




                    switch (selecteditemid) {



                        case (R.id.Fat_male_button):


                            float BodyFatFormale = (float) (-44.988 + (0.503 * fage) + (10.689 * 0) + (3.172 * BMI) - (0.026 * BMI*BMI) + (0.181 * BMI * 0) - (0.02 * BMI * fage) - (0.005 * BMI*BMI * 0) + (0.00021 * BMI*BMI * fage));
                            dialouge_result.setText("");


                            String bodyFat = String.format("%.01f", BodyFatFormale);

                            dialouge_result.setText(bodyFat + "%");


                            if (BodyFatFormale<2) {

                                dialouge_position.setText("Extremely low level");
                                dialouge_result.setTextColor(Color.parseColor("#D51A1A"));
                                dialouge_position.setTextColor(Color.parseColor("#D51A1A"));
                            }

                            else if (BodyFatFormale>2 && BodyFatFormale<=5 ) {

                                dialouge_position.setText("Essential Fat");
                            }
                            else if (BodyFatFormale>6 && BodyFatFormale<=13 ) {

                                dialouge_position.setText("Athletes");
                            }

                            else if (BodyFatFormale>14 && BodyFatFormale<=17) {

                                dialouge_position.setText("Fitness");
                                dialouge_result.setTextColor(Color.parseColor("#3F51B5"));
                                dialouge_position.setTextColor(Color.parseColor("#3F51B5"));




                            }




                            else if (BodyFatFormale>25) {


                                dialouge_position.setText("Obese");
                                dialouge_result.setTextColor(Color.parseColor("#D51A1A"));
                                dialouge_position.setTextColor(Color.parseColor("#D51A1A"));
                            }

                            else   {

                                dialouge_position.setText("Average");
                                dialouge_result.setTextColor(Color.parseColor("#D51A1A"));
                                dialouge_position.setTextColor(Color.parseColor("#D51A1A"));




                            }


                            break;



                        case (R.id.Fat_female_button):


                            float BodyFatForFmale = (float) (-44.988 + (0.503 * fage) + (10.689 * 1) + (3.172 * BMI) - (0.026 * BMI*BMI) + (0.181 * BMI * 1) - (0.02 * BMI * fage) - (0.005 * BMI*BMI * 1) + (0.00021 * BMI*BMI * fage));
                            dialouge_result.setText("");


                            String bodyFat2 = String.format("%.01f", BodyFatForFmale);

                            dialouge_result.setText(bodyFat2 + "%");


                            if (BodyFatForFmale<10) {

                                dialouge_position.setText("Extremely low level");
                            }

                            else if (BodyFatForFmale>=10 && BodyFatForFmale<=13 ) {

                                dialouge_position.setText("Essential Fat");
                            }
                            else if (BodyFatForFmale>14 && BodyFatForFmale<=20 ) {

                                dialouge_position.setText("Athletes");
                            }

                            else if (BodyFatForFmale>21 && BodyFatForFmale<=24) {

                                dialouge_position.setText("Fitness");




                            }




                            else if (BodyFatForFmale>32) {


                                dialouge_position.setText("Obese");
                            }

                            else   {

                                dialouge_position.setText("Average");




                            }


                            break;









                    }


dialog.show();
                    btn_back.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                        }
                    });



                }


                else {


                    Toasty.info(BodyFat.this, "Please enter valid values", Toast.LENGTH_SHORT).show();

                }



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
            case android.R.id.home:
                this.finish();
                return true;


            case  R.id.info:


                Dialog dialog = new Dialog(BodyFat.this);
                dialog.setContentView(R.layout.info);
                TextView title = dialog.findViewById(R.id.tv_title);
                TextView dis = dialog.findViewById(R.id.tv_Dis);
                Button btnback = dialog.findViewById(R.id.btn_back2);


                title.setText("Body Fat Size ");
                dis.setText("This body fat calculator is a tool designed to help you estimate what percentage of your total body weight is body fat. If you ever wondered what is your body fat percentage, this is a perfect place to find out. We will explain to you in detail not only what is the importance of this information, but also how to calculate your body fat (including some alternative methods for measuring it) and give you some general guidelines regarding reducing your body fat.");


                dialog.show();

                btnback.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });


        }
        return super.onOptionsItemSelected(item);
    }
}