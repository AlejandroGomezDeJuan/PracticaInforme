package com.example.Comandos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejecutor {
    private static final String SALTO = "\n";

    public String ejecutar(String comando) throws IOException, InterruptedException {
        StringBuilder resultado = new StringBuilder();
        Process proceso = Runtime.getRuntime().exec(comando);

        try (BufferedReader lector = new BufferedReader(new InputStreamReader(proceso.getInputStream()))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                resultado.append(linea).append(SALTO);
            }
        }

        proceso.waitFor();
        return resultado.toString();
    }
}
