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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class BloodVolume extends AppCompatActivity {


    EditText ed_bloodheight , ed_bloodweight;
    Button btn_cal, btn_res;
    RadioGroup radioGroup;
    RadioButton radioButtonMale, radioButtonFemale;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_volume);


        ed_bloodheight = findViewById(R.id.ed_bloodHeight);
        ed_bloodweight = findViewById(R.id.ed_bloodWeight);
        btn_cal = findViewById(R.id.btn_bloodcal);
        btn_res = findViewById(R.id.btn_bloodreset);
        radioGroup = findViewById(R.id.RadioGroup);



        // calling the action bar
        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);
        // Define ColorDrawable object and parse color
        // using parseColor method
        // with color hash code as its parameter

        actionBar.setTitle("Blood Volume");

        btn_res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ed_bloodheight.getText().clear();
               ed_bloodweight.getText().clear();


            }
        });



        btn_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String sheight = ed_bloodheight.getText().toString();
                String sweight = ed_bloodweight.getText().toString();


                if (sheight.length() >0 && sweight.length()>0 ) {



                    Dialog dialog = new Dialog(BloodVolume.this);
                    dialog.setContentView(R.layout.dia_result);

                    TextView Dia_score = dialog.findViewById(R.id.di_score);
                    TextView dia_result = dialog.findViewById(R.id.dia_result);
                    TextView dia_position = dialog.findViewById(R.id.dia_position);
                    TextView dia_tips = dialog.findViewById(R.id.dia_tips);
                    Button btn_back = dialog.findViewById(R.id.btn_back);


                    int selecteditemid = radioGroup.getCheckedRadioButtonId();



                    float fheight = Float.parseFloat(sheight);

                    float fweight = Float.parseFloat(sweight);

                    float Meter = fheight/100;

                    switch (selecteditemid) {


                        case (R.id.blood_male_button):

                            float bloodresult = (float) (0.3669 * Meter* Meter* Meter + 0.03219 * fweight + 0.6041);
                            String bloodvolume = String.format("%.02f", bloodresult);
                            Dia_score.setText("Your total blood volume is");
                            dia_result.setText("" + bloodvolume);
                            dia_position.setText("Liters");
                            dia_tips.setText("Preoperative assessment of estimated blood volume is essential for patients undergoing surgery. It impacts perfusion care , including hemodynamic and pharmacologic interventions , and transfusion practices.");


                            break;


                        case (R.id.blood_female_button):

                            float bloodresult1 = (float) (0.3561 * Meter* Meter* Meter + 0.03308 * fweight + 0.1833);
                            String bloodvolume2 = String.format("%.02f", bloodresult1);
                            Dia_score.setText("Your total blood volume is");
                            dia_result.setText("" + bloodvolume2);
                            dia_position.setText("Liters");
                            dia_tips.setText("Preoperative assessment of estimated blood volume is essential for patients undergoing surgery. It impacts perfusion care , including hemodynamic and pharmacologic interventions , and transfusion practices.");
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


                    Toasty.info(BloodVolume.this, "Please enter valid values", Toast.LENGTH_SHORT).show();

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


                Dialog dialog = new Dialog(BloodVolume.this);
                dialog.setContentView(R.layout.info);
                TextView title = dialog.findViewById(R.id.tv_title);
                TextView dis = dialog.findViewById(R.id.tv_Dis);
                Button btnback = dialog.findViewById(R.id.btn_back2);

                title.setText("Blood Volume");
                dis.setText("Our blood volume calculator uses three methods to determine the total blood volume. The first uses Dr. Nadler's formula; the second is an equation developed by Dr. Lemmens, Dr. Bernstein, and Dr. Brodsky.");


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