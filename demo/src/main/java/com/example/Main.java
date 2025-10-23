package com.example;

import com.example.Comandos.GestorResultados;
import com.example.Informes.Generador;
import com.example.Informes.InformeMarkdown;

import java.io.IOException;
import java.util.Map;

public class Main {
    private static final String[] LISTA_COMANDOS = {"ps", "df -h", "free -h"};
    private static final String MENSAJE_EXITO = "El informe del sistema se ha creado correctamente.";
    private static final String MENSAJE_ERROR = "Error durante la ejecución: ";

    public static void main(String[] args) {
        try {
            GestorResultados gestor = new GestorResultados();
            Map<String, String> salidasSistema = gestor.recolectarSalidas(LISTA_COMANDOS);

            Generador generadorInforme = new InformeMarkdown();
            generadorInforme.generar(salidasSistema);

            System.out.println(MENSAJE_EXITO);
        } catch (IOException | InterruptedException error) {
            System.err.println(MENSAJE_ERROR + error.getMessage());
        }
    }
}
