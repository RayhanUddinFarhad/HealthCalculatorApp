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
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class WaistToHip extends AppCompatActivity {


    EditText ed_waist, ed_Hip;
    Button btn_cal, btn_reset;
    RadioGroup radioGroup;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waist_to_hip);



        ed_waist = findViewById(R.id.ed_waist);
        ed_Hip = findViewById(R.id.ed_hip);
        btn_cal = findViewById(R.id.btn_cal_waistToHip);
        btn_reset = findViewById(R.id.btn_res_waistToHip);
        radioGroup = findViewById(R.id.RadioGroupHip);

        // calling the action bar
        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);

        actionBar.setTitle("Waist Hip Ratio");


        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ed_waist.getText().clear();
                ed_Hip.getText().clear();



            }
        });


        btn_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                String Swaist = ed_waist.getText().toString();
                String Ship = ed_Hip.getText().toString();

                if (Swaist.length() >0 && Ship.length()>0 ) {




                    Dialog dialog = new Dialog(WaistToHip.this);
                    dialog.setContentView(R.layout.dia_result);

                    TextView dialouge_score = dialog.findViewById(R.id.di_score);
                    TextView dialouge_result = dialog.findViewById(R.id.dia_result);
                    TextView dialouge_position = dialog.findViewById(R.id.dia_position);
                    TextView dialouge_tips = dialog.findViewById(R.id.dia_tips);
                    Button btn_back = dialog.findViewById(R.id.btn_back);
                    dialouge_score.setText("Your waist-hip ratio");
                    dialouge_tips.setText("According to WHO, the best (i.e., related to low health risk)) WHR is below 0.95 for men and below 0.80 for women.");
                    int selecteditemid = radioGroup.getCheckedRadioButtonId();



                    float Waist = Float.parseFloat(Swaist);


                    float Hip = Float.parseFloat(Ship);



                    float ratio = Waist/Hip;
                    String Ratio = String.format("%.02f", ratio);

                    dialouge_result.setText("" +Ratio );



                    switch (selecteditemid){




                        case (R.id.Hip_male_button):

                        if (ratio<0.95) {



                            dialouge_position.setText("Low");



                        }

                        else if (ratio>0.96 && ratio<1.0) {


                            dialouge_position.setText("Moderate");
                        }

                        else {

                            dialouge_position.setText("High");
                        }

                        break;


                        case (R.id.Hip_female_button):

                            if (ratio<0.80) {



                                dialouge_position.setText("Low");



                            }

                            else if (ratio>0.81 && ratio<0.85) {


                                dialouge_position.setText("Moderate");
                            }

                            else {

                                dialouge_position.setText("High");
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


                    Toasty.info(WaistToHip.this, "Please enter valid values", Toast.LENGTH_SHORT).show();

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
                Dialog dialog = new Dialog(WaistToHip.this);
                dialog.setContentView(R.layout.info);
                TextView title = dialog.findViewById(R.id.tv_title);
                TextView dis = dialog.findViewById(R.id.tv_Dis);
                Button btnback = dialog.findViewById(R.id.btn_back2);

                title.setText("Waist Hip Ratio ");
                dis.setText("The waist-hip ratio is generally an indicator or measure of health and the risk of developing serious health conditions, such as diabetes, asthma, or Alzheimer's disease. Research shows that people with \"apple-shaped\" bodies (with more weight around the waist) face more health risks than those with \"pear-shaped\" bodies who carry more weight around the hips.");

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