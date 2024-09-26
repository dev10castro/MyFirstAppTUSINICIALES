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

        // Obtiene referencias a los elementos de la interfaz
        EditText name = findViewById(R.id.nameSurname);
        EditText yourAge = findViewById(R.id.editTextyears);
        EditText stature = findViewById(R.id.editTextestature);
        Switch sw1 = findViewById(R.id.years);
        Button send = findViewById(R.id.buttonSend);
        Button back = findViewById(R.id.buttonBack);

// Configura un listener para el botón "Volver"
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Crea una intención para regresar a la actividad principal
                Intent intenttoMainctivity = new Intent(SecondActivity.this, MainActivity.class);

                // Inicia la actividad principal
                startActivity(intenttoMainctivity);
            }
        });

// Configura un listener para el botón "Enviar"
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verifica si el campo de nombre está vacío
                if (name.getText().toString().isEmpty()) {

                    // Muestra un mensaje de error si el nombre está vacío
                    Toast toastName = Toast.makeText(SecondActivity.this, "Name can't be empty", Toast.LENGTH_SHORT);
                    toastName.show();
                }
                // Verifica si el campo de edad está vacío
                else if (yourAge.getText().toString().isEmpty()) {

                    // Muestra un mensaje de error si la edad está vacía
                    Toast toastAge = Toast.makeText(SecondActivity.this, "Age can't be empty", Toast.LENGTH_SHORT);
                    toastAge.show();
                }
                // Verifica si el campo de estatura está vacío
                else if (stature.getText().toString().isEmpty()) {

                    // Muestra un mensaje de error si la estatura está vacía
                    Toast toastStature = Toast.makeText(SecondActivity.this, "Stature can't be empty", Toast.LENGTH_SHORT);
                    toastStature.show();
                }
                // Si todos los campos están llenos, procede a la siguiente actividad
                else {
                    // Crea un intent para iniciar la tercera activity
                    Intent intenttoThirdActivity = new Intent(SecondActivity.this, ThirdActivity.class);

                    // Envía los datos ingresados a la tercera actividad
                    intenttoThirdActivity.putExtra("name", name.getText().toString());
                    intenttoThirdActivity.putExtra("age", yourAge.getText().toString());
                    intenttoThirdActivity.putExtra("stature", stature.getText().toString());

                    // Verifica el estado del Switch y envía un mensaje correspondiente en funcion de si es true o false
                    if (sw1.isChecked()) {
                        intenttoThirdActivity.putExtra("Acept", "Acepto las condiciones");
                    } else {
                        intenttoThirdActivity.putExtra("Acept", "No acepto las condiciones");
                    }

                    // Inicia la tercera activity
                    startActivity(intenttoThirdActivity);
                }
            }
        });


    }
}