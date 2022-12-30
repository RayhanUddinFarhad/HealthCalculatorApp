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
import android.widget.TextView;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class Bmi_Calculator extends AppCompatActivity {


    EditText ed_age, ed_feet, ed_inch, ed_weight;
    Button btn_calculate, btn_reset;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calculator);








        ed_age = findViewById(R.id.ed_age);
        ed_feet = findViewById(R.id.ed_feet);
        ed_inch = findViewById(R.id.ed_inch);
        ed_weight = findViewById(R.id.ed_kg);
        btn_calculate = findViewById(R.id.btn_BMI_Calculate);
        btn_reset = findViewById(R.id.btn_BMI_Reset);




        // calling the action bar
        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);

        actionBar.setTitle("BMI Calculator");




        // this event will enable the back
        // function to the button on press



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
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {








                String Sage = ed_age.getText().toString();
                String ssfeet = ed_feet.getText().toString();
                String ssinch = ed_inch.getText().toString();
                String ssweight = ed_weight.getText().toString();


                if (ssweight.length() >0 && ssfeet.length()>0 && ssinch.length()>0 ) {

                    Dialog dialog = new Dialog(Bmi_Calculator.this);
                    dialog.setContentView(R.layout.dia_result);

                    TextView dialouge_score = dialog.findViewById(R.id.di_score);
                    TextView dialouge_result = dialog.findViewById(R.id.dia_result);
                    TextView dialouge_position = dialog.findViewById(R.id.dia_position);
                    TextView dialouge_tips = dialog.findViewById(R.id.dia_tips);
                    Button btn_back = dialog.findViewById(R.id.btn_back);


                    float fage = Float.parseFloat(Sage);


                    float fweight = Float.parseFloat(ssweight);
                    float ffeet = Float.parseFloat(ssfeet);
                    float finch = Float.parseFloat(ssinch);

                    float resultheight = (float) (ffeet*0.3048 + finch*0.0254);

                    float bmiindex = fweight/ (resultheight*resultheight);





                    if (bmiindex<=18.5) {

                        String bmiindex2 = String.format("%.02f", bmiindex);


                        dialouge_result.setText(" " +bmiindex2 );
                        dialouge_position.setText("Underweight");
                        dialouge_result.setTextColor(Color.parseColor("#D51A1A"));
                        dialouge_position.setTextColor(Color.parseColor("#D51A1A"));
                        dialouge_tips.setText("Having BMI below 18.5 indicates that you are Feathery , so you are recommended to get admonishment from your doctor or reflexologist about gaining some weight.");


                    }

                    else if (bmiindex< 25) {
                        String bmiindex2 = String.format("%.02f", bmiindex);



                        dialouge_result.setText(" " + bmiindex2 );
                        dialouge_result.setTextColor(Color.parseColor("#3F51B5"));
                        dialouge_position.setTextColor(Color.parseColor("#3F51B5"));
                        dialouge_position.setText("Healthy weight");
                        dialouge_tips.setText("Bravo!! Your BMI score shows how healthy and fit you are correlating to your height . Maintaining your weight keeps you away from serious health related problems.");
                    }

                    else if (bmiindex<30){

                        String bmiindex2 = String.format("%.02f", bmiindex);
                        dialouge_result.setTextColor(Color.parseColor("#D51A1A"));
                        dialouge_position.setTextColor(Color.parseColor("#D51A1A"));


                        dialouge_result.setText(" " + bmiindex2 );

                        dialouge_position.setText("Overweight");
                        dialouge_tips.setText("If you are overweight or obese, even a small weight loss (10% of your current weight) can lower your risk of several diseases. ");


                    }


                    else if (bmiindex>30){

                        String bmiindex2 = String.format("%.02f", bmiindex);


                        dialouge_result.setText(" " + bmiindex2 );
                        dialouge_result.setTextColor(Color.parseColor("#D51A1A"));
                        dialouge_position.setTextColor(Color.parseColor("#D51A1A"));

                        dialouge_position.setText("Obesity");
                        dialouge_tips.setText("If you are overweight or obese, even a small weight loss (10% of your current weight) can lower your risk of several diseases. ");
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


                    Toasty.info(Bmi_Calculator.this, "Please enter valid values", Toast.LENGTH_SHORT).show();

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

                Dialog dialog = new Dialog(Bmi_Calculator.this);
                dialog.setContentView(R.layout.info);
                TextView title = dialog.findViewById(R.id.tv_title);
                TextView dis = dialog.findViewById(R.id.tv_Dis);
                Button btnback = dialog.findViewById(R.id.btn_back2);


                title.setText("BMI Calculator");
                dis.setText("The BMI calculator is a useful tool that measures whether you are overweight, underweight, or just right. \n Your weight alone is not enough to tell, as a tall, skinny man may easily weigh more than a short but rotund woman. \n  The body mass index, or BMI, overcomes this problem by finding a ratio of your weight to your height, and returning a single number. \n This number will fit into a category on the scale of BMI ranges, which are defined as underweight, normal, overweight, and obese.");


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