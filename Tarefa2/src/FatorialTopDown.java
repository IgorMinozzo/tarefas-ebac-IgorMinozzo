import java.math.BigInteger;
import java.util.HashMap;

public class FatorialTopDown {
    private static HashMap<Integer, BigInteger> memo = new HashMap<>();

    public static BigInteger fatorial (int n){
        if (n == 0 || n == 1){
            return BigInteger.ONE;
        }
        if (memo.containsKey(n)){
            return memo.get(n);
        }
        BigInteger resultado = BigInteger.valueOf(n).multiply(fatorial(n -1));
        memo.put(n, resultado);
        return resultado;
    }

    public static void main(String[] args) {
        int numero1 = 3;
        int numero2 = 100;

        System.out.println("Fatorial de " + numero1 + " é: " + fatorial(numero1));
        System.out.println("Fatorial de " + numero2 + " é: " + fatorial(numero2));
    }
}

//A solução utilizando TopDown evita calculos repitidos e usa a recursão com armazenamento
//de resultados intermediarios.