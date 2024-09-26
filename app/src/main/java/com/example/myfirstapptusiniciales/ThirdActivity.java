package com.example.myfirstapptusiniciales;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button backMain = findViewById(R.id.buttonmain);
        TextView nameSur = findViewById(R.id.textPutIm);
        TextView age = findViewById(R.id.textPutAge);
        TextView staTure = findViewById(R.id.textPutStature);
        TextView agemore18 = findViewById(R.id.textMayorEdad);


        Intent intenttoThirdActivity = getIntent();

        String sname = intenttoThirdActivity.getStringExtra("name");
        nameSur.setText("Soy "+sname+".");
        String sage = intenttoThirdActivity.getStringExtra("age");
        age.setText("Tengo "+sage+" años.");
        String statu = intenttoThirdActivity.getStringExtra("stature");
        staTure.setText("Mido "+statu+" metros.");
        String sage18 = intenttoThirdActivity.getStringExtra("upto18");
        agemore18.setText(sage18);



        backMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intenttoMain = new Intent(ThirdActivity.this, MainActivity.class);

                startActivity(intenttoMain);
            }
        });

    }
}