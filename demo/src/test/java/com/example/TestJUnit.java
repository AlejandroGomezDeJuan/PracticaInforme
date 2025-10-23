package com.example;

import com.example.Comandos.Ejecutor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

public class TestJUnit {

    private Ejecutor ejecutor;

    @BeforeEach
    void setUp() {
        ejecutor = new Ejecutor();
    }

    // Test que comprueba que la salida del comando no está vacía
    @Test
    public void testSalidaNoVacia() throws IOException, InterruptedException {
        String salida = ejecutor.ejecutar("echo prueba");
        assertNotNull(salida);
        assertFalse(salida.isBlank());
    }

    // Test que comprueba que se lanza una excepción si el comando es inválido
    @Test
    public void testComandoInvalido() {
        assertThrows(IOException.class, () -> {
            ejecutor.ejecutar("comando_que_no_existe");
        });
    }
}
