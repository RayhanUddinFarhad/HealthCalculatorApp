package com.rayhanuddinfarhad.healthcalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class Water_intake extends AppCompatActivity {


    EditText ed_wage , ed_wweight;

    Button btn_cal , btn_reset;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_intake);



        ed_wage = findViewById(R.id.ed_wateage);
        ed_wweight = findViewById(R.id.ed_waterkg);
        btn_cal = findViewById(R.id.btn_wcal);
        btn_reset = findViewById(R.id.btn_wreset);



        // calling the action bar
        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);
        // Define ColorDrawable object and parse color
        // using parseColor method
        // with color hash code as its parameter

        actionBar.setTitle("Water Intake");













        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ed_wage.getText().clear();
                ed_wweight.getText().clear();


            }
        });



        btn_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String age = ed_wage.getText().toString();
                String weight = ed_wweight.getText().toString();





                if (age.length() >0  && weight.length()>0 ) {








                    Dialog dialog = new Dialog(Water_intake.this);
                    dialog.setContentView(R.layout.dia_result);

                    TextView Dia_score = dialog.findViewById(R.id.di_score);
                    TextView dia_result = dialog.findViewById(R.id.dia_result);
                    TextView dia_position = dialog.findViewById(R.id.dia_position);
                    TextView dia_tips = dialog.findViewById(R.id.dia_tips);
                    Button btn_back = dialog.findViewById(R.id.btn_back);



                    float fyear = Float.parseFloat(age);


                    float fweight = Float.parseFloat(weight);

                    float waterneed = (float) (fweight*0.033);

                    String waterresult = String.format("%.02f", waterneed);

                    Dia_score.setText("Your daily water requirement is ");
                    dia_result.setText("" +waterresult);
                    dia_position.setText("Litres ");
                    dia_tips.setText("Take more litres of water additionally if you exercise or if your environtmental conditions are hot.");
















dialog.show();
btn_back.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        dialog.dismiss();
    }
});



                }


                else {


                    Toasty.info(Water_intake.this, "Please enter valid values", Toast.LENGTH_SHORT).show();

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


                Dialog dialog = new Dialog(Water_intake.this);
                dialog.setContentView(R.layout.info);
                TextView title = dialog.findViewById(R.id.tv_title);
                TextView dis = dialog.findViewById(R.id.tv_Dis);
                Button btnback = dialog.findViewById(R.id.btn_back2);

                title.setText("Water Intake");
                dis.setText("This water intake calculator will help you to estimate your adequate water intake per day. Whether you want to check daily water intake for an adult, teen, child, or even infant, this hydration calculator can do it in no time.");


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