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

public class BodyFrame extends AppCompatActivity {




    EditText ed_height , ed_wrist;
    Button btn_cal, btn_reset;
    RadioGroup radioGroup;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_frame);

        ed_height = findViewById(R.id.ed_frameheight);
        ed_wrist = findViewById(R.id.ed_frameWrist);
        btn_cal = findViewById(R.id.btn_framecal);
        btn_reset  = findViewById(R.id.btn_FrameReset);
        radioGroup = findViewById(R.id.RadioGroupBodyframe);


        // calling the action bar
        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);
        // Define ColorDrawable object and parse color
        // using parseColor method
        // with color hash code as its parameter

        actionBar.setTitle("Body Frame Size");


        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ed_height.getText().clear();
                ed_wrist.getText().clear();


            }
        });

        btn_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Sheight = ed_height.getText().toString();
                String SWrist = ed_wrist.getText().toString();


                if (Sheight.length() >0  && SWrist.length()>0 ) {




                    Dialog dialog = new Dialog(BodyFrame.this);
                    dialog.setContentView(R.layout.dia_result);

                    TextView Dia_score = dialog.findViewById(R.id.di_score);
                    TextView dia_result = dialog.findViewById(R.id.dia_result);
                    TextView dia_position = dialog.findViewById(R.id.dia_position);
                    TextView dia_tips = dialog.findViewById(R.id.dia_tips);
                    Button btn_back = dialog.findViewById(R.id.btn_back);

                    Dia_score.setText("Your Body Frame Size Is: ");



                    float height = Float.parseFloat(Sheight);


                    float wrist = Float.parseFloat(SWrist);
                    int selecteditemid = radioGroup.getCheckedRadioButtonId();



                    float inch = (float) (height*0.3937007874);

                    float wristInch = (float) (wrist*0.3937007874);


                    float frame_size = inch/wristInch;


                    String frameSize = String.format("%.01f", frame_size);

                    dia_result.setText("" + frameSize);


                    switch (selecteditemid){


                        case (R.id.bodyframe_male_button):

                            if (frame_size>10.4) {

                                dia_position.setText("Small Frame");
                                dia_tips.setVisibility(View.GONE);





                            }




                            else if (frame_size<9.6) {


                                dia_position.setText("Large Frame");
                                dia_tips.setVisibility(View.GONE);

                            }


                            else if (frame_size>=9.6 && frame_size<=10.4){

                                dia_position.setText("Medium Frame");
                                dia_tips.setVisibility(View.GONE);


                            }

                            break;



                        case (R.id.bodyframe_female_button):
                            if (frame_size>11) {

                                dia_position.setText("Small Frame");
                                dia_tips.setVisibility(View.GONE);





                            }




                            else if (frame_size<10.1) {


                                dia_position.setText("Large Frame");
                                dia_tips.setVisibility(View.GONE);

                            }


                            else if (frame_size>=10.1 && frame_size<=11.0){

                                dia_position.setText("Medium Frame");
                                dia_tips.setVisibility(View.GONE);


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


                    Toasty.info(BodyFrame.this, "Please enter valid values", Toast.LENGTH_SHORT).show();

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

                Dialog dialog = new Dialog(BodyFrame.this);
                dialog.setContentView(R.layout.info);
                TextView title = dialog.findViewById(R.id.tv_title);
                TextView dis = dialog.findViewById(R.id.tv_Dis);
                Button btnback = dialog.findViewById(R.id.btn_back2);

                title.setText("Body Frame Size ");
                dis.setText("Welcome to body frame size calculator, a convenient tool that will help you determine your body frame size with simple inputs such as gender, height, and wrist circumference. Grab a measurement tape and come along to find out what the body frame size is, how to calculate your body frame size, measure your wrist circumference, and more!");


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