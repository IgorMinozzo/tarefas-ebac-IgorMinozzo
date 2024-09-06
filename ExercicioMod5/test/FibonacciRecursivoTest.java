import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibonacciRecursivoTest {

    @Test
    public void testeElementoZero() {
        // Testa o caso base onde n = 0, deve retornar 0
        assertEquals(0, FibonacciRecursivo.encontrarElemento(0));
    }

    @Test
    public void testeElementoUm() {
        // Testa o caso base onde n = 1, deve retornar 1
        assertEquals(1, FibonacciRecursivo.encontrarElemento(1));
    }

    @Test
    public void testeElementoDez() {
        // Testa um caso onde n = 10, deve retornar 55
        assertEquals(55, FibonacciRecursivo.encontrarElemento(10));
    }

    @Test
    public void testeElementoSeis() {
        // Testa um caso onde n = 6, deve retornar 8
        assertEquals(8, FibonacciRecursivo.encontrarElemento(6));
    }

    @Test
    public void testeElementoVinte() {
        // Testa um caso onde n = 20, deve retornar 6765
        assertEquals(6765, FibonacciRecursivo.encontrarElemento(20));
    }
}
