package com.njs.mobileappdevelop.labtest01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText weightValueET,heightValueET;
    private Button calculateBmiBtn;
    private TextView resultTV;
    private float meter=100.00f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightValueET=findViewById(R.id.weightValueETId);
        heightValueET=findViewById(R.id.heightValueETId);
        calculateBmiBtn=findViewById(R.id.calculateBmiBtnId);
        resultTV=findViewById(R.id.resultTVId);

        calculateBmiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                displayBMI();

            }
        });

    }

    private void displayBMI() {


        String value1=weightValueET.getText().toString();
        String value2=heightValueET.getText().toString();

        if(value1.equals(""))
        {
            Toast.makeText(MainActivity.this, "Please enter weight value", Toast.LENGTH_SHORT).show();
        }
        else if(value2.equals(" "))
        {
            Toast.makeText(MainActivity.this, "Please enter height value", Toast.LENGTH_SHORT).show();
        }
        else
        {
            float weight=Float.valueOf(value1);
            float height1=Float.valueOf(value2);
            float height=height1/meter;
            float result=weight/(height*height);

            if(result>=0 && result<=15)
            {
                resultTV.setText(String.valueOf(result)+"\n\n"+"Very Serverly Underweight");

            }
            else if(result>=15 && result<=16)
            {
                resultTV.setText(String.valueOf(result)+"\n\n"+"Serverly Underweight");
            }
            else if(result>=16 && result<=18.5)
            {
                resultTV.setText(String.valueOf(result)+"\n\n"+"Underweight");
            }
            else if(result>=18.5 && result<=25)
            {
                resultTV.setText(String.valueOf(result)+"\n\n"+"Normal");
            }
            else if(result>=25 && result<=30)
            {
                resultTV.setText(String.valueOf(result)+"\n\n"+"Overweight");
            }

        }
    }
}
