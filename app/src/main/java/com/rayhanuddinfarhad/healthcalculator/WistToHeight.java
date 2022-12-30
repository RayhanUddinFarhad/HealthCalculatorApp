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

public class WistToHeight extends AppCompatActivity {



    EditText ed_waist, ed_Height;
    Button btn_cal, btn_reset;
    RadioGroup radioGroup;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wist_to_height);






        ed_waist = findViewById(R.id.ed_Hwaist);
        ed_Height = findViewById(R.id.ed_Hhip);
        btn_cal = findViewById(R.id.btn_cal_waistToHeight);
        btn_reset = findViewById(R.id.btn_res_waistToHeight);
        radioGroup = findViewById(R.id.wh_RadioGroupHip);


        // calling the action bar
        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);

        actionBar.setTitle("Waist To Height Ratio");



        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ed_waist.getText().clear();
                ed_Height.getText().clear();



            }
        });


        btn_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Swaist = ed_waist.getText().toString();
                String SHeight = ed_Height.getText().toString();


                if (Swaist.length() >0 && SHeight.length()>0 ) {


                    Dialog dialog = new Dialog(WistToHeight.this);
                    dialog.setContentView(R.layout.dia_result);

                    TextView dialouge_score = dialog.findViewById(R.id.di_score);
                    TextView dialouge_result = dialog.findViewById(R.id.dia_result);
                    TextView dialouge_position = dialog.findViewById(R.id.dia_position);
                    TextView dialouge_tips = dialog.findViewById(R.id.dia_tips);
                    Button btn_back = dialog.findViewById(R.id.btn_back);
                    dialouge_score.setText("Your Waist to Height ratio");
                    dialouge_tips.setVisibility(View.GONE);

                    int selecteditemid = radioGroup.getCheckedRadioButtonId();





                    float Waist = Float.parseFloat(Swaist);


                    float Height = Float.parseFloat(SHeight);



                    float ratio = Waist/Height;
                    String Ratio = String.format("%.02f", ratio);

                    dialouge_result.setText("" +Ratio );



                   switch (selecteditemid) {



                       case (R.id.Wh_male_button):

                           if (ratio<=0.34) {


                               dialouge_position.setText("Extremely slim");
                           }


                           else if (ratio>0.35 && ratio<0.42) {

                               dialouge_position.setText("Slim");
                           }


                           else if (ratio>0.43 && ratio<0.52) {

                               dialouge_position.setText("Healthy");
                           }

                           else if (ratio>0.53 && ratio<0.57) {


                               dialouge_position.setText("Overweight");
                           }

                           else if (ratio>0.58 && ratio<0.62) {


                               dialouge_position.setText("Very Overweight");
                           }


                           else if (ratio>=0.63){


                               dialouge_position.setText("Obese");
                           }

                           break;


                       case (R.id.Wh_female_button):


                           if (ratio<=0.34) {


                               dialouge_position.setText("Extremely slim");
                           }


                           else if (ratio>0.35 && ratio<0.41) {

                               dialouge_position.setText("Slim");
                           }


                           else if (ratio>0.42 && ratio<0.48) {

                               dialouge_position.setText("Healthy");
                           }

                           else if (ratio>0.49 && ratio<0.53) {


                               dialouge_position.setText("Overweight");
                           }

                           else if (ratio>0.54 && ratio<0.57) {


                               dialouge_position.setText("Very Overweight");
                           }


                           else if (ratio>=0.58){


                               dialouge_position.setText("Obese");
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


                    Toasty.info(WistToHeight.this, "Please enter valid values", Toast.LENGTH_SHORT).show();








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


                Dialog dialog = new Dialog(WistToHeight.this);
                dialog.setContentView(R.layout.info);
                TextView title = dialog.findViewById(R.id.tv_title);
                TextView dis = dialog.findViewById(R.id.tv_Dis);
                Button btnback = dialog.findViewById(R.id.btn_back2);

                title.setText("Waist Height Ratio ");
dis.setText("The waist-to-height ratio is a measure of the distribution of body fat. The higher someone's waist-height ratio is, the higher their risk of obesity-related cardiovascular diseases, as it is a rough estimate of obesity.");
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