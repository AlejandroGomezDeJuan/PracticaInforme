package com.example.Comandos;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class GestorResultados {
    private final Ejecutor ejecutor = new Ejecutor();

    public Map<String, String> recolectarSalidas(String[] comandos) throws IOException, InterruptedException {
        Map<String, String> resultados = new LinkedHashMap<>();

        for (int i = 0; i < comandos.length; i++) {
            String salidaComando = ejecutor.ejecutar(comandos[i]);
            resultados.put(comandos[i], salidaComando);
        }

        return resultados;
    }
}
