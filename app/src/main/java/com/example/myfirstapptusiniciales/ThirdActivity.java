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

// Obtiene referencias a los elementos de la interfaz
        Button backMain = findViewById(R.id.buttonmain);
        TextView nameSur = findViewById(R.id.textPutIm);
        TextView age = findViewById(R.id.textPutAge);
        TextView staTure = findViewById(R.id.textPutStature);
        TextView agemore18 = findViewById(R.id.textMayorEdad);

// Obtiene la intención que inició esta actividad
        Intent intenttoThirdActivity = getIntent();

// Recupera los datos pasados desde la segunda actividad
        String sname = intenttoThirdActivity.getStringExtra("name");
        nameSur.setText("Soy " + sname + "."); // Establece el texto del TextView con el nombre

        String sage = intenttoThirdActivity.getStringExtra("age");
        age.setText("Tengo " + sage + " años."); // Establece el texto del TextView con la edad

        String statu = intenttoThirdActivity.getStringExtra("stature");
        staTure.setText("Mido " + statu + " metros."); // Establece el texto del TextView con la estatura

        String sage18 = intenttoThirdActivity.getStringExtra("Acept");
        agemore18.setText(sage18); // Establece el texto del TextView sobre si es mayor de 18

// Configura un listener para el botón "Volver a la activityMain"
        backMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crea una intención para regresar a la actividad principal
                Intent intenttoMain = new Intent(ThirdActivity.this, MainActivity.class);
                // Inicia la actividad principal
                startActivity(intenttoMain);
            }
        });

    }
}