package com.example.Informes;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Map;

public class InformeMarkdown implements Generador {

    private static final String ARCHIVO = "Informe.md";
    private static final String TITULO = "# INFORME DEL SISTEMA";
    private static final String COMANDO = "## Comando: `";
    private static final String FECHA = "_Generado el ";
    private static final String BLOQUE_INICIO = "```bash";
    private static final String BLOQUE_FIN = "```";
    private static final String SEPARADOR = "---";
    private static final String MENSAJE_ERROR = "Error al generar el informe: ";

    @Override
    public void generar(Map<String, String> datos) {
        try (PrintWriter escritor = new PrintWriter(new FileWriter(ARCHIVO))) {
            escritor.println(TITULO);
            escritor.println(FECHA + LocalDateTime.now() + "_\n");

            for (Map.Entry<String, String> entrada : datos.entrySet()) {
                escritor.println(COMANDO + entrada.getKey() + "`");
                escritor.println(BLOQUE_INICIO);
                escritor.println(entrada.getValue().trim());
                escritor.println(BLOQUE_FIN + "\n" + SEPARADOR + "\n");
            }

        } catch (IOException e) {
            System.err.println(MENSAJE_ERROR + e.getMessage());
        }
    }
}
