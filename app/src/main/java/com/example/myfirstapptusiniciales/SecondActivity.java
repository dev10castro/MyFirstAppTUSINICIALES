package com.example.myfirstapptusiniciales;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText name = findViewById(R.id.nameSurname);
        EditText yourAge = findViewById(R.id.editTextyears);
        EditText stature = findViewById(R.id.editTextestature);
        Switch sw1 = findViewById(R.id.years);
        Button send = findViewById(R.id.buttonSend);
        Button back = findViewById(R.id.buttonBack);

    back.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intenttoMainctivity = new Intent(SecondActivity.this,MainActivity.class);
            startActivity(intenttoMainctivity);
        }


    });

    send.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(name.getText().toString().isEmpty()){
                Toast toastName = new Toast(SecondActivity.this);
                toastName.setText("Name can´t be empty");
                toastName.show();
            } else if (yourAge.getText().toString().isEmpty()) {
                Toast toastAge = new Toast(SecondActivity.this);
                toastAge.setText("Age can´t be empty");
                toastAge.show();

            }else if(stature.getText().toString().isEmpty()){
                Toast toastStature = new Toast(SecondActivity.this);
                toastStature.setText("Stature can´t be empty");
                toastStature.show();
            }else {

                Intent intenttoThirdActivity = new Intent(SecondActivity.this, ThirdActivity.class);

                intenttoThirdActivity.putExtra("name",name.getText().toString());
                intenttoThirdActivity.putExtra("age",yourAge.getText().toString());
                intenttoThirdActivity.putExtra("stature",stature.getText().toString());

                if(sw1.isChecked()){
                    intenttoThirdActivity.putExtra("upto18","Soy mayor de 18");
                }else{
                    intenttoThirdActivity.putExtra("upto18","No soy mayor de 18");
                }

                startActivity(intenttoThirdActivity);
            }


        }
    });

    ;





    }
}