package com.example.lab2_20211688;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab2_20211688.bean.Pregunta;

import java.util.List;

public class PreguntasRedes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_preguntas);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        List<Pregunta> preguntas = (List<Pregunta>) getIntent().getSerializableExtra("preguntas");
        Integer numero = (Integer) getIntent().getIntExtra("numeroPregunta",0);


        TextView preguntaView = findViewById(R.id.pregunta);
        preguntaView.setText(String.valueOf(preguntas.get(numero).getEnunciado()));

        Button buttonView1 = findViewById(R.id.r1);
        buttonView1.setText(String.valueOf(preguntas.get(numero).getOpciones()[0]));

        Button buttonView2 = findViewById(R.id.r2);
        buttonView2.setText(String.valueOf(preguntas.get(numero).getOpciones()[1]));

        Button buttonView3 = findViewById(R.id.r3);
        buttonView3.setText(String.valueOf(preguntas.get(numero).getOpciones()[2]));


    }
}