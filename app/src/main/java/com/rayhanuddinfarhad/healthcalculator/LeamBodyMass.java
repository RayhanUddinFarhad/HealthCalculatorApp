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

public class LeamBodyMass extends AppCompatActivity {




    EditText ed_height , ed_weight;
    Button btn_cal, btn_res;
    RadioGroup radioGroup;
    RadioButton radioButtonMale, radioButtonFemale;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leam_body_mass);

        ed_height = findViewById(R.id.ed_LBMheight);
        ed_weight = findViewById(R.id.ed_LbmWeight);
        btn_cal = findViewById(R.id.btn_LBMcal);
        btn_res = findViewById(R.id.btn_LBMreset);
        radioGroup = findViewById(R.id.Lbm_RadioGroup);


        // calling the action bar
        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);
        // Define ColorDrawable object and parse color
        // using parseColor method
        // with color hash code as its parameter

        actionBar.setTitle("Lean Body Mass");


        btn_res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ed_height.getText().clear();
                ed_weight.getText().clear();


            }
        });


        btn_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sheight = ed_height.getText().toString();
                String sweight = ed_weight.getText().toString();








                if (sheight.length() >0 && sweight.length()>0 ) {


                    Dialog dialog = new Dialog(LeamBodyMass.this);
                    dialog.setContentView(R.layout.dia_result);

                    TextView Dia_score = dialog.findViewById(R.id.di_score);
                    TextView dia_result = dialog.findViewById(R.id.dia_result);
                    TextView dia_position = dialog.findViewById(R.id.dia_position);
                    TextView dia_tips = dialog.findViewById(R.id.dia_tips);
                    Button btn_back = dialog.findViewById(R.id.btn_back);
                    Dia_score.setText("Your lean body mass is");
                    dia_position.setVisibility(View.GONE);
                    dia_tips.setVisibility(View.GONE);


                    int selecteditemid = radioGroup.getCheckedRadioButtonId();



                    float fheight = Float.parseFloat(sheight);

                    float fweight = Float.parseFloat(sweight);


                    switch (selecteditemid) {


                        case (R.id.Lbm_male_button):

                            float lbm = (float) (0.407 * fweight + 0.267 * fheight - 19.2);
                            String malelbm = String.format("%.02f", lbm);
                            dia_result.setText("" +malelbm);


                            break;


                        case (R.id.Lbm_female_button):

                            float lbm1 = (float) (0.252 * fweight + 0.473 * fheight - 48.3);
                            String femalelbm = String.format("%.02f", lbm1);
                            dia_result.setText("" +femalelbm);


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


                    Toasty.info(LeamBodyMass.this, "Please enter valid values", Toast.LENGTH_SHORT).show();

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


                Dialog dialog = new Dialog(LeamBodyMass.this);
                dialog.setContentView(R.layout.info);
                TextView title = dialog.findViewById(R.id.tv_title);
                TextView dis = dialog.findViewById(R.id.tv_Dis);
                Button btnback = dialog.findViewById(R.id.btn_back2);

                title.setText("Lean Body Mass ");
                dis.setText("Lean body mass is what your body would weight if you didn't have any body fat; that means it counts all the organs, bones, muscles, blood and skin, and everything else which is not fat but has mass.\n" +
                        "\n" +
                        "It is particularly important to know your lean body mass if you are trying to lose weight. By watching your LBM you can monitor how much muscle you are losing. If you are only losing the muscle, the effect of your diet may be very disappointing, as losing muscle very often results in unpleasant appearance. Knowing how to calculate your lean body mass also helps you decide how much fat you should lose and what your body fat percentage will be after that. It is much more accurate to consider your LBM than your body weight.");
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