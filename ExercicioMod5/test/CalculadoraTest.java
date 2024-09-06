import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CalculadoraTest {

    Calculadora calculadora = new Calculadora();

    @Test
    public void testeAdicionar() {
        assertEquals(5, calculadora.adicionarPublico(2, 3));
        assertEquals(0, calculadora.adicionarPublico(-2, 2));
        assertEquals(-5, calculadora.adicionarPublico(-2, -3));
    }

    @Test
    public void testeSubtrair() {
        assertEquals(1, calculadora.subtrairPublico(3, 2));
        assertEquals(-4, calculadora.subtrairPublico(-2, 2));
        assertEquals(1, calculadora.subtrairPublico(-2, -3));
    }

    @Test
    public void testeMultiplicar() {
        assertEquals(6, calculadora.multiplicarPublico(2, 3));
        assertEquals(-4, calculadora.multiplicarPublico(-2, 2));
        assertEquals(6, calculadora.multiplicarPublico(-2, -3));
    }

    @Test
    public void testeDividir() {
        assertEquals(2, calculadora.dividirPublico(6, 3));
        assertEquals(-2, calculadora.dividirPublico(-6, 3));
        assertEquals(2, calculadora.dividirPublico(-6, -3));

        // Teste para divisão por zero, deve lançar uma exceção
        assertThrows(ArithmeticException.class, () -> {
            calculadora.dividirPublico(6, 0);
        });
    }
}
