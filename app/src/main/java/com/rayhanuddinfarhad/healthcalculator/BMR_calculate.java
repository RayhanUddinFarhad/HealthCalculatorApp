package com.rayhanuddinfarhad.healthcalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class BMR_calculate extends AppCompatActivity {

    EditText ed_bmryear, ed_bmr_height, ed_bmrWeight;
    Button bmrcal, bmrreset;
    Spinner spgender;
    RadioGroup radioGroup;
    RadioButton radioButtonMale, radioButtonFemale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmr_calculate);


        ed_bmryear = findViewById(R.id.ed_bmryear);
        ed_bmr_height = findViewById(R.id.ed_bmrheight);
        ed_bmrWeight = findViewById(R.id.ed_bmrweight);
        bmrcal = findViewById(R.id.btn_bmrcal);
        radioGroup = findViewById(R.id.RadioGroup);
        radioButtonMale = findViewById(R.id.male_button);
        radioButtonFemale = findViewById(R.id.female_button);
        bmrreset = findViewById(R.id.btn_bmrreset);


        // calling the action bar
        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);

        actionBar.setTitle("BMR Calculator");





        bmrreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ed_bmryear.getText().clear();
                ed_bmr_height.getText().clear();
                ed_bmrWeight.getText().clear();


            }
        });


bmrcal.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {




        String age = ed_bmryear.getText().toString();
        String height = ed_bmr_height.getText().toString();
        String weight = ed_bmrWeight.getText().toString();


        if (age.length() >0 && height.length()>0 && weight.length()>0 ) {

            Dialog dialog = new Dialog(BMR_calculate.this);
            dialog.setContentView(R.layout.dia_result);

            TextView Dia_score = dialog.findViewById(R.id.di_score);
            TextView dia_result = dialog.findViewById(R.id.dia_result);
            TextView dia_position = dialog.findViewById(R.id.dia_position);
            TextView dia_tips = dialog.findViewById(R.id.dia_tips);
            Button btn_back = dialog.findViewById(R.id.btn_back);


            int selecteditemid = radioGroup.getCheckedRadioButtonId();

            float fyear = Float.parseFloat(age);

            float fheight = Float.parseFloat(height);

            float fweight = Float.parseFloat(weight);


            switch (selecteditemid) {


                case(R.id.male_button):


                    float maleBMIresult = (float) (66.47 + (13.75 * fweight) + (5.003 *fheight ) - (6.755 * fyear ));
                    String Bmiresult2 = String.format("%.02f", maleBMIresult);


                    Dia_score.setText("Your basal metabolic rate is");


                    dia_result.setText("" +Bmiresult2);
                    dia_position.setText("Kcal/day");
                    dia_tips.setText(" This BMR Calculator is a simple tool that helps you calculate how many calories your body needs if yu were only to rest for the hole day.");


                    break;


                case(R.id.female_button):


    float femaleBMIresult = (float) (655.1 + (9.563 * fweight ) + (1.85 *fheight) - (4.676 * fyear));


    String Bmiresult3 = String.format("%.02f", femaleBMIresult);


    Dia_score.setText("Your basal metabolic rate is");


    dia_result.setText("" +Bmiresult3);
    dia_position.setText("Kcal/day");
    dia_tips.setText(" This BMR Calculator is a simple tool that helps you calculate how many calories your body needs if yu were only to rest for the hole day.");

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


            Toasty.info(BMR_calculate.this, "Please enter valid values", Toast.LENGTH_SHORT).show();

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



                Dialog dialog = new Dialog(BMR_calculate.this);
                dialog.setContentView(R.layout.info);
                TextView title = dialog.findViewById(R.id.tv_title);
                TextView dis = dialog.findViewById(R.id.tv_Dis);
                Button btnback = dialog.findViewById(R.id.btn_back2);

                title.setText("BMR Calculator");
                dis.setText("This BMR Calculator is a simple tool that helps you calculate how many calories your body needs if you were only to rest for the whole day. \n Based on your age, height, weight, and gender, the Basal Metabolic Rate Calculator returns your BMR score.");


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