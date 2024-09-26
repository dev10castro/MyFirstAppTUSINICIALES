package com.example.myfirstapptusiniciales;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Se crea la variable Button para utilizarla mas adelante
        Button botonWrite = findViewById(R.id.buttonwrite);

        // Establece un listener para el clic en el botón
        botonWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Crea un intent para iniciar la segunda activity
                Intent intentSecondActivity = new Intent(MainActivity.this, SecondActivity.class);

                // Inicia la segunda actividad
                startActivity(intentSecondActivity);
            }
        });
    }

    @Override
    protected void onResume(){

        super.onResume();
        Log.i("Ciclo de vida", "Ha entrado en el método onResume");
    }

    @Override
    protected void onPause(){

        super.onPause();
        Log.i("Ciclo de vida", "Ha entrado en el método onPause");
    }

    @Override
    protected void onStop(){

        super.onStop();
        Log.i("Ciclo de vida", "Ha entrado en el método onStop");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("Ciclo de vida","Ha entrado en el metodo onDestroy");
    }


}