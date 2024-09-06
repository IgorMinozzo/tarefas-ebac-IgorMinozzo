/**
 * A classe Calculadora fornece métodos básicos para realizar operações aritméticas
 * como adição, subtração, multiplicação e divisão.
 *
 * Esta classe é projetada para ser usada em cálculos simples e não suporta operações
 * com números decimais ou operações mais complexas.
 */
public class Calculadora {

    /**
     * Adiciona dois números inteiros.
     *
     * @param a o primeiro número inteiro
     * @param b o segundo número inteiro
     * @return a soma de a e b
     */
    private int adicionar(int a, int b) {
        return a + b;
    }

    /**
     * Subtrai o segundo número inteiro do primeiro.
     *
     * @param a o primeiro número inteiro
     * @param b o segundo número inteiro
     * @return a diferença entre a e b
     */
    private int subtrair(int a, int b) {
        return a - b;
    }

    /**
     * Multiplica dois números inteiros.
     *
     * @param a o primeiro número inteiro
     * @param b o segundo número inteiro
     * @return o produto de a e b
     */
    private int multiplicar(int a, int b) {
        return a * b;
    }

    /**
     * Divide o primeiro número inteiro pelo segundo.
     *
     * @param a o primeiro número inteiro
     * @param b o segundo número inteiro (não pode ser zero)
     * @return o quociente da divisão de a por b
     * @throws ArithmeticException se b for zero
     */
    private int dividir(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Divisão por zero não é permitida.");
        }
        return a / b;
    }

    /**
     * Adiciona dois números inteiros. Este método é um wrapper público para o método
     * privado {@link #adicionar(int, int)}.
     *
     * @param a o primeiro número inteiro
     * @param b o segundo número inteiro
     * @return a soma de a e b
     */
    public int adicionarPublico(int a, int b) {
        return adicionar(a, b);
    }

    /**
     * Subtrai o segundo número inteiro do primeiro. Este método é um wrapper público
     * para o método privado {@link #subtrair(int, int)}.
     *
     * @param a o primeiro número inteiro
     * @param b o segundo número inteiro
     * @return a diferença entre a e b
     */
    public int subtrairPublico(int a, int b) {
        return subtrair(a, b);
    }

    /**
     * Multiplica dois números inteiros. Este método é um wrapper público para o método
     * privado {@link #multiplicar(int, int)}.
     *
     * @param a o primeiro número inteiro
     * @param b o segundo número inteiro
     * @return o produto de a e b
     */
    public int multiplicarPublico(int a, int b) {
        return multiplicar(a, b);
    }

    /**
     * Divide o primeiro número inteiro pelo segundo. Este método é um wrapper público
     * para o método privado {@link #dividir(int, int)}.
     *
     * @param a o primeiro número inteiro
     * @param b o segundo número inteiro (não pode ser zero)
     * @return o quociente da divisão de a por b
     * @throws ArithmeticException se b for zero
     */
    public int dividirPublico(int a, int b) {
        return dividir(a, b);
    }
}
/**
 * você conseguiria entender o código que escreveu sem documentá-lo? Justifique sua resposta.
 *
 * no caso do código da calculadora sim pois é um codigo apenas com calculos simples mas se fosse uma calculadora
 * com calculos cientificos seria necessario a documentação
 */