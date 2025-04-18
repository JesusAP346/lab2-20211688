package com.example.lab2_20211688.bean;

import java.io.Serializable;
public class Pregunta implements Serializable {
    private String enunciado;
    private String[] opciones;
    private int respuestaCorrecta;

    public Pregunta(String enunciado, String[] opciones, int respuestaCorrecta) {
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    // Getters (opcional)
    public String getEnunciado() { return enunciado; }
    public String[] getOpciones() { return opciones; }
    public int getRespuestaCorrecta() { return respuestaCorrecta; }
}
