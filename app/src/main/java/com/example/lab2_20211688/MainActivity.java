package com.example.lab2_20211688;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab2_20211688.bean.Pregunta;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static List<Integer> numerosDisponiblesRedes = new ArrayList<>(Arrays.asList( 1,2,3,4,5));



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

        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        Log.d("menu", "menu_main inflado correctamente");
        return true;
    }




    public void iconoRegresar(MenuItem item) {
        Log.d("menu", "Regresando...");
    }


    public void abrirActPreguntas(View view) {
        Intent intent = new Intent(this, PreguntasRedes.class);
        List<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(new Pregunta("p1", new String[]{"Opción A", "Opción B", "Opción C"}, 1));
        preguntas.add(new Pregunta("p2", new String[]{"Opción A", "Opción B", "Opción C"}, 2));
        preguntas.add(new Pregunta("p3", new String[]{"Opción A", "Opción B", "Opción C"}, 3));
        preguntas.add(new Pregunta("p4", new String[]{"Opción A", "Opción B", "Opción C"}, 1));
        preguntas.add(new Pregunta("p5", new String[]{"Opción A", "Opción B", "Opción C"}, 2));

        intent.putExtra("preguntas", (Serializable) preguntas);

        /*
        if (numerosDisponiblesRedes.isEmpty()) {
            for (int i = 1; i <= 5; i++) {
                numerosDisponiblesRedes.add(i);
            }
        }*/

        // Escoge uno aleatorio
        Random rand = new Random();

        int index = rand.nextInt(numerosDisponiblesRedes.size());
        int numero = numerosDisponiblesRedes.get(index);

        // Elimina el número ya usado
        numerosDisponiblesRedes.remove(index);

        Log.d("numero elegido", "" + numero);

        intent.putExtra("numeroPregunta", numero-1);
        startActivity(intent);
    }





}