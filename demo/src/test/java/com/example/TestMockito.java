package com.example;

import com.example.Comandos.Ejecutor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TestMockito {

    @Test
    void testEjecutorSimulado() throws Exception {
        Ejecutor ejecutorMock = mock(Ejecutor.class);

        when(ejecutorMock.ejecutar("echo test")).thenReturn("test");

        String salida = ejecutorMock.ejecutar("echo test");

        assertEquals("test", salida);

        verify(ejecutorMock).ejecutar("echo test");
    }
}
