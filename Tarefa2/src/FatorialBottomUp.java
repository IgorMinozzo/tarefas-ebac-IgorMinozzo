import java.math.BigInteger;

public class FatorialBottomUp {

    public static BigInteger fatorial (int n ){
        BigInteger[] dp = new BigInteger[n + 1];
        dp[0] = BigInteger.ONE;
        for (int i = 1; i <= n; i++){
            dp[i] = dp[i - 1].multiply(BigInteger.valueOf(i));
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int numero1 = 3;
        int numero2 = 100;

        System.out.println("Fatorial de " + numero1 + " é: " + fatorial(numero1));
        System.out.println("Fatorial de " + numero2 + " é: " + fatorial(numero2));
    }
}

//Não utiliza recursão, eliminando o risco de StackOverFlowError.
//É eficiente e direto. Pode consumir mais memoria para armazenar todos os resultados
//intermediarios, mas é mais eficiente em termos de tempo.